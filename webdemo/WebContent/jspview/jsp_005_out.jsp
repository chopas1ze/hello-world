<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_005_out</title>
</head>
<body>
	<%
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String ope = request.getParameter("ope");
		int sum = 0;
	
/* 		if (ope.equals("+")) {
			sum = Integer.parseInt(x) + Integer.parseInt(y);
		} else if (ope.equals("-")) {
			sum = Integer.parseInt(x) - Integer.parseInt(y);
		} else if (ope.equals("*")) {
			sum = Integer.parseInt(x) * Integer.parseInt(y);
		} else if (ope.equals("/")){
			sum = Integer.parseInt(x) / Integer.parseInt(y);
		} 
		 */
		switch(ope){
		case "+":
			sum = Integer.parseInt(x) + Integer.parseInt(y);
		break;
		case "-":
			sum = Integer.parseInt(x) - Integer.parseInt(y);
		break;
		case "*":
			sum = Integer.parseInt(x) * Integer.parseInt(y);
		break;
		case "/":
			sum = Integer.parseInt(x) / Integer.parseInt(y);
		break;
		}
		
		 
		out.print(x+ope+y+"="+sum);
	%>
</body>
</html>