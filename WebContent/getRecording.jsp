<?xml version="1.0" encoding="UTF-8"?>
<%@page import="in.health.dao.SessionUtil"%>
<%@page import="in.health.dao.HealthIssueDAO"%>
<%@page import="in.health.model.HealthIssue"%>
<%@page import="in.health.dao.UserDAO"%>
<%@page contentType="text/xml" language="java"%>
<Response>

  <Say>You have recorded</Say>
	<%
		
		String rec_url = request.getParameter("RecordingUrl");
		UserDAO dao = new UserDAO();
		HealthIssueDAO healthIssueDAO= new HealthIssueDAO();
	%>
  
  <Say> Your date will now be inserted </Say>
  	<%
  	
  		String mobile="";
		Cookie cookies[]= request.getCookies();
		for ( Cookie c: cookies){
			if(c.getName().equals("mobile")){
				mobile=c.getValue();
			}
		}
		if( mobile.equals("")){
			mobile="guest_mobile";
			//mobile=SessionUtil.getSessionData(request, "mobile"); 
		}
		
		
  
		healthIssueDAO.insertHealthIssue(mobile, rec_url);
		
		
	//	dao.updatePatient("+918884314202", "location", rec_url);
	
	%>
        <Say>Thank you for calling</Say>
        

    
	
</Response>