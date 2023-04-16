package com.emre.service.join;

import com.emre.repository.entity.join.OrderProduct;
import com.emre.repository.join.IOrderProductRepository;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService extends ServiceManager<OrderProduct,Long> {
    private final IOrderProductRepository orderProductRepository;

    public OrderProductService(IOrderProductRepository orderProductRepository) {
        super(orderProductRepository);
        this.orderProductRepository = orderProductRepository;
    }

    public List<OrderProduct> orders() {
        return orderProductRepository.orders();
    }
}
