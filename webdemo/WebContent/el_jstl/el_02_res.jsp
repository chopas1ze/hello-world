<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_02_res</title>
</head>
<body>

	<%
		String data = request.getParameter("data");
		//out.print(data);
		String[] chk = request.getParameterValues("chk");
		/* for(String sn : chk)
			out.print(sn); */
	%>

	<p>${param.data}</p>
	<p>${paramValues.chk[0]}</p>
	<p>${paramValues.chk[1]}</p>
	<p>${paramValues.chk[2]}</p>
	

</body>
</html>