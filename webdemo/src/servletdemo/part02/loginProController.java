package servletdemo.part02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginPro")
public class loginProController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		MemberDTO dto = new MemberDTO();
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		dto.setId(id);
		String password=req.getParameter("password");
		dto.setPassword(password);
		req.setAttribute("dto",dto);
		

		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part02/res.jsp");
		dis.forward(req, resp);
		
		
	}
	

	
}//end class
