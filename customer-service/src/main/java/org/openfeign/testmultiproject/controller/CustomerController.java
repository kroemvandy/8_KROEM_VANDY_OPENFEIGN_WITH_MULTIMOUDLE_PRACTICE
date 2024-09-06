package org.openfeign.testmultiproject.controller;

import lombok.AllArgsConstructor;
import org.openfeign.testmultiproject.dto.response.ApiResponse;
import org.openfeign.testmultiproject.dto.response.CustomerApiResponse;
import org.openfeign.testmultiproject.model.dto.CustomerDto;
import org.openfeign.testmultiproject.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<?>> getAllCustomers() {
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .message("Get all customers successfully")
                .status(HttpStatus.OK)
                .payload(customerService.getAllCustomers())
                .code(200)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(Collections.singletonList(apiResponse));
    }

    @GetMapping("/{cusId}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long cusId) {
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .message("Get customer id " + cusId + " successfully")
                .status(HttpStatus.OK)
                .payload(customerService.getCustomerById(cusId))
                .code(200)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDto customerDto) {
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .message("Create customer successfully")
                .status(HttpStatus.CREATED)
                .payload(customerService.createCustomer(customerDto))
                .code(201)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{cusId}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long cusId, @RequestBody CustomerDto customerDto) {
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .message("Create customer successfully")
                .status(HttpStatus.OK)
                .payload(customerService.updateCustomer(cusId, customerDto))
                .code(200)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{cusId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long cusId) {
        customerService.deleteCustomer(cusId);
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .message("Create customer successfully")
                .status(HttpStatus.OK)
                .code(200)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
