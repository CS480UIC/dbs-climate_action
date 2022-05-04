package natural_disaster.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import natural_disaster.domain.Natural_Disaster;

/**
 * DDL functions performed in database
 */
public class Natural_DisasterDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "JSD"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "jega2rox"; //TODO change password

	public Natural_Disaster findByNid(Integer nid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Natural_Disaster natural_disaster = new Natural_Disaster();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
		    String sql = "select * from natural_disaster where n_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,nid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer n_id = Integer.parseInt(resultSet.getString("n_id"));
		    	if(n_id == nid){
		    		natural_disaster.setN_id(Integer.parseInt(resultSet.getString("n_id")));
		    		natural_disaster.setDisaster_name(resultSet.getString("disaster_name"));
		    		natural_disaster.setOccurence_date(java.sql.Date.valueOf(resultSet.getString("occurence_date")));		
		    		natural_disaster.setDamage_cost(Double.parseDouble(resultSet.getString("damage_cost")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return natural_disaster;
	}	
	
	/**
	 * insert Natural Disaster
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Natural_Disaster form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "insert into natural_disaster(n_id,disaster_name,occurence_date,damage_cost) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getN_id());
		    preparestatement.setString(2,form.getDisaster_name());
		    preparestatement.setDate(3,form.getOccurence_date());
		    preparestatement.setDouble(4,form.getDamage_cost());
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
	public void update(Natural_Disaster form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "UPDATE natural_disaster SET disaster_name = ?, occurence_date = ?, damage_cost = ? where n_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getDisaster_name());
			preparestatement.setDate(2,form.getOccurence_date());
		    preparestatement.setDouble(3,form.getDamage_cost());
		    preparestatement.setInt(4,form.getN_id());
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
	public void delete(Integer nid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "delete from natural_disaster where n_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,nid);
		    preparestatement.executeUpdate();
		    System.out.println(nid);
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
