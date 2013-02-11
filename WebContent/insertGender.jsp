<?xml version="1.0" encoding="UTF-8"?>
<%@page contentType="text/xml" language="java"%>
<Response>
	<%
		String genderString= request.getParameter("Digits");
		if( genderString!=null ){
			int n = Integer.parseInt(genderString);
			if( n<1 || n>2){
	%>
	
				<Say> You've entered an invalid number </Say>
	<%				
				
			}
			else{
				String shout = n==1?"You entered Male":"you entered female";
	%>
				<Say><%=shout%></Say>
				
				<Gather timeout="40" finishOnKey="*" action="/healthhack/insertDOB.jsp">	
					<Say> please enter your date of birth </Say>
				</Gather>
	
	<%
				
			}
		}
		
			
	%>
</Response>