package com.fooddelivery.controller;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.dto.CustomerDto;
import com.fooddelivery.service.CustomerService;

import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    // Constructor injection
    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    // Create a new customer
    
    @PostMapping
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody @Valid CustomerDto customerDto) {

        CustomerDto created = customerService.registerCustomer(customerDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Get all customers
    
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {

        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    // Get customer by ID
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {

        CustomerDto customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    // Update customer
    
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerDto customerDto) {

        CustomerDto updated = customerService.updateCustomer(id, customerDto);
        return ResponseEntity.ok(updated);
    }

    // Delete customer

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {

        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully.");
    }
}