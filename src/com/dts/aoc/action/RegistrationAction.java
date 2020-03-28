package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.dae.dao.ProfileDAO;
import com.dts.dae.dto.RegistrationBean;

public class RegistrationAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();
RegistrationBean rb=new RegistrationBean();
rb.setUserID(request.getParameter("uid"));
rb.setPassword(request.getParameter("pass"));
rb.setUserName(request.getParameter("uname"));
rb.setUserEmail(request.getParameter("email"));
rb.setUserMobile(request.getParameter("mob"));
rb.setUserDOB(request.getParameter("dob"));
rb.setUserGender(request.getParameter("g"));
rb.setUserType(request.getParameter("utype"));
rb.setUserAddress(request.getParameter("uaddress"));
boolean f=new ProfileDAO().registration(rb);

String target = "Registration.jsp?status=Registration Failed  !!!!!";
if(f)
{          
   target = "Login.jsp?status=Welcome Account is created successfully";
 
} 

else { 
   target = "Registration.jsp?status=Registration Failed  !!!!!";
   }       

RequestDispatcher rd = request.getRequestDispatcher(target);
rd.forward(request,response);  

out.flush();
out.close();
}


public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();
doGet(request,response);
out.flush();
out.close();
}

}