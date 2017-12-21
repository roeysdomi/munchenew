package Extra_functions;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Wifi.Wifi;


public class Sort {
	String fileloc;
	ArrayList<String> csv;
	ArrayList<Wifi> csv2;
	
	////----------sort function--------
	/**
	 *the class handle the sorting process.
	 *by sginal.
	 * @return 
	 * @throws FileNotFoundException
	 */

	public ArrayList<Wifi> SortSignal() throws FileNotFoundException
	{
        /**
         * take the array list of the wifi type and sort it by signal.
         */
		ArrayList<Wifi>test=new ArrayList<>(csv2);
        
      
	     for(int i=0;i<test.size();i++)
	     {
	    	 Wifi wifi1=test.get(i);
	    	 Double max=Double.valueOf(wifi1.getSignal());
	    	 for(int j=0;j<test.size();j++)
	    	 {   Wifi wifi2=test.get(j);
	    		 Wifi temp=test.get(i);
	    		 Double currect=Double.valueOf(wifi2.getSignal());
	    		 

	    		 if(currect<max){test.set(i,test.get(j));test.set(j,temp);max=currect;}
	    	   
	    		 
	    	 }
	    	
	    	 
	     }


	  return test;	
	}
	public ArrayList<Wifi> SortPie() throws FileNotFoundException
	{
        /**
         * take the array list of the wifi type and sort it by signal.
         */
		ArrayList<Wifi>test=new ArrayList<>(csv2);
        
      
	     for(int i=0;i<test.size();i++)
	     {
	    	 Wifi wifi1=test.get(i);
	    	 Double max=Double.valueOf(wifi1.getPie());
	    	 for(int j=0;j<test.size();j++)
	    	 {   Wifi wifi2=test.get(j);
	    		 Wifi temp=test.get(i);
	    		 Double currect=Double.valueOf(wifi2.getPie());
	    		 

	    		 if(currect<max){test.set(i,test.get(j));test.set(j,temp);max=currect;}
	    	   
	    		 
	    	 }
	    	
	    	 
	     }


	  return test;	
	}

//--------set and get---------
	public String getFileloc() {
		return fileloc;
	}



	public void setFileloc(String fileloc) {
		this.fileloc = fileloc;
	}



	public ArrayList<String> getCsv() {
		return csv;
	}



	public void setCsv(ArrayList<String> csv) {
		this.csv = csv;
	}
	public ArrayList<Wifi> getCsv2() {
		return csv2;
	}
	public void setCsv2(ArrayList<Wifi> csv2) {
		this.csv2 = csv2;
	}

	
}
