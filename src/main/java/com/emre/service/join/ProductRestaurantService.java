package com.emre.service.join;

import com.emre.repository.entity.join.ProductRestaurant;
import com.emre.repository.join.IProductRestaurantRepository;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRestaurantService extends ServiceManager<ProductRestaurant,Long> {
    private final IProductRestaurantRepository productRestaurantRepository;
    public ProductRestaurantService(IProductRestaurantRepository productRestaurantRepository) {
        super(productRestaurantRepository);
        this.productRestaurantRepository = productRestaurantRepository;
    }
    public List<ProductRestaurant> productForRestaurant(Long restaurantId) {
        return productRestaurantRepository.productForRestaurant(restaurantId);
    }
}
