package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmployeeBean;
import com.EmployeeDao;
import com.EmployeeService;

public class EmployeeRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String eName = request.getParameter("txtEmployeeName");
		String ePassword = request.getParameter("pwdEmployeePassword");
		String eEmail = request.getParameter("txtEmployeeEmail");
		String age = request.getParameter("txtEmployeeAge");
		int eAge = 0;
		if (!age.equals("") || !age.equals(null)) {

			eAge = Integer.parseInt(age);
		}

		EmployeeBean employeeBean = new EmployeeBean();
	
		employeeBean.seteName(eName);
		employeeBean.seteEmail(eEmail);
		employeeBean.setePassword(ePassword);
		employeeBean.setEage(eAge);

		EmployeeService employeeService = new EmployeeDao();

		if (employeeService.addEmployee(employeeBean)) {

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