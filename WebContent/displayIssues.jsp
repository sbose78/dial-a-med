


<%@page import="in.health.dao.HealthIssueDAO"%>
<%@page import="in.health.model.HealthIssue"%>
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
<title>All issues</title>

<script>
	$(document).ready(call_on_load);
	function call_on_load()
	{
        $(".discuss").colorbox({iframe:true, innerWidth:525, innerHeight:344});    	//	alert("here");
        $(".userinfo").colorbox({iframe:true, innerWidth:425, innerHeight:344});    	//	alert("here");
        $(".feedback").colorbox({iframe:true, innerWidth:525, innerHeight:344});    	//	alert("here");

        
		$("a#playback").click(function(){
			
			$("iframe").remove();
			
//			alert("here2");
		//	var mobile=$(this).attr("mobile");
		//	alert(mobile);
			var rec_url= $(this).attr("url");
	//		alert(rec_url);
			var health_issue_id=$(this).attr("issue");
			var my_iframe= document.createElement('iframe');
			$(my_iframe).attr("src",rec_url);
			$(my_iframe).attr("height","20px");
			$(my_iframe).attr("width","100x");
			
			var parent_div =  $("div[issue='"+health_issue_id+"']");
			$(parent_div).append(my_iframe);

		
		});
	}
	
	function playRecording(my_link){
		alert("here2");
		var mobile=$(my_link).attr("mobile");
		var rec_url= $(my_link).attr("url");
		var health_issue_id=$(my_link).attr("issue");
		var my_iframe= document.createElement('iframe');
		$(my_iframe).attr("src",rec_url);
		$(my_iframe).attr("height","20px");
		$(my_iframe).attr("width","100x");
		
		var parent_div =  $("div[issue='"+health_issue_id+"']");
		$(parent_div).append(my_iframe);
	
		
	}
	
	


</script>

	
<style>

#hbar{
	padding:30px;
	font-weight:bolder;
	font-size: 130%;
	color:#F32B10;
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


th{
	background-color: #4285F4;
	color: white;
	padding: 9px;

}

body{
	z-index: 1;
	
}

table{
	margin: auto;
	left:0;right:0;

}

td{
	
	padding: 20px;

}
tr:hover{

	background-color: #EBF8A4;

}


a.discuss{
	cursor: pointer;
	text-decoration:none;
	border-radius: 4px;
	background-color: #0042AF;
	color: white;
	padding: 8px;
	font-size: 120%;
	

}


a.feedback{
	cursor: pointer;
	text-decoration:none;
	border-radius: 4px;
	background-color: #0042AF;
	color: white;
	padding: 8px;
	font-size: 120%;
	

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
<br><br><br><br><br><br>

<div id="table_container"><a>

	<table>
		<th width="15%">User</th> <th width="20%">Audio</th> <th width="15%">Solution</th> <th width="30%">Update solution</th>
		
<%

	ArrayList<HealthIssue> ahi = HealthIssueDAO.getAllRecords();
	for(  HealthIssue h : ahi){
		

%>		
		
		<tr>
		<td align="center"> 
		 <a class="userinfo" href="<%=request.getContextPath() %>/showUserInfo.jsp?mobile=<%=h.getMobile()%>"><img src="<%=request.getContextPath()%>/icons/malefemale.jpeg" width="60px" height="60px"/></a>
			
		
		</td>
		
		<td align="center"> 
		
			 <div issue="<%=h.getHealth_issue_id() %>" ><a issue="<%=h.getHealth_issue_id() %>" href="#" id="playback" mobile="" url="<%=h.getRecording_url()%>"><img width="50px" height=40px" src="<%=request.getContextPath()%>/icons/play.jpeg"/></a>
			 		<a href="<%=h.getRecording_url()%>.mp3" id="download"><img width="50px" height=40px" src="<%=request.getContextPath()%>/icons/download.jpeg"/></a>
			</div>
 		</td>
		
		<td align="center">

<% 
		  String img_url = h.getSolved()!=0?request.getContextPath()+"/icons/solved.jpeg":request.getContextPath()+"/icons/unsolved.jpeg"; 
		  
		  
		  %>
		  
		  <img width="60px" height="60px"src="<%=img_url %>"/>
		  

</td>
		
		<td align="center"><a class="discuss"  href="<%=request.getContextPath()%>/postOpinion.jsp?health_issue_id=<%=h.getHealth_issue_id() %>">MY OPINION</a> 
		
		&nbsp;
		
		<a class="feedback" href="<%=request.getContextPath()%>/fillFeedback.jsp?health_issue_id=<%=h.getHealth_issue_id()%>">FEEDBACK</a>
		
		</td>
		</tr>
	<% } %>
	</table>

</div>


</body>
</html>