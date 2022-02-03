package com.customerApp.model.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.customerApp.model.exception.CustomerNotFoundException;
import com.customerApp.model.exception.DataAccessException;

public class CustomerDaoImpl implements CustomerDao {

	private Connection connection;

	public CustomerDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addCustomer(Customer customer) {
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("insert into customer(name,address,mobileno, dob) values(?,?,?,?)");
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getAddress());
			pstmt.setString(3, customer.getMobileNo());
			pstmt.setDate(4, customer.getDob());

			pstmt.executeUpdate();

		} catch (SQLException ex) {
			throw new DataAccessException("Unable to Insert customer");
		}

	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		PreparedStatement pstmt;
		Customer customer = null;

		try {
			pstmt = connection.prepareStatement("Select * from customer where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"),
						rs.getString("mobileno"), rs.getDate("dob"));
			}
		} catch (SQLException ex) {
			throw new CustomerNotFoundException("Customer with id " + id + " not found.");
		}
		return Optional.ofNullable(customer);
	}

}
