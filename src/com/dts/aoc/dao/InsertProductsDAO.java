package com.dts.aoc.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.dts.aoc.dto.InsertProductsBean;
import com.dts.core.db.DbInterface;
import com.dts.core.util.DataObject;


public class InsertProductsDAO extends DataObject{
    
    static Connection con;
    public DbInterface db;
    private boolean flag;
    private int count;
    
    public InsertProductsDAO() 
    {
           con=getConnection();  
    }
   
  //////////////////
    public int checkVenue(String pname,String venue) {
    	try 
        {	
	Statement st=con.createStatement();
	String q="select count(VENU) FROM PRODUCTS where BNAME='"+pname+"' and VENU='"+venue+"'";
	System.out.println("*******************"+q);
	
	ResultSet rs=st.executeQuery(q);

	while (rs.next()) {
		count=rs.getInt(1);
		System.out.print(count);
	}
        }catch (SQLException ex) 
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
	return count;
    }
    
    //////////////
    
    public Vector<InsertProductsBean> getProducts(String path1) {
		Vector<InsertProductsBean> tsb = new Vector<InsertProductsBean>();

		try {
			
			PreparedStatement ps=con.prepareStatement("select * FROM PRODUCTS");
			
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
				ipbs.setBookID(rs.getInt(10));
				ipbs.setVenue(rs.getString(9));
				System.out.println("================>"+ipbs.getBookName());
				Blob b = rs.getBlob(7);
				if (b != null) {
					byte b1[] = b.getBytes(1, (int) b.length());
					System.out.println(" path is " + path1);
					OutputStream fout = new FileOutputStream(path1 + "/"+ ipbs.getBookID() + ".png");
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
	
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean insertProducts(InsertProductsBean ip)
    {
    	 	String bname=ip.getBookName();
    	 	String bcost=ip.getBookCost();
    	 	String bauthor=ip.getBookAuthor();
    	 	String bpublication=ip.getBookPublication();
    	 	String bcategory=ip.getBookCategory();
    	 	String sprovider=ip.getBookServiceProvider();    	 	 	
    	 	String desc=ip.getBookDescription(); 
    	 	String venue=ip.getVenue();
    	 	
      //,(select nvl(max(productid),500)+1 from PRODUCTS)
        
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
           pst.setString(6,sprovider); 
           String photo = ip.getBookPicture();
		   System.out.println("uploaded photo is=" + photo);
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("lenth of image file is===" + f.length());
			pst.setBinaryStream(7, fis, (int) f.length());           
			pst.setString(8, desc);	
			pst.setString(9, venue);	
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
