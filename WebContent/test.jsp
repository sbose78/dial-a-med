<%@page import="in.health.dao.UserDAO"%>
<%@page import="in.health.model.*"%>

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
in.health.model.User user= new in.health.model.User("+918884314202","fdsfd","fdsfs","gfhgf","gghfg","hgfhf");
UserDAO dao = new UserDAO();
//out.println(dao.insertPatient(user));

//out.println(dao.updatePatient(user.getMobile(), "location", "kolkata"));
 out.println(UserDAO.isRegistered("+918884314202"));


%>

</body>
</html>