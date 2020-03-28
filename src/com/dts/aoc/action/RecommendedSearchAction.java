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

import com.dts.aoc.dao.ProductsSearchDAO;
import com.dts.aoc.dao.UserProfileDAO;
import com.dts.aoc.dto.InsertProductsBean;

public class RecommendedSearchAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String path="";
		String search=request.getParameter("search");
		
		
		try {

			Vector<InsertProductsBean>  tsb=null;
			String path2 = request.getRealPath("/images");
			HttpSession session = request.getSession();
			String ssearch=(String)session.getAttribute("s");
			if(search==null){
				search=ssearch;
			}
			System.out.println("search"+search);
			
			System.out.println("ssearch"+ssearch);
			if(search!=null||ssearch!=null){
				
				session.setAttribute("s", search);
			 tsb = new ProductsSearchDAO().getSearchRecommendedProducts(search, path2);
			 request.setAttribute("vp", tsb);
			}
			

			if (!tsb.isEmpty()) {

				path = "ViewRecommendedProducts.jsp";
				request.setAttribute("smsg", "Recommended Itemes are ........");
			} else {

				path = "ViewRecommendedProducts.jsp";
				request.setAttribute("smsg", "No Recommended Itemes !!!!!!!!!");

			}

		} catch (Exception e) {
			e.printStackTrace();
			path = "ViewRecommendedProducts.jsp";
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
		doGet(request,response);
		out.flush();
		out.close();
	}



}
