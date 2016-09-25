<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_07_foreach</title>
</head>
<body>
	<%
		int[] num = new int[] { 10, 20, 30, 40, 50 };
		for (int i = 0; i < num.length; i++)
			out.print(num[i] + "  ");
	%>
	<hr />
	<c:forEach items="<%=num%>" var="i">
		<c:out value="${i}" />
	</c:forEach>
	<hr />

		<!-- varStatus : 반복상태를 갖는 속성이다. -->
	<c:forEach items="<%=new int[] { 10, 20, 30, 40, 50 }%>" var="i" varStatus="status" step="2">
	<p>
			<!-- status.count: 반복문이 돌아간 횟수 -->
		count:${status.count}/
		   <!-- status.index: 인덱스 표시(1부터 시작) -->
		[${status.index}]:<c:out value="${i}"/>
		</p>
	</c:forEach>


</body>
</html>