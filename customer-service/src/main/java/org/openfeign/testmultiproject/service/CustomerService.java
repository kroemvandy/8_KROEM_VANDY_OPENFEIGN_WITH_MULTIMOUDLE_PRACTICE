package org.openfeign.testmultiproject.service;

import org.openfeign.testmultiproject.model.dto.CustomerDto;
import org.openfeign.testmultiproject.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer createCustomer(CustomerDto CustomerDto);
    Customer updateCustomer(Long id, CustomerDto CustomerDto);
    void deleteCustomer(Long id);
}
