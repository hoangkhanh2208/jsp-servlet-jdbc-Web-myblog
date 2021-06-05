package com.myblog.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myblog.model.PostModel;
import com.myblog.service.IPostsService;
import com.myblog.utils.HttpUtil;

@WebServlet(urlPatterns = "/api-admin-post")
public class PostAPI extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPostsService postService;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PostModel postModel = HttpUtil.of(request.getReader()).toModel(PostModel.class);
		postModel = postService.save(postModel);
		mapper.writeValue(response.getOutputStream(), postModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PostModel updatePost = HttpUtil.of(request.getReader()).toModel(PostModel.class);
		updatePost = postService.update(updatePost);
		mapper.writeValue(response.getOutputStream(), updatePost);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PostModel postModel = HttpUtil.of(request.getReader()).toModel(PostModel.class);
		postService.delete(postModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{}");
	}
	
	
}
