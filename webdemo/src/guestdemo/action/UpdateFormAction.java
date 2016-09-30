package guestdemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;


public class UpdateFormAction {

	public void excute(HttpServletRequest req, HttpServletResponse resp){
		String number = req.getParameter("num");
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.viewMethod(Integer.parseInt(number));
		req.setAttribute("dto", dto);
		
	}//end excute()
	
	
}//end class
