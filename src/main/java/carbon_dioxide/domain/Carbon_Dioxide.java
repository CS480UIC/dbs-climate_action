package carbon_dioxide.domain;

/**
 * Carbon_Dioxide object
 * 
 * @author Saksham Ayush
 * 
 */
public class Carbon_Dioxide {
	
	
	private String co_id;
	private Integer emission_year; 
	private Double co_metric;
	/**
	 * @return the co_id
	 */
	public String getCo_id() {
		return co_id;
	}
	/**
	 * @param co_id the co_id to set
	 */
	public void setCo_id(String co_id) {
		this.co_id = co_id;
	}
	/**
	 * @return the emission_year
	 */
	public Integer getEmission_year() {
		return emission_year;
	}
	/**
	 * @param emission_year the emission_year to set
	 */
	public void setEmission_year(Integer emission_year) {
		this.emission_year = emission_year;
	}
	/**
	 * @return the co_metric
	 */
	public Double getCo_metric() {
		return co_metric;
	}
	/**
	 * @param co_metric the co_metric to set
	 */
	public void setCo_metric(Double co_metric) {
		this.co_metric = co_metric;
	}
	
	
	
}
