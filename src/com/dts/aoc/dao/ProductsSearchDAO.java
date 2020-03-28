package com.dts.aoc.dao;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.dts.aoc.dto.InsertProductsBean;

import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;

public class ProductsSearchDAO  extends DataObject{
    
    static Connection con;
    public DbInterface db;
   
    public ProductsSearchDAO() 
    {
           con=getConnection();  
    }
   
  ///////////////////////////////////////
    
    public Vector<InsertProductsBean> getSearchRecommendedProducts(String search, String path2) {
		Vector<InsertProductsBean> tsb = new Vector<InsertProductsBean>();

		try {
			String s=search.toUpperCase();
			String query="Select PRODUCTS.BNAME, PRODUCTS.BCOST,PRODUCTS.BAUTHOR, PRODUCTS.BPUBLICATION, PRODUCTS.BCATEGORY, PRODUCTS.SPROVIDER,PRODUCTS.BIMAGE,PRODUCTS.BDESCRIPTION, PRODUCTS.VENU,PRODUCTS.BID, VENUERECOMMENDED.COUNT from   PRODUCTS  INNER JOIN VENUERECOMMENDED  ON(PRODUCTS.BNAME=VENUERECOMMENDED.PNAME)where UPPER(VENUERECOMMENDED.PNAME) like '%"+s+"%' ORDER BY VENUERECOMMENDED.COUNT DESC";
			//String Q="select * FROM PRODUCTS where BNAME LIKE '%"+search+"%' OR BAUTHOR LIKE '%"+search+"%' OR BPUBLICATION LIKE '%"+search+"%' OR BCATEGORY LIKE '%"+search+"%' OR BDESCRIPTION LIKE '%"+search+"%'";
			System.out.println(query);
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {

				InsertProductsBean ipbs = new InsertProductsBean();
				ipbs.setBookName(rs.getString(1));
				ipbs.setBookCost(rs.getString(2));
				ipbs.setBookAuthor(rs.getString(3));
				ipbs.setBookPublication(rs.getString(4));
				ipbs.setBookCategory(rs.getString(5));
				ipbs.setBookServiceProvider(rs.getString(6));
				ipbs.setDistance(rs.getString(7));
				ipbs.setBookDescription(rs.getString(8));
				ipbs.setVenue(rs.getString(9));
				ipbs.setBookID(rs.getInt(10));
				ipbs.setProdutsRating(rs.getString(11));
				
				Blob b = rs.getBlob(7);
				if (b != null) {
					byte b1[] = b.getBytes(1, (int) b.length());
					System.out.println(" path is " + path2);
					OutputStream fout = new FileOutputStream(path2 + "/"+ ipbs.getBookID() + ".png");
					fout.write(b1);
					ipbs.setBookPicture(ipbs.getBookID() + ".png");
					}
					tsb.add(ipbs);
			
		}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return tsb;
	}
    
    
    ///////////////////////////////////////////
    public Vector<InsertProductsBean> getSearchProducts(String search, String path2) {
		Vector<InsertProductsBean> tsb = new Vector<InsertProductsBean>();

		try {
			String s=search.toUpperCase();
			String Q="select * FROM PRODUCTS where UPPER(BNAME) LIKE '%"+s+"%' OR UPPER(BAUTHOR) LIKE '%"+s+"%' OR UPPER(BPUBLICATION) LIKE '%"+s+"%'";
			System.out.println(Q);
			PreparedStatement ps=con.prepareStatement(Q);
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {

				InsertProductsBean ipbs = new InsertProductsBean();
				ipbs.setBookName(rs.getString(1));
				ipbs.setBookCost(rs.getString(2));
				ipbs.setBookAuthor(rs.getString(3));
				ipbs.setBookPublication(rs.getString(4));
				ipbs.setBookCategory(rs.getString(5));
				ipbs.setBookServiceProvider(rs.getString(6));
				ipbs.setBookDescription(rs.getString(8));
				ipbs.setVenue(rs.getString(9));
				ipbs.setBookID(rs.getInt(10));
				Blob b = rs.getBlob(7);
				if (b != null) {
					byte b1[] = b.getBytes(1, (int) b.length());
					System.out.println(" path is " + path2);
					OutputStream fout = new FileOutputStream(path2 + "/"+ ipbs.getBookID() + ".png");
					fout.write(b1);
					ipbs.setBookPicture(ipbs.getBookID() + ".png");
					}
					tsb.add(ipbs);
			
		}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return tsb;
	}
	///////////////////////
    
    public InsertProductsBean getProductsByID(String path3, int id) {
    	InsertProductsBean ipbs=new InsertProductsBean();
		try {
			
			String Q="select * FROM PRODUCTS where BID="+id;
			System.out.println(Q);
			PreparedStatement ps=con.prepareStatement(Q);
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				
				ipbs.setBookName(rs.getString(1));
				ipbs.setBookCost(rs.getString(2));
				ipbs.setBookAuthor(rs.getString(3));
				ipbs.setBookPublication(rs.getString(4));
				ipbs.setBookCategory(rs.getString(5));
				ipbs.setBookServiceProvider(rs.getString(6));
				ipbs.setBookDescription(rs.getString(8));
				ipbs.setVenue(rs.getString(9));
				ipbs.setBookID(rs.getInt(10));
				Blob b = rs.getBlob(7);
				if (b != null) {
					byte b1[] = b.getBytes(1, (int) b.length());
					System.out.println(" path is " + path3);
					OutputStream fout = new FileOutputStream(path3 + "/"+ ipbs.getBookID() + ".png");
					fout.write(b1);
					ipbs.setBookPicture(ipbs.getBookID() + ".png");
					}
					
			
		}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return ipbs;
	}
	
    

}
