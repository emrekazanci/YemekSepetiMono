package com.emre.service;

import com.emre.dto.request.SaveProductRequestDto;
import com.emre.exception.ErrorType;
import com.emre.exception.YemekSepetiException;
import com.emre.mapper.IProductMapper;
import com.emre.repository.IProductRepository;
import com.emre.repository.entity.Product;
import com.emre.repository.entity.join.ProductRestaurant;
import com.emre.service.join.ProductRestaurantService;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends ServiceManager<Product, Long> {
    private final IProductRepository productRepository;
    private final RestaurantService restaurantService;
    private final ProductRestaurantService productRestaurantService;

    public ProductService(IProductRepository productRepository,
                          RestaurantService restaurantService,
                          ProductRestaurantService productRestaurantService) {
        super(productRepository);
        this.productRepository = productRepository;
        this.restaurantService = restaurantService;
        this.productRestaurantService = productRestaurantService;
    }

    public Product save(SaveProductRequestDto dto) {
        Product product = IProductMapper.INSTANCE.fromSaveDtoToProduct(dto);
        List<Product> restaurantId = productRepository.findByRestaurantId(dto.getRestaurantId());
        if (restaurantId.isEmpty()) {
            throw new YemekSepetiException(ErrorType.RESTAURANT_NOT_FOUND);
        }
        restaurantId.forEach(x -> {
            if (x.getProductName().equals(product.getProductName())) {
                throw new YemekSepetiException(ErrorType.RESTAURANT_PRODUCT_ALREADY_EXIST);
            }
        });
        return save(product);
    }

    public List<ProductRestaurant> productForRestaurant(Long restaurantId) {
        return productRestaurantService.productForRestaurant(restaurantId);
    }


}
