package SQL;

/**
 * This is a very simple example presenting how to work with MySQL using jave JDBC interface
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import GUI.GUI2;
import Wifi.Wifi;

import java.sql.Statement;

public class MySQL {
	/**
	 * class that handle all the functions that  read from the data base.
	 */
      public static GUI2 ron;
	  public static String _ip = "";
	  public static String _port = "";

	  public static String _url = "";
	  public static String _user = "";
	  public static String _password = "";
	  private static Connection _con = null;
    
	  
 public MySQL()
 {
	 
 }
 public MySQL(GUI2 obj)
 {
	 ron=obj;
	 
 }
     public static ArrayList<Wifi>  AddData(ArrayList<Wifi> enterlist) {
    	
    	/**
    	 * read from the data base and add to the currect list
    	 */
        Statement st = null;
        ResultSet rs = null;
   	    ArrayList<Wifi>combcsv=new ArrayList<Wifi>();


        try {     
            _con = DriverManager.getConnection(_url, _user, _password);
            st = _con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
           
            PreparedStatement pst = _con.prepareStatement("SELECT * FROM ex4_db");
            rs = pst.executeQuery();
            int linecounter=1;
       	    int counter=0;
            while (rs.next())
            {
            	
                 
         		
         		    Wifi wifi1=new Wifi();
         			int amount=Integer.valueOf(rs.getInt(7));
         			if(amount!=1)
         			{
         			    wifi1.setMac(rs.getString(8));
         				wifi1.setSignal(String.valueOf(rs.getInt(9)));
         				wifi1.setLat(String.valueOf(rs.getDouble(4)));
         				wifi1.setLot(String.valueOf(rs.getDouble(5)));
         				wifi1.sethight(String.valueOf(rs.getDouble(6)));
         				wifi1.setDeviceid(rs.getString(3));
         				wifi1.setTime(rs.getString(2));
         				wifi1.setLine(linecounter);
         				combcsv.add(counter++,wifi1);
         				
         				int z=0;
         				for(int i=0;i<amount-1;i++)
         				{  
         					Wifi wifi2=new Wifi();
         					 wifi2.setMac(rs.getString(10+z));
              				wifi2.setSignal(String.valueOf(rs.getInt(11+z)));
         				
         					wifi2.setLat(String.valueOf(rs.getDouble(4)));
             				wifi2.setLot(String.valueOf(rs.getDouble(5)));
             				wifi2.sethight(String.valueOf(rs.getDouble(6)));
             				wifi2.setDeviceid(rs.getString(3));
             				wifi2.setTime(rs.getString(2));
             				
         					wifi2.setLine(linecounter);
         					combcsv.add(counter++,wifi2);
         					
         					z=z+2;
         					
         				}
         				
         				z=0;
         				
         				
         				
         			}
         			
         			if(amount==1)
         			{
         				wifi1.setMac(rs.getString(8));
         				wifi1.setSignal(String.valueOf(rs.getInt(9)));
         				wifi1.setLat(String.valueOf(rs.getDouble(4)));
         				wifi1.setLot(String.valueOf(rs.getDouble(5)));
         				wifi1.sethight(String.valueOf(rs.getDouble(6)));
         				wifi1.setDeviceid(rs.getString(3));
         				wifi1.setTime(rs.getString(2));
         				wifi1.setLine(linecounter);
         				combcsv.add(counter++,wifi1);
         			}
         			
         			linecounter++;
         		
         		
         	
               
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
        
        
        for(int i=0;i<combcsv.size();i++)
        {
        	enterlist.add(combcsv.get(i));
        }
       
        
        return enterlist;
    }
    
    
	
}