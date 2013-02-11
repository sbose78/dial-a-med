<?xml version="1.0" encoding="UTF-8"?>
<%@page import="in.health.dao.UserDAO"%>
<%@page contentType="text/xml" language="java"%>
<Response>

	
        <Say>please record your health narrative and press #</Say>
        
		    <Record timeout="20"  finishOnKey="#" playBeep="true"  action="http://care.udhc.co.in/healthhack/getRecording.jsp"/>    

    
	
</Response>