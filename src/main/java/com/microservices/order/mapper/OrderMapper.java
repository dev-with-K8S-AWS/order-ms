package com.microservices.order.mapper;

import com.microservices.order.dto.OrderDTO;
import com.microservices.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    public OrderDTO getOrderDTOFromOrder(Order order);

    public Order getOrderFromOrderDTO(OrderDTO orderDTO);
}
