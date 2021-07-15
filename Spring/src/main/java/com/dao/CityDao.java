package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import com.CITYBean;
import com.bean.CityBean;

@Repository("citDao")
public class CityDao {

	Scanner sc = new Scanner(System.in);
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int addCity() {

		System.out.println("Enter City Name = ");
		String cityName = sc.next();
		
		return jdbcTemplate.update("insert into city(cname) values(?)", cityName);
		
		
	}

	public int deleteCity() {
		System.out.println("Enter city id u want to delete");
		int cityId = sc.nextInt();
		jdbcTemplate.update("delete from temprature where cid = "+cityId);
		return jdbcTemplate.update("delete from city where cid =" + cityId );
	}

	
	public int addTemp() {
		System.out.println("Enter City Id = ");
		int cityID = sc.nextInt();
		System.out.println("Enter Morning Temp = ");
		int morn = sc.nextInt();
		System.out.println("Enter Evening Temp = ");
		int eve = sc.nextInt();
		System.out.println("Enter Night Temp = ");
		int night = sc.nextInt();
		float avg = (morn+eve+night)/3;
		return jdbcTemplate.update("insert into temprature(cid,mornTemp,eveTemp,nightTemp,average) values(?,?,?,?,?)",cityID,morn,eve,night,avg);
	}
	public CityBean averageTemp() {
		
		System.out.println("Enter city id to get it's temprature = ");
		int cityid = sc.nextInt();
	
		System.out.println("Average city temprature is ");
		return jdbcTemplate.queryForObject("select average from temprature where cid="+cityid,new Citymapper());
		
	}

	public int updateTemp() {
		System.out.println("Enter city ID ");
		int cityid = sc.nextInt();
		System.out.println("Enter updated temprature");
		System.out.println("Enter Morning Temp = ");
		int morn = sc.nextInt();
		System.out.println("Enter Evening Temp = ");
		int eve = sc.nextInt();
		System.out.println("Enter Night Temp = ");
		int night = sc.nextInt();
		float avg = (morn+eve+night)/3;
		
		return jdbcTemplate.update("update temprature set mornTemp="+morn+",eveTemp="+eve+",nightTemp="+night+",average="+avg+"where cid="+cityid);
	}
	private final static class Citymapper implements RowMapper<CityBean> {

		@Override
		public CityBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			CityBean cityBean = new CityBean();
			cityBean.setcId(rs.getInt("cid"));
			cityBean.setcName(rs.getString("cname"));
			cityBean.setmTemp(rs.getInt("mornTemp"));
			cityBean.seteTemp(rs.getInt("eveTemp"));
			cityBean.setnTemp(rs.getInt("nightTemp"));
			cityBean.setAverage(rs.getFloat("average"));
	
			return cityBean;
		}

	}

	public List<CityBean> getAllCity() {

		return jdbcTemplate.query("select * from city natural join temprature", new ResultSetExtractor<List<CityBean>>() {

			public List<CityBean> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<CityBean> list = new ArrayList<CityBean>();
				while (rs.next()) {

					CityBean cityBean = new CityBean();
					cityBean.setcId(rs.getInt("cid"));
					cityBean.setcName(rs.getString("cname"));
					cityBean.setmTemp(rs.getInt("mornTemp"));
					cityBean.seteTemp(rs.getInt("eveTemp"));
					cityBean.setnTemp(rs.getInt("nightTemp"));
					cityBean.setAverage(rs.getFloat("average"));
					list.add(cityBean);

				}

				return list;
			}

		});

	}

	public CityBean getTemByCityName() {
		
		System.out.println("Enter city name");
		String name = sc.next();
		//jdbcTemplate.query("select cid from city where cname='" + name + "'", new Citymapper());
		return jdbcTemplate.queryForObject("select temprature.mornTemp,temprature.eveTemp,temprature.nightTemp from temprature natural join city where cname ='" + name + "'", new Citymapper());
	}

	public List<CityBean> cityList() {
		System.out.println("enter city name ");
		String name = sc.next();
		return jdbcTemplate.query("select * from city natural join temprature where cname ='"+name+"'", new Citymapper());
	}

}