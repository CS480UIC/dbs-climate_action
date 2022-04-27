package state.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import state.domain.State;

/**
 * DDL functions performed in database
 */
public class StateDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "JSD"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "jega2rox"; //TODO change password

<<<<<<< HEAD
	public State findByCode(String code_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		State state = new State();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
		    String sql = "select * from book where code=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,code_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String code = resultSet.getString("code");
		    	if(code.equals(code_p)){
		    		state.setArea(Integer.parseInt(resultSet.getString("area")));
		    		state.setCode(code);
		    		state.setName(resultSet.getString("name"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return state;
	}	
	
	/**
	 * insert state
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(State form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "insert into state (code, name, area) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCode());
		    preparestatement.setString(2,form.getName());
		    preparestatement.setInt(3,form.getArea());
=======
	public State findByUsername(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		State entity1 = new State();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
		    String sql = "select * from entity1 where username=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String user_name = resultSet.getString("username");
		    	if(user_name.equals(username)){
		    		entity1.setUsername(resultSet.getString("username"));
		    		entity1.setPassword(resultSet.getString("password"));
		    		entity1.setEmail(resultSet.getString("email"));		
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return entity1;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(State form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "insert into entity1 values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getUsername());
		    preparestatement.setString(2,form.getPassword());
		    preparestatement.setString(3,form.getEmail());
>>>>>>> branch 'main' of git@github.com:CS480UIC/dbs-climate_action.git
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
	public void update(State form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "UPDATE entity1 SET password = ?, email = ? where username = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getPassword());
			preparestatement.setString(2,form.getEmail());
		    preparestatement.setString(3,form.getUsername());
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
	public void delete(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "delete from entity1 where username = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
