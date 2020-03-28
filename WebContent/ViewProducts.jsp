<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%@ page import="com.dts.aoc.dto.InsertProductsBean" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ViewProducts JSP 'ViewProducts.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
   </center>
   				<%
  					String search=(String)session.getAttribute("s");
  					System.out.println("====="+search);
  					%>
  					<table style="margin-top: -22px; margin-left: 70px;width: 780px;background-image: url(ban.png);">
  					<tr>
  						<td colspan="4">
  						<label style="font-size: 25px; color: red; font-style: italic;"><% String m=(String)request.getAttribute("smsg"); if(m!=null){out.print(m);} %></label>
  						</td>
  					</tr>
  					<%
    					 int i=0;
    					 int count =0;     
						 Vector c = (Vector) request.getAttribute("vp");
						 Iterator it = c.listIterator();						
						 while (it.hasNext()) {							
						 InsertProductsBean event=(InsertProductsBean) it.next();	
					%>
					<tr>					
					<td>
					<div style="float: left; width: 180px; " >
						<form action="./ProductsSearchAction" method="post">
						<input type="hidden" name="pname" value="<%= event.getBookName() %>"/>
						<input type="hidden" name="sprovider" value="<%= event.getBookServiceProvider() %>"/>
						<input type="hidden" name="venue" value="<%= event.getVenue() %>"/>												
						<input type="image" src="images/<%= event.getBookPicture() %>" wd3__shadow_src="images/<%= event.getBookPicture() %>" height="260px" width="180px" alt="fghf"/>
					 </form>
						</div>
					<div style="float: left;">
					<div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
					</div>
					<div style="float: left;width: 250px;">
					<div><label class="heading" >Book Name:</label><label class="content" > <%= event.getBookName() %></label></div>
					<div><label class="heading" >Book Cost:</label><label class="content" ><%= event.getBookCost() %></label></div>
					<div><label class="heading" >Book Author: </label><label class="content" ><%= event.getBookAuthor() %></label></div>
					<div><label class="heading" >Book Description: </label><label class="content" ><%= event.getBookDescription() %></label></div>
					</div>	
					<div style="float: left;">
					<div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </div>
					</div>
					<div style="float: left;width: 180px;">
					<div><label class="heading" >Service Provider: </label><label class="content" ><%= event.getBookServiceProvider() %></label></div>
					<div><label class="heading" >Venue: </label><label class="content" ><%= event.getVenue()%></label></div>
					</div>
					</td>				
					</tr>
					<%}	%>
    
    </table>
 
  </body>
</html>
