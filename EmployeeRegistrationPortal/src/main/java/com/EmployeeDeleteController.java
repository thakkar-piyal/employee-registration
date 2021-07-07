package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmployeeDao;
import com.EmployeeService;

public class EmployeeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String empid = request.getParameter("eid");
		int eId = 0;
		if (!empid.equals(null) || !empid.equals("")) {

			eId = Integer.parseInt(empid);
		}
		EmployeeService employeeService = new EmployeeDao();
		if (employeeService.deleteEmployee(eId)) {

			response.sendRedirect("EmployeeListController");
		} else {

			response.sendRedirect("EmployeeListController");
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doGet(request, response);
	}

}