package com.dts.dae.dao;


import com.dts.dae.dto.RegistrationBean;
import com.dts.core.util.DataObject;
import com.dts.core.util.LoggerManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SecurityDAO extends DataObject
{
     private Connection con;
     private boolean flag;
    public SecurityDAO() 
    {       
               con=getConnection();
    }
    
    public String loginCheck(RegistrationBean regbean)
    {
        String loginid=regbean.getUserID();
        String password=regbean.getPassword();
        String role="";        
        try
        {
            con.setAutoCommit(true);
            PreparedStatement pst=con.prepareStatement("select UTYPE from REGISTRATION where USERID=? and PASS=?");
            pst.setString(1,loginid);
            pst.setString(2,password);
            
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                role=rs.getString(1);
            
            }
            else
            {
                flag=false;
               
            }
        }
        catch (SQLException ex) 
        {
        	LoggerManager.writeLogSevere(ex);
            
            flag=false;
        }
       
        return role;
    }
    
    public String userName(RegistrationBean regbean)
    {
        String loginid=regbean.getUserID();
        String password=regbean.getPassword();
        String name="";        
        try
        {
            con.setAutoCommit(true);
            PreparedStatement pst=con.prepareStatement("select UNAME from REGISTRATION where USERID=? and PASS=?");
            pst.setString(1,loginid);
            pst.setString(2,password);
            
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                name=rs.getString(1);
            
            }
            else
            {
                flag=false;
               
            }
        }
        catch (SQLException ex) 
        {
        	LoggerManager.writeLogSevere(ex);
            
            flag=false;
        }
       
        return name;
    }
    
    
    
    
}
