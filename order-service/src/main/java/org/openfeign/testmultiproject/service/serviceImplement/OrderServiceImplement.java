package org.openfeign.testmultiproject.service.serviceImplement;

import lombok.AllArgsConstructor;
import org.openfeign.testmultiproject.dto.response.CustomerApiResponse;
import org.openfeign.testmultiproject.fetchClient.CustomerFetchClient;
import org.openfeign.testmultiproject.fetchClient.ProductFetchClient;
import org.openfeign.testmultiproject.model.dto.OrderDto;
import org.openfeign.testmultiproject.model.entity.Order;
import org.openfeign.testmultiproject.repository.OrderRepository;
import org.openfeign.testmultiproject.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
public class OrderServiceImplement implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerFetchClient customerFetchClient;
    private final ProductFetchClient productFetchClient;


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return order;
    }

    @Override
    public Order createOrder(OrderDto orderDto) {
        ResponseEntity<?> customer = customerFetchClient.getCustomerById(orderDto.getCustomerId());
        CustomerApiResponse customerResponse = (CustomerApiResponse) customer.getBody();

        if (customerResponse == null) {
            throw new RuntimeException("Customer not found");
        }

        List<Long> productIds = orderDto.getProductIds();
        ResponseEntity<?> productResponse = productFetchClient.getProductsByIds(productIds);
        productResponse.getBody();


        Order order = new Order();
        order.setCustomerId(orderDto.getCustomerId());
        order.setProductIds(orderDto.getProductIds());
        order.setLocalDate(LocalDate.now());
        order = orderRepository.save(order);
    return order;
    }

    @Override
    public Order updateOrder(Long orderId, OrderDto orderDto) {
        return null;
    }

    @Override
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }
}
