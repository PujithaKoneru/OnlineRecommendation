package com.dts.aoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;
import com.dts.dae.dto.RegistrationBean;

public class LogHistoryDAO extends DataObject{
    
    static Connection con;
    public DbInterface db;
   
    public LogHistoryDAO() 
    {
           con=getConnection();  
    }
    

    /////////////////////
    
    
    public Vector<RegistrationBean> getVenueRecommended() {
		Vector<RegistrationBean> logvenue = new Vector<RegistrationBean>();

		try {
			
			PreparedStatement ps=con.prepareStatement("select * FROM VENUERECOMMENDED");
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {

				RegistrationBean rbs = new RegistrationBean();
				
				rbs.setPname(rs.getString(1));
				rbs.setSprovider(rs.getString(2));
				rbs.setVenue(rs.getString(3));
				rbs.setDistance(rs.getString(4));
				rbs.setCountVenue(rs.getString(5));
				
				logvenue.add(rbs);
		}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return logvenue;
	}

    
    ///////////////////////
    
    public Vector<RegistrationBean> getLogHistory() {
		Vector<RegistrationBean> log = new Vector<RegistrationBean>();

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
				
				
				log.add(rbs);
			
		}
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return log;
	}

}
