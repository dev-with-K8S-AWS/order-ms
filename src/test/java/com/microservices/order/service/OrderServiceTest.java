package com.microservices.order.service;

import com.microservices.order.dto.OrderDTO;
import com.microservices.order.dto.OrderDTOFromClient;
import com.microservices.order.dto.UserDTO;
import com.microservices.order.entity.Order;
import com.microservices.order.mapper.OrderMapper;
import com.microservices.order.repo.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    @Mock
    OrderRepository orderRepository;

    @Mock
    SequenceGenerator sequenceGenerator;

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    OrderService orderService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveOrderDetailsInDB(){
        OrderDTOFromClient orderDetails= new OrderDTOFromClient();
        Integer newOrderId = 1;
        UserDTO userDTO = new UserDTO();
        Order orderToBeSaved = new Order(newOrderId,orderDetails.getFoodItemDTOList(), userDTO,orderDetails.getRestaurantDTO());
        when(sequenceGenerator.generateNextOrderId()).thenReturn(newOrderId);
        when(restTemplate.getForObject(anyString(),eq(UserDTO.class))).thenReturn(userDTO);
        when(orderRepository.save(orderToBeSaved)).thenReturn(orderToBeSaved);

        OrderDTO orderDTOActual = orderService.saveOrderDetailsInDB(orderDetails);

        verify(orderRepository,times(1)).save(orderToBeSaved);
        assertDoesNotThrow(() -> orderService.saveOrderDetailsInDB(orderDetails));
    }
}


