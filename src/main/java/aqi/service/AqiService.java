package aqi.service;


import java.util.List;

import aqi.dao.AqiDao;
import aqi.domain.Aqi;

/**
 * logic functions such as register, login
 * @author Deepanshu Raghuvanshi
 *
 */
public class AqiService {
	private AqiDao aqiDao = new AqiDao();
	
	/**
	 * register a Aqi
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Aqi form) throws AqiException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Aqi aqi = aqiDao.findByAqiMeasuring(form.getAqi_id(), form.getMeasuring_year());
		if(aqi.getAqi_id()!=null && aqi.getAqi_id().equals(form.getAqi_id()) && aqi.getMeasuring_year()!=null && aqi.getMeasuring_year() == (form.getMeasuring_year())) throw new AqiException("This AqiId and Measuring year have been registered before!");
		aqiDao.add(form);
	}
	
	public List<Object> findAqi() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return aqiDao.findAqi();
	
}
}