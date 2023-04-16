package com.emre.repository.join;

import com.emre.repository.entity.join.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderProductRepository extends JpaRepository<OrderProduct,Long> {
    @Query(nativeQuery = true, value = "select o.order_id,p.product_id,p.product_name from tbl_order as o \n" +
            "inner join order_product_id as op on op.order_order_id = o.order_id\n" +
            "inner join tbl_product as p on p.product_id = op.product_id")
    List<OrderProduct> orders();
}
