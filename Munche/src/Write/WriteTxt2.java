package Write;

import Reads.Read;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import Algorithems.Start;
import Extra_functions.Sort;
import Reads.Read;
import Wifi.CompareWifi;
import Wifi.Wifi;

public class WriteTxt2 {
	String path=System.getProperty("user.dir")+"\\tempfiles\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	
	public ArrayList<Wifi> ListTest1;
	public ArrayList<Wifi> ListLiner;
	public ArrayList<Wifi> tempcount;
	public ArrayList<Wifi> Sort_tempcount;
	public ArrayList<Wifi> Fix_tempcount;
	
	/**
	 * @The class that incharge  all the procces
	 * of writing to Arraylist.
	 * It manipulate them from ,csv file until the orgnized csv file
	 * whice the the filter class work with..
	 */
	
	public WriteTxt2()
	{
		
	}
	public void createTest1List() throws IOException
	{  
		/** 
		 *  convert all the csv file to one
		 * csv file.
		 * after that he convert the csv file to
		 * Array list(Wifi element) which will used int the next function.
		 */
		
		File file3=new File(path+"test1.csv");
		file3.createNewFile();
		File folder = new File(csvpath);
		File[] listOfFiles = folder.listFiles();
	    FileWriter writer=new FileWriter(path+"test1.csv");
		for (File file : listOfFiles) {
			if (file.isFile())
			{
		        String g=file.getName();
		    
			
		    Scanner scanner = new Scanner(new File(csvpath+g));
		    scanner.useDelimiter(",");
	
		    while(scanner.hasNext()){
		    	String line=scanner.next();
		        writer.write(line+",");
		    }
		    
	
		    scanner.close();
		    }
	      
		} 
		writer.close();
	
		System.out.println("---STARTING PROCCESS-WAIT FOR THE LOADING BAR----");
        Read readtext1=new Read();
        readtext1.setCsvfilename("test1");
        readtext1.convertcsvtotxt();
        readtext1.setLoc(path+"test1.txt");
        
        //ListTest1=readtext1.converttocsv();
       ListLiner=readtext1.converttocsv();
	}
 	
