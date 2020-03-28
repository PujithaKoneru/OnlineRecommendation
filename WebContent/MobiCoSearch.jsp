<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MobiCoSearch.jsp' starting page</title>    
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
         <div style="width: 100%; height: auto;background-image: url(images/mbbac.png);">
   		<div><jsp:include page="UserMenu.jsp"></jsp:include></div>   
   		<div style=" ">   
  		<form action="./MobiAction" >
   		<table >
   			<tr ><td> <label  style="width: 140px; height: 40px; font-size: 2ex; color: white; "> Your Place Name: </label></td><td > <input type="text" class="input_text" style="width: 500px; height: 40px;" name="placesearch" id="placesearch"  /></td></tr>
   			<tr ><td style=" "> <label  style="width: 140px; height: 80px; font-size: 2ex; color: white; "> Product Name: </label></td><td > <input type="text" class="input_text" style="width: 500px; height: 40px;" name="search" id="search" /><br/><input type="submit" class="submit" style="width: 500px; height: 40px;" value="Search"></td></tr>
   		</table>
   </form>
   </div> 
  </div>
   </center>
  </body>
</html>
