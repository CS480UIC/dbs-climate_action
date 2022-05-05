package state.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import state.domain.FindAll;

//import java.util.ArrayList;
//import java.util.List;

import state.domain.State;
import user.domain.User;

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

	public State findByCode(String code_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		State state = new State();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
		    String sql = "select * from state where code=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,code_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String code = resultSet.getString("code");
		    	if(code.equals(code_p)){
		    		state.setCode(code);
		    		state.setName(resultSet.getString("name"));
		    		state.setArea(Integer.parseInt(resultSet.getString("area")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return state;
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
			
			String sql = "insert into state (code, name, area) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCode());
		    preparestatement.setString(2,form.getName());
		    preparestatement.setInt(3,form.getArea());
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
			
			String sql = "UPDATE state SET name=?, area=? where code=?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			preparestatement.setString(1,form.getName());
		    preparestatement.setInt(2,form.getArea());
		    preparestatement.setString(3,form.getCode());
		    preparestatement.executeUpdate();
		    System.out.println(form.getName());
		    System.out.println(form.getArea());
		    System.out.println(form.getCode());
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
	public void delete(String code_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			
			String sql = "delete from state where code=?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,code_p);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Object> findPopulation() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			String sql = "select name from state where area>100000 order by name";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				State state = new State();
				state.setName("name");
	    		/*state.setPassword(resultSet.getString("password"));
	    		state.setEmail(resultSet.getString("email"));*/
	    		list.add(state);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	
	public List<Object> findallstates() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			String sql = "select name,area from state where area>100000 order by name;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				State state = new State();
				state.setName(resultSet.getString("name"));
	    		state.setArea(Integer.parseInt(resultSet.getString("area")));
	    		
	    		list.add(state);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	public List<Object> listall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/climate_action", MySQL_user, MySQL_password);
			String sql = "select s.code, s.name, s.area, c.emission_year, c.co_metric from state s left join carbon_dioxide c on s.code=c.co_id";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				FindAll all = new FindAll();
				all.setCode(resultSet.getString("code"));
	    		all.setName(resultSet.getString("name"));
	    		all.setArea(Integer.parseInt(resultSet.getString("area")));
	    		all.setEmission_year(Integer.parseInt(resultSet.getString("emission_year")));
	    		all.setCo_metric(Double.parseDouble(resultSet.getString("co_metric")));
	    		list.add(all);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
		
	
}
