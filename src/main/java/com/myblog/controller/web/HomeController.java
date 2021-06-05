
package com.myblog.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myblog.model.PostModel;
import com.myblog.service.ICategoryService;
import com.myblog.service.IPostsService;
import com.myblog.service.impl.CategoryService;

@WebServlet(urlPatterns = "/trang-chu")
public class HomeController extends HttpServlet{
	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("categorys", categoryService.findAll());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/web/home.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
