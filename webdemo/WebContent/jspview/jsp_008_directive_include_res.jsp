<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_008_directive_include_res</title>
</head>
<body>
<%@ include file="jsp_008_directive_include.jsp" %>

<%-- 
jsp
1. jsp-> java(servlet) 변경
2. 컴파일 -> class파일 생성
----여기까지가 jsp 컨테이너가 처리. 이후는 servlet 컨테이너에게 위임한다. ---------
3. 메모리에 로딩.	

 --%>

<%
	int x = 20;
	out.print(x+y+z);
%>
</body>
</html>