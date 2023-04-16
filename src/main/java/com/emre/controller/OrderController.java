package com.emre.controller;

import com.emre.dto.request.SaveOrderRequestDto;
import com.emre.repository.entity.Order;
import com.emre.repository.entity.join.CustomerOrder;
import com.emre.repository.entity.join.OrderProduct;
import com.emre.repository.entity.join.OrderRestaurant;
import com.emre.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.emre.constant.EndPointList.*;

@RestController
@RequestMapping(ORDER)
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping(SAVE)
    public ResponseEntity<Order> save(SaveOrderRequestDto dto) {
        return ResponseEntity.ok(orderService.save(dto));
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping(ORDER_FOR_CUSTOMER)
    public ResponseEntity<List<CustomerOrder>> orderForCustomer(Long customerId) {
        return ResponseEntity.ok(orderService.orderForCustomer(customerId));
    }

    @GetMapping(ORDER_FOR_RESTAURANT)
    public ResponseEntity<List<OrderRestaurant>> orderForRestaurant(Long restaurantId) {
        return ResponseEntity.ok(orderService.orderForRestaurant(restaurantId));
    }

    @GetMapping(ALL_ORDERS)
    public ResponseEntity<List<OrderProduct>> orders() {
        return ResponseEntity.ok(orderService.orders());
    }
}
