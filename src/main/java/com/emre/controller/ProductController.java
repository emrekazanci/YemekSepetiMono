package com.emre.controller;

import com.emre.dto.request.SaveProductRequestDto;
import com.emre.repository.entity.Product;
import com.emre.repository.entity.join.ProductRestaurant;
import com.emre.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.emre.constant.EndPointList.*;

@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(SAVE)
    public ResponseEntity<Product> save(@RequestBody @Valid SaveProductRequestDto dto) {
        return ResponseEntity.ok(productService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(PRODUCT_FOR_RESTAURANT)
    public ResponseEntity<List<ProductRestaurant>> productForRestaurant(Long restaurantId) {
        return ResponseEntity.ok(productService.productForRestaurant(restaurantId));
    }
}
