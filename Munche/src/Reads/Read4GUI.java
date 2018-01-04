package Reads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Extra_functions.History;
import Wifi.Wifi;

public class Read4GUI  extends Read {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	String loc;
	String csvfilename;
	
	/////-----read and convert function---
	
	public ArrayList<Wifi> Readwigles(ArrayList<Wifi> listenter,String g) throws IOException
	{
		
		File folder = new File(path+"\\"+g);
		File[] listOfFiles = folder.listFiles();
		ArrayList<Wifi> listout=new ArrayList<>();
		int counter=1;
			for (File file : listOfFiles)
			{
			
				if (file.isFile()&&file.getName().contains("csv"))
				{
			         String name=file.getName();
		
			             String line;
			             String deviceid1="";
			        	  BufferedReader reader = new BufferedReader(new FileReader(path+"\\"+g+"\\"+name));
			        	  while((line = reader.readLine()) != null)
			              {    
			        		    if(line.contains("WigleWifi") ) 
			        		    {String []split=line.split(",");deviceid1=split[4];deviceid1=deviceid1.replaceAll("device=", "");  }
			      				
			        		    if (!line.equals("")&&!line.contains("SSID")&&!line.contains("WigleWifi-1.4")) 
			      				{
			                        Wifi wifi1=new Wifi(line);
			                        wifi1.deviceid=deviceid1;
			                        wifi1.setLine(counter++);
			                        listout.add(wifi1);
			                        
			      				}
			              }
			    }
		      
			}
			
		    for(int i=0;i<listout.size();i++)
		    {
		    	listenter.add(listout.get(i));
		    }
	
		    return listenter;
	
		
	
	}
	public ArrayList<Wifi> Read_1_wigles(ArrayList<Wifi> listenter ,String folder,String filename) throws IOException
	{
		
		
		ArrayList<Wifi> listout=new ArrayList<>();
		
			
			
				
			       
		
			             String line;
			             String deviceid1="";
			        	  BufferedReader reader = new BufferedReader(new FileReader(path+"\\"+folder+"\\"+filename));
			        	  while((line = reader.readLine()) != null)
			              {    
			        		    if(line.contains("WigleWifi") ) 
			        		    {String []split=line.split(",");deviceid1=split[4];deviceid1=deviceid1.replaceAll("device=", "");  }
			      				
			        		    if (!line.equals("")&&!line.contains("SSID")&&!line.contains("WigleWifi-1.4")) 
			      				{
			                        Wifi wifi1=new Wifi(line);
			                        wifi1.deviceid=deviceid1;
			                        listout.add(wifi1);
			                        
			      				}
			              }
			    for(int i=0;i<listout.size();i++)
			    {
			    	listenter.add(listout.get(i));
			    }
		
			return listenter;
	
		
	
	}
	public ArrayList<Wifi> ReadeCombCsv(ArrayList<Wifi> listenter ,String folder,String filename) throws IOException
    {
    	BufferedReader reader = new BufferedReader(new FileReader(	path+"\\"+folder+"\\"+filename));

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
			    wifi1.channel=g[8];	
				wifi1.setMac(g[7]);
				wifi1.setSignal(g[9]);
				wifi1.setId(g[6]);
				wifi1.setLat(g[2]);
				wifi1.setLot(g[3]);
				wifi1.sethight(g[4]);
				wifi1.setDeviceid(g[1]);
				wifi1.setTime(g[0]);
				wifi1.setLine(linecounter);
				combcsv.add(counter++,wifi1);
				
				int z=0;
				for(int i=0;i<amount-1;i++)
				{   Wifi wifi2=new Wifi();
					wifi2.setMac(g[11+z]);
					wifi2.channel=g[12+z];
					wifi2.setSignal(g[13+z]);
					wifi2.setId(g[10]+z);
					wifi2.setLat(g[2]);
					wifi2.setLot(g[3]);
					wifi2.sethight(g[4]);
					wifi2.setDeviceid(g[1]);
					wifi2.setTime(g[0]);
					wifi2.setLine(linecounter);
					combcsv.add(counter++,wifi2);
					
					z=z+4;
					
				}
				
				z=0;
				
				
				
			}
			
			if(amount==1)
			{
				 wifi1.channel=g[8];	
				wifi1.setMac(g[7]);
				wifi1.setSignal(g[9]);
				wifi1.setId(g[6]);
				wifi1.setLat(g[2]);
				wifi1.setLot(g[3]);
				wifi1.sethight(g[4]);
				wifi1.setDeviceid(g[1]);
				wifi1.setTime(g[0]);
				wifi1.setLine(linecounter);
				combcsv.add(counter++,wifi1);
			}
			
			linecounter++;
		}
		
	
		
		reader.close();
		
		   for(int i=0;i<combcsv.size();i++)
		    {
		    	listenter.add(combcsv.get(i));
		    }
	
		return listenter;

		
	}
	 public ArrayList<Wifi> ReadeNoGPSCsv(String line) throws IOException
	    {
	    	
			int countline=1;
			 ArrayList<Wifi>combcsv=new ArrayList<Wifi>();
	        int counter=0;
			if ((line != null&&!line.equals("")&&!line.contains("SSID")) )
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
			
		
			
			return combcsv;
			
		}
	public History Readsavedfilter(History sample) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(path+"\\OUTPUT\\SAVEDFILTER.csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		int linecounter=1;
		 ArrayList<Wifi>combcsv=new ArrayList<Wifi>();
        int counter=0;
		while ((line = reader.readLine()) != null)
		{
			String []split=line.split(",");
			
			sample.type=split[0];
			sample.id=split[1];
			sample.hours1=split[2];
			sample.minutes1=split[3];
			sample.hours2=split[4];
			sample.minutes2=split[5];
			sample.lat1=split[6];
			sample.lot1=split[7];
			sample.hight1=split[8];
			sample.lat2=split[9];
			sample.lot2=split[10];
			sample.hight2=split[11];
			


		}
		reader.close();
		return sample;
	}
	/////------------new Read functions---------
	
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



