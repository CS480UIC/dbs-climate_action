package state.service;


import state.dao.StateDao;
import state.domain.State;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class StateService {
	private StateDao entity1Dao = new StateDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(State form) throws StateException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		State entity1 = entity1Dao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new StateException("This user name has been registered!");
		entity1Dao.add(form);
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void login(State form) throws StateException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		State user = entity1Dao.findByUsername(form.getUsername());
		if(user.getUsername()==null) throw new StateException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new StateException(" The password is not right");
		
	}
}
