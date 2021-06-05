package com.myblog.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.myblog.dao.ICategoryDAO;
import com.myblog.model.CategoryModel;
import com.myblog.service.ICategoryService;

public class CategoryService implements ICategoryService{
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<CategoryModel> findAll() {
		return null;
	}
	
	
}
