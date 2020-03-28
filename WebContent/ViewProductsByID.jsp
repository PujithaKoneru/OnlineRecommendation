<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.dts.aoc.dto.InsertProductsBean"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ViewProductsByID.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>
<style type="text/css">
	.heading{
	color: #000011;
	font-size: 16px;
	}
		.content{
	color: #0000ee;
	font-style: italic; 
	font-size: 14px;
	}


	</style>
  </head>
  
  <body>
  
   <% String u=(String)session.getAttribute("user"); if(u==null){
        String target = "Login.jsp?status=Please enter username and password";        
         RequestDispatcher rd = request.getRequestDispatcher(target);
       rd.forward(request,response);   
        } %> 
      <center>
  <jsp:include page="ProductsSearch.jsp"></jsp:include>

  					<%
  					InsertProductsBean event=(InsertProductsBean)request.getAttribute("vp");    					
					%>
					<table border="0" style="background-image: url(ban.png); width: 800px;">
					<tr>
					<td> &nbsp; </td>	
					<td> &nbsp; </td>
					<td> &nbsp; </td>	
					<td> &nbsp; </td>
					</tr>
					<tr>
					<td> &nbsp; </td>	
					<td> &nbsp; </td>
					<td>
				<div >
					<div style="float: left;" ><img src="<%= request.getAttribute("p") %>" title="" height="400px" width="300px"/></div>
					
					<div style="float: left; " > &nbsp; </div>				
					<div style="float: left; ">
					<table>
						<tr>
							<td>
								<div><label class="heading" >Book Name:</label><label class="content" > <%= event.getBookName() %></label></div>
								<div><label class="heading" >Book Cost:</label><label class="content" ><%= event.getBookCost() %></label></div>
								<div><label class="heading" >Book Author: </label><label class="content" ><%= event.getBookAuthor() %></label></div>
								<div><label class="heading" >Book Publication: </label><label class="content" ><%= event.getBookPublication() %></label></div>
								<div><label class="heading" >Book Category: </label><label class="content" ><%= event.getBookCategory() %></label></div>
								<div style=" width: 444px;"><label class="heading" >Book Description: </label><label class="content" ><%= event.getBookDescription() %></label></div>
							</td>
						</tr>
					</table>
					</div>
					</div>
					</td>
					</tr>
					<tr>
					<td> &nbsp; </td>	
					<td> &nbsp; </td>
					<td> &nbsp; </td>	
					<td> &nbsp; </td>
					</tr>
					</table>
			
    </center>
  </body>
</html>
