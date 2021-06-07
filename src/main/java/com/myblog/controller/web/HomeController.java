
package com.myblog.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myblog.model.PostModel;
import com.myblog.model.UserModel;
import com.myblog.service.ICategoryService;
import com.myblog.service.IPostsService;
import com.myblog.service.IUserService;
import com.myblog.service.impl.CategoryService;
import com.myblog.utils.FormUtil;
import com.myblog.utils.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet{
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IUserService userService;
	
	ResourceBundle bundle = ResourceBundle.getBundle("message");
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if (message != null && alert != null) {
				request.setAttribute("message", bundle.getString(message));
				request.setAttribute("alert", alert);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}else if(action != null && action.equals("logout") ) {
			SessionUtil.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		}else {
			request.setAttribute("categories", categoryService.findAll());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/web/home.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, request);
			model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
			if (model != null) {
				SessionUtil.getInstance().putValue(request, "USERMODEL", model);
				if(model.getRole().getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
				}
				else if (model.getRole().getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin-home");
				}
			}
			else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
			
		}
	}
}
