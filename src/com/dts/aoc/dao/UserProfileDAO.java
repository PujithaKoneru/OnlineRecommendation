package com.dts.aoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import com.dts.core.util.DateWrapper;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;
public class UserProfileDAO extends DataObject{
    
    static Connection con;
    public DbInterface db;
    private boolean flag;
    private int count;
    public UserProfileDAO() 
    {
           con=getConnection();  
    }
   
    public boolean userProfileData(String uname,String pname,String sprovider,String venue)
    {
    	         
        try 
        {
           con.setAutoCommit(false);
           PreparedStatement pst=null;
           PreparedStatement pst1=null;
           int i=0;
      	 String newdate=DateWrapper.parseDate(new Date());
           
          pst=con.prepareStatement("insert into USERPROFILEDATA values(?,?,?,?,?)");                        
           pst.setString(1,uname);
           pst.setString(2,pname);
           pst.setString(3,sprovider);
           pst.setString(4,venue);
           pst.setString(5, newdate);
 		
           i=pst.executeUpdate();
        
            if(i==1)
            {
                flag=true;
                con.commit();
                
        			Statement st=con.createStatement();
        			String q="select count(VENUE) FROM USERPROFILEDATA where pname='"+pname+"' and VENUE='"+venue+"'";
        			System.out.println("*******************"+q);
        			
        			ResultSet rs=st.executeQuery(q);
        			
        			while (rs.next()) {
        				count=rs.getInt(1);
        		}
        			System.out.println(count);
        			 if(count>1){
        			
        				 updateVENUERECOMMENDED(pname,venue, count);
        			 }
        			 else{
        			
        				 insertVENUERECOMMENDED(uname,pname,sprovider, venue,newdate);
        				   
        				 
        			 }
        		
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
    
    public boolean insertVENUERECOMMENDED(String uname,String pname,String sprovider,String venue,String distance)
    {
    	         
        try 
        {
           con.setAutoCommit(false);
           PreparedStatement pst1=null;
           int i=0;
       	String c="1";
         pst1=con.prepareStatement("insert into VENUERECOMMENDED values(?,?,?,?,?)");                        
           
           pst1.setString(1,pname);
           pst1.setString(2,sprovider);
           pst1.setString(3,venue);
           pst1.setString(4,distance);
           pst1.setString(5,c);
           i=pst1.executeUpdate();
           if(i==1){
        	   con.commit();
           }
           System.out.println("i in insert venue recomended   "+i);
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
    ///////////////////////////
    public boolean updateVENUERECOMMENDED(String pname,String venue,int count)
    {
    	         
        try 
        {
           con.setAutoCommit(false);
           Statement st=con.createStatement();
      	 	String q1="Update VENUERECOMMENDED set COUNT='"+count+"'  where PNAME='"+pname+"' and VENUE='"+venue+"'";
			System.out.println(count+"*******************qqq1111*****"+q1);
			int i=0;
			i=st.executeUpdate(q1);	
           if(i==1){
        	   con.commit();
           }
           System.out.println("i in update venue recomended   "+i);
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
   