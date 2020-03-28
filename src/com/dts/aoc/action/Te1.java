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
import com.dts.aoc.dto.InsertProductsBean;

public class Te1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String psearch1="Ja";
		String pname=psearch1.toUpperCase();
		HashMap mshm11=new MobiContexDAO().getTopProd(pname);
		for(int i=1;i<=mshm11.size();i++){
			
			ClassBean mscb111=new ClassBean();
			mscb111=(ClassBean)mshm11.get(i);
			String topproductnam=mscb111.getTopRankProductName();			
			String topproductpath = request.getRealPath("/images");
			
			InsertProductsBean msipb1=new MobiContexDAO().getTopProductInfo(topproductnam, topproductpath);
			String t=msipb1.getBookName();
			out.print(t);
			out.print("<br/>");
			out.println(mscb111.getTopRankProductName());
			out.println(mscb111.getProductRank());
		}
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
