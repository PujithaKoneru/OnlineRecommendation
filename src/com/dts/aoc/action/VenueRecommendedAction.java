package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.aoc.dao.LogHistoryDAO;
import com.dts.dae.dto.RegistrationBean;

public class VenueRecommendedAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		
		String path = "";
		
		
		try {
		Vector<RegistrationBean>  logvenue=null;	
		HttpSession session = request.getSession();
		 logvenue = new LogHistoryDAO().getVenueRecommended();

		request.setAttribute("logvenue", logvenue);
		System.out.println("in Action class vcb userinfo...........");

		if (!logvenue.isEmpty()) {

			path = "VenueRecommended.jsp";
		} else {

			path = "VenueRecommended.jsp";

		}

	} catch (Exception e) {
		e.printStackTrace();
		path = "VenueRecommended.jsp";
	}

	RequestDispatcher rd = request.getRequestDispatcher(path);
	rd.forward(request, response);

		
		
		
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		doGet(request, response);
		out.flush();
		out.close();
	}


}
