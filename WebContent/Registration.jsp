<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Registration.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>
	

 <link href="css/a.css" rel="stylesheet" type="text/css" media="all"/>

  </head>
  
  <body>
    <jsp:include page="Header.jsp"></jsp:include>
    
  <div style="width: 100%; height: auto;margin-top: -20px;">
          <div><jsp:include page="UserMenu.jsp"></jsp:include></div> 
          </div> 
      <center>
      <br/>
        <div class="signup" style=" width: 100%;margin-top: -17px;">
        <strong class="box_msg">Registration Form </strong>    
            <form action="./RegistrationAction">
                <table>
                	<tr>
                	<td colspan="2" style="">
                	<label style="color: red; font-style:italic; text-align: center; "><% String status=request.getParameter("status"); if(status!=null){out.println(status);} %></label>      
                   	</td>
                	</tr>                	
                    <tr>
                        <td><p>User ID : </p></td>
                        <td><input type="text" name="uid" id="uid" class="input_text"  value="" required=""></td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td><p>Password : </p></td>
                        <td><input type="password" name="pass" id="pass" class="input_password" value="" required=""></td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td><p>Confirm Password :</p></td>
                        <td><input type="password" name="cpass" id="cpass" class="input_password" value="" required=""></td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td><p>User Name : </p></td>
                        <td><input type="text" name="uname" id="uname"  class="input_text" value="" required=""></td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td><p>Email : </p></td>
                        <td><input type="text" name="email" id="email" class="input_text"  value="" required=""></td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td><p>Mobile No :</p></td>
                        <td><input type="text" name="mob" id="mob" class="input_text"  value="" required=""></td>
                    </tr> 
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>                   
                    <tr>
                        <td><p>Date of Birth : </p></td>
                        <td><input type="text" name="dob" id="dob"  class="input_text"  value="" required="" placeholder="dd-mm-yyyy"></td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td><p>Gender : </p></td>
                        <td class="input_text">
                        M<input type="radio" name="g" id="g" value="M" checked="checked"/> &nbsp;
                        F<input type="radio" name="g" id="g" value="F" />
                        </td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td><p>User Type : </p></td>
                        <td >
                        <select name="utype" id="utype" size="1" class="input_text">
							<option value="USER">User</option>
						</select>
						</td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td><p>Address :</p></td>
                        <td><textarea name="uaddress"  class="input_a" ></textarea>                                              
                        </td>
                    </tr>
                    <tr>
                    	<td> &nbsp; </td>
                    	<td> &nbsp; </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" class="submit" value="Register"></td>
                    </tr>                    
                </table>
            </form>	
            
             <strong class="box_msg" style="margin-top: -8px;"> <a href="Login.jsp" style="color: white; text-decoration: none;">Back</a>  </strong>            
        
        </div>
    </center>
  </body>
</html>
