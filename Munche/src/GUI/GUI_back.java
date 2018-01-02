package GUI;
import java.io.IOException;
import java.util.ArrayList;

import Reads.Read;
import Wifi.Wifi;

public class GUI_back {
	
	public String type;
	public  String  lat1;
	public  String lot1;
	public  String  lat2;
	public  String lot2;
	public  String id;
	public  String hours1;
	public  String hours2;
	public  String minutes1;
	public  String minutes2;
	
	
	
	
	public static void main (String []args) throws IOException
	{
		
		Read re=new Read();
	    re.setCsvfilename("orgnized");
	    ArrayList<Wifi>  temp=new ArrayList<>(re.ReadOrgnized());
	    String roey = "";
	    int counter=0;
	    for(int i=0;i<temp.size();i++)
	    {
	    	String currect=temp.get(i).getMac();
	    	if(!roey.contains(currect))
	    	{
	    		roey=roey+currect;
	    		counter++;
	    	}
	    }
	    System.out.println(counter+" temp size:"+temp.size());
	}

}
