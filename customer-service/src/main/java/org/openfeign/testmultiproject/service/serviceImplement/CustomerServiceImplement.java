package org.openfeign.testmultiproject.service.serviceImplement;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.openfeign.testmultiproject.exception.CustomException;
import org.openfeign.testmultiproject.model.dto.CustomerDto;
import org.openfeign.testmultiproject.model.entity.Customer;
import org.openfeign.testmultiproject.repository.CustomerRepository;
import org.openfeign.testmultiproject.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImplement implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepository.findAll();
        return getAllCustomers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomException("Customer not found"));
        return null;
    }

    @Override
    public Customer createCustomer(CustomerDto CustomerDto) {
        Customer customer = modelMapper.map(CustomerDto, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, Customer.class);
    }

    @Override
    public Customer updateCustomer(Long id, CustomerDto CustomerDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomException("Customer not found"));

        modelMapper.map(CustomerDto, customer);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomException("Customer not found"));
        customerRepository.delete(customer);
    }
}
