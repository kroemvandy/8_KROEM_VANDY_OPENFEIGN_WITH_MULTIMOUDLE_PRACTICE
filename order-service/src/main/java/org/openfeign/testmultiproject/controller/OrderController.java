package org.openfeign.testmultiproject.controller;

import lombok.AllArgsConstructor;
import org.openfeign.testmultiproject.dto.response.ApiResponse;
import org.openfeign.testmultiproject.dto.response.CustomerApiResponse;
import org.openfeign.testmultiproject.dto.response.OrderApiResponse;
import org.openfeign.testmultiproject.model.dto.OrderDto;
import org.openfeign.testmultiproject.model.entity.Order;
import org.openfeign.testmultiproject.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        OrderApiResponse<Object> apiResponse = OrderApiResponse
                .builder()
                .orderId()
                .customerResponse()
                .productResponses()
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        ApiResponse<Object> response = ApiResponse
                .builder()
                .message("Order deleted successfully")
                .status(HttpStatus.OK)
                .code(200)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        Order order = orderService.createOrder(orderDto);
        OrderApiResponse<Object> response = OrderApiResponse
                .builder()
                .orderId(order.getOrderId())
                .customerResponse(customerApiResponse)
                .productResponses(productResponse)
                .orderDate(order.getLocalDate().toString())
                .build();
        return ResponseEntity.ok(response);
    }

}
