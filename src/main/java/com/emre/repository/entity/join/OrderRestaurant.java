package com.emre.repository.entity.join;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;
    Long orderId;
    Long restaurantId;
    String restaurantName;
    Long customerId;
    String customerName;
    String productName;

}
