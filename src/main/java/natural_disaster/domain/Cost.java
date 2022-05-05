package natural_disaster.domain;

public class Cost {
	private String disaster_name;
	private Double damage_cost;
	
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
