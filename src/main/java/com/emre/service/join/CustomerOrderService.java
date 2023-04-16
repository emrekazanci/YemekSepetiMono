package com.emre.service.join;

import com.emre.repository.entity.join.CustomerOrder;
import com.emre.repository.join.ICustomerOrderRepository;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService extends ServiceManager<CustomerOrder,Long> {
    private final ICustomerOrderRepository customerOrderRepository;

    public CustomerOrderService(ICustomerOrderRepository customerOrderRepository) {
        super(customerOrderRepository);
        this.customerOrderRepository = customerOrderRepository;
    }

    public List<CustomerOrder> orderForCustomer(Long customerId) {
        return customerOrderRepository.orderForCustomer(customerId);
    }
}
