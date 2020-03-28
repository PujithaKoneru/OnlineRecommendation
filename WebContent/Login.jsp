<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>
			<script type="text/javascript">
function validator() {

		document.getElementById("msguid").innerHTML = "";
		document.getElementById("msgpass").innerHTML = "";

	if (document.getElementById("uid").value == "") {

		document.getElementById("msguid").innerHTML = "Please Enter User ID";
		return false;
	} else if (document.getElementById("pass").value == "") {

		document.getElementById("msgpass").innerHTML = "Please Enter Password";
		return false;
	}

}
</script>
  </head>  
  <body> 
          <jsp:include page="Header.jsp"></jsp:include>

  <div style="width: 100%; height: auto;margin-top: -5px;">
   <div style=""><jsp:include page="Menu.jsp"></jsp:include></div>         
    </div>

  <center>
        <div class="signup" style="margin-top: -1px; width: 100%;">        
        <strong class="box_msg">LOGIN ACCOUNT</strong>                	
             <form action="./LoginAction"  onsubmit="return validator();">
                <table border="0"  style="" width="305px"  >                	
                	<tr>
                	<td colspan="2" style="">
                	<label style="color: red; font-style:italic; text-align: center; "><% String status=request.getParameter("status"); if(status!=null){out.println(status);} %></label>      
           
                	</td>
                	</tr>
                	
                    <tr>
                        <td>User ID : <span class="dot">*</span></td>
                        <td><input type="text" name="uid" id="uid" class="input_text"  value="" >
                         <label id="msguid"  style="color: red;font-size: 16px;font-style: italic;"></label>
                      
                        </td>
                    </tr>
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td>Password : <span class="dot">*</span></td>
                        <td><input type="password" name="pass" id="pass" class="input_password" value="">
                         <label id="msgpass"  style="color: red;font-size: 16px;font-style: italic;"></label>
                      </td>
                    </tr>
                    <tr>
                	<td> &nbsp; </td>
                	<td> &nbsp; </td>
                	</tr>
                    <tr>
                        <td> &nbsp; </td>
                        <td><input type="submit" class="submit" value="LOGIN"></td>
                    </tr>
                </table>
            </form>	 
            
             <strong class="box_msg" style="margin-top: -8px;"> <a href="Registration.jsp" style="color: white; text-decoration: none;">New User</a>  </strong>            
        </div>
    </center>
    <div style=" margin-top: -1px; height: 50px;background-color: black;">         
   <jsp:include page="Footer.jsp"></jsp:include>
  </div>   
  </body>
</html>
