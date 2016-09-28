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
					<td><c:if test="${dto.re_level>0}">
							<img src="../guestview/images/level.gif"
								width="${15 * dto.re_level}" height="5px" />
							<!-- 주소를 상대경로로 잡아줘야 한다. .. -> 상위 폴더 이동 -->
							<img src="../guestview/images/re.gif" />
						</c:if> <a href="view.do?num=${dto.num}">${dto.subject}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.readcount}</td>
					<td>${dto.upload}</td>
				</tr>
			</c:forEach>
		</table>

	
		<!-- 이전 -->
		<c:if test="${pdto.startPage>1}">
			<span><a href="list.do?pageNum=${pdto.startPage-pdto.blockPage}">이전</a></span>
		</c:if>

		<!-- 페이지 -->
		<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}">
			<a href="list.do?pageNum=${i}"><c:out value="${i}"></c:out></a>
		</c:forEach>


		<!-- 다음 -->
		<c:if test="${pdto.totalPage>pdto.endPage}">
			<span><a href="list.do?pageNum=${pdto.startPage+pdto.blockPage}">다음</a></span>
		</c:if>
		
	
		 	

	</div>

</body>
</html>