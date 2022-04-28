package aqi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aqi.domain.Aqi;

//import java.util.ArrayList;
//import java.util.List;

import aqi.domain.Aqi;

/**
 * DDL functions performed in database
 */
public class AqiDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "JSD"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "jega2rox"; //TODO change password

	public Aqi findByAqiMeasuring(String aqi_idp, Integer measuringyear) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Aqi aqi = new Aqi();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
		    String sql = "select * from aqi where aqi_id=? and measuring_year=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,aqi_idp);
		    preparestatement.setInt(2,measuringyear);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String aqi_id = resultSet.getString("aqi_id");
		    	Integer measuring_year = Integer.parseInt(resultSet.getString("measuring_year"));
		    	if(aqi_id.equals(aqi_idp) && measuring_year.equals(measuringyear)){
		    		aqi.setAqi_id(aqi_id);
		    		aqi.setMeasuring_year(Integer.parseInt(resultSet.getString("measuring_year")));
		    		aqi.setAqi_metric(Integer.parseInt(resultSet.getString("aqi_metric")));
		    		aqi.setReporting_city(resultSet.getString("reporting_city"));
		    		aqi.setReporting_date(java.sql.Date.valueOf(resultSet.getString("reporting_date")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return aqi;
	}	
	
	/**
	 * insert Aqi
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Aqi form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "insert into aqi(aqi_id,measuring_year,aqi_metric,reporting_city,reporting_date) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getAqi_id());
		    preparestatement.setInt(2,form.getMeasuring_year());
		    preparestatement.setInt(3,form.getAqi_metric());
		    preparestatement.setString(4,form.getReporting_city());
		    preparestatement.setDate(5,form.getReporting_date());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	
	public void update(Aqi form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "UPDATE aqi SET measuring_year = ?, aqi_metric = ?, reporting_city = ?, reporting_date = ? where aqi_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getMeasuring_year());
		    preparestatement.setInt(2,form.getAqi_metric());
		    preparestatement.setString(3,form.getReporting_city());
		    preparestatement.setDate(4,form.getReporting_date());
		    preparestatement.setString(5,form.getAqi_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	
	public void delete(String aqi_idp, Integer measuringyear) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "delete from aqi where aqi_id = ? and measuring_year = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,aqi_idp);
		    preparestatement.setInt(2,measuringyear);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
