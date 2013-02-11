<?xml version="1.0" encoding="UTF-8"?>

<%@page import="in.health.dao.FeedbackDAO"%>
<%@page contentType="text/xml" language="java"%>
<Response>


	<Say>You have recorded the feedback</Say>
	<%
		
		String rec_url = request.getParameter("RecordingUrl");
		FeedbackDAO.updateFeedback(2, rec_url);
	
	%>
	
	<Say> Thanks a lot</Say>
  
  
	
</Response>