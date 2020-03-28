<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.dts.aoc.dto.ClassBean" %>
<%@ page import="com.dts.dae.dto.RegistrationBean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BiObjectiveRecommendation.jsp' starting page</title>
    
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
                		<%HashMap shm1=(HashMap)request.getAttribute("jhm1");
                			for(int j=1;j<=shm1.size();j++){
							
							String u11=(String)shm1.get(j);
                		 %>
                		<th class="f1"><%=u11 %></th>
                		<% }%>
                		<th class="f1">Rank</th>
                		
                	</tr>
                	
                		<%
    					 int i=0;
    					 int count =0;     
						 Vector c = (Vector) request.getAttribute("vaa1");
						 Iterator it = c.listIterator();						
						 while (it.hasNext()) {							
						ClassBean jcb1=(ClassBean)it.next();								
													
					%>
					<tr>
						<td class="f">
							<%=jcb1.getTopRankProductName() %>
						</td>
						<%
						Vector<ClassBean> aa11 = new Vector<ClassBean>();
						aa11=jcb1.getVectorProductLikeOrNot();
						Iterator it1 = aa11.listIterator();						
						 while (it1.hasNext()) {							
						ClassBean jcb2=(ClassBean)it1.next();
						  %>
						<td class="f">
							<%=jcb2.getProductLikeOrNot() %>
						</td>
						<%} %>
							<td class="f">
							<%=jcb1.getProductRank() %>
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
