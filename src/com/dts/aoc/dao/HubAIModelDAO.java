package com.dts.aoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;

public class HubAIModelDAO extends DataObject{
    
    static Connection con;
    public DbInterface db;
    private boolean flag;
    public HubAIModelDAO() 
    {
           con=getConnection();  
    }

    
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
    
    
    
    
    public HashMap getSimilarity(String v1,String v2){
    	HashMap hm3=new HashMap();
    	try 
        {
    	int i=0;  
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
    	return hm3;
    }
    
    
    
    
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
        }catch (Exception e) {
			System.out.println(e);
		}       
    	return hm1;
    }
    /////////
    public HashMap getProd(){
    	
    	HashMap hm1=new HashMap();
    	try 
        {
    		int i=0;
    	PreparedStatement ps=con.prepareStatement("SELECT PNAME from USERPROFILEDATA INTERSECT SELECT PNAME from USERPROFILEDATA");		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			i=i+1;
			hm1.put(i,rs.getString(1));
		}		
        }catch (Exception e) {
			System.out.println(e);
		}       
    	return hm1;
    }
    
    
    
}
