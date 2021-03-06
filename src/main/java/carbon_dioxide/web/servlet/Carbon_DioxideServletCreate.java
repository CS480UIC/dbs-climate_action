package carbon_dioxide.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carbon_dioxide.domain.Carbon_Dioxide;
import carbon_dioxide.service.Carbon_DioxideException;
import carbon_dioxide.service.Carbon_DioxideService;


/**
 * Servlet implementation class UserServlet
 */

public class Carbon_DioxideServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carbon_DioxideServletCreate() {
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
		Carbon_DioxideService entity1service = new Carbon_DioxideService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Carbon_Dioxide form = new Carbon_Dioxide();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setCo_id(info.get(0));
		form.setEmission_year(Integer.parseInt(info.get(1)));
		form.setCo_metric(Double.parseDouble(info.get(2)));		
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Carbon_DioxideException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
