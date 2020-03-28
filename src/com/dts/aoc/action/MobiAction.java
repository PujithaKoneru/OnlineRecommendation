package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.aoc.dao.MobiContexDAO;
import com.dts.aoc.dao.ProductsSearchDAO;
import com.dts.aoc.dto.ClassBean;
import com.dts.aoc.dto.InsertProductsBean;

public class MobiAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uplace1=request.getParameter("placesearch");
		String uplace=uplace1.toUpperCase();
		String psearch1=request.getParameter("search");
		String psearch=psearch1.toUpperCase();
		/*
		 
		 TOP Rank Product logic
		 
		HashMap mshm11=new MobiContexDAO().getTopProd(psearch);
		HashMap mshm3=new HashMap();
		int iii=0;
		for(int i=1;i<=mshm11.size();i++){
			
			ClassBean mscb111=new ClassBean();
			mscb111=(ClassBean)mshm11.get(i);
			String topproductnam=mscb111.getTopRankProductName();			
			String topproductpath = request.getRealPath("/images");
			
			InsertProductsBean msipb1=new MobiContexDAO().getTopProductInfo(topproductnam, topproductpath);
			String t=msipb1.getBookName();
			ClassBean cb=new ClassBean();
			
			if(t!=null){
				iii=iii+1;
			cb.setProductInformationObject(msipb1);
			cb.setProductRank(mscb111.getProductRank());
			mshm3.put(iii,cb);
			}
		}
		*/
		//=======================Code to get by distance =======================
		System.out.println("in s>"+uplace);
		HashMap mshm1=new MobiContexDAO().getMinimumDistanceServiceProviderPlace(uplace);
		HashMap mshm2=new HashMap();
		int ii=0;
		for(int i=1;i<=mshm1.size();i++){
			ClassBean mscb1=new ClassBean();
			ClassBean mscb11=new ClassBean();
			mscb1=(ClassBean)mshm1.get(i);
			
			String splace=mscb1.getPlace2();
			
			String path111 = request.getRealPath("/images");
			InsertProductsBean msipb=new MobiContexDAO().getMinimumDistanceServiceProviderProductInformation(splace, psearch, path111);
			String t=msipb.getBookName();
			if(t!=null){
				ii=ii+1;
			mscb11.setProductInformationObject(msipb);
			mscb11.setPlace1(mscb1.getPlace1());
			mscb11.setPlace2(splace);
			mscb11.setDistance(mscb1.getDistance());
			mshm2.put(ii,mscb11);
			}
		}
		
			///=========================================
		Vector<InsertProductsBean>  tsb=null;
		String path2 = request.getRealPath("/images");
		HttpSession session = request.getSession();
		String ssearch=(String)session.getAttribute("s");
		if(psearch==null){
			psearch=ssearch;
		}
		System.out.println("search"+psearch);
		
		System.out.println("ssearch"+ssearch);
		if(psearch!=null||ssearch!=null){
			
			session.setAttribute("s", psearch);
		 tsb = new ProductsSearchDAO().getSearchRecommendedProducts(psearch, path2);
		 request.setAttribute("vp", tsb);
		}
		

		

		///=========================================
		if(!mshm2.isEmpty()){request.setAttribute("smsg2", "Closest Service Provider Matched Itemes are ........");}
	//	if(!mshm3.isEmpty()){request.setAttribute("smsg3", "Top Rank Matched Itemes are ........");}
		request.setAttribute("mshm2", mshm2);
	//	request.setAttribute("mshm3", mshm3);
		String tpath="MobiCoPage.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(tpath);
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
