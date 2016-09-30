package guestdemo.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import guestdemo.dao.BoardDAO;

public class FileDownLoadAction implements ActionImp {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		BoardDAO dao = BoardDAO.getInstance();

		String filename = dao.fileMethod(num);
		try {
			// filename을 그대로 사용하지 말고, 인코딩을 해줘야 한다. 파일 다운로드 창에서 깨져서 나온다.
			String convName = URLEncoder.encode(filename, "UTF-8");
			//인코딩시 공백이 + 기호로 표시되어 있기 때문에 교체한다.
			convName =convName.replace("+", " ");
			
			//컨텐트 타입(모든 타입이 가능하도록 설정 txt,jpg..)
			resp.setContentType("application/octet-stream");
			
			//다운로드창에 표시되는 다운로드 파일명.  형식은 고정된 형식이다.
			resp.setHeader("Content-Disposition", "attachment;filename="+convName+";");
			
			String saveDirectory=req.getRealPath("/");
			File file=new File(saveDirectory+"/temp/"+filename);
			
			//서버의 파일 첨부 읽어오기
			FileInputStream is = new FileInputStream(file);
			BufferedInputStream bs = new BufferedInputStream(is);
			
			//클라이언트 파일 내용 내보내기
			BufferedOutputStream bo = new BufferedOutputStream(resp.getOutputStream());
			
			byte buffer[] = new byte[1024];
			int len = 0;
			//서버에서 buffer의 크기만큼 읽어오는것을 len에 저장. 1바이트씩 들어옴.
			while((len=bs.read(buffer)) > 0){
				//buffer에 있는 내용을 0번째 인덱스부터 len크기만큼 쓰기
				bo.write(buffer,0,len);
				bo.flush();
			}
			
			//스트림 연결 종료
			is.close();
			bs.close();
			bo.close();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end execute()

	@Override
	public MultipartRequest execute(HttpServletRequest req) {

		return null;
	}// end execute()

}// end class
