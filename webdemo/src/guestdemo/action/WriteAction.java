package guestdemo.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import guestdemo.dao.BoardDAO;
import guestdemo.dto.BoardDTO;

public class WriteAction {

		public MultipartRequest excute(HttpServletRequest req, HttpServletResponse resp) {
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
			
			//답변글이면
			if(multi.getParameter("re_level")!=null){
				//re_step컬럼의 값을 1증가시키기 위해서 HashMap ref,re_step을 저장해서 넘긴다.
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put("ref", new Integer(multi.getParameter("ref")));
				map.put("re_step", new Integer(multi.getParameter("re_step")));
				dao.reStepMethod(map);
				dto.setRef(Integer.parseInt(multi.getParameter("ref")));
				dto.setRe_step(Integer.parseInt(multi.getParameter("re_step"))+1);
				dto.setRe_level(Integer.parseInt(multi.getParameter("re_level"))+1);
			}
			
			dao.insertMethod(dto);
			
			return multi;
		}//end excute()
	
}//end class
