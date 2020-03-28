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

import com.dts.aoc.dao.HubAIModelDAO;
import com.dts.aoc.dao.RankDAO;
import com.dts.aoc.dto.ClassBean;
import com.dts.aoc.dto.HubAIModelBean;

public class Rank extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		HashMap shm1=new HubAIModelDAO().getUser();
		HashMap shm2=new HubAIModelDAO().getProd();
		Vector<ClassBean> aa1 = new Vector<ClassBean>();	
		
		for(int i=1;i<=shm2.size();i++){
			String p1=(String)shm2.get(i);
			
			out.print(p1+"-->");
			
			
			ClassBean cb1=new ClassBean();
			
			float count=0;
			Vector<ClassBean> aa11 = new Vector<ClassBean>();
			for(int j=1;j<=shm1.size();j++){
				ClassBean cb2=new ClassBean();
				String u1=(String)shm1.get(j);
				boolean f=new RankDAO().checkUserUsingProduct(p1, u1);
				out.print(u1+"-->");
				if(f==false){out.print("N");cb2.setProductLikeOrNot("N");}
				if(f==true){out.print("Y");cb2.setProductLikeOrNot("Y");count=count+1;}
				
				aa11.add(cb2);
				out.print(", ");
				
			}
			out.print(" ( "+count+" )");out.print(" ( "+shm1.size()+" )");
			float rank=count/shm1.size();
			out.print(" ( "+rank+" )");
			//set product name
			cb1.setTopRankProductName(p1);
			//set yes no collection
			cb1.setVectorProductLikeOrNot(aa11);
			// set rank
			cb1.setProductRank(rank);
			new RankDAO().checkProductWithRank(p1, rank);
			aa1.add(cb1);
		}
		
		
		
		
		
		
		
		
		HttpSession session = request.getSession();
		String role=(String)session.getAttribute("role");
		if(role.equals("ADMIN")){System.out.println(role);
		String path="BiObjectiveRecommendation.jsp";
		request.setAttribute("vaa1", aa1);
		request.setAttribute("jhm1", shm1);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		}
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
