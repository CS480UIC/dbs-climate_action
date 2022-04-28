package carbon_dioxide.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carbon_dioxide.dao.Carbon_DioxideDao;
import carbon_dioxide.domain.Carbon_Dioxide;

/**
 * Servlet implementation class UserServlet
 */

public class Carbon_DioxideServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Carbon_DioxideServletUpdate() {
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
		Carbon_DioxideDao carbon_dioxidedao = new Carbon_DioxideDao();
		Carbon_Dioxide carbon_dioxide = null;

		if(method.equals("search"))
		{
			try {
				carbon_dioxide = carbon_dioxidedao.findByCOID_Year(request.getParameter("co_id"), Integer.parseInt(request.getParameter("emission_year")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(carbon_dioxide.getCo_id()!=null && carbon_dioxide.getEmission_year()!=null){
				request.setAttribute("carbon_dioxide", carbon_dioxide);
				request.getRequestDispatcher("/jsps/carbon_dioxide/carbon_dioxide_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Entry not found");
				request.getRequestDispatcher("/jsps/carbon_dioxide/carbon_dioxide_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Carbon_Dioxide form = new Carbon_Dioxide();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setCo_id(request.getParameter("co_id"));
			form.setEmission_year(Integer.parseInt(request.getParameter("emission_year")));
			form.setCo_metric(Double.parseDouble(request.getParameter("co_metric")));

			try {
				carbon_dioxidedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/carbon_dioxide/carbon_dioxide_read_output.jsp").forward(request, response);
		}
	}
}



