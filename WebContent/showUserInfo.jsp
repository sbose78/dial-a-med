<%@page import="in.health.dao.*"%>

<%@page import="in.health.model.*"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User info</title>
</head>
<body>

<%

	UserDAO dao = new UserDAO();
	System.out.println(request.getParameter("mobile"));
	User user = dao.getUserMobile(request.getParameter("mobile"));
%>

<table>
	
	
	<tr>
	<td> Location </td> <td> <%= user.getLocation() %> </td> </tr>
	<tr>
	<td> Gender </td>  <td> <%= user.getGender() %></td>
	</tr>
	
	 <tr>
	<td> Date of birth  </td>  <td> <%= user.getDob() %></td>
	
	</tr>
</table>

</body>
</html>