package state.service;


import state.dao.StateDao;
import state.domain.State;

/**
 * logic functions such as register, login
 * @author Saksham Ayush
 *
 */
public class StateService {
	private StateDao statedao = new StateDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(State form) throws StateException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		State state = statedao.findByCode(form.getCode());
		if(state.getCode()!=null && state.getCode().equals(form.getCode())) throw new StateException("This state code has been registered before!");
		statedao.add(form);
	}
	
}
