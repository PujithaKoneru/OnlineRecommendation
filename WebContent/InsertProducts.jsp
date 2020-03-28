<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'InsertProducts.jsp' starting page</title>
    
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
   
      </div>
        <div class="signup" style=" width: 100%;">        
        <strong class="box_msg">INSERT PRODUCTS</strong>                	
            <form action="./InsertProductsAction">
                <table border="0"  style="">                	
                	<tr>
                	<td colspan="2" style="">
                	  <label style="color: red; font-style:italic; text-align: center; "><% String status=(String)request.getAttribute("status"); if(status!=null){out.println(status);} %></label>      
         
                	</td>
                	</tr>
                	
                    <tr>
                        <td>Book Name: <span class="dot">*</span></td>
                        <td><input type="text" class="input_text" name="bname" id="bname" value="" required=""></td>
                    </tr>
                
                	<tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td>Book Cost: <span class="dot">*</span></td>
                        <td><input type="text" class="input_text" name="bcost"  id="bcost" value="" required=""></td>
                    </tr>
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td>Book Author : <span class="dot">*</span></td>
                        <td><input type="text" class="input_text" name="bauthor"  id="bauthor" value="" required=""></td>
                    </tr>
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td>Book Publication  : <span class="dot">*</span></td>
                        <td><input type="text" class="input_text" name="bpublication"  id="bpublication" value="" required=""></td>
                    </tr>
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td>Book Category : <span class="dot">*</span></td>
                        <td><input type="text" class="input_text" name="bcategory"  id="bcategory" value="" required=""></td>
                    </tr>
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td>Book Picture : <span class="dot">*</span></td>
                        <td><input type="file" class="input_text" name="bpic"  id="bpic" value="" required=""></td>
                    </tr>                    
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td>Book Description : <span class="dot">*</span></td>
                        <td><textarea class="input_a" name="bdescription"  id="bdescription" value="" required=""></textarea></td>
                    
                    
                    
                    </tr>                    
                     <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td>Service Provider: <span class="dot">*</span></td>
                        <td><input type="text" class="input_text" name="sprovider"  id="sprovider" value="" required=""></td>
                    </tr>
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td>Venue: <span class="dot">*</span></td>
                        <td><input type="text" class="input_text" name="venue"  id="venue" value="" required=""></td>
                    </tr>                    
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                                        
                    <tr>
                        <td> &nbsp; </td>
                        <td><input type="submit" class="submit" value="Register"></td>
                    </tr>
                </table>
            </form>	 
             <strong class="box_msg" style="margin-top: -8px;">&nbsp;</strong>            
        </div>
         <div style=" margin-top: -1px; height: 50px;background-color: black;">         
   <jsp:include page="Footer.jsp"></jsp:include>
  </div>
    </center>
  </body>
</html>
