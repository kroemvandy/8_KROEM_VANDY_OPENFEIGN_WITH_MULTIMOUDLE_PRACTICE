package org.openfeign.testmultiproject.repository;

import org.openfeign.testmultiproject.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
