package com.emre.service;

import com.emre.dto.request.SaveOrderRequestDto;
import com.emre.exception.ErrorType;
import com.emre.exception.YemekSepetiException;
import com.emre.mapper.IOrderMapper;
import com.emre.repository.IOrderRepository;
import com.emre.repository.entity.Customer;
import com.emre.repository.entity.EStatus;
import com.emre.repository.entity.Order;
import com.emre.repository.entity.Product;
import com.emre.repository.entity.join.CustomerOrder;
import com.emre.repository.entity.join.OrderProduct;
import com.emre.repository.entity.join.OrderRestaurant;
import com.emre.service.join.CustomerOrderService;
import com.emre.service.join.OrderProductService;
import com.emre.service.join.OrderRestaurantService;
import com.emre.utility.ServiceManager;
import org.aspectj.apache.bcel.classfile.annotation.RuntimeInvisAnnos;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService extends ServiceManager<Order, Long> {
    private final IOrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private final CustomerOrderService customerOrderService;
    private final OrderRestaurantService orderRestaurantService;
    private final OrderProductService orderProductService;

    public OrderService(IOrderRepository orderRepository,
                        CustomerService customerService,
                        ProductService productService,
                        CustomerOrderService customerOrderService,
                        OrderRestaurantService orderRestaurantService,
                        OrderProductService orderProductService) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.customerOrderService = customerOrderService;
        this.orderRestaurantService = orderRestaurantService;
        this.orderProductService = orderProductService;
    }

    public Order save(SaveOrderRequestDto dto) {
        Order order = IOrderMapper.INSTANCE.fromDtoToOrder(dto);
        Customer customer = customerService.findById(dto.getCustomerId()).get();
        if (customer.getStatus().equals(EStatus.PENDING))
            throw new YemekSepetiException(ErrorType.USER_NOTACTIVE);
        //Tek siparişte sadece aynı restauranttan ürünün eklenebilmesi.
        Set<Long> restaurantId = new HashSet<>();
        order.getProductId().forEach(id -> {
            Product product = productService.findById(id).get();
            restaurantId.add(product.getRestaurantId());
        });
        if (restaurantId.size() > 1) {
            throw new YemekSepetiException(ErrorType.ORDER_DIFFERENT_RESTAURANT);
        }
        return save(order);
    }

    public List<CustomerOrder> orderForCustomer(Long customerId) {
        return customerOrderService.orderForCustomer(customerId);
    }

    public List<OrderRestaurant> orderForRestaurant(Long restaurantId) {
        return orderRestaurantService.orderForRestaurant(restaurantId);
    }

    public List<OrderProduct> orders() {
        return orderProductService.orders();
    }
}
