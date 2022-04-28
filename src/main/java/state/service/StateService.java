package state.service;


import java.util.List;

import state.dao.StateDao;
import state.domain.State;

/**
 * logic functions such as register, login
 * @author Saksham Ayush
 *
 */
public class StateService {
	private StateDao stateDao = new StateDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(State form) throws StateException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		State entity1 = stateDao.findByCode(form.getCode());
		if(entity1.getCode()!=null && entity1.getCode().equals(form.getCode())) throw new StateException("This user name has been registered before!");
		stateDao.add(form);
	}
	public List<Object> findPopulation() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return StateDao.findPopulation();
		
	}
		
	

}
