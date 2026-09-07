package com.example.orders.service;

import com.example.orders.client.UserServiceClient;
import com.example.orders.entity.Order;
import com.example.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final UserServiceClient users;

    public OrderService(OrderRepository repository, UserServiceClient users) {
        this.repository = repository;
        this.users = users;
    }

    public List<Order> listOrders() {
        return repository.findAll();
    }

    public Order getOrder(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Order placeOrder(Order order) {
        order.setStatus("PLACED");
        order.setPlacedAt(Instant.now());
        return repository.save(order);
    }

    /** Resolves the order's customer through the user service. */
    public String customerFor(Long orderId) throws Exception {
        Order order = getOrder(orderId);
        if (order == null) {
            return null;
        }
        return users.fetchUser(order.getUserId());
    }
}
