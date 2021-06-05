package com.myblog.dao;

import java.util.List;

import com.myblog.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
}
