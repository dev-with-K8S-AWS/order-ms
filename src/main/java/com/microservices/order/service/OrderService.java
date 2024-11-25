package com.microservices.order.service;

import com.microservices.order.dto.OrderDTO;
import com.microservices.order.dto.OrderDTOFromClient;
import com.microservices.order.dto.UserDTO;
import com.microservices.order.entity.Order;
import com.microservices.order.mapper.OrderMapper;
import com.microservices.order.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderDetailsInDB(OrderDTOFromClient orderDetails) {
        //get the order Id
        Integer  newOrderId= sequenceGenerator.generateNextOrderId();

        // get user details form user id
        UserDTO userDTO = fetchUserDetailsFromUserMS(orderDetails.getUserId());

        //save order in DB
        Order orderToBeSaved = new Order(newOrderId,orderDetails.getFoodItemDTOList(),userDTO,orderDetails.getRestaurantDTO());
        orderRepository.save(orderToBeSaved);

        //map order to OrderDTO
        return OrderMapper.INSTANCE.getOrderDTOFromOrder(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserMS(Integer userId) {
    return restTemplate.getForObject("http://USER-SERVICE/user/getUserById/"+userId,UserDTO.class);
    }
}
