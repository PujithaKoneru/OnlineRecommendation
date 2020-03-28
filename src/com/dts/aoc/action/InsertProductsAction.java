package com.dts.aoc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.aoc.dao.InsertProductsDAO;
import com.dts.aoc.dto.InsertProductsBean;
//import com.sun.org.apache.commons.beanutils.BeanUtils;


public class InsertProductsAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
doPost(request,response);
		
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		InsertProductsBean  ipb=new InsertProductsBean();
		ipb.setBookName(request.getParameter("bname"));
		ipb.setBookCost(request.getParameter("bcost"));
		ipb.setBookAuthor(request.getParameter("bauthor"));
		ipb.setBookPublication(request.getParameter("bpublication"));
		ipb.setBookCategory(request.getParameter("bcategory"));
		ipb.setBookPicture(request.getParameter("bpic"));
		ipb.setBookServiceProvider(request.getParameter("sprovider"));		
		ipb.setBookDescription(request.getParameter("bdescription"));
		ipb.setVenue(request.getParameter("venue"));
		String pname=request.getParameter("bname");
		String venue=request.getParameter("venue");

		boolean flag = false;
		try {
				int i=new InsertProductsDAO().checkVenue(pname, venue);
				System.out.println(i);
				if(i>0){
					request.setAttribute("status", "For Products "+pname+" venue "+venue+" is also present");
				}				
				else{
					flag = new InsertProductsDAO().insertProducts(ipb);
					if (flag) {
							request.setAttribute("status", "Products Is Inserted !!!!!");
					} else {				
						request.setAttribute("status", "Products Insertion Is Failed");
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status", e.getMessage());
		}
		String path ="InsertProducts.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		out.flush();
		out.close();
	}
}
