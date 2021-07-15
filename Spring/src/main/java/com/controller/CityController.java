package com.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.CITYBean;
import com.bean.CityBean;
import com.config.DbConfig;
import com.dao.CityDao;


public class CityController {

	
	static ApplicationContext ctx;
	
	@Autowired
	static CityDao cityDao;
	
	
	public static void main(String[] args) {

		int choice = 0;
		System.out.println("1 - user cann add city first and then add temprature for the city");
		System.out.println("2 - user can delete city ");
		System.out.println("3 - user can able to get city temprature from city name");
		System.out.println("4 - user can able to get average day temprature by city name");
		System.out.println("5 - update city temprature");
		System.out.println("6 - Exit");
		System.out.println("Enter Task number which you want to perform...");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		
		
		switch(choice) {
		
			case 1:
				System.out.println(" case 1");
				ctx = new AnnotationConfigApplicationContext(DbConfig.class);
				cityDao = (CityDao) ctx.getBean("citDao");
				
				int res = cityDao.addCity();
				int res1 = cityDao.addTemp();
								
				if(res>0 && res1>0) {
					System.out.println("Record inserted..."); 
					
				}
				
				break;
			case 2:
				System.out.println(" case 2");
				ctx = new AnnotationConfigApplicationContext(DbConfig.class);
				cityDao = (CityDao) ctx.getBean("citDao");
				int res2 = cityDao.deleteCity();
				
				if(res2>0) {
					System.out.println("record deleted..."); 
					
				}
				
				break;
			case 3:
				System.out.println(" case 3");
				ctx = new AnnotationConfigApplicationContext(DbConfig.class);
				cityDao = (CityDao) ctx.getBean("citDao");
				List<CityBean> citylist = cityDao.cityList();
				  for(CityBean emp :citylist) {
				  System.out.println("cname morn even night");
				  System.out.println(emp.getcName()+"    "+emp.getmTemp()+"   "+emp.geteTemp()+"    "+emp.getnTemp()); 
				  }
				break;
				
			case 4:
				System.out.println(" case 4");
				ctx = new AnnotationConfigApplicationContext(DbConfig.class);
				cityDao = (CityDao) ctx.getBean("citDao");
				//cityDao.averageTemp();
				//cityDao.cityList();
				//cityDao.cityList();
				List<CityBean> citylist1 = cityDao.cityList();
				  for(CityBean emp :citylist1) {
				  System.out.println("avg");
				  System.out.println(emp.getAverage()); 
				  }
				break;
			case 5:
				ctx = new AnnotationConfigApplicationContext(DbConfig.class);
				cityDao = (CityDao) ctx.getBean("citDao");
				int res3 = cityDao.updateTemp();
				if(res3>0) {
					System.out.println("Temprature record updated..."); 
					
				}
				break;
			case 6:
				System.out.println("Exit..");
				return;
		
			default:
				System.out.println("Enter valid case");
				break;
			
		
		
		}
		
		// natural join - to get all data
			
		
		 
		  
		  
		 
		
		
	}
}

	
	
	
