package com.myblog.dao;

import java.util.List;

import com.myblog.model.PostModel;
import com.myblog.paging.Pageble;

public interface IPostsDAO extends GenericDAO<PostModel>{
	PostModel findOne(long id);
	List<PostModel> findByCategoryId(long categoryId);
	Long save(PostModel model);
	void update(PostModel updatePost);
	void delete(long id);
	List<PostModel> findAll(Pageble pageble);
	int getTotalItem();
}
