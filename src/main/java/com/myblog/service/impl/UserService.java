package com.myblog.service.impl;


import javax.inject.Inject;

import com.myblog.dao.IUserDAO;
import com.myblog.model.UserModel;
import com.myblog.service.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
}
