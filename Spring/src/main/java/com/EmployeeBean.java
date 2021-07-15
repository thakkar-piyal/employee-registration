package com;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component("employee")
//@Service("employee")
//@Repository("employee")
//service,controller,repo
/*
 * @Scope("prototype")
 */public class EmployeeBean {

	@Value("101")
	private int eId;

	@Autowired
	private EmployeeDetail employeeDetail;

	public void display() {

		System.out.println("id = " + eId + "-" + employeeDetail.getEmpCity());
	}

	@PostConstruct
	public void initmethod() {

		System.out.println("init method called.");
	}

	@PreDestroy
	public void destroymethod() {

		System.out.println("destroy method called...");
	}
}