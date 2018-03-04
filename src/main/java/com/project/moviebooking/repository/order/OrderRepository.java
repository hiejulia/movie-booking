package com.project.moviebooking.repository.order;

import java.util.List;

import com.project.moviebooking.model.Customer;
import com.project.moviebooking.model.order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface OrderRepository extends MongoRepository<Order, Integer> {
    Order insert(Order order);

    List<Order> findByCustomer(Customer customer);

    Order findById(String orderId);

    Long deleteOrderById(String id);
}