package picturePreview;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/uploadMain")
public class TestUploadController extends HttpServlet {
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher dis = req.getRequestDispatcher("/picturePreview/insert.jsp");
			dis.forward(req, resp);
		}//end doGet()	
	
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//req 로는 파라메타값을 받을수가 없어서, cos.jar 파일이 필요하다 	 
			//System.out.println(req.getParameter("filepath"));
			
			MultipartRequest multi=null;
			
			//String saveDirectory="c:/temp/";

			// root=C:\study\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\webdemo\
			
			String root=req.getRealPath("/");
			String saveDirectory=root+"/temp";
			//System.out.println(root);
			 
			File file=new File(saveDirectory);
			if(!file.isDirectory())
				file.mkdir();
			int maxPostSize=1*1000*1000*1000; //1GB
			String encoding="UTF-8";
			
			/*new DefaultFileRenamePolicy() = 파일 이름 중복 관리하여 처리시켜줌. ex) sample(1).txt*/
			multi=new MultipartRequest(req, saveDirectory,maxPostSize,encoding,new DefaultFileRenamePolicy());
			//System.out.println(multi.getFilesystemName("filepath"));

			TestDAO dao=TestDAO.getInstance();
			dao.insertMethod(multi.getFilesystemName("filepath"));
			resp.sendRedirect("previewList");
			 
		}//end doPost()
}//end class
