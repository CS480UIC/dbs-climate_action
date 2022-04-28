package aqi.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aqi.dao.AqiDao;
import aqi.domain.Aqi;

/**
 * Servlet implementation class UserServlet
 */

public class AqiServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AqiServletUpdate() {
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
		AqiDao aqidao = new AqiDao();
		Aqi aqi = null;

		if(method.equals("search"))
		{
			try {
				aqi = aqidao.findByAqiMeasuring(request.getParameter("aqi_id"), Integer.parseInt(request.getParameter("measuring_year")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(aqi.getAqi_id()!=null && aqi.getMeasuring_year()!=null){
				request.setAttribute("aqi", aqi);
				request.getRequestDispatcher("/jsps/aqi/aqi_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Aqi not found");
				request.getRequestDispatcher("/jsps/aqi/aqi_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Aqi form = new Aqi();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setPassword(info.get(2));
			form.setEmail(info.get(3));
			form.setUsername(request.getParameter("username"));

			try {
				entity1dao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
		}
	}
}



