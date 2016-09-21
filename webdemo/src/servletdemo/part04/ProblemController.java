package servletdemo.part04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8090/webdemo/problem

@WebServlet("/problem")
public class ProblemController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part04/form.jsp");
		dis.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		String ko=req.getParameter("ko");
		String res="";
		if(ko.equals("서울")){
			res=ko+"는(은) 정답입니다.";
		}else{
			res=ko+"는(은) 정답이 아닙니다.";			
		}
		
		req.setAttribute("res",res);
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part04/result.jsp");
		dis.forward(req, resp);
		
		
	}

}//end class
