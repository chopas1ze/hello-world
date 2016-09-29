package guestdemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;
 

public class ViewAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp){
		//list.jsp에서 글번호(num)값을 받는다.
		String number = req.getParameter("num");
		BoardDAO dao = BoardDAO.getInstance();
		//readCountMethod를 통해 조회수값을 먼저 증가시킨다.
		dao.readCountMethod(Integer.parseInt(number));
		//viewMethod를 통해 dto객체에 num,writer,readcount,subject,email,content,upload,ref,re_step,re_level 값을 받는다.
		BoardDTO dto = dao.viewMethod(Integer.parseInt(number));
		//request영역에 dto객체를 저장한다
		req.setAttribute("dto", dto);
		
	}//end execute();
	
	
}//end class

