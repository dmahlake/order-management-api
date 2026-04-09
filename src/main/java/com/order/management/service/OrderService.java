package com.order.management.service;

import com.order.management.entity.CustomerOrder;
import com.order.management.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo repository;

    public OrderService(OrderRepo repository) {
        this.repository = repository;
    }

    public CustomerOrder createOrder(CustomerOrder order) {
        CustomerOrder savedOrder = repository.save(order);

        // Simulate event
        System.out.println("EVENT: OrderCreated -> " + savedOrder.getId());

        return savedOrder;
    }

    public List<CustomerOrder> getAllOrders() {
        return repository.findAll();
    }
}
