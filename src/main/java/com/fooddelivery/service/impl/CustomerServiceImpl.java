package com.fooddelivery.service.impl;

import org.springframework.stereotype.Service;

import com.fooddelivery.dto.CustomerDto;
import com.fooddelivery.entity.Customer;
import com.fooddelivery.exception.ResourceNotFoundException;
import com.fooddelivery.repository.CustomerRepository;
import com.fooddelivery.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    
    // Constructor injection
    public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
    public CustomerDto registerCustomer(CustomerDto customerDto) {

        Customer customer = mapToEntity(customerDto);
        Customer saved = customerRepository.save(customer);

        return mapToDto(saved);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return mapToDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {

        return customerRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));

        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setAddress(customerDto.getAddress());

        Customer updated = customerRepository.save(customer);
        return mapToDto(updated);
    }

    @Override
    public void deleteCustomer(Long id) {

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepository.delete(customer);
    }

    // Helper methods

    private CustomerDto mapToDto(Customer entity) {

        CustomerDto dto = new CustomerDto();

        dto.setId(entity.getCustomerId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());

        return dto;
    }

    private Customer mapToEntity(CustomerDto dto) {

        Customer entity = new Customer();

        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());

        return entity;
    }
}