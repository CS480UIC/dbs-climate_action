package aqi.domain;

public class Metric {
	private String code;
	private String name;
	private Integer aqi_metric;
	private Integer measuring_year;
	
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
	

}
