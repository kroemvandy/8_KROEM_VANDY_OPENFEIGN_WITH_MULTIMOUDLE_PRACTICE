package org.openfeign.testmultiproject.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openfeign.testmultiproject.dto.response.ApiResponse;
import org.openfeign.testmultiproject.dto.response.ProductApiResponse;
import org.openfeign.testmultiproject.model.dto.request.ProductRequest;
import org.openfeign.testmultiproject.model.entity.Product;
import org.openfeign.testmultiproject.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<?>> getAllProducts() {
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .message("Get all products successfully")
                .status(HttpStatus.OK)
                .payload(productService.getAllProducts())
                .code(200)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(Collections.singletonList(apiResponse));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> findProductById(@PathVariable Long productId) {
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .message("Get product id " + productId + " successfully")
                .status(HttpStatus.OK)
                .payload(productService.getProductById(productId))
                .code(200)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest productRequest) {
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .message("Add product successfully")
                .status(HttpStatus.CREATED)
                .payload(productService.createProduct(productRequest))
                .code(201)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody ProductRequest productRequest) {
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .message("Update product id " + productId + " successfully")
                .status(HttpStatus.OK)
                .payload(productService.updateProduct(productId, productRequest))
                .code(200)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        ApiResponse<Object> apiResponse = ApiResponse
                .builder()
                .message("Delete product id " + productId + " successfully")
                .status(HttpStatus.OK)
                .code(200)
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}
