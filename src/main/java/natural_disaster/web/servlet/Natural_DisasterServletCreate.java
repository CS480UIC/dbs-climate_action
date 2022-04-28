package natural_disaster.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import natural_disaster.domain.Natural_Disaster;
import natural_disaster.service.Natural_DisasterException;
import natural_disaster.service.Natural_DisasterService;


/**
 * Servlet implementation class UserServlet
 */

public class Natural_DisasterServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Natural_DisasterServletCreate() {
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
		Natural_DisasterService entity1service = new Natural_DisasterService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Natural_Disaster form = new Natural_Disaster();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setN_id(Integer.parseInt(info.get(0)));
		form.setDisaster_name(info.get(1));
		form.setOccurence_date(java.sql.Date.valueOf(info.get(2)));
		form.setDamage_cost(Double.parseDouble(info.get(3)));
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Natural_DisasterException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
