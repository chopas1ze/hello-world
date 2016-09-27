package guestdemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;
 

public class ViewAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp){
		String number = req.getParameter("num");
		BoardDAO dao = BoardDAO.getInstance();
		dao.readCountMethod(Integer.parseInt(number));
		BoardDTO dto = dao.viewMethod(Integer.parseInt(number));
		req.setAttribute("dto", dto);
		
		
	}//end execute();
	
	
}//end class

