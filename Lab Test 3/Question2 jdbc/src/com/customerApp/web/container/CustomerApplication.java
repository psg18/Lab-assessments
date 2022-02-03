package com.customerApp.web.container;

import java.sql.Date;
import java.util.Optional;

import com.customerApp.model.exception.CustomerNotFoundException;
import com.customerApp.model.persistance.Customer;
import com.customerApp.model.service.CustomerServiceImpl;

public class CustomerApplication {

	public static void main(String[] args) {

		CustomerServiceImpl service = new CustomerServiceImpl();
		
		//adding a customer
		Date dob=Date.valueOf("2000-08-07");
		Customer customer=new Customer("Paras", "Delhi", "9971611373", dob);
		service.addCustomer(customer);

		
		//find customer by id
		int id = 4;
		Optional<Customer> getCustomerById = service.getCustomerById(id);
		
//		if(getCustomerById.isPresent()) {
//			System.out.println(getCustomerById.get());
//		}
//		else {
//			System.out.println("Customer with id "+id+" not found!");
//		}
		
		System.out.println(getCustomerById
				.orElseThrow(() -> new CustomerNotFoundException("Customer with id " + id + " not found!")));

	}

}
