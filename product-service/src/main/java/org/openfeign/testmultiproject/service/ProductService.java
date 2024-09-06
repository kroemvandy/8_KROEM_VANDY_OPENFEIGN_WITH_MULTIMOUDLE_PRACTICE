package org.openfeign.testmultiproject.service;


import org.openfeign.testmultiproject.model.dto.request.ProductRequest;
import org.openfeign.testmultiproject.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    Product createProduct(ProductRequest productRequest);
    Product updateProduct(Long productId, ProductRequest productRequest);
    void deleteProduct(Long productId);
}
