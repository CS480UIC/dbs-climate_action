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
<<<<<<< HEAD
		State state = statedao.findByCode(form.getCode());
		if(state.getCode()!=null && state.getCode().equals(form.getCode())) throw new StateException("This state code has been registered before!");
		statedao.add(form);
=======
		State entity1 = entity1Dao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new StateException("This user name has been registered!");
		entity1Dao.add(form);
>>>>>>> branch 'main' of git@github.com:CS480UIC/dbs-climate_action.git
	}
<<<<<<< HEAD
	
=======
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
>>>>>>> branch 'main' of git@github.com:CS480UIC/dbs-climate_action.git
}
