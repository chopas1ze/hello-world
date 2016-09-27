<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
	<div class="wrap">
		<p>
			<a href="writeForm.do">글쓰기</a>
		</p>

		<table>
			<tr>
				<th>num</th>
				<th>subject</th>
				<th>writer</th>
				<th>readcount</th>
				<th>file</th>
			</tr>
	<c:forEach items="${requestScope.aList}" var="dto">
	  <tr>
             <td>${dto.num}</td>
             <td><a href="view.do?num=${dto.num}">${dto.subject}</a></td>
             <td>${dto.writer}</td>
             <td>${dto.readcount}</td>
             <td>${dto.upload}</td>
           </tr>
	
	</c:forEach>
		</table>

	</div>



</body>
</html>