package com.emre.service;

import com.emre.dto.request.SaveRestaurantRequestDto;
import com.emre.mapper.IRestaurantMapper;
import com.emre.repository.IRestaurantRepository;
import com.emre.repository.entity.Restaurant;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService extends ServiceManager<Restaurant, Long> {
    private final IRestaurantRepository restaurantRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant save(SaveRestaurantRequestDto dto) {
        Restaurant restaurant = IRestaurantMapper.INSTANCE.fromDtoToSaveRestaurant(dto);
        return save(restaurant);
    }

}
