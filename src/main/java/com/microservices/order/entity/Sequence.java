package com.microservices.order.entity;

import com.microservices.order.dto.FoodItemDTO;
import com.microservices.order.dto.RestaurantDTO;
import com.microservices.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sequence {

    @Id
    private String id;
    private int sequence;
}
