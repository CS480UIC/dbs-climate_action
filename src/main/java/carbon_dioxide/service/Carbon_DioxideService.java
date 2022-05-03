package carbon_dioxide.service;


import java.util.List;

import carbon_dioxide.dao.Carbon_DioxideDao;
import carbon_dioxide.domain.Carbon_Dioxide;

/**
 * logic functions such as register, login
 * @author Saksham Ayush
 *
 */
public class Carbon_DioxideService {
	private Carbon_DioxideDao carbon_dioxideDao = new Carbon_DioxideDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Carbon_Dioxide form) throws Carbon_DioxideException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Carbon_Dioxide entity1 = carbon_dioxideDao.findByCOID_Year(form.getCo_id(), form.getEmission_year());
		if((entity1.getCo_id()!=null && entity1.getCo_id().equals(form.getCo_id()) && (entity1.getEmission_year()!=null && entity1.getEmission_year() == form.getEmission_year()))) throw new Carbon_DioxideException("This carbon_dioxide entry has been registered before!");
		carbon_dioxideDao.add(form);
	}
	
	public List<Object> findEmission() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return carbon_dioxideDao.findEmission();
		
	}

}
