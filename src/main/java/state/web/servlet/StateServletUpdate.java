package state.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import state.dao.StateDao;
import state.domain.State;

/**
 * Servlet implementation class UserServlet
 */

public class StateServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StateServletUpdate() {
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

		String method = request.getParameter("method");
		StateDao statedao = new StateDao();
		State state = null;

		if(method.equals("search"))
		{
			try {
				state = statedao.findByCode(request.getParameter("code"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(state.getCode()!=null){
				request.setAttribute("state", state);
				request.getRequestDispatcher("/jsps/state/state_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "State not found");
				request.getRequestDispatcher("/jsps/state/state_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			State form = new State();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			//form.setPassword(info.get(2));
			//form.setEmail(info.get(3));
			//form.setUsername(request.getParameter("username"));
			form.setCode(request.getParameter("code"));
			form.setName(request.getParameter("name"));
			form.setArea(Integer.parseInt(request.getParameter("area")));

			try {
				statedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "State Updated");
			request.getRequestDispatcher("/jsps/state/state_read_output.jsp").forward(request, response);
		}
	}
}



