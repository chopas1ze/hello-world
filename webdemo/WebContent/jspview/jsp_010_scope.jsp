<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_010_scope</title>
</head>
<body>
	<%
		/*
		scope(영역)-데이터를 참조할 수 있도록 저장해놓은 공간
		*/
	
	
		/* 같은 페이지에서만 값을 사용가능. 자바의 private(같은클래스에서만 사용가능)과 같음 */
		//page영역에 p1이름으로 page값이 저장된다.
		pageContext.setAttribute("p1", "page");

		/* 한번의 요청으로 처리하는 페이지들에서 공유하여 사용가능함 */
		//request영역에 p2이름으로 request값이 저장된다.
		request.setAttribute("p2", "request");

		/* 서버와 클라이언트와의 연결 상태를 지속적으로 유지하는데 사용. 물리적으로 연결한게 아니라 소프트웨어적으로 연결하는 방법이다.  예)세션에 id값을 저장하고 요청할때마다 id값을 묻는다.*/
		//session영역에 p3이름으로 session값이 저장된다.
		session.setAttribute("p3", "session");
		

		/* 클라이언트들간의 데이터를 공유		예) 방문자 수  */
		/* 메모리에 로딩되기 떄문에 서버가 다운되면 데이터가 사라지므로,  방문자 수 같은 경우는  application을 사용하지 않고 db에 데이터를 저장시켜야한다 */
		//application p4이름으로 application값이 저장된다.
		application.setAttribute("p4", "application");
	%>
	
	<jsp:forward page="jsp_010_next.jsp"/>

</body>
</html>

