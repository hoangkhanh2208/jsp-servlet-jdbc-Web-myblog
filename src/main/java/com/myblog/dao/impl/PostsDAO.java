package com.myblog.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myblog.dao.IPostsDAO;
import com.myblog.mapper.PostsMapper;
import com.myblog.model.CategoryModel;
import com.myblog.model.PostModel;
import com.myblog.paging.Pageble;

public class PostsDAO extends AbstractDAO<PostModel> implements IPostsDAO{
	
	@Override
	public List<PostModel> findByCategoryId(long categoryId) {
		String sql = "SELECT * FROM posts WHERE categoryid = ?";
		return query(sql, new PostsMapper(), categoryId);
	}
	
	@Override
	public Long save(PostModel postModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO posts (title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), postModel.getTitle(), postModel.getContent(), 
				postModel.getThumbnail(), postModel.getShortDescription(), postModel.getCategoryId(),
				postModel.getCreatedDate(), postModel.getCreatedBy());
	}
	
	@Override
	public PostModel fineOne(long id) {
		String sql = "SELECT * FROM posts WHERE id = ?";
		List<PostModel> post = query(sql, new PostsMapper(), id);
		return post.isEmpty() ? null : post.get(0);
	}
	
	@Override
	public void update(PostModel updatePost) {
		StringBuilder sql = new StringBuilder("UPDATE posts SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		
		update(sql.toString(), updatePost.getTitle(), updatePost.getThumbnail(), updatePost.getShortDescription(),
				updatePost.getContent(), updatePost.getCategoryId(), updatePost.getCreatedDate(), 
				updatePost.getCreatedBy(), updatePost.getModifiedDate(), 
				updatePost.getModifiedBy(), updatePost.getId());
		
	}
	
	@Override
	public void delete(long id) {
		String sql = "DELETE FROM posts WHERE id = ?";
		update(sql, id);
		
	}
	
	@Override
	public List<PostModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM posts ");
		if (pageble.getSorter() != null ) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + " , " + pageble.getLimit() + " " );
		}
		return query(sql.toString(), new PostsMapper());
	}
	
	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM posts";
		return count(sql);
	}
}
