package guestdemo.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import guestdemo.dao.BoardDAO;

public class DeleteAction implements ActionImp{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		BoardDAO dao = BoardDAO.getInstance();
		String filename=dao.fileMethod(num);
		String saveDirectory=req.getRealPath("/");
		File file=new File(saveDirectory+"/temp");
		if(filename!=null){
			File file2 = new File(file,filename);
			file2.delete();
		}
		dao.DeleteMethod(num);
		
	}

	@Override
	public MultipartRequest execute(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}//end class
