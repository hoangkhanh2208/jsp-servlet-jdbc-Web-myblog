package com.myblog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.myblog.model.PostModel;

public class PostsMapper implements RowMapper<PostModel> {
	@Override
	public PostModel mapRow(ResultSet resultSet) {
		try {
			PostModel posts = new PostModel();
			posts.setId(resultSet.getLong("id"));
			posts.setTitle(resultSet.getString("title"));
			posts.setContent(resultSet.getString("content"));
			posts.setCategoryId(resultSet.getLong("categoryid"));
			posts.setThumbnail(resultSet.getString("thumbnail"));
			posts.setShortDescription(resultSet.getString("shortdescription"));
			posts.setCreatedDate(resultSet.getTimestamp("createddate"));
			posts.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				posts.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getString("modifiedby") != null) {
				posts.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return posts;
		} catch (SQLException e) {
			return null;
		}		
	}
}
