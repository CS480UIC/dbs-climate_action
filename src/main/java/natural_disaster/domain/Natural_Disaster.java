package natural_disaster.domain;

import java.sql.Date;

/**
 * Natural Disaster object
 * 
 * @author Deepanshu Raghuvanshi
 * 
 */
public class Natural_Disaster {
	/*
	 * Correspond to the user table
	 */
	
	private Integer n_id;
	private String disaster_name;
	private Date occurence_date;
	private Double damage_cost;
	
	/**
	 * @return the n_id
	 */
	public Integer getN_id() {
		return n_id;
	}
	/**
	 * @param n_id the n_id to set
	 */
	public void setN_id(Integer n_id) {
		this.n_id = n_id;
	}
	/**
	 * @return the disaster_name
	 */
	public String getDisaster_name() {
		return disaster_name;
	}
	/**
	 * @param disaster_name the disaster_name to set
	 */
	public void setDisaster_name(String disaster_name) {
		this.disaster_name = disaster_name;
	}
	/**
	 * @return the occurence_date
	 */
	public Date getOccurence_date() {
		return occurence_date;
	}
	/**
	 * @param occurence_date the occurence_date to set
	 */
	public void setOccurence_date(Date occurence_date) {
		this.occurence_date = occurence_date;
	}
	/**
	 * @return the damage_cost
	 */
	public Double getDamage_cost() {
		return damage_cost;
	}
	/**
	 * @param damage_cost the damage_cost to set
	 */
	public void setDamage_cost(Double damage_cost) {
		this.damage_cost = damage_cost;
	}
	
	
}
