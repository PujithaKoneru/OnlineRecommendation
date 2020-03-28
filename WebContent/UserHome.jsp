<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UserHome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>

  </head>
  
  <body>
    <jsp:include page="Header.jsp"></jsp:include>
    
      <center>
  <div style="width: 100%; height: auto;margin-top: -20px;">
          <div><jsp:include page="UserMenu.jsp"></jsp:include></div>    
          <div style="background-image:url('images/home_msg_back.jpg'); margin-top: -5px; color: black; font-size: 30px; text-align: center; height: 300px; ">
          <br/><br/><br/>
          <label style="color: white; font-style:italic; margin-left: 121px; ">Welcome <% String status=(String)session.getAttribute("user"); if(status!=null){out.println(status);} %></label>      
      
          </div>
      </div>
        <div style=" margin-top: -1px; height: 50px;background-color: black;">         
   <jsp:include page="Footer.jsp"></jsp:include>
  </div>  
       </center>
    
    
    
    

  </body>
</html>
