package com.myblog.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.myblog.dao.ICategoryDAO;
import com.myblog.dao.IPostsDAO;
import com.myblog.model.CategoryModel;
import com.myblog.model.PostModel;
import com.myblog.paging.Pageble;
import com.myblog.service.IPostsService;

public class PostsService implements IPostsService{
	@Inject
	private IPostsDAO postsDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<PostModel> findByCategoryId(long categoryId) {	
		return postsDAO.findByCategoryId(categoryId);
	}
	
	@Override
	public PostModel save(PostModel postModel) {
		postModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(postModel.getCategoryCode());
		postModel.setCategoryId(category.getId());
		long postId = postsDAO.save(postModel);
		return postsDAO.findOne(postId);
	}
	
	@Override
	public PostModel update(PostModel updatePost) {
		PostModel oldPost = postsDAO.findOne(updatePost.getId());
		updatePost.setCreatedDate(oldPost.getCreatedDate());
		updatePost.setCreatedBy(oldPost.getCreatedBy());
		updatePost.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findOneByCode(updatePost.getCategoryCode());
		updatePost.setCategoryId(category.getId());
		postsDAO.update(updatePost);
		return postsDAO.findOne(updatePost.getId());
	}
	
	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			postsDAO.delete(id);
		}
	}
	
	@Override
	public List<PostModel> findAll(Pageble pageble) {
		return postsDAO.findAll(pageble);
	}
	
	@Override
	public int getTotalItem() {
		return postsDAO.getTotalItem();
	} 
	
	@Override
	public PostModel findOne(long id) {
		PostModel postModel = postsDAO.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOne(postModel.getCategoryId());
		postModel.setCategoryCode(categoryModel.getCode());
		
		return postModel;
	}
	
	
}
