package com.myblog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.myblog.model.RoleModel;
import com.myblog.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {
	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setFullName(resultSet.getString("fullname"));
			user.setStatus(resultSet.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} {
				// TODO: handle finally clause
			}
			return user;
		} catch (SQLException e) {
			return null;
		}		
	}
}
