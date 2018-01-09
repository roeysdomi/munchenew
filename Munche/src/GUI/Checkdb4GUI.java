package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import SQL.MySQL;
import Wifi.Wifi;

public  class Checkdb4GUI implements Runnable  {
   
    public static GUI2 ron;
   
	  private static Connection _con = null;
  
    String path=System.getProperty("user.dir")+"\\";
    /**
		 * the thread function that run in the background and check change in the files
		 */
   
    public Checkdb4GUI(GUI2 obj)
	
	{
    	ron=obj;
    	
    	
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		checkfiles();
		
	}
	
	
	
	
	
	public boolean checkfiles()
	{  
		
		String b=readlastdate();
		ron.textArea.append(" \n  last update of the data base :" +b+" \n started thread for check changing in the data base \n ");
		boolean a=false;
		while(!a&&ron.loaddb==1)
		{
			
           String c=readlastdate();
           if(!c.equals(b)) {ron.resetandload();ron.textArea.append(" \n  last update of the data base :" +c+" \n ");b=c;JOptionPane.showMessageDialog(null, "DETECT FILE CHANGE");}
			
		}
		return a;
	}
    public static String readlastdate()
    {
    	/**
		 * check last date
		 */
   
    	String date="";
    	Statement st = null;
        ResultSet rs = null;
        
    	 try {     
    		 String ip=ron.db_ip.getText();
    		 String user=ron.db_user.getText();
    		 String passw=ron.db_passw.getText();
    		 String port=ron.db_port.getText();

    		 String url="jdbc:mysql://"+ip+":"+port+"/oop_course_ariel";
             _con = DriverManager.getConnection(url,user,passw);
             st = _con.createStatement();
             rs = st.executeQuery("SELECT VERSION()");
             if (rs.next()) {
                 System.out.println(rs.getString(1));
             }
            
             PreparedStatement pst = _con.prepareStatement("SELECT  table_name,  update_time FROM information_schema.tables where table_name='ex4_db'");
             rs = pst.executeQuery();
             int linecounter=1;
        	    int counter=0;
        	    
             while (rs.next())
             {
             	date=rs.getString(2);
          		
                
             }
             
         } catch (SQLException ex) {
         	ron.textArea.append("\n ERROR CHECK INPUT OF DATABASE \n");
             Logger lgr = Logger.getLogger(MySQL.class.getName());
             lgr.log(Level.SEVERE, ex.getMessage(), ex);
         } finally {
             try {
                 if (rs != null) {rs.close();}
                 if (st != null) { st.close(); }
                 if (_con != null) { _con.close();  }
             } catch (SQLException ex) {
             	ron.textArea.append("\n ERROR CHECK INPUT OF DATABASE \n");

                 Logger lgr = Logger.getLogger(MySQL.class.getName());
                 lgr.log(Level.WARNING, ex.getMessage(), ex);
             }
         }
    	 return date;
         
    }
	
}
