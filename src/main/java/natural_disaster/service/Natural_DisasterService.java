package natural_disaster.service;


import java.util.List;

import natural_disaster.dao.Natural_DisasterDao;
import natural_disaster.domain.Natural_Disaster;

/**
 * logic functions such as register, login
 * @author Deepanshu Raghuvanshi
 *
 */
public class Natural_DisasterService {
	private Natural_DisasterDao natural_disasterDao = new Natural_DisasterDao();
	
	/**
	 * register a Natural Disaster
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Natural_Disaster form) throws Natural_DisasterException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Natural_Disaster natural_disaster = natural_disasterDao.findByNid(form.getN_id());
		if(natural_disaster.getN_id()!=null && natural_disaster.getN_id() == form.getN_id()) throw new Natural_DisasterException("This Natural Disaster has been registered!");
		natural_disasterDao.add(form);
	}
	
	public List<Object> findDisaster() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return natural_disasterDao.findDisaster();
		
}
}
