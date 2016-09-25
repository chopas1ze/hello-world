<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
	<%--  window.onload=function(){
	 var ck='<%=request.getParameter("ck")%>';
	
	 if (ck == 2)
	 alert("아이디 비밀번호를 확인하세요");
	 } --%> 

	$(document).ready(function() {
		
		var ck = "${param.ck}";
		if (ck == 2) {
			alert("아이디 비밀번호를 확인하세요");
		}

		$("#login").click(function(){
			
		if($("#id").text()==""){
			alert("아이디를 입력하세요");
			return false;
		}
		if($("#pass").val().length==0){
			alert("비밀번호를 입력하세요");
			return false;
		}
		
		return true;
		
		});
		
	});
</script>
</head>
<body>
	<%-- 	<%
		String ck = request.getParameter("ck");
		String logOK = (String) session.getAttribute("logOK");
		if(logOK==null){
		if (ck == null || ck.equals("2")) {
	%> --%>

	<c:set var="ck" value='<%=request.getParameter("ck")%>' />
	<c:set var="logOK" value='<%=(String) session.getAttribute("logOK")%>' />
	<c:choose>
		<%-- <c:when test="${empty sessionScope.logOK}">
	<c:if test="${param.ck=null || param.ck=='2'}"> --%>
		<c:when test="${logOK==null}">
			<c:if test="${ck==null || ck=='2'}">

				<div class="login">
					<form action="logPro" method="post">
						<table>
							<tr>
								<td>아이디</td>
								<td><input type="text" name="id" id="id"></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" name="pass" id="pass"></td>
							</tr>
							<tr>
								<td colspan="2" align="center"><input type="submit"
									id="login" value="로그인"> <input type="reset"
									value="취&nbsp;&nbsp;소"></td>
							</tr>
						</table>
					</form>
				</div>

			</c:if>

		</c:when>


		<%-- 	<%
		}
		} else {
	%> --%>
		<c:otherwise>
			<div class="logout">
				<p>
					<a href="logout">로그아웃</a>
				</p>
			</div>
		</c:otherwise>

	</c:choose>
	<%-- 	<%
		}
	%> --%>
</body>
</html>