package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AdminBean;
import com.AdminDao;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String aEmail = request.getParameter("txtAdminEmail");
		String aPassword = request.getParameter("pwdAdminPassword");
		
		AdminBean adminBean = new AdminDao().login(aEmail, aPassword);
		
		HttpSession session = request.getSession();
		session.setAttribute("adminBean", adminBean);
		response.sendRedirect("firstpage.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}