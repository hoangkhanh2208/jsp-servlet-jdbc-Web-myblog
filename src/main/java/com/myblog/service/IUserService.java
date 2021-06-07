package com.myblog.service;


import com.myblog.model.UserModel;


public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
