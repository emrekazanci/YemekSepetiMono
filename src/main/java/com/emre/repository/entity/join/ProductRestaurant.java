package com.emre.repository.entity.join;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;
    Long restaurantId;
    String restaurantName;
    String productName;
}
