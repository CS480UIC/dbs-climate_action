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

public class Carbon_DioxideServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carbon_DioxideServletRead() {
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
		Carbon_Dioxide carbon_dioxide = null;
		Carbon_DioxideDao carbon_dioxideDao = new Carbon_DioxideDao();
		
		try {
			carbon_dioxide = carbon_dioxideDao.findByCode(request.getParameter("username"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(carbon_dioxide.getUsername()!=null){
					System.out.println(carbon_dioxide);
					request.setAttribute("entity1", carbon_dioxide);
					request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/entity1/entity1_read_output.jsp").forward(request, response);
		}
	}
}



