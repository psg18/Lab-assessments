package com.traineeApp.model.service;

import com.traineeApp.model.persistence.user.User;
import com.traineeApp.model.persistence.user.UserDao;
import com.traineeApp.model.persistence.user.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	
	public UserServiceImpl() {
		userDao=new UserDaoImpl();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

}
