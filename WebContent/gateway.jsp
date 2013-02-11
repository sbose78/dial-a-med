<?xml version="1.0" encoding="UTF-8"?>


<%@page contentType="text/xml" language="java"%>
<Response>


	<Say> Hi I shall help you register to UDHC</Say>

  <Gather timeout="15" numDigits="1" action="/healthhack/route.jsp">	
        <Say voice="woman" >Press 1 for feedback else dial 2</Say>      
    </Gather>
        <Say>We didn't receive any input. Goodbye!</Say>
    
</Response>