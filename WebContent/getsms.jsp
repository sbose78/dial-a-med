<%@page import="in.health.cao.SMSUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	
	String mobile_number = request.getParameter("From");
	String message  =  request.getParameter("Body");

	SMSUtil.sendSMS(mobile_number, " THANKS FOR SEDNING + "+message);

/*
	String params[]=(String[])request.getParameterMap().keySet().toArray();
	for( String param : params ){
		out.println(param+" <br>");
	}
	
	*/

%>


</body>
</html>