package com.customerApp.model.service;

import java.util.Optional;

import com.customerApp.model.persistance.Customer;
import com.customerApp.model.persistance.CustomerDao;
import com.customerApp.model.persistance.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	
	public CustomerServiceImpl() {
		customerDao=new CustomerDaoImpl();
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}
	

}
