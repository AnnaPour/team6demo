package com.example.team6demo.services;

import gr.codelearn.spring.showcase.app.model.Customer;

public interface CustomerService extends BaseService<Customer, Long> {
	Customer findByEmail(String email);
}
