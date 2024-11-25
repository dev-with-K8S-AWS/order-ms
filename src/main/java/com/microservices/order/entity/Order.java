package com.microservices.order.entity;

import com.microservices.order.dto.FoodItemDTO;
import com.microservices.order.dto.RestaurantDTO;
import com.microservices.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

    private Integer orderId;
    private List<FoodItemDTO> foodItemDTOList;
    private UserDTO userDTO;
    private RestaurantDTO restaurantDTO;

}
