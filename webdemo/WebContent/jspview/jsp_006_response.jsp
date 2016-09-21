<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if (id.equals("kim") && pwd.equals("1234")) {
			//response.sendRedirect("jsp_006_logout.jsp"); 
			RequestDispatcher dis = request.getRequestDispatcher("jsp_006_logout.jsp?bb="+id);
			
			//서버내에서 페이지 이동. 클라이언트는 주소창에 변화가 없다(서버내에서 페이지가 이동되기떄문)
			dis.forward(request, response);
		%>
		<%-- <jsp:forward page="jsp_006_logout.jsp"/> --%>
		
		<%
		} else {
			//서버와 클라이언트 사이에서 페이지 이동(서버가 클라이언트에게 login.jsp로 가라고 전달하고 클라이언트가 다시 login.jsp요청하게되면 서버가 login.jsp로 응답해주기때문에 주소창에 변화가있다.)
			response.sendRedirect("jsp_006_login.jsp");
		}
	%>


</body>
</html>