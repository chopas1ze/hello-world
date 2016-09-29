package guestdemo.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;
import guestdemo.dto.PageDTO;

public class ListAction {

	public void execute(HttpServletRequest req, HttpServletResponse resp){
		//list.jsp에서 pageNum(페이지시작 번호)값을 받고, 없을시에는 기본 1을 설정한다.
		String pageNum=req.getParameter("pageNum");
		if(pageNum==null || pageNum.equals("null") || pageNum.equals("")){
			pageNum="1";
		}
		
		//pageNum 숫자값으로 변환
		int currentPage=Integer.parseInt(pageNum);
		
		//view.jsp에서 searchKey,searchWord값을 저장한다. 없을시 null값 저장.
		String searchKey=req.getParameter("searchKey");
		String searchWord=req.getParameter("searchWord");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchKey", searchKey);
		map.put("searchWord", searchWord);

		
		BoardDAO dao = BoardDAO.getInstance();
		
		//searchKey,searchWord값을 가지고 컬럼의 총 레코드를 구한다. 
		int cnt = dao.rowTotalCount(map);
		//레코드 갯수가 1이라도 있다면  pdto 객체 생성.
		if(cnt>0){
		PageDTO pdto=new PageDTO(currentPage,cnt,searchKey,searchWord);
		//num,writer,subject,readcount,re_level,upload 값을 가진 aList 생성
		List<BoardDTO> aList = dao.listMethod(pdto);
		//리퀘스트 영역에 aList 저장.
		req.setAttribute("aList", aList);
		//현재페이지,총레코드수,한페이지에 보여줄 레코드수,한블록에 보여줄 페이지수, 총페이지수, 시작레코드 번호
		//끝레코드 번호, 한블록의 시작페이지 번호, 한블록의 끝페이지 번호, 검색어종류, 검색어 pdto 객체를
		//리퀘스트 영역에 pdto 저장.
		req.setAttribute("pdto", pdto);
		
		}
	}//end execute()
	
	
}//end class
