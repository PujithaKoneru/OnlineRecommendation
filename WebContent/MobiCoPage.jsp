<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.dts.aoc.dto.InsertProductsBean" %>
<%@ page import="com.dts.aoc.dto.ClassBean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MobiCoPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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

<script type="text/javascript" type="text/javascript"  src="jquery.min.js"></script>
	<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
		
		$('#pdistance').hide();
		$('#cp').click(function(){
		$('#pdistance').show();
		$('#cp').hide();
		$('#prank').hide();
		});
		
		
	
		
		});
		
		</script>

  </head>
  <body>
  
  <jsp:include page="MobiCoSearch.jsp"></jsp:include>
   <div style="width: 100%; height: auto;background-image: url(images/mbbac.png);">
 			
 			
 			
 			
 			 			<div id="prank">
 			
  			<table style="margin-top: 0px; margin-left: 70px;width: 780px;background-image: url(ban.png);">
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
						
					<img src="images/<%= event.getBookPicture() %>" wd3__shadow_src="images/<%= event.getBookPicture() %>" border="0" height="260px" width="180px" alt="fghf"/>
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
   				 <br/>	
    <div style="margin-left: 100px;"><input type="Button" name="cp"  id="cp" value="Closest Service Provider"/></div>
 			</div>
 			
 			
 			
 		<div id="pdistance">
 			
  					<table style="margin-top: 0px; margin-left: 70px;width: 780px;background-image: url(ban.png);">
  						<tr>
  						<td colspan="4">
  						<label style="font-size: 25px; color: red; font-style: italic;"><% String m2=(String)request.getAttribute("smsg2"); if(m2!=null){out.print(m2);}else{out.print("No Itemes Match !!!!!!!!!");} %></label>
  						</td>
  					</tr>
  				<%	HashMap jmshm2=(HashMap)request.getAttribute("mshm2");
						 		for(int k=1;k<=jmshm2.size();k++){
								ClassBean jmscb1=new ClassBean();
								InsertProductsBean event=new InsertProductsBean();
								jmscb1=(ClassBean)jmshm2.get(k);
								event=jmscb1.getProductInformationObject();
					%>
					<tr>					
					<td>
					<div style="float: left; width: 180px; " >																	
						<img src="images/<%= event.getBookPicture() %>" wd3__shadow_src="images/<%= event.getBookPicture() %>" height="260px" width="180px" alt="fghf"/>
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
					<div style="float: left;width: 220px;">
					<div><label class="heading" >Service Provider: </label><label class="content" ><%= event.getBookServiceProvider() %></label></div>
					<div><label class="heading" >Service Provider Place: </label><label class="content" ><%= event.getVenue()%></label></div>
					<div><label class="heading" >Search Place: </label><label class="content" ><%= jmscb1.getPlace1()%></label></div>
					<div><label class="heading" >Distance: </label><label class="content" ><%=jmscb1.getDistance()%></label></div>
					
					</div>
					</td>				
					</tr>
					<%}	%>
   				 </table>
 			</div>
 		</div>
  </body>
</html>
	