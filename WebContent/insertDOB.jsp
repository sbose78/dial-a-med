<%@page contentType="text/xml" %>
<Response>
	<%
		String DOBString= request.getParameter("Digits");
		if( DOBString!=null ){
			
	%>
			<Say> You've entered <%=DOBString %> </Say>
	<%
		}
	%>
	
	  		    <Redirect method="POST">http://care.udhc.co.in/healthhack/recordNarrative.jsp</Redirect>
	
	
</Response>