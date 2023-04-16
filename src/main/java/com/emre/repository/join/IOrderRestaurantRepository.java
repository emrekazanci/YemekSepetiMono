package com.emre.repository.join;

import com.emre.repository.entity.join.OrderRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRestaurantRepository extends JpaRepository<OrderRestaurant,Long> {
    @Query(nativeQuery = true,value = "select r.restaurant_id,r.restaurant_name,o.order_id,p.product_id,c.customer_id,c.customer_name,p.product_name from tbl_customer as c\n" +
            "inner join tbl_order as o on o.customer_id = c.customer_id\n" +
            "inner join order_product_id as op on op.order_order_id = o.order_id\n" +
            "inner join tbl_product as p on p.product_id = op.product_id\n" +
            "inner join tbl_restaurant as r on p.restaurant_id = r.restaurant_id\n" +
            "where r.restaurant_id = ?1")
    List<OrderRestaurant> orderForRestaurant(Long restaurantId);
}
