<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_19_xml</title>
</head>
<body>
<!-- 
	Servlet 3.1 and JavaServer Page 2.3
	xalan-2.7.1.jar 추가
 -->


<!-- 문자열형식 -->
<c:import url="mem.xml" var="mem" charEncoding="UTF-8"/>

<!-- 지원을 하지 않아서 http://xalan.apache.org/old/xalan-j/downloads.html 에서 xalan-j_2_7_1-bin.zip 설치 xalan.jar 을 web-inf->lib폴더에 넣음 -->
<!-- 문자열형식을 XML형식으로 바꾸는 역할 -->
<x:parse var="xmldata" xml="${mem}"/>

<x:forEach select="$xmldata//student">
<p>
	<x:out select="./name"/>
	<x:out select="./id"/>
	<x:out select="./age"/>
</p>
</x:forEach>

</body>
</html>