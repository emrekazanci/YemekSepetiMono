package com.emre.service.join;

import com.emre.repository.entity.join.OrderRestaurant;
import com.emre.repository.join.IOrderRestaurantRepository;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderRestaurantService extends ServiceManager<OrderRestaurant,Long> {
    private final IOrderRestaurantRepository orderRestaurantRepository;

    public OrderRestaurantService(IOrderRestaurantRepository orderRestaurantRepository) {
        super(orderRestaurantRepository);
        this.orderRestaurantRepository = orderRestaurantRepository;
    }
    public List<OrderRestaurant> orderForRestaurant(Long restaurantId) {
        return orderRestaurantRepository.orderForRestaurant(restaurantId);
    }
}
