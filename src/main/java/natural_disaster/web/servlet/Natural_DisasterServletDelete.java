package natural_disaster.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import natural_disaster.dao.Natural_DisasterDao;
import natural_disaster.domain.Natural_Disaster;


/**
 * Servlet implementation class UserServlet
 */

public class Natural_DisasterServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Natural_DisasterServletDelete() {
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
		Natural_DisasterDao natural_disasterDao = new Natural_DisasterDao();
		Natural_Disaster natural_disaster = null;
		if(method.equals("search"))
		{
			try {
				natural_disaster = natural_disasterDao.findByNid(Integer.parseInt(request.getParameter("n_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(natural_disaster.getN_id()!=null){
						System.out.println(natural_disaster);
						request.setAttribute("natural_disaster", natural_disaster);
						request.getRequestDispatcher("/jsps/natural_disaster/natural_disaster_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "natural_disaster not found");
				request.getRequestDispatcher("/jsps/natural_disaster/natural_disaster_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				natural_disasterDao.delete(request.getParameter("n_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "natural_disaster Deleted");
			request.getRequestDispatcher("/jsps/natural_disaster/natural_disaster_read_output.jsp").forward(request, response);
		}
	}
}



