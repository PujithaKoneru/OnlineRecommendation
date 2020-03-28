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

public class ProductsByIDAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		String path="";

		HttpSession session = request.getSession();
	
		

		int id=Integer.parseInt(request.getParameter("bid"));
		String picadress=request.getParameter("pic");
	
		try {

			Vector<InsertProductsBean>  tsb2=null;
			InsertProductsBean ipb2;
			String path3 = request.getRealPath("/images");		
			 ipb2 = new ProductsSearchDAO().getProductsByID(path3, id);

				request.setAttribute("vp", ipb2);	
				request.setAttribute("p", picadress);

				path = "ViewProductsByID.jsp";
				


		} catch (Exception e) {
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
