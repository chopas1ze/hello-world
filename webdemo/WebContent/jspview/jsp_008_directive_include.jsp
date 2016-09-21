<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp_008_directive_include</title>
</head>
<body>
<%!
  int y=10;
%>

<%-- 스크립트릿에 있는 지역변수도 자바소스로 변환될때 멤버변수로 처리가됨. --%>
<%
	int z = 50;
%>
</body>
</html>