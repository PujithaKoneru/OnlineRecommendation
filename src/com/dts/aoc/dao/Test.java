package com.dts.aoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;
import com.dts.dae.dto.RegistrationBean;

public class Test extends DataObject{
    
    static Connection con;
    public DbInterface db;
    private boolean flag;
    public Test() 
    {
           con=getConnection();  
    }
    
    ///////////////////////////////////
    public int getItemsByUser(String v1){
    	int matchitems=0;
    	try 
        {
    	PreparedStatement ps=con.prepareStatement("Select Count(PNAME) from USERPROFILEDATA where UNAME ='"+v1+"'");		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			matchitems=rs.getInt(1);
			System.out.println(rs.getInt(1));
		}
		}catch (Exception e) {
			System.out.println(e);
		}
    	return matchitems;
    }
    
    
    ///////////////////////////////////
    

    public int getSimilarity(String v1,String v2){
    	HashMap hm3=new HashMap();
    	try 
        {
    		int i=0;  
    		System.out.println("Select PNAME from USERPROFILEDATA where UNAME = '"+v1+"'  INTERSECT SELECT PNAME from USERPROFILEDATA where UNAME = '"+v2+"'");
    	PreparedStatement ps=con.prepareStatement("Select PNAME from USERPROFILEDATA where UNAME = '"+v1+"'  INTERSECT SELECT PNAME from USERPROFILEDATA where UNAME = '"+v2+"'");		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			i=i+1;
			hm3.put(i,rs.getString(1));
		
		}
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(hm3.size());
    	return hm3.size();
    }
    
    
    
    ///////////////////////////////////
    
    public HashMap getUser(){
    	
    	HashMap hm1=new HashMap();
    	try 
        {
    		int i=0;
    	PreparedStatement ps=con.prepareStatement("SELECT  UNAME from REGISTRATION INTERSECT SELECT UNAME from USERPROFILEDATA");		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			i=i+1;
			hm1.put(i,rs.getString(1));
		}
		
		System.out.println((String)hm1.get(i-1));
		flag=true;
        }catch (Exception e) {
			System.out.println(e);
		}
        
        int i=1;
        String ii=Integer.toString(i);
        System.out.println(ii);
        i=Integer.parseInt(ii);
        i=i+1;
        System.out.println(i);
        
        
        
        
    	return hm1;
    }
    

}
