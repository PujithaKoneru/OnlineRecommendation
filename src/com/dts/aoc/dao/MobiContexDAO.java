package com.dts.aoc.dao;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

import com.dts.aoc.dto.ClassBean;
import com.dts.aoc.dto.InsertProductsBean;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;

public class MobiContexDAO extends DataObject{
    
    static Connection con;
    public DbInterface db;
    private boolean flag;
    public MobiContexDAO() 
    {
           con=getConnection();  
    }
    
    public HashMap getMinimumDistanceServiceProviderPlace(String uplace) {
    	System.out.println("in DAO>"+uplace);
    	HashMap mhm1=new HashMap();
    	try 
        {
    		int i=0;
    	PreparedStatement ps=con.prepareStatement("SELECT * from DISTANCETABLE where UPPER(PLACE1) LIKE'%"+uplace+"%' ORDER BY DISTANCE");
    
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			i=i+1;			
			ClassBean mdcb1=new ClassBean();
			mdcb1.setPlace1(rs.getString(1));
			mdcb1.setPlace2(rs.getString(2));
			mdcb1.setDistance(rs.getInt(3));
			mhm1.put(i,mdcb1);
			System.out.print(rs.getString(1));System.out.print("   ===    ");System.out.println(rs.getString(2));
		}		
        }catch (Exception e) {
			System.out.println(e);
		}
    	return mhm1;
    }
    //
    public InsertProductsBean getMinimumDistanceServiceProviderProductInformation(String splace,String psearch,String path111) {
    	InsertProductsBean mdipb=new InsertProductsBean();
    	try 
        {
    	PreparedStatement ps=con.prepareStatement("SELECT * from PRODUCTS t1 INNER JOIN VENUERECOMMENDED t2 ON t2.PNAME=t1.BNAME where UPPER(t1.VENU) like '%"+splace+"%' AND UPPER(t1.BNAME) LIKE '%"+psearch+"%' AND UPPER(t2.PNAME) LIKE '%"+psearch+"%'");
    	//PreparedStatement ps=con.prepareStatement("SELECT * from PRODUCTS where VENU=? AND UPPER(BNAME) LIKE '%"+psearch+"%'");
    	//ps.setString(1, splace);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			mdipb=new InsertProductsBean();
			mdipb.setBookName(rs.getString(1));
			mdipb.setBookCost(rs.getString(2));
			mdipb.setBookAuthor(rs.getString(3));
			mdipb.setBookPublication(rs.getString(4));
			mdipb.setBookCategory(rs.getString(5));
			mdipb.setBookServiceProvider(rs.getString(6));
			mdipb.setBookDescription(rs.getString(8));
			mdipb.setVenue(rs.getString(9));
			mdipb.setBookID(rs.getInt(10));
			Blob b = rs.getBlob(7);
			if (b != null) {
				byte b1[] = b.getBytes(1, (int) b.length());
				OutputStream fout = new FileOutputStream(path111 + "/"+ mdipb.getBookID() + ".png");
				fout.write(b1);
				mdipb.setBookPicture(mdipb.getBookID() + ".png");
				}
			
		}	
	
        }catch (Exception e) {
			System.out.println(e);
		}
        
    	return mdipb;
    }
    
    public HashMap getTopProd(String pname) {
    	HashMap mhm1=new HashMap();
    	try 
        {
    		int i=0;
    	PreparedStatement ps=con.prepareStatement("SELECT * from PRANK where RANK>=.5 AND UPPER(PRODUCT) LIKE '%"+pname+"%' ORDER BY RANK DESC");
    	ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			i=i+1;			
			ClassBean mdcb1=new ClassBean();
			mdcb1.setTopRankProductName(rs.getString(1));
			mdcb1.setProductRank(rs.getFloat(2));
			mhm1.put(i,mdcb1);
		}		
        }catch (Exception e) {
			System.out.println(e);
		}
    	return mhm1;
    }
    
    //
    public InsertProductsBean getTopProductInfo(String psearch,String topproductpath) {
    	InsertProductsBean mdipb=new InsertProductsBean();
    	try 
        {
    		int i=0;
    		System.out.print("p---->"+psearch);
    	PreparedStatement ps=con.prepareStatement("SELECT * from PRODUCTS where  BNAME LIKE '%"+psearch+"%'");
    	ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			mdipb=new InsertProductsBean();
			mdipb.setBookName(rs.getString(1));
			mdipb.setBookCost(rs.getString(2));
			mdipb.setBookAuthor(rs.getString(3));
			mdipb.setBookPublication(rs.getString(4));
			mdipb.setBookCategory(rs.getString(5));
			mdipb.setBookServiceProvider(rs.getString(6));
			mdipb.setBookDescription(rs.getString(8));
			mdipb.setVenue(rs.getString(9));
			mdipb.setBookID(rs.getInt(10));
			Blob b = rs.getBlob(7);
			if (b != null) {
				byte b1[] = b.getBytes(1, (int) b.length());
				OutputStream fout = new FileOutputStream(topproductpath + "/"+ mdipb.getBookID() + ".png");
				fout.write(b1);
				mdipb.setBookPicture(mdipb.getBookID() + ".png");
				}
			System.out.println("c-->"+rs.getString(1));
		}	
		System.out.println("===========");
        }catch (Exception e) {
			System.out.println(e);
		}
        
    	return mdipb;
    }
    
    
    ///////////////////////
    /*
    public InsertProductsBean getVenuRecommendedProductInformation(String splace,String psearch,String path111) {
    	InsertProductsBean mdipb=new InsertProductsBean();
    	try 
        {
    	PreparedStatement ps=con.prepareStatement("SELECT * from PRODUCTS t1 INNER JOIN VENUERECOMMENDED t2 ON t2.PNAME=t1.BNAME where UPPER(t1.VENU) like '%"+splace+"%' AND UPPER(t1.BNAME) LIKE '%"+psearch+"%' AND UPPER(t2.PNAME) LIKE '%"+psearch+"%'");
    	//PreparedStatement ps=con.prepareStatement("SELECT * from PRODUCTS where VENU=? AND UPPER(BNAME) LIKE '%"+psearch+"%'");
    	//ps.setString(1, splace);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			mdipb=new InsertProductsBean();
			mdipb.setBookName(rs.getString(1));
			mdipb.setBookCost(rs.getString(2));
			mdipb.setBookAuthor(rs.getString(3));
			mdipb.setBookPublication(rs.getString(4));
			mdipb.setBookCategory(rs.getString(5));
			mdipb.setBookServiceProvider(rs.getString(6));
			mdipb.setBookDescription(rs.getString(8));
			mdipb.setVenue(rs.getString(9));
			mdipb.setBookID(rs.getInt(10));
			Blob b = rs.getBlob(7);
			if (b != null) {
				byte b1[] = b.getBytes(1, (int) b.length());
				OutputStream fout = new FileOutputStream(path111 + "/"+ mdipb.getBookID() + ".png");
				fout.write(b1);
				mdipb.setBookPicture(mdipb.getBookID() + ".png");
				}
			
		}	
	
        }catch (Exception e) {
			System.out.println(e);
		}
        
    	return mdipb;
    }
*/
}
