package com.myblog.service;

import java.util.List;

import com.myblog.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
