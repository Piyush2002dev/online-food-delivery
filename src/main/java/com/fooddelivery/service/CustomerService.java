package com.fooddelivery.service;

import java.util.List;

import com.fooddelivery.dto.CustomerDto;

public interface CustomerService {

    CustomerDto registerCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(Long id);

    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long id, CustomerDto customerDto);
    
    void deleteCustomer(Long id);
}