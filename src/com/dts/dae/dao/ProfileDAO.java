/*
 * ProfileDAO.java
 *
 * 
 * 
 */

package com.dts.dae.dao;

import com.dts.dae.dto.RegistrationBean;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;




public class ProfileDAO extends DataObject{
    
    static Connection con;
    public DbInterface db;
    private boolean flag;
    public ProfileDAO() 
    {
           con=getConnection();  
    }
   
    public boolean registration(RegistrationBean reb)
    {
    	 	 String uid=reb.getUserID();
    		 String pass=reb.getPassword();
    		 String uname=reb.getUserName();
    		 String email=reb.getUserEmail();
    		 String mob=reb.getUserMobile();
    		 String dob=reb.getUserDOB();
    		 String gender=reb.getUserGender();
    		 String utype=reb.getUserType();
    		 String uaddress=reb.getUserAddress();
    		 
      
        
        try 
        {
           con.setAutoCommit(false);
           PreparedStatement pst=null;
           int i=0;
          pst=con.prepareStatement("insert into REGISTRATION values(?,?,?,?,?,?,?,?,?)");                        
           pst.setString(1,uid);
           pst.setString(2,pass);
           pst.setString(3,uname);
           pst.setString(4,email);
           pst.setString(5,mob);
           pst.setString(6,dob);
           pst.setString(7,gender);
           pst.setString(8,utype);
           pst.setString(9,uaddress);    
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
    /////////////////////////////////////
    
    public boolean changePassword(RegistrationBean reb)
    {
    	 	 String uid=reb.getUserID();
    		 String pass=reb.getPassword();
    		 String oldpass=reb.getOldPassword();
    		 
      
        
        try 
        {
           con.setAutoCommit(false);

           int i;
           String q="Update REGISTRATION set pass='"+pass+"' where userid='"+uid+"' and pass='"+oldpass+"'";
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
   
    }
