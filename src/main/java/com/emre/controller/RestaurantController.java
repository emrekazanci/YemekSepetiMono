package com.emre.controller;

import com.emre.dto.request.SaveRestaurantRequestDto;
import com.emre.repository.entity.Restaurant;
import com.emre.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.emre.constant.EndPointList.*;


@RestController
@RequestMapping(RESTAURANT)
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping(SAVE)
    public ResponseEntity<Restaurant> save(@RequestBody @Valid SaveRestaurantRequestDto dto) {
        return ResponseEntity.ok(restaurantService.save(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Restaurant>> findAll() {
        return ResponseEntity.ok(restaurantService.findAll());
    }
}
