package com.myblog.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myblog.dao.ICategoryDAO;
import com.myblog.mapper.CategoryMapper;
import com.myblog.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}
	
	@Override
	public CategoryModel findOne(long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), id);
		return category.isEmpty() ? null : category.get(0);
	}
	
	@Override
    public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> category = query(sql, new CategoryMapper(), code);
		return category.isEmpty() ? null : category.get(0);
    }
}
