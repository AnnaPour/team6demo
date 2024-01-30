package com.example.team6demo.services;


import com.example.team6demo.model.Customer;

public interface CustomerService extends BaseService<Customer, Long> {
	Customer findByEmail(String email);
}
