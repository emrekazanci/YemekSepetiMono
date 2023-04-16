package com.emre.repository.join;

import com.emre.repository.entity.Product;
import com.emre.repository.entity.join.ProductRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRestaurantRepository extends JpaRepository<ProductRestaurant,Long> {
    @Query(nativeQuery = true,value = "select r.restaurant_id,r.restaurant_name,p.product_id,p.product_name from tbl_product as p \n" +
            "inner join tbl_restaurant as r on r.restaurant_id = p.restaurant_id\n" +
            "where p.restaurant_id = ?1")
    List<ProductRestaurant> productForRestaurant(Long restaurantId);
}
