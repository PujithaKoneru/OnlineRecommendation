<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AdminHome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>

  </head>
  
  <body>
         
        <% String u=(String)session.getAttribute("user"); if(u==null){
        String target = "Login.jsp?status=Please enter username and password";        
         RequestDispatcher rd = request.getRequestDispatcher(target);
       rd.forward(request,response);   
        } %>      
          
         
          <jsp:include page="Header.jsp"></jsp:include>
  <center>
     <br/>
  <div style="width: 100%; height: auto;margin-top: -20px;">
   <div style=""><jsp:include page="AdminMenu.jsp"></jsp:include></div>         
          <div style="background-image:url('images/home_msg_back.jpg'); margin-top: -8px; color: black; font-size: 30px; text-align: center; height: 300px; ">
          <br/><br/><br/>
          <label style="color: white; font-style:italic; margin-left: 150px;">Welcome <% String status=(String)session.getAttribute("user"); if(status!=null){out.println(status);} %></label>      
      
          </div>
      </div>
       <div style=" margin-top: -1px; height: 50px;background-color: black;">         
   <jsp:include page="Footer.jsp"></jsp:include>
  </div>
       </center>
  </body>
</html>
