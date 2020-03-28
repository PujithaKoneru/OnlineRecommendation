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
import com.dts.aoc.dao.HubAIModelDAO;
import com.dts.aoc.dto.HubAIModelBean;


public class HubAIModelAction extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HashMap hm=new HubAIModelDAO().getUser();
		Vector<HubAIModelBean> vhamb = new Vector<HubAIModelBean>();	
	
		for(int i=1;i<=hm.size();i++){
			String v1=(String)hm.get(i);
			int u1=new HubAIModelDAO().getItemsByUser(v1);
				for(int j=i+1;j<=hm.size();j++){
					String v2=(String)hm.get(j);
					HashMap hm33=new HubAIModelDAO().getSimilarity(v1, v2);
					int s=hm33.size();
					/// get Name of Similar Product 
					Vector<HubAIModelBean> vhamb1 = new Vector<HubAIModelBean>();
					for(int k=1;k<=s;k++){
						
						HubAIModelBean ohamb1=new HubAIModelBean();
						ohamb1.setNameSimilarityProduct((String)hm33.get(k));
						vhamb1.add(ohamb1);
					}
					
					///
					
					int u2=new HubAIModelDAO().getItemsByUser(v2);
					float p=0;
					if(u1>u2){p=u1;}else{p=u2;}
					HubAIModelBean ohamb=new HubAIModelBean();
					ohamb.setUserName1(v1);
					ohamb.setUserName2(v2);
					ohamb.setSimilarity(s);
					ohamb.setCollectionNameSimilarityProduct(vhamb1);
					ohamb.setProbability(s/p);
					vhamb.add(ohamb);
				}
			
			}
		if (!vhamb.isEmpty()) {
		request.setAttribute("vhamb",vhamb);
		String path="HubAIModel.jsp";
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

		out.flush();
		out.close();
	}

	

}
