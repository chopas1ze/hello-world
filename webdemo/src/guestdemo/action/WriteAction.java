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
			//saveDirectory = C:\study\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webdemo\
			String saveDirectory=req.getRealPath("/");
			//첨부파일을 담을 경로 지정
			File file=new File(saveDirectory+"/temp");
			//temp폴더가 없으면 생성한다.
			if(!file.exists())
				file.mkdir();
			
			saveDirectory+="/temp";
			
			//첨부파일 크기 지정
			int maxPostSize=1*1000*1000;
			//인코딩 타입 설정
			String encoding="UTF-8";
			
			try {
				//new DefaultFileRenamePolicy() =>  중복 이름이 있을시 자동 교체
				multi=new MultipartRequest(req, saveDirectory,maxPostSize,encoding,new DefaultFileRenamePolicy());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// MultipartRequest로 전송받은 데이터를 불러온다.
			// enctype을 "multipart/form-data"로 선언하고 submit한 데이터들은 request객체가 아닌 MultipartRequest객체로 불러와야 한다.
			BoardDTO dto = new BoardDTO();
			dto.setWriter(multi.getParameter("writer"));
			dto.setEmail(multi.getParameter("email"));
			dto.setSubject(multi.getParameter("subject"));
			dto.setContent(multi.getParameter("content"));
			// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
			dto.setUpload(multi.getFilesystemName("upload"));
			BoardDAO dao = BoardDAO.getInstance();
			
			//답변글이면
			if(multi.getParameter("re_level")!=null){
				//re_step컬럼의 값을 1증가시키기 위해서 HashMap ref,re_step을 저장해서 넘긴다.
				HashMap<String, Integer> map = new HashMap<String, Integer>();
				map.put("ref", new Integer(multi.getParameter("ref")));
				map.put("re_step", new Integer(multi.getParameter("re_step")));
				//답변글 구분을 위해 동일한 ref값을 가진 레코드들의 re_step 값을 1씩 증가시킨다. 
				dao.reStepMethod(map);
				//답변글이기 때문에 고정된 ref값과 re_step,re_level(들여쓰기) 값을 1씩 증가시킨다.
				dto.setRef(Integer.parseInt(multi.getParameter("ref")));
				dto.setRe_step(Integer.parseInt(multi.getParameter("re_step"))+1);
				dto.setRe_level(Integer.parseInt(multi.getParameter("re_level"))+1);
			}
			
			//답변글 등록
			dao.insertMethod(dto);
			
			return multi;
		}//end excute()
	
}//end class
