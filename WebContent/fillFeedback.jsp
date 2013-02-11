<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My opinion</title>
</head>
<body>

<br><br>

<style>

textarea:focus{
	border: solid 2px red;

}

#submit_button{

	background:#FF9900;
	color:white;
	border-radius: 5px;
	padding: 5px;
	font-size: 120%;

}

textarea{
	font-weight: 120%;
	border-radius: 5px;
		

}
	
</style>

<div align="center">

	<form action="<%=request.getContextPath()%>/PostFeedback" method="post">
		<textarea name="question" id="text_space" rows="10" cols="55"></textarea> <br>
		<input type="hidden" value="sbose78@gmail.com" name="doctor_id">
		<input type="hidden" value="<%=request.getParameter("health_issue_id")%>" name="health_issue_id">
				<input id="submit_button" value="POST FEEDBACK" type="submit">
		
		
	
	
	</form>
</div>

</body>
</html>