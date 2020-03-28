<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ChangePassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>

			<script type="text/javascript">
function validator() {

		document.getElementById("msgoldpass").innerHTML = "";
		document.getElementById("msgnewpass").innerHTML = "";
		document.getElementById("msgchangedpass").innerHTML = "";
		document.getElementById("alertmsg").innerHTML = "";

	if (document.getElementById("opass").value == "") {

		document.getElementById("msgoldpass").innerHTML = "Please Enter Old Password";
		return false;
	} else if (document.getElementById("pass").value == "") {

		document.getElementById("msgnewpass").innerHTML = "Please Enter New Password";
		return false;
	}else if(document.getElementById("cpass").value == ""){
		document.getElementById("msgchangedpass").innerHTML = "Please Enter Confirm Password";
		return false;
	}else if(document.getElementById("cpass").value !=document.getElementById("pass").value){
		document.getElementById("alertmsg").innerHTML = "New Password is not matched with confirm password";
		return false;
		
	}

}
</script>

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
          <% String role=(String) session.getAttribute("role");  if(role.equals("ADMIN")){%>
   <div style=""><jsp:include page="AdminMenu.jsp"></jsp:include></div>  
   <%}if(role.equals("USER")){ %> 
   <div><jsp:include page="UserMenu.jsp"></jsp:include></div> 
   <%} %>
      </div>
        <div class="signup" style=" width: 100%;">
        <strong class="box_msg">Change Password</strong>    
            <form action="./ChangePasswordAction" onsubmit="return validator();">
                <table>
                	<tr>
                	<td colspan="2" style="">
                	<label style="color: red; font-style:italic; text-align: center; "><% String status=request.getParameter("status"); if(status!=null){out.println(status);} %></label>      
                   	</td>
                	</tr>                	
                    <tr>
                        <td><p>Old Password : <span class="dot">*</span></p></td>
                        <td>
                        <input type="password" name="opass" id="opass" class="input_password" value="" >
                       <label id="msgoldpass" style="color: red;font-size: 16px;font-style: italic;"></label>
                        </td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td><p>New Password : <span class="dot">*</span></p></td>
                        
                        
                        <td><input type="password" name="pass" id="pass" class="input_password" value="" >
                      <label id="msgnewpass"  style="color: red;font-size: 16px;font-style: italic;"> </label>
                        </td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td><p>Confirm Password :<span class="dot">*</span></p></td>
                        <td><input type="password" name="cpass" id="cpass" class="input_password" value="" >
                        <label id="msgchangedpass"  style="color: red;font-size: 16px;font-style: italic;"></label>
                        </td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> <label id="alertmsg" style="color: red;font-size: 16px;font-style: italic;"></label> </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" class="submit" value="Change Password"></td>
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
