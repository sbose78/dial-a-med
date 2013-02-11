


<%@page import="in.health.dao.*"%>
<%@page import="in.health.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>



<script
	src="<%=request.getContextPath()%>/colorbox/jquery.colorbox.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/colorbox/colorbox.css" />


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ALl issues</title>

<script>
	$(document).ready(call_on_load);
	function call_on_load()
	{
	}	
	


</script>

	
<style>
#hbar{
	padding:30px;
	font-weight:bolder;
	font-size: 130%;
	color:black;
	z-index:999;
	width:100%;
	
	position: fixed;
	
		background: #f6f8f9; /* Old browsers */
		background: -moz-linear-gradient(top, #f6f8f9 0%, #e5ebee 50%, #d7dee3 51%, #f5f7f9 100%); /* FF3.6+ */
		background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f6f8f9), color-stop(50%,#e5ebee), color-stop(51%,#d7dee3), color-stop(100%,#f5f7f9)); /* Chrome,Safari4+ */
		background: -webkit-linear-gradient(top, #f6f8f9 0%,#e5ebee 50%,#d7dee3 51%,#f5f7f9 100%); /* Chrome10+,Safari5.1+ */
		background: -o-linear-gradient(top, #f6f8f9 0%,#e5ebee 50%,#d7dee3 51%,#f5f7f9 100%); /* Opera 11.10+ */
		background: -ms-linear-gradient(top, #f6f8f9 0%,#e5ebee 50%,#d7dee3 51%,#f5f7f9 100%); /* IE10+ */
		background: linear-gradient(to bottom, #f6f8f9 0%,#e5ebee 50%,#d7dee3 51%,#f5f7f9 100%); /* W3C */
		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f6f8f9', endColorstr='#f5f7f9',GradientType=0 ); /* IE6-9 */
			
}

#logo{
     margin-right:40%;
     float:left; 
  }  
  
  #all_links ul li{
    
    display:inline; 
  }
  
  
  #all_links ul li a{
    
    background-color: #00A6E5 ;
    padding: 10px;
    margin:5px;
    color: white;
    text-decoration:none;
    border-radius: 5px;
    
  }
  
  .qa{
  	margin-left: 15%;
  	margin-right: 15%; 
  
  }
  
  .question{
  
  	float:left;
  	
  	background-color: #004E9B;
  	color: white;
  	font-weight: 120%;
  	padding: 10px;
  	border-radius:5px;
  	
  }
  
  .answer a{
  
  	background-color: white;
  	color: black;
  	text-decoration: none;
  	padding: 10px;
  	border-radius:6px;
  }
  
  .answer a:hover{
  	background: black;
  	color: white;
  }
</style>

</head>

  <header id="hbar"><div id="logo">Dial-a-doctor</div>
  
  <div id="all_links">
    <ul>
    
      <li> <a href="#"> ACCOUNT </a> </li>
      <li> <a href="<%=request.getContextPath()%>/dashboard.jsp"> DASHBOARD </a></li>
      <li>  <a href="<%=request.getContextPath()%>/displayIssues.jsp"> HEALTH ISSUES  </a></li>
    
    
    </ul>
    	
  </div>  
  

</header>

<body>
<br><br><br><br><br><br><br><br>><br>

<%
	ArrayList<Feedback> feedbacks = new ArrayList<Feedback>(); 
	feedbacks = FeedbackDAO.getAllFeedbacks();
	
	for ( Feedback feedback : feedbacks)
	{	
		
%>
<div class="qa" align="center">
	<div align="left" class="question"><%=feedback.getQuestion() %></div>
	
	
	<%
		String linksrc="";
		String linktext="";
		if (feedback.getAnswer().equals("NO_ANSWER")){
			linksrc="#";
			linktext="NO ANSWER YET";
		}
		else{
			linksrc=feedback.getAnswer();
			linktext="PLAY REPLY";
		}
	%>
	<div align="left" class="answer"> <a href="<%=linksrc%>"><%=linktext %></a> </div>
</div>

<br><br>

<%

	}
%>
</body>
</html>