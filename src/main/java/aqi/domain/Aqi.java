package aqi.domain;

import java.sql.Date;

/**
 * Aqi object
 * 
 * @author Deepanshu Raghuvanshi
 * 
 */
public class Aqi {
	
	private String aqi_id;
	private Integer measuring_year; 
	private Integer aqi_metric;
	private String reporting_city; 
	private Date reporting_date;
	
	/**
	 * @return the aqi_id
	 */
	public String getAqi_id() {
		return aqi_id;
	}
	/**
	 * @param aqi_id the aqi_id to set
	 */
	public void setAqi_id(String aqi_id) {
		this.aqi_id = aqi_id;
	}
	/**
	 * @return the measuring_year
	 */
	public Integer getMeasuring_year() {
		return measuring_year;
	}
	/**
	 * @param measuring_year the measuring_year to set
	 */
	public void setMeasuring_year(Integer measuring_year) {
		this.measuring_year = measuring_year;
	}
	/**
	 * @return the aqi_metric
	 */
	public Integer getAqi_metric() {
		return aqi_metric;
	}
	/**
	 * @param aqi_metric the aqi_metric to set
	 */
	public void setAqi_metric(Integer aqi_metric) {
		this.aqi_metric = aqi_metric;
	}
	/**
	 * @return the reporting_city
	 */
	public String getReporting_city() {
		return reporting_city;
	}
	/**
	 * @param reporting_city the reporting_city to set
	 */
	public void setReporting_city(String reporting_city) {
		this.reporting_city = reporting_city;
	}
	/**
	 * @return the reporting_date
	 */
	public Date getReporting_date() {
		return reporting_date;
	}
	/**
	 * @param reporting_date the reporting_date to set
	 */
	public void setReporting_date(Date reporting_date) {
		this.reporting_date = reporting_date;
	}
	
	
}
