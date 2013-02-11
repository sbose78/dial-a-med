<?xml version="1.0" encoding="UTF-8"?>


<%@page contentType="text/xml" language="java"%>
<Response>

<%

	String choice= request.getParameter("Digits");
	if( choice.equals("1")){
		
%>
    <Redirect method="POST">http://care.udhc.co.in/healthhack/recordFeedback.jsp</Redirect>
		
<%	
		
	}else{
%>
	 <Redirect method="POST">http://care.udhc.co.in/healthhack/getCall.jsp</Redirect>	

<%
	}
%>
    
</Response>