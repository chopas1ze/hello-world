package part05;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myList2")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDeptLocDao dao = new EmpDeptLocDao();

		List<EmpDTO> dto = dao.lastMethod();

		req.setAttribute("aList", dto);
		RequestDispatcher dis = req.getRequestDispatcher("/view/list2.jsp");
		dis.forward(req, resp);

	}

}// end class
