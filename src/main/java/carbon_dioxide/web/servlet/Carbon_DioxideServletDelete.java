package carbon_dioxide.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carbon_dioxide.dao.Carbon_DioxideDao;
import carbon_dioxide.domain.Carbon_Dioxide;


/**
 * Servlet implementation class UserServlet
 */

public class Carbon_DioxideServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carbon_DioxideServletDelete() {
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
		Carbon_DioxideDao carbon_dioxideDao = new Carbon_DioxideDao();
		Carbon_Dioxide carbon_dioxide = null;
		if(method.equals("search"))
		{
			try {
				carbon_dioxide = carbon_dioxideDao.findByCOID_Year(request.getParameter("co_id"), Integer.parseInt(request.getParameter("emission_year")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			System.out.println(carbon_dioxide.getCo_id());
			if(carbon_dioxide.getCo_id()!=null && carbon_dioxide.getEmission_year()!=null){
						System.out.println(carbon_dioxide);
						request.setAttribute("carbon_dioxide", carbon_dioxide);
						request.getRequestDispatcher("/jsps/carbon_dioxide/carbon_dioxide_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/carbon_dioxide/carbon_dioxide_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				carbon_dioxideDao.delete(request.getParameter("co_id"), Integer.parseInt(request.getParameter("emission_year")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Deleted");
			request.getRequestDispatcher("/jsps/carbon_dioxide/carbon_dioxide_read_output.jsp").forward(request, response);
		}
	}
}



