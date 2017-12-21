package Reads;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Wifi.Wifi;


public class Read {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	String loc;
	String csvfilename;
	
	/////-----read and convert function---
	
	public ArrayList<Wifi> converttocsv() throws FileNotFoundException
	{
		/**
		 * read text file and convert it to wifi array list.
		 */
		
	int z=0;
	String g;

	File file = new File(loc);

	ArrayList<Wifi> csv1 = new  ArrayList<Wifi>();


		Scanner sc = new Scanner(file);
	   
	    while (sc.hasNextLine()) {
	         g = sc.nextLine();
	        if(!(g.contains("SSID")||g.contains("WigleWifi")||g==null))
	        {
	          if(!(g.equals(",")))
	          {
	              Wifi wifi1=new Wifi(g);
	           csv1.add(z++, wifi1);
	        
	          }
	        }
	    }
	  
	   

		return csv1;

	}
	public ArrayList<String> converttocsv2() throws FileNotFoundException
	{
	  /**
	   * convert csv to array list of String type.
	   * this function is used in writekml class.
	   */

		
	int z=0;
	String g;

	File file = new File(loc);

	ArrayList<String> csv1 = new  ArrayList<String>();


		Scanner sc = new Scanner(file);
	   
	    while (sc.hasNextLine()) {
	         g = sc.nextLine();
	        if(!(g.contains("SSID")||g.contains("WigleWifi")||g==null))
	        {
	          if(!(g.equals(",")))
	          {
	              
	           csv1.add(z++, g);
	        
	          }
	        }
	    }
	  
	   

		return csv1;

	}
	public void convertcsvtotxt() throws IOException
	{ 
		
		/**
		 * take csv file and convert it to txt file.
		 */
		
		File file1=new File(path+"\\tempfiles\\"+csvfilename+".txt");
		file1.createNewFile();
		FileWriter writer= new FileWriter(file1);
	    Scanner scanner = new Scanner(new File(path+"\\tempfiles\\"+csvfilename+".csv"));
	    scanner.useDelimiter(",");

	    while(scanner.hasNext()){
	    	String line=scanner.next();
	    	
	        writer.write(line+",");
	    }
	    writer.close();
	    scanner.close();
	}
	public void convertcsvtotxtnew() throws IOException
	{ 
		
		/**
		 * take csv file and convert it to txt file.
		 */
		
		File file1=new File(path+csvfilename+".txt");
		file1.createNewFile();
		FileWriter writer= new FileWriter(file1);
	    Scanner scanner = new Scanner(new File(path+csvfilename+".csv"));
	    scanner.useDelimiter(",");

	    while(scanner.hasNext()){
	    	String line=scanner.next();
	    	
	        writer.write(line+",");
	        writer.write(System.lineSeparator());
	    }
	    writer.close();
	    scanner.close();
	}
    public ArrayList<Wifi> ReadeCombCsv() throws IOException
    {
    	BufferedReader reader = new BufferedReader(new FileReader(	path+csvfilename+".csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		int linecounter=1;
		 ArrayList<Wifi>combcsv=new ArrayList<Wifi>();
        int counter=0;
		while ((line = reader.readLine()) != null&&!line.equals("")&&!line.contains("SSID")) 
		{
		    Wifi wifi1=new Wifi();
			String []g=line.split(",");
			int amount=Integer.valueOf(g[5]);
			if(amount!=1)
			{
				
				wifi1.setMac(g[7]);
				wifi1.setSignal(g[9]);
				wifi1.setId(g[6]);
				wifi1.setLat(g[2]);
				wifi1.setLot(g[3]);
				wifi1.sethight(g[4]);
				wifi1.setLine(linecounter);
				combcsv.add(counter++,wifi1);
				
				int z=0;
				for(int i=0;i<amount-1;i++)
				{   Wifi wifi2=new Wifi();
					wifi2.setMac(g[11+z]);
					wifi2.setSignal(g[13+z]);
					wifi2.setId(g[10]+z);
					wifi2.setLat(g[2]);
					wifi2.setLot(g[3]);
					wifi2.sethight(g[4]);
					wifi2.setLine(linecounter);
					combcsv.add(counter++,wifi2);
					
					z=z+4;
					
				}
				
				z=0;
				
				
				
			}
			
			if(amount==1)
			{
				wifi1.setMac(g[7]);
				wifi1.setSignal(g[9]);
				wifi1.setId(g[6]);
				wifi1.setLat(g[2]);
				wifi1.setLot(g[3]);
				wifi1.sethight(g[4]);
				wifi1.setLine(linecounter);
				combcsv.add(counter++,wifi1);
			}
			
			linecounter++;
		}
		
	
		
		reader.close();
		return combcsv;
		
	}
    public ArrayList<Wifi> ReadeNoGPSCsv() throws IOException
    {
    	BufferedReader reader = new BufferedReader(new FileReader(	path+csvfilename+".csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		int countline=1;
		 ArrayList<Wifi>combcsv=new ArrayList<Wifi>();
        int counter=0;
		while ((line = reader.readLine()) != null&&!line.equals("")&&!line.contains("SSID")) 
		{
		    Wifi wifi1=new Wifi();
			String []g=line.split(",");
			int amount=Integer.valueOf(g[5]);
			if(amount!=1)
			{
				
				wifi1.setMac(g[7]);
				wifi1.setSignal(g[9]);
				wifi1.setId(g[6]);
				wifi1.setLine(countline);
				combcsv.add(counter++,wifi1);
				
				int z=0;
				for(int i=0;i<amount-1;i++)
				{   Wifi wifi2=new Wifi();
					wifi2.setMac(g[11+z]);
					wifi2.setSignal(g[13+z]);
					wifi2.setId(g[10]+z);
					wifi2.setLine(countline);
					combcsv.add(counter++,wifi2);
					
					z=z+4;
					
				}
				
				z=0;
				
				
				
			}
			
			if(amount==1)
			{
				wifi1.setMac(g[7]);
				wifi1.setSignal(g[9]);
				wifi1.setId(g[6]);
				wifi1.setLine(countline);
				combcsv.add(counter++,wifi1);
			}
			
			countline++;
		}
		
	
		
		reader.close();
		return combcsv;
		
	}

    public int[] ReadTocompare() throws IOException
    {  int [] loc=new int [3];
    	BufferedReader reader = new BufferedReader(new FileReader(	path+csvfilename+".csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		int countline=0;
		 ArrayList<Wifi>combcsv=new ArrayList<Wifi>();
        int counter=0;
        double lat=0;
		double lot=0;
		double hight=0;
		while ((line = reader.readLine()) != null&&!line.equals("")&&!line.contains("SSID")) 
		{     countline++;
		    Wifi wifi1=new Wifi();
			String []g=line.split(",");
			 lat=lat+Double.valueOf(g[0]);
			 lot=lot+Double.valueOf(g[1]);
			 hight=hight+Double.valueOf(g[2]);
			
		}
		
	    System.out.println(countline);
		System.out.println(lat+","+lot+","+hight);
		lat=lat/countline;
		lot=lot/countline;
		hight=hight/countline;
		System.out.println(lat+","+lot+","+hight);
		reader.close();
		return loc;
		
	}

	
	
	////-----get and set-----
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getCsvfilename() {
		return csvfilename;
	}
	public void setCsvfilename(String csvfilename) {
		this.csvfilename = csvfilename;
	} 

}
