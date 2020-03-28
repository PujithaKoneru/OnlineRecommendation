package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.aoc.dao.HubAIModelDAO;
import com.dts.aoc.dao.ProductsSearchDAO;
import com.dts.aoc.dao.RankDAO;
import com.dts.aoc.dao.UserProfileDAO;
import com.dts.aoc.dto.ClassBean;
import com.dts.aoc.dto.InsertProductsBean;


public class ProductsSearchAction extends HttpServlet {


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
			 tsb = new ProductsSearchDAO().getSearchProducts(search, path2);
			 request.setAttribute("vp", tsb);
			}
			

			if (!tsb.isEmpty()) {

				path = "ViewProducts.jsp";
				request.setAttribute("smsg", "Matched Itemes are ........");
			} else {

				path = "ViewProducts.jsp";
				request.setAttribute("smsg", "No Itemes Match !!!!!!!!!");

			}

		} catch (Exception e) {
			e.printStackTrace();
			path = "ViewProducts.jsp";
		}
		
		HttpSession session = request.getSession();
		String uid=(String)session.getAttribute("uid");
		String uname=(String)session.getAttribute("user");
		String prodname=request.getParameter("pname");
		String sprovider=request.getParameter("sprovider");
		String distance=request.getParameter("distance");
		String venue=request.getParameter("venue");
	
	
		try{
			if(prodname!=null){
			boolean f=new UserProfileDAO().userProfileData(uname,prodname, sprovider, venue);
			
			//======================Start  update rank of the product
			HashMap shm1=new HubAIModelDAO().getUser();
			HashMap shm2=new HubAIModelDAO().getProd();
			for(int i=1;i<=shm2.size();i++){
				String p1=(String)shm2.get(i);
				ClassBean cb1=new ClassBean();
				float count=0;
				Vector<ClassBean> aa11 = new Vector<ClassBean>();
				for(int j=1;j<=shm1.size();j++){
					String u1=(String)shm1.get(j);
					boolean ff=new RankDAO().checkUserUsingProduct(p1, u1);
					out.print(u1+"-->");
					if(ff==true){count=count+1;}
				}
				float rank=count/shm1.size();
				new RankDAO().checkProductWithRank(p1, rank);
			}
			//======================End  update rank of the product
			
			}
		}catch (Exception e) {
			e.printStackTrace();		
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
