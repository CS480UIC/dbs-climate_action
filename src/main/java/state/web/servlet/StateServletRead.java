package state.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import state.dao.StateDao;
import state.domain.State;


/**
 * Servlet implementation class UserServlet
 */

public class StateServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateServletRead() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		State state = null;
		StateDao stateDao = new StateDao();
		
		try {
			state = stateDao.findByCode(request.getParameter("code"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(state.getCode()!=null){
					System.out.println(state);
					request.setAttribute("state", state);
					request.getRequestDispatcher("/jsps/state/state_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "State not found");
			request.getRequestDispatcher("/jsps/state/state_read_output.jsp").forward(request, response);
		}
	}
}



