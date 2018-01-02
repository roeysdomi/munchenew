package Extra_functions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Reads.Read;
import Wifi.Wifi;


public class Count {
	
String loc;
ArrayList<String> csv;



/**
 * this class count rows in txt file and csv file.
 * @return
 * @throws FileNotFoundException
 */

public int countrows() throws FileNotFoundException
{
	/**
	 * count rows in txt file
	 */
 int z=0;
 File file1=new File(loc);
 Scanner sc =new Scanner(file1);
 ///---------------------
 while(sc.hasNextLine())
 {z++;sc.nextLine();}
 return z;
}
public int countrowsCSV() throws FileNotFoundException
{
	/**
	 * count rows in csv file
	 */
 int z=0;
 ArrayList<String> temp=csv;
 ///---------------------
 z=temp.size();
 System.out.println(z);
 return z;
}

public int countmacs(ArrayList<Wifi> sample)
{
	
    ArrayList<Wifi>  temp=new ArrayList<>(sample);
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
   return counter;
}

//------------get and set-------------

public String getLoc() {
	return loc;
}
public void setLoc(String loc) {
	this.loc = loc;
}
public ArrayList<String> getCsv() {
	return csv;
}
public void setCsv(ArrayList<String> csv) {
	this.csv = csv;
}

}
