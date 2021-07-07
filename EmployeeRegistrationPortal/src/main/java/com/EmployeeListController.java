package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmployeeBean;
import com.EmployeeDao;
import com.EmployeeService;


public class EmployeeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		EmployeeService employeeService = new EmployeeDao();
		List<EmployeeBean> employees = employeeService.getAllEmployees();

		request.setAttribute("employees", employees);
		request.getRequestDispatcher("employeeList.jsp").forward(request, response);		

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}