package com.order.management.controller;

import com.order.management.entity.CustomerOrder;
import com.order.management.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerOrder createOrder(@Valid @RequestBody CustomerOrder order) {
        return service.createOrder(order);
    }

    @GetMapping
    public List<CustomerOrder> getOrders() {
        return service.getAllOrders();
    }
}
