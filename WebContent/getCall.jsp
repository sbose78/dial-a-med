<?xml version="1.0" encoding="UTF-8"?>
<%@page import="in.health.dao.SessionUtil"%>
<%@page import="in.health.dao.UserDAO"%>
<%@page import="in.health.model.*"%>

<%@page contentType="text/xml" language="java"%>
<Response>

<%
	
	String from = request.getParameter("From") ;
	String location = request.getParameter("location");
	
	UserDAO DAO = new UserDAO();
	
	

	SessionUtil.setSessionData(request, from);
	Cookie mobile_cookie = new Cookie("mobile",from);
	response.addCookie(mobile_cookie);
	if (!UserDAO.isRegistered(from)){
		
		User user=new User(from,"","","","","");
		UserDAO dao = new UserDAO();
		dao.insertPatient(user);
		DAO.updatePatient(from, "location",location);

%>
	
	 
	<Say> Hi I shall help you register to UDHC</Say>

  <Gather timeout="30" numDigits="1" action="/healthhack/insertGender.jsp">	
        <Say voice="woman" >Press 1 if your gender is male  and 2 if woman</Say>      
    </Gather>
        <Say>We didn't receive any input. Goodbye!</Say>
    
    
    
<%
	}else{
	
		DAO.updatePatient(from, "location",location);
%>
  		    <Redirect method="POST">http://care.udhc.co.in/healthhack/recordNarrative.jsp</Redirect>
    
<%

	}
	
	
%>
    
	
</Response>