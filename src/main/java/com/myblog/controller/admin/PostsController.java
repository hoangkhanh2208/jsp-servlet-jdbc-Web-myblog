package com.myblog.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myblog.constant.SystemConstant;
import com.myblog.model.PostModel;
import com.myblog.paging.PageRequest;
import com.myblog.paging.Pageble;
import com.myblog.service.ICategoryService;
import com.myblog.service.IPostsService;
import com.myblog.sort.Sorter;
import com.myblog.utils.FormUtil;
import com.myblog.utils.MessageUtil;

@WebServlet(urlPatterns = "/admin-posts")
public class PostsController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IPostsService postsService;
	
	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostModel model = FormUtil.toModel(PostModel.class, request);
		String view = "";
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(postsService.findAll(pageble));
			model.setTotalItem(postsService.getTotalItem());
			model.setTotalPage((int)Math.ceil((double)model.getTotalItem() / model.getMaxPageItem()));
			view = "/WEB-INF/views/admin/posts/list.jsp";
		}else if(model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = postsService.findOne(model.getId());
			}	
			request.setAttribute("categories", categoryService.findAll());
			view = "/WEB-INF/views/admin/posts/edit.jsp";
			
		}
		
		MessageUtil.showMessage(request);
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
