package com.myblog.service;

import java.util.List;

import com.myblog.model.PostModel;
import com.myblog.paging.Pageble;

public interface IPostsService {
	List<PostModel> findByCategoryId(long categoryId);
	PostModel save(PostModel postModel);
	PostModel update(PostModel updatePost);
	void delete(long[] ids); 
	List<PostModel> findAll(Pageble pageble);
	int getTotalItem();
}
