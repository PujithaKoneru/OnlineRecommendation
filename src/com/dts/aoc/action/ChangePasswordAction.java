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

public class ChangePasswordAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		HttpSession session = request.getSession();
		String userid=(String)session.getAttribute("userid");
		String target = "ChangePassword.jsp?status=Please enter correct old password......";
		RegistrationBean b=new RegistrationBean();
		b.setOldPassword(request.getParameter("opass"));
		b.setPassword(request.getParameter("pass"));
		b.setUserID(userid);
		boolean f=	new ProfileDAO().changePassword(b);
		if(f==true){
			
			target = "ChangePassword.jsp?status=Your Password is changed password......";
		}
		else{
			
			target = "ChangePassword.jsp?status=Please enter correct old password......";
		}

	       RequestDispatcher rd = request.getRequestDispatcher(target);
	       rd.forward(request,response);    
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doGet(request,response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.flush();
		out.close();
	}

	

}
