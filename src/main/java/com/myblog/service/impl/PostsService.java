package com.myblog.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.myblog.dao.IPostsDAO;
import com.myblog.model.PostModel;
import com.myblog.paging.Pageble;
import com.myblog.service.IPostsService;

public class PostsService implements IPostsService{
	@Inject
	private IPostsDAO postsDAO;
	
	@Override
	public List<PostModel> findByCategoryId(long categoryId) {	
		return postsDAO.findByCategoryId(categoryId);
	}
	
	@Override
	public PostModel save(PostModel postModel) {
		postModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		postModel.setCreatedBy("");
		long postId = postsDAO.save(postModel);
		return postsDAO.fineOne(postId);
	}
	
	@Override
	public PostModel update(PostModel updatePost) {
		PostModel oldPost = postsDAO.fineOne(updatePost.getId());
		updatePost.setCreatedDate(oldPost.getCreatedDate());
		updatePost.setCreatedBy(oldPost.getCreatedBy());
		updatePost.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updatePost.setCreatedBy("");
		postsDAO.update(updatePost);
		return postsDAO.fineOne(updatePost.getId());
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
}
