package org.openfeign.testmultiproject.repository;


import org.openfeign.testmultiproject.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
