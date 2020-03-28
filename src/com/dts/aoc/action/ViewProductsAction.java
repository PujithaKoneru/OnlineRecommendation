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
import com.dts.aoc.dao.InsertProductsDAO;
import com.dts.aoc.dto.InsertProductsBean;

public class ViewProductsAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String path = "";

		try {

			Vector<InsertProductsBean>  tsb=null;
			String path1 = request.getRealPath("/images");
			HttpSession session = request.getSession();
			 tsb = new InsertProductsDAO().getProducts(path1);

			request.setAttribute("vp", tsb);
			System.out.println("in Action class vcb userinfo...........");

			if (!tsb.isEmpty()) {

				path = "ViewProducts.jsp";
			} else {

				path = "ViewProducts.jsp";

			}

		} catch (Exception e) {
			e.printStackTrace();
			path = "ViewProducts.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

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
