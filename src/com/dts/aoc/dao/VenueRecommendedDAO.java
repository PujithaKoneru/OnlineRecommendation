package com.dts.aoc.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.dts.aoc.dto.InsertProductsBean;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;
import com.dts.dae.dto.RegistrationBean;

public class VenueRecommendedDAO  extends DataObject{
    
    static Connection con;
    public DbInterface db;
    private boolean flag;
    public VenueRecommendedDAO() 
    {
           con=getConnection();  
    }
   
  
   ////////////////
    public Vector<RegistrationBean> getVenueRecommended() {
		Vector<RegistrationBean> logvenue = new Vector<RegistrationBean>();

		try {
			
			PreparedStatement ps=con.prepareStatement("select * FROM USERPROFILEDATA");
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {

				RegistrationBean rbs = new RegistrationBean();   
				rbs.setUserName(rs.getString(1));
				rbs.setPname(rs.getString(2));
				rbs.setSprovider(rs.getString(3));
				rbs.setVenue(rs.getString(4));
				rbs.setDistance(rs.getString(5));				
				logvenue.add(rbs);			
		}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return logvenue;
	}

    ////////////
    
    
    public boolean insertProducts(InsertProductsBean ip)
    {
    	 	String bname=ip.getBookName();
    	 	String bcost=ip.getBookCost();
    	 	String bauthor=ip.getBookAuthor();
    	 	String bpublication=ip.getBookPublication();
    	 	String bcategory=ip.getBookCategory();
        
        try 
        {
           con.setAutoCommit(false);
           PreparedStatement pst=null;
           int i=0;
          pst=con.prepareStatement("insert into PRODUCTS values(?,?,?,?,?,?,?,?,?,(select nvl(max(BID),500)+1 from PRODUCTS))");                        
           pst.setString(1,bname);
           pst.setString(2,bcost);
           pst.setString(3,bauthor);
           pst.setString(4,bpublication);
           pst.setString(5,bcategory);			
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
