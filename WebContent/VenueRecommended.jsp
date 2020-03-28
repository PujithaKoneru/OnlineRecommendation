<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.dts.dae.dto.RegistrationBean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'VenueRecommended.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>
	<style type="text/css">
	.f{
	font-family: monospace;
	font-size: 14px;
	}
	.f1{
	font-family: cursive;
	font-size: 18px;
	color: blue;
	}
	</style>
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
   
      </div>
        <div class="signup" style=" width: 100%;">        
        <strong class="box_msg">Venue Recommended</strong>                	
          
                <table border="1"  style="" cellpadding="5px">                	
                
                	<tr>               		
                		<th class="f1">Products Name</th>
                		<th class="f1">Service Provider</th>
                		<th class="f1">Venue</th>
                		<th class="f1">Log Date</th>
                		<th class="f1">Recommended Count</th>
                		
                	</tr>
                	
                		<%
    					 int i=0;
    					 int count =0;     
						 Vector c = (Vector) request.getAttribute("logvenue");
						 Iterator it = c.listIterator();						
						 while (it.hasNext()) {							
						RegistrationBean rbvenue=(RegistrationBean) it.next();								
													
					%>
					<tr>
						<td class="f">
							<%=rbvenue.getPname() %>
						</td>
					
						<td class="f">
							<%=rbvenue.getSprovider() %>
						</td>
						<td class="f">
							<%=rbvenue.getVenue() %>
						</td>
						
						<td class="f">
							<%=rbvenue.getDistance() %>
						</td>
							<td class="f">
							<%=rbvenue.getCountVenue() %>
						</td>
					</tr>
			<%			}
	%>
    
                	
                  
                </table>
        <br/>
             <strong class="box_msg" style="margin-top: -8px;">&nbsp;</strong>            
        </div>
          <div style=" margin-top: -1px; height: 50px;background-color: black;">         
   <jsp:include page="Footer.jsp"></jsp:include>
  </div>  
    </center>
  </body>
</html>
