package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmployeeBean;
import com.EmployeeDao;
import com.EmployeeService;


public class EmployeeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String id = request.getParameter("eid");
		int eId = 0;
		if (!id.equals("") || !id.equals(null)) {

			eId = Integer.parseInt(id);
		}

		EmployeeService employeeService = new EmployeeDao();
		EmployeeBean employeeBean = employeeService.getEmployeeById(eId);
		// null
		request.setAttribute("employeeBean", employeeBean);
		request.getRequestDispatcher("employeeEdit1.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}