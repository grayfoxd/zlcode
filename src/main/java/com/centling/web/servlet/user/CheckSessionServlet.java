package com.centling.web.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.centling.common.util.ConstWords;
import com.centling.common.util.LoginContext;
import com.centling.web.servlet.ServletServiceController;

public class CheckSessionServlet extends ServletServiceController {

	private static final long serialVersionUID = -7036407629385969386L;

	public CheckSessionServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginContext.removeSessionByLogin(request);// 释放平台session
		HttpSession session = request.getSession(true);// 在线人员
		session.removeAttribute(ConstWords.OnLineUser_Sign);
		response.sendRedirect("login.jsp");
		return;
	}

	public void init() throws ServletException {
		super.init();
	}
}
