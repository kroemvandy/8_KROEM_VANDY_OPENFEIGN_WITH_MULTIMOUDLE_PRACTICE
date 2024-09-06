package org.openfeign.testmultiproject.repository;

import org.openfeign.testmultiproject.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
