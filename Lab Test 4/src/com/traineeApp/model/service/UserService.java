package com.traineeApp.model.service;

import com.traineeApp.model.persistence.user.User;

public interface UserService {
	public void addUser(User user);
	public User getUser(String username, String password);
}
