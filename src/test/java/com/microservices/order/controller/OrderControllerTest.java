package com.microservices.order.controller;

import com.microservices.order.dto.FoodItemDTO;
import com.microservices.order.dto.OrderDTO;
import com.microservices.order.dto.OrderDTOFromClient;
import com.microservices.order.dto.RestaurantDTO;
import com.microservices.order.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @InjectMocks
    OrderController orderController;
    @Mock
    OrderService orderService;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveOrder(){
        // Arrange
        OrderDTOFromClient orderDetails = new OrderDTOFromClient();
        OrderDTO orderSavedInDB = new OrderDTO();
        when(orderService.saveOrderDetailsInDB(orderDetails)).thenReturn(orderSavedInDB);

        // Act
        ResponseEntity<OrderDTO> response = orderController.saveOrder(orderDetails);

        // Assert
        verify(orderService, times(1)).saveOrderDetailsInDB(orderDetails);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(orderSavedInDB, response.getBody());
    }



}
