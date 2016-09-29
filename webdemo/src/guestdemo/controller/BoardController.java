package guestdemo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import guestdemo.action.ListAction;
import guestdemo.action.ViewAction;
import guestdemo.action.WriteAction;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 모든 /board/* 요청을 process()로 리턴
		process(req, resp);

	}// end doGet()

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 모든 /board/* 요청을 process()로 리턴
		process(req, resp);

	}// end doPost()

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 어떤 주소로 /board/* 에 접근하는지 판별한다.
		String uri = req.getRequestURI();
		// /webdemo/board/*
		// /webdemo/board/writeForm.do
		// System.out.println(uri);

		// 제일 끝 "/" 문자의 인덱스를 구하고 "/"부터 문자열을 가져온다.
		String action = uri.substring(uri.lastIndexOf("/"));
		// 분기별 적용시킬 path 지정.
		String path = "";

		// 첫 접속 + list.do 요청 판별
		if (action.equals("/*") || action.equals("/list.do")) {
			ListAction list = new ListAction();
			list.execute(req, resp);
			path = "/guestview/list.jsp";
			// 글쓰기 양식 폼으로 이동
		} else if (action.equals("/writeForm.do")) {
			path = "/guestview/write.jsp";
			// 내용 view 로 이동
		} else if (action.equals("/view.do")) {
			ViewAction view = new ViewAction();
			view.execute(req, resp);
			path = "/guestview/view.jsp";
			// 글 쓰기 폼의 submmit
		} else if (action.equals("/write.do")) {
			WriteAction write = new WriteAction();
			MultipartRequest multi = write.excute(req, resp);
			String param = "?pageNum=" + multi.getParameter("pageNum");
			/*
			 * param+="&searchKey="+multi.getParameter("searchKey");
			 * param+="&searchWord="+multi.getParameter("searchWord");
			 */
			resp.sendRedirect("list.do" + param);
		}

		//요청에 따라 path값이 설정 되었을때만 페이지 이동을 한다. 
		if (path != "") {
			RequestDispatcher dis = req.getRequestDispatcher(path);
			dis.forward(req, resp);
		}

	}// end process()

}// end class
