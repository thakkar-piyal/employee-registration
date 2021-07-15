/*
 * package com.dao;
 * 
 * import java.sql.ResultSet; import java.sql.SQLException; import
 * java.util.ArrayList; import java.util.List; import java.util.Scanner;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.dao.DataAccessException; import
 * org.springframework.jdbc.core.JdbcTemplate; import
 * org.springframework.jdbc.core.ResultSetExtractor; import
 * org.springframework.jdbc.core.RowMapper; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.CITYBean; //import com.bean.TempBean; //import
 * com.dao.CityDao.Citymapper;
 * 
 * @Repository("temDao") public class TempDao {
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * @Autowired JdbcTemplate jdbcTemplate;
 * 
 * 
 * public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
 * 
 * 
 * public int addTemp() { System.out.println("Enter Morning Temp = "); int morn
 * = sc.nextInt(); System.out.println("Enter Evening Temp = "); int eve =
 * sc.nextInt(); System.out.println("Enter Night Temp = "); int night =
 * sc.nextInt(); float avg = (morn+eve+night)/3; return jdbcTemplate.
 * update("insert into temprature(mornTemp,eveTemp,nightTemp,average) values(?,?,?,?)"
 * ,morn,eve,night,avg); }
 * 
 * public int averageTemp() {
 * 
 * System.out.println("Enter city name to get it's temprature = "); String
 * cityName = sc.next(); System.out.println("Average city temprature is ");
 * return jdbcTemplate.
 * update("select temprature.average from temprature left outer join city on temprature.cid=city.cid where cname= "
 * +cityName);
 * 
 * }
 * 
 * }
 */