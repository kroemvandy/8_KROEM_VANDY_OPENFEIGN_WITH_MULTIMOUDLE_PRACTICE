package org.openfeign.testmultiproject.service;

import org.openfeign.testmultiproject.model.dto.OrderDto;
import org.openfeign.testmultiproject.model.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(OrderDto orderDto);
    Order updateOrder(Long orderId, OrderDto orderDto);
    void deleteOrder(Long orderId);
}
