package carbon_dioxide.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import carbon_dioxide.domain.Carbon_Dioxide;
import carbon_dioxide.domain.Emission;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class Carbon_DioxideDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "JSD"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "jega2rox"; //TODO change password

	public Carbon_Dioxide findByCOID_Year(String coid_p, Integer year_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Carbon_Dioxide carbon_dioxide = new Carbon_Dioxide();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
		    String sql = "select * from carbon_dioxide where co_id=? and emission_year=? ";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,coid_p);
		    preparestatement.setInt(2,year_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String co_id = resultSet.getString("co_id");
		    	Integer emission_year = resultSet.getInt("emission_year");
		    	if(co_id.equals(coid_p) && (emission_year.equals(year_p))){
		    		carbon_dioxide.setCo_id(co_id);
		    		carbon_dioxide.setEmission_year(emission_year);
		    		carbon_dioxide.setCo_metric(Double.parseDouble(resultSet.getString("co_metric")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return carbon_dioxide;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Carbon_Dioxide form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "insert into carbon_dioxide (co_id, emission_year, co_metric) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCo_id());
		    preparestatement.setInt(2,form.getEmission_year());
		    preparestatement.setDouble(3,form.getCo_metric());
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
	public void update(Carbon_Dioxide form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "UPDATE carbon_dioxide SET co_metric = ? where co_id = ? and emission_year = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setDouble(1,form.getCo_metric());
			preparestatement.setString(2,form.getCo_id());
		    preparestatement.setInt(3,form.getEmission_year());
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
	public void delete(String coid_p, Integer year_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "delete from carbon_dioxide where co_id = ? and emission_year=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,coid_p);
		    preparestatement.setInt(2,year_p);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Object> findEmission() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			String sql = "select emission_year, AVG(co_metric) as avg_metric from carbon_dioxide group by emission_year";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Emission user = new Emission();
				user.setYear(Integer.parseInt(resultSet.getString("emission_year")));
	    		user.setEmission(Double.parseDouble(resultSet.getString("avg_metric")));
	    		list.add(user);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
