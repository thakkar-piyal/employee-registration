package com;

import java.util.List;

import com.EmployeeBean;

public interface EmployeeService {

	public boolean addEmployee(EmployeeBean employeeBean);

	public List<EmployeeBean> getAllEmployees();

	public boolean deleteEmployee(int eId);

	public EmployeeBean getEmployeeById(int eId);

	public boolean updateEmployee(EmployeeBean employeeBean);

}