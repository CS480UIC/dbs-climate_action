package natural_disaster.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import natural_disaster.dao.Natural_DisasterDao;
import natural_disaster.domain.Natural_Disaster;

/**
 * Servlet implementation class UserServlet
 */

public class Natural_DisasterServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Natural_DisasterServletUpdate() {
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
		Natural_DisasterDao natural_disasterdao = new Natural_DisasterDao();
		Natural_Disaster natural_disaster = null;

		if(method.equals("search"))
		{
			try {
				natural_disaster = natural_disasterdao.findByNid(Integer.parseInt(request.getParameter("n_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(natural_disaster.getN_id()!=null){
				request.setAttribute("natural_disaster", natural_disaster);
				request.getRequestDispatcher("/jsps/natural_disaster/natural_disaster_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Natural Disaster not found");
				request.getRequestDispatcher("/jsps/natural_disaster/natural_disaster_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Natural_Disaster form = new Natural_Disaster();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setN_id(Integer.parseInt(request.getParameter("n_id")));
			form.setDisaster_name(request.getParameter("disaster_name"));
			form.setOccurence_date(java.sql.Date.valueOf(request.getParameter("occurence_date")));
			form.setDamage_cost(Double.parseDouble(request.getParameter("damage_cost")));

			try {
				natural_disasterdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Natural Disaster Updated");
			request.getRequestDispatcher("/jsps/natural_disaster/natural_disaster_read_output.jsp").forward(request, response);
		}
	} 
}



