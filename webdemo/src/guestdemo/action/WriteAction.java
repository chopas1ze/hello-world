package guestdemo.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;

public class WriteAction {

		public void excute(HttpServletRequest req, HttpServletResponse resp) {
			MultipartRequest multi=null;
			String saveDirectory=req.getRealPath("/");
			File file=new File(saveDirectory+"/temp");
			if(!file.exists())
				file.mkdir();
			
			saveDirectory+="/temp";
			
			int maxPostSize=1*1000*1000; 
			String encoding="UTF-8";
			
			try {
				multi=new MultipartRequest(req, saveDirectory,maxPostSize,encoding,new DefaultFileRenamePolicy());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BoardDTO dto = new BoardDTO();
			dto.setWriter(multi.getParameter("writer"));
			dto.setEmail(multi.getParameter("email"));
			dto.setSubject(multi.getParameter("subject"));
			dto.setContent(multi.getParameter("content"));
			dto.setUpload(multi.getFilesystemName("upload"));

			BoardDAO dao = BoardDAO.getInstance();
			dao.insertMethod(dto);
			
		}//end excute()
	
}//end class