 	public void Writewifi_liner(int i) throws IOException 
	{    
 		/**
 		 * The function that create the lines in the of the orgnized csv file.
 		 * the function get the choosen line(the one that you want to compare the rest) and compare it to the rest of the lines,once 
 		 * its find the same object its add to the list , sort them and clean the duplicate mac addres.
 		 * at the end he return fix_temp count list for the orgnized function .
 		 * (to write the line of the 10 networks).
 		 */
 		
 		
	  if(!ListLiner.get(i).getMac().equals("1"))
	  {  
		    tempcount=new ArrayList<Wifi>();
	 		Wifi dead=new Wifi();
	 		dead.Wifikill("1");
			///---------csv------
		    Start a1=new Start();
		    
		    //////------big file-----
		    tempcount.add(ListLiner.get(i));
			int size=ListLiner.size();
			 /////--------------- 
			
			for(int z=i;z<size;z++)
				 
			{  if(!ListLiner.get(z).getMac().equals("1")&&i!=z)
			   {	
				
					
					
				 CompareWifi com=new CompareWifi(ListLiner);
                    				 
				      
				 
				 if(a1.choose==1) 
	             {if(com.IDComperator(i, z)) {tempcount.add(ListLiner.get(z));ListLiner.set(z,dead );}};
	             if(a1.choose==3) 
	             {if(com.TimeComperator(i, z)) {tempcount.add(ListLiner.get(z));ListLiner.set(z,dead );}};
	             if(a1.choose==4) 
	             {if(com.LocComperator(i, z)) {tempcount.add(ListLiner.get(z));ListLiner.set(z,dead );}};
	             if(a1.choose==6) 
	             {if(com.MacComperator(i, z)) {tempcount.add(ListLiner.get(z));ListLiner.set(z,dead );}};
	             if(a1.choose==5) 
	             {if(com.AllComperator(i, z)) {tempcount.add(ListLiner.get(z));ListLiner.set(z,dead );}};
	             
			           
			           
			             
			       
				 
			   }
				
			}
			
			
			
			////--------	 
			 
			 
			 ////-----------------
	
		     Sort sort=new Sort();
		     sort.setCsv2(tempcount);
		     Sort_tempcount=new ArrayList<Wifi>();
		     Fix_tempcount=new ArrayList<Wifi>();
			 Sort_tempcount=sort.SortSignal();
		     ///------------------
			// Fix_tempcount=new ArrayList<Wifi>(Sort_tempcount);
		     /////--------------------
		     //if(a1.choose==6)
		    Writefixmac();
		   
	  }    
	    
}
 	public void Writefixmac() throws IOException
	{  
 		/**
 		 * clean the duplicate mac .
 		 * leave only the most strongest mac address.
 		 * all of them of course unique
 		 */
	
		////--------------------
		ArrayList<Wifi>temp=new ArrayList<>(Sort_tempcount);
		Fix_tempcount=new ArrayList<>();
		Wifi dead=new Wifi();
		dead.Wifikill("1");
		////------------------
		for(int t=0;t<temp.size();t++)
		 { 
			if(!temp.get(t).getMac().equals("1"))
			{
				  Wifi wifi1=temp.get(t);
				   
				   Fix_tempcount.add(temp.get(t));
					for(int y=0;y<temp.size();y++)
				  {  if(!temp.get(y).equals("1"))
					    {
					        Wifi wifi2=temp.get(y);
					        if( wifi1.Comperator(wifi1.getMac(), wifi2.getMac())&&t!=y)
					        {  temp.set(y,dead); }
					    }
				  }
			  
			}
		 } 
	 ////---------------------
		 
		 
		 
		 
		
	}
 	public void WriteOrgnized() throws IOException
	{  
		/**
		 * call the liner function inorder to create the lines of the 
		 * orgnized csv file.
		 * each time the liner function return new arraylist .
		 *     
		 */
	
	    //--------------יצירת מסמך 
	    File file2 = new File(path+"orgnized.csv");
	    file2.createNewFile();
	    FileWriter writer = new FileWriter(file2); 
	    //----------------------------------
	   // Writes the content to the file
	     
	     
	     
	     int x=ListLiner.size();

	  ///--------------------------------------
	     
	     writer.write("WigleWifi-1.4,appRelease=2.25,model=ONEPLUS A3003,release=7.1.1,device=OnePlus3T,display=ONEPLUS A3003_28_171012,board=QC_Reference_Phone,brand=OnePlus");
	     writer.write(System.lineSeparator());
	     writer.write("WIFI#,");
	     for(int k=1;k<11;k++)
	     {writer.write("MAC-"+k+",SSID-"+k+",FirstSeen-"+k+",RSSI-"+k+",CurrentLatitude-"+k+",CurrentLongitude-"+k+",AltitudeMeters-"+k+",") ;  };
	     writer.write(System.lineSeparator());
         ///-------חישוב אחוזים------
	     double all=x*0.01;
	     int all2=(int)all;
	     int count1=0;
	     int counter=0;
	      for(int i=0;i<x;i++)
	      { 
	    	  count1++;
	    	  if(count1==all2+1)
	    	  {
	          System.out.println("        ||procces:("+counter+"%)||");
	          counter++;
	          count1=0;
	          }
	    	  
	    	//----יוצרמסמך זמני של ה האיי הראשון
	       if(!ListLiner.get(i).getMac().equals("1"))
	        {
	    	   Writewifi_liner(i);
	            ////--------------
		       
		    	int z=Fix_tempcount.size();
	
		    	writer.write(z+",");
		    	/////---------
		    	
		    	
		    	
			     ArrayList<Wifi> csv2=new ArrayList<>(Fix_tempcount);
			     ///-----------
					for(int count=0;count<z;count++)
		    	{   if(count<=10)
		    		{ Wifi w=csv2.get(count);
		    		  
		    		writer.write(w.getMac()+","+w.getId()+","+w.getTime()+","+w.getSignal()+","+w.getLat()+","+w.getLot()+","+w.getHight()+",");
		    		}
		    	}
					writer.write(System.lineSeparator());
		    	
		    	
		      }  
	      }
	       ///////////////////////////////////////////////////////
			    writer.close();
			    int rest=100-counter;
			    for( int r=0;r<=rest;r++)
			    {
			    	System.out.println("        ||procces:("+counter+++"%)||");
			    }
			   
	      } 

	

 
}
