package part04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myList")
public class ListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemDao dao = new MemDao();
		   String[] chk = req.getParameterValues("chk");
			
		   if(chk!=null)
			   dao.deleteMethod(chk);   
		   
			
			req.setAttribute("aList", dao.listMethod());
			RequestDispatcher dis = req.getRequestDispatcher("/view/list.jsp");
			dis.forward(req, resp);	
		
	}//end doGet()
	
}//end class
