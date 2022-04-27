package state.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class State {
<<<<<<< HEAD
	
	
	private String code;
	private String name; 
	private Integer area;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the area
	 */
	public Integer getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(Integer area) {
		this.area = area;
	}
	
	
	
=======
	/*
	 * Correspond to the user table
	 */
	
	private String username;
	private String password; 
	private String email;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [ username=" + username + ", password="
				+ password + ", email=" + email +"]";
	}
>>>>>>> branch 'main' of git@github.com:CS480UIC/dbs-climate_action.git
}
