package aqi.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aqi.dao.AqiDao;
import aqi.domain.Aqi;


/**
 * Servlet implementation class UserServlet
 */

public class AqiServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AqiServletDelete() {
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
		AqiDao aqiDao = new AqiDao();
		Aqi aqi = null;
		if(method.equals("search"))
		{
			try {
				aqi = aqiDao.findByAqiMeasuring(request.getParameter("aqi_id"), Integer.parseInt(request.getParameter("measuring_year")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			System.out.println(aqi.getAqi_id());
			if(aqi.getAqi_id()!=null && aqi.getMeasuring_year()!= null){
						System.out.println(aqi);
						request.setAttribute("aqi", aqi);
						request.getRequestDispatcher("/jsps/aqi/aqi_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Aqi not found");
				request.getRequestDispatcher("/jsps/aqi/aqi_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				aqiDao.delete(request.getParameter("aqi_id"), Integer.parseInt(request.getParameter("measuring_year")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Aqi Deleted");
			request.getRequestDispatcher("/jsps/aqi/aqi_read_output.jsp").forward(request, response);
		}
	}
}



