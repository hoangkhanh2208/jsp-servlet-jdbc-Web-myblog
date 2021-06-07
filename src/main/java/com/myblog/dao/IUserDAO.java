package com.myblog.dao;

import com.myblog.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
