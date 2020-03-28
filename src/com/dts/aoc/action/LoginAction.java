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
import com.dts.dae.dao.SecurityDAO;
import com.dts.dae.dto.RegistrationBean;

public class LoginAction extends HttpServlet {
	private String role="";
	private String username="";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		RegistrationBean rb=new RegistrationBean();
		session.setAttribute("userid",request.getParameter("uid"));
		rb.setUserID(request.getParameter("uid"));
		rb.setPassword(request.getParameter("pass"));
		try{
		role=new SecurityDAO().loginCheck(rb);
		
		}
		catch (Exception e) {
			out.println("Login Check Problem");
		}
		try{
			username=new SecurityDAO().userName(rb);
			
			}
			catch (Exception e) {
				out.println("User Name Check Problem");
			}
		
		String target = "Login.jsp?status=Invalid username and password";
		
		session.setAttribute("uid", request.getParameter("uid"));
        if(role.equals("ADMIN"))
        {          
           target = "AdminHome.jsp?status=Welcome "+username;
           session.setAttribute("user",username);
           session.setAttribute("role",role);
        } 
        else if(role.equals("USER"))
        {
           target = "UserHome.jsp?status=Welcome "+username;  	
           session.setAttribute("user",username);
           session.setAttribute("role",role);
           
        } 
        else { 
           target = "Login.jsp?status=Invalid username and password";
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