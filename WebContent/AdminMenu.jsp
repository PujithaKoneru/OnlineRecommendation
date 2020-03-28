<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AdminMenu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css"	href="css/menu.css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all"/>
<script src="css/HoverMenu.js" type="text/javascript"></script>
  </head>
  
  <body>
  
  
 		 <ul id="nav">
 		 		<li class="top">
 					 <a href="AdminHome.jsp" class="top_link"><span	>Home</span> </a>						
					</li>
					<li class="top">
						<a href="InsertProducts.jsp" class="top_link"><span>Insert Products</span></a>
					</li>
					
						<li class="top">
 					 <a href="./LogHistoryAction" id="services" class="top_link"><span	class="down">Log History</span> </a>
						<ul class="sub">
								<li><a href="./LogHistoryAction" class="parent"><span>Log History</span></a></li>
								<li><a href="./VenueRecommendedAction" class="parent"><span> Venue Recommended </span></a></li>
								<li><a href="./HubAIModelAction" class="parent">Hub Authority Inference Model</a></li>
								<li><a href="./Rank" class="parent">Bi Objective Recommendation </a></li>
						</ul>
					</li>
					
					
					<li class="top">
						<a href="ChangePassword.jsp" class="top_link"><span>Change Password</span></a>
					</li>
					<li class="top">
						<a href="LogoutAction.jsp" class="top_link"><span>Logout</span> </a>
					</li>


		</ul>
  
                
       