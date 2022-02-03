package com.customerApp.model.service;

import java.util.Optional;

import com.customerApp.model.persistance.Customer;

public interface CustomerService {
	public void addCustomer(Customer customer);

	public Optional<Customer> getCustomerById(int id);
}
