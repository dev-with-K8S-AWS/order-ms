package com.microservices.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromClient {

    private List<FoodItemDTO> foodItemDTOList;
    private Integer userId;
    private RestaurantDTO restaurantDTO;
}
