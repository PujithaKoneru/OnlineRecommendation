package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.aoc.dao.MobiContexDAO;
import com.dts.aoc.dto.ClassBean;

public class MobiContextAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/*
		 * logic to find minimum distance service provider
		 * 
		 * call method to select place1 ,place2 and distance from distance table where place1=user place order by distance
		 * call method to check place2 (service provider place) and search product name is present or not
		 * if yes then set distance, product name, service provider place and other information in one vector
		 * 
		 * above vector have minimum distance service provider
		 * 
		 * 
		 */
		out.println("++++++++++++1");
		String uplace="SR Nagar";
			//request.getParameter("#####################");
		/*HashMap mshm1=new MobiContexDAO().getMinimumDistanceServiceProviderPlace(uplace);
		
		out.println("++++++++++++2");
		for(int i=1;i<=mshm1.size();i++){
			ClassBean mscb1=new ClassBean();
			mscb1=(ClassBean)mshm1.get(i);
			out.println(mscb1.getPlace2());
			out.print("=======");
		}
		out.println("++++++++++++3");
		*/
		
		
		/*
		 * logic to find high rank product information 
		 * get all product name where product name = search product and rank >=.5
		 * 
		 * above result store in vector
		 * 
		 * using above vector we find all the information of the product
		 * 
		 * then store in vector
		 * 
		 */
		
		
		
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
