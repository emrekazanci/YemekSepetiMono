package com.emre.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;
    @NotBlank(message = "Lütfen ürün ismini boş geçmeyiniz.")
    String productName;
    String category;
    @NotNull(message = "Ürün fiyatı giriniz.")
    Double cost;
    Long restaurantId;
}
