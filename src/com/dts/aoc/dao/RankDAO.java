package com.dts.aoc.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.dts.aoc.dto.InsertProductsBean;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;
import com.dts.dae.dto.RegistrationBean;

public class RankDAO extends DataObject{
    
    static Connection con;
    public DbInterface db;
    private boolean flag;
    public RankDAO() 
    {
           con=getConnection();  
    }
    
    
    public boolean checkUserUsingProduct(String pname,String user){
    	boolean f=false;
    	try 
        {    	
    	PreparedStatement ps=con.prepareStatement("SELECT * from USERPROFILEDATA where UNAME=? and PNAME=?");
    	ps.setString(1, user);
    	ps.setString(2, pname);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			f=true;
		}		
        }catch (Exception e) {
			System.out.println(e);
		}       
    	return f;
    }
    /*this method used to check product with rank present or not present  
    1:-if product is present with parameter rank then no need to update or insert product info in table
    2:-may be parameter rank  is not matched but product is present because parameter new calculated
    3:- so we need to check product only(when rank and product is not present) 
    4:- so if we get result as a):- product is present b):- product is not present
    		a):-then update rank
    		b):- insert product and rank both
    **/
    public boolean checkProductWithRank(String pname,float rank){
    	boolean f=false;
    	try 
        {    	
    	PreparedStatement ps=con.prepareStatement("SELECT * from PRANK where PRODUCT=? and RANK=?");
    	ps.setString(1, pname);
    	ps.setFloat(2, rank);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			f=true;
		}
		if(f==false){
			
			boolean f1=checkProduct(pname);
			
			if(f1==false){
				//call method to insert product with rank
				insertProductWithRank(pname, rank);
			}
			if(f1==true){
				// method to update product with rank
				updateProductRank(pname, rank);
			}
		}
        }catch (Exception e) {
			System.out.println(e);
		}       
    	return f;
    }
    
    // product checking step 3
    public boolean checkProduct(String pname){
    	boolean f=false;
    	try 
        {    	
    	PreparedStatement ps=con.prepareStatement("SELECT * from PRANK where PRODUCT=?");
    	ps.setString(1, pname);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			f=true;
		}
        }catch (Exception e) {
			System.out.println(e);
		}       
    	return f;
    }
    ///// method to update product with rank step (a)
    public boolean updateProductRank(String pname,float rank)
    {
    	try 
        {
           con.setAutoCommit(false);
           int i;
           String q="Update PRANK set RANK="+rank+" where  PRODUCT='"+pname+"'";
           System.out.println(q);           
           i=con.createStatement().executeUpdate(q);
          
            if(i==1)
            {
                flag=true;
                con.commit();
            }
            else
            {
                flag=false;
                con.rollback();
            }      
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
                sex.printStackTrace();
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException se) 
            {
                se.printStackTrace();
            }
        }
        return flag;
    }
    //// method to insert product with rank step (b)
    public boolean insertProductWithRank(String pname,float rank){
    	
    	        try 
    	        {
    	        	flag=false;
    	           con.setAutoCommit(false);
    	           PreparedStatement pst=null;
    	           int i=0;
    	          pst=con.prepareStatement("insert into PRANK values(?,?)");                        
    	           pst.setString(1,pname);
    	           pst.setFloat(2,rank);
    		
    	           i=pst.executeUpdate();
    	        
    	            if(i==1)
    	            {
    	                flag=true;
    	                con.commit();
    	            }
    	            else
    	            {
    	                flag=false;
    	                con.rollback();
    	            }      
    	        } 
    	        catch (SQLException ex) 
    	        {
    	            ex.printStackTrace();
    	            flag=false;
    	            try 
    	            {
    	                con.rollback();
    	            } 
    	            catch (SQLException sex) 
    	            {
    	                sex.printStackTrace();
    	            }
    	        }
    	        catch (Exception e) 
    	        {
    	            e.printStackTrace();
    	            flag=false;
    	            try 
    	            {
    	                con.rollback();
    	            } 
    	            catch (SQLException se) 
    	            {
    	                se.printStackTrace();
    	            }
    	        }
    	        return flag;
    }
}
