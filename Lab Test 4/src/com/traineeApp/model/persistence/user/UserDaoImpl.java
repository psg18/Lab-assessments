package com.traineeApp.model.persistence.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.traineeApp.model.persistence.factory.ConnectionFactory;
import com.traineeApp.model.exceptions.UserNotFoundException;

public class UserDaoImpl implements UserDao{
	
	private Connection connection;
	
	 public UserDaoImpl() {
		connection=ConnectionFactory.getConnection();
	}
	@Override
	public void addUser(User user) {
		try {
			PreparedStatement pstmt=connection.prepareStatement("insert into users(username, password) values(?,?)");
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public User getUser(String username, String password) {
		User user=null;
		try {
			PreparedStatement pstmt=connection.prepareStatement("select * from users where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user=new User(rs.getInt(1),
						rs.getString(2), 
						rs.getString(3));
			}else {
				throw new UserNotFoundException("user with name : "+ username + " not found");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
