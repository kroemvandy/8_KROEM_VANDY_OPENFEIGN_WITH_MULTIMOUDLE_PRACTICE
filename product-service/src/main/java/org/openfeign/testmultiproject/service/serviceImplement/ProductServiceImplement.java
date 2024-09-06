package org.openfeign.testmultiproject.service.serviceImplement;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openfeign.testmultiproject.exception.CustomException;
import org.openfeign.testmultiproject.model.dto.request.ProductRequest;
import org.openfeign.testmultiproject.model.entity.Product;
import org.openfeign.testmultiproject.repository.ProductRepository;
import org.openfeign.testmultiproject.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplement implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public Product getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new CustomException("Product not found"));
        return product;
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = modelMapper.map(productRequest, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, Product.class);
    }

    @Override
    public Product updateProduct(Long productId, ProductRequest productRequest) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new CustomException("Product not found"));

        modelMapper.map(productRequest, product);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new CustomException("Product not found"));
        productRepository.delete(product);
    }
}
