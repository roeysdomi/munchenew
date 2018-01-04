package Write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import Algorithems.Calculate1;
import Algorithems.Calculate2;
import Algorithems.Start;
import Extra_functions.History;
import Extra_functions.Sort;
import Wifi.Calc1parms;
import Wifi.CompareWifi;
import Wifi.Wifi;

public class Write4GUI {
	
	
	
	/**
		 * class that more adapt to the matala 3 requests
		 * inlcude algo2 writing algo1 .
		 */
	String regpath=System.getProperty("user.dir")+"\\";
	String path=System.getProperty("user.dir")+"\\tempfiles\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	
	public ArrayList<Wifi> ListTest1;
	public ArrayList<Wifi> ListLiner;
	public ArrayList<Wifi> tempcount;
	public ArrayList<Wifi> Sort_tempcount;
	public ArrayList<Calc1parms> result_mac;
	public ArrayList<Wifi> Fix_tempcount;
	public static String resultalgo1;
	//----------algo2--------
	public ArrayList<Wifi> targetlist;
	public ArrayList<Wifi> traininglist;
	public ArrayList<Wifi> temp_targetlist;
	public ArrayList<Wifi> temp_traininglist;
	public ArrayList<Wifi> temp_pielist;
	public String resultalgo2_line;
	//----------------------------
	
 	public Write4GUI()
	{
		
	}
 	public Write4GUI(ArrayList<Wifi> list) throws IOException
	{
		ListLiner=new ArrayList<>(list);
		
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
                    				 
				      
				 
			
	             {if(com.LocComperator(i, z)) {tempcount.add(ListLiner.get(z));ListLiner.set(z,dead );}};
	            
			           
			           
			             
			       
				 
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
			 //Fix_tempcount=new ArrayList<Wifi>(Sort_tempcount);
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
					for(int y=t;y<temp.size();y++)
				  {  
						if(!temp.get(y).equals("1"))
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
	    File file2 = new File(System.getProperty("user.dir")+"\\OUTPUT\\SAVED46COL.csv");
	    file2.createNewFile();
	    FileWriter writer = new FileWriter(file2); 
	    //----------------------------------
	   // Writes the content to the file
	     
         
	   
	     
	     int x=ListLiner.size();

	  ///--------------------------------------
	     
	     writer.write("WigleWifi-1.4,appRelease=2.25,model=ONEPLUS A3003,release=7.1.1,device=OnePlus3T,display=ONEPLUS A3003_28_171012,board=QC_Reference_Phone,brand=OnePlus");
	     writer.write(System.lineSeparator());
	     writer.write("TIME,DEVICEID,LAT,LOT,HIGHT,WIFI#,");
	     for(int k=1;k<11;k++)
	     {writer.write("SSID-"+k+",MAC-"+k+",Frequncy-"+k+",SIGNAL-"+k+",") ;  };
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
	    		  
	           
	    	  }
	          counter++;
	          count1=0;
	          
	    	  
	    	//----יוצרמסמך זמני של ה האיי הראשון
	       if(!ListLiner.get(i).getMac().equals("1"))
	        {
	    	   Writewifi_liner(i);
	            ////--------------
		       
		    	int z=Fix_tempcount.size();
	
		    
		    	/////---------
		    	
		    	
		    	
			     ArrayList<Wifi> csv2=new ArrayList<>(Fix_tempcount);
			     ///-----------
					for(int count=0;count<z;count++)
		    	{   if(count<10)
		    		{ Wifi w=csv2.get(count);
		    		  if(count==0) {writer.write(w.getTime()+","+w.getDeviceid()+","+w.getLat()+","+w.getLot()+","+w.getHight()+","+z+","+w.getId()+","+w.getMac()+","+w.channel+","+w.getSignal()+",");}
		    		  else
		    		  writer.write(w.getId()+","+w.getMac()+","+w.channel+","+w.getSignal()+",");
		    		}
		    	}
					writer.write(System.lineSeparator());
		    	
		    	
		      }  
	      }
	       ///////////////////////////////////////////////////////
			    writer.close();
			   
	      } 
    public void Savefilter(History sample) throws IOException
    {
    	File file=new File(regpath+"\\OUTPUT\\SAVEDFILTER.csv");
    	FileWriter writer=new FileWriter(file);
    	writer.write(sample.type+","+sample.id+","+sample.hours1+","+sample.minutes1+","+sample.hours2+","+sample.minutes2+","+sample.lat1+","+sample.lot1+","+sample.hight1+","+sample.lat2+","+sample.lot2+","+sample.hight2+",");
        writer.close();  
    }
	
///----------------algo1----------------------------
     public void Writewifi_liner2(String mac) throws IOException 
	{    
 		/**
 		 * The function that create the lines in the of the macBycalc1 csv file.
 		 * the function get the choosen line(the one that you want to compare the rest) and compare it to the rest of the lines,once 
 		 * its find the same object its add to the list , sort them and clean the duplicate mac addres.
 		 * at the end he return fix_temp count list for the orgnized function .
 		 * (to write the line of the 10 networks).
 		 */
 		
 		
	   
		    tempcount=new ArrayList<Wifi>();
	 		
	 		
			///---------csv------
		    Start a1=new Start();
		    
		    //////------big file-----
		    
			int size=ListLiner.size();
			if(size==0){return;}
			 /////--------------- 
			
			for(int z=0;z<size;z++)
				 
			{  
                    				 
				
	            
	           if(ListLiner.get(z).getMac().equals(mac))
	           {
	        	   tempcount.add(ListLiner.get(z));
	           }
	             
	            
	             
			           
			           
			             
			       
				
			}
			
			
			
			////--------	 
			 
			 
			 ////-----------------
	
		     Sort sort=new Sort();
		     sort.setCsv2(tempcount);
		     Sort_tempcount=new ArrayList<Wifi>();
		     Fix_tempcount=new ArrayList<Wifi>();
			 Sort_tempcount=sort.SortSignal();
		     Calculate1 calc1=new Calculate1(Sort_tempcount);
		     calc1.runCalculate1();
		     this.result_mac=new ArrayList<>(calc1.result);
		   
	   
	    
}
 	
 	public void WriteMacalgo(ArrayList<Wifi> enterlist,String mac) throws IOException
	{  
		/**
		 * call the liner function inorder to create the lines of the 
		 * Macbycalc1 csv file.
		 * each time the liner function return new arraylist .
		 *     
		 */
	
	    //--------------יצירת מסמך 
	   
	    //----------------------------------
	   // Writes the content to the file
	     
	     
	     
	     int x=enterlist.size();
	     ListLiner=new ArrayList<>(enterlist);
         
	  ///--------------------------------------
	     
	    
	    
	   
         ///-------חישוב אחוזים------
	    
	      
	    	//----יוצרמסמך זמני של ה האיי הראשון
	       
	    	   Writewifi_liner2(mac);
	            ////--------------
		       
		    	
		    	/////---------
		    	
		    	
		    	
			    
			     ///-----------
				if(result_mac.size()==0) {return;}
		    		//writer.write(result_mac.get(0).getId()+","+result_mac.get(0).getMac()+","+result_mac.get(0).getLat()+","+result_mac.get(0).getLot()+","+result_mac.get(0).getHight());
		    	   resultalgo1= result_mac.get(0).getLat()+" , "+result_mac.get(0).getLot()+" , "+result_mac.get(0).getHight();
					//writer.write(System.lineSeparator());
		    	
		    	
		      
	     
	       ///////////////////////////////////////////////////////
	        
			   
	      } 
////------------algo2 function----------
 	public void WriteLiner() throws IOException
 	{   int writecounter=0;
 		File file2 = new File(path+"ALGO2_result.csv");
 	    file2.createNewFile();
 	    FileWriter writer = new FileWriter(file2); 
 		double weight=1;
 		double pi;
 		int targetlastline=targetlist.get(targetlist.size()-1).getLine();
 		int traininglastline=traininglist.get(traininglist.size()-1).getLine();
 		for(int i=0;i< targetlastline;i++)
 		{   
 			
 			this.temp_pielist=new ArrayList<>();
 			create_temp_target(i+1);			
 			
 					
 				
 				for(int z=0;z<traininglastline;z++)
 				{    
 					create_temp_training(z+1);
 				    
 				      double pie=createpie();
 				      
 				      setpie(pie);
 				      Wifi wifi1=new Wifi();
 				      wifi1=temp_traininglist.get(0);
 				      temp_pielist.add(wifi1);
 				    
 				    
 				     
 				       
 				}
 				
 				Sort so=new Sort();
 				so.setCsv2(temp_pielist);
 				temp_pielist=so.SortPie();
 				 Calculate1 calc=new Calculate1(temp_pielist);
 			      calc.setAlgo2(1);
 			      calc.runCalculate1();
 			     writecounter++;
 			      writer.write(calc.result.get(0).getLat()+","+calc.result.get(0).getLot()+","+calc.result.get(0).getHight()+","+temp_targetlist.size()+",");
 			      resultalgo2_line=calc.result.get(0).getLat()+","+calc.result.get(0).getLot()+","+calc.result.get(0).getHight()+",";
 			      for(int f=0;f<temp_targetlist.size();f++)
 			      {
 			      writer.write(temp_targetlist.get(f).getId()+","+temp_targetlist.get(f).getMac()+","+temp_targetlist.get(f).getSignal()+",");
 			      }
 			      writer.write(System.lineSeparator());
 			
 				
 				
 			
 			
 		}
 		writer.close();
 		
 		
 		
 		
 		
 		
 	}
 	public double createpie()
 		{ 
            /**
             * create the pie list		
             */
 		 double pie=1;
 			 for(int j=0;j<temp_targetlist.size();j++)
 		      {
 			       int arraymac[]=checkline(j);
 			       Calculate2 createweight =new Calculate2();
 			       for(int f=0;f<arraymac.length;f++)
 			       {
 			    	   double newweight=createweight.Calculate2(temp_targetlist.get(j),temp_traininglist.get(arraymac[f]));
 			    	   pie=pie*newweight;
 			       }
 			       if(arraymac.length==0)
 			       {   Wifi sig120=new Wifi();
 			           sig120.setSignal("-120");
 			    	   double newweight=createweight.Calculate2(temp_targetlist.get(j),sig120);
 		    	      pie=pie*newweight;
 		    	      
 		    	   }
 		      }
 			
 			 return pie;
 		}
 	public void create_temp_target(int z)
 	{   
 		/**
 		 * create temp list for target
 		 */
 		this.temp_targetlist=new ArrayList<>();
 	    
 		for(int i=0;i<targetlist.size();i++)
 		{
 			
 			if(targetlist.get(i).getLine()==z)
 			{    Wifi wifi1=new Wifi ();
 			     wifi1=targetlist.get(i);
 				this.temp_targetlist.add(wifi1);
 				
 			}
 			if(targetlist.get(i).getLine()>z)
 			{  i=targetlist.size();}
 		}
 	}
 	public void create_temp_training(int z)
 	{   
 		/**
 		 * create temp list for training
 		 */
 		this.temp_traininglist=new ArrayList<>();
 		for(int i=0;i<traininglist.size();i++)
 		{
 			
 			if(traininglist.get(i).getLine()==z)
 			{     Wifi wifi1=new Wifi ();
 		         wifi1=traininglist.get(i);
 				this.temp_traininglist.add(wifi1);
 				
 			}
 			if(traininglist.get(i).getLine()>z)
 			{  i=traininglist.size();}
 		}
 	}
 	public void setpie(double pie)
 	{
 		/**
 		 * cset pie
 		 */
 		for(int i=0;i<temp_traininglist.size();i++)
 		{  
 			temp_traininglist.get(i).setPie(pie);
 		}
 		
 	}
 	public int [] checkline(int z)
 	{ 
 		/**
 		 * check which line u r
 		 */
 		int a[]=new int[0]; 
 	   
 	   int countermacs=0;
 	   int counter=0;
 	    String mac1=temp_targetlist.get(z).getMac();
 		for (int i=0;i<temp_traininglist.size();i++)
 		{
 			if(mac1.equals(temp_traininglist.get(i).getMac()))
 			{countermacs++;}
 		}
 		a=new int[countermacs]; 
 		for (int i=0;i<temp_traininglist.size();i++)
 		{
 			if(mac1.equals(temp_traininglist.get(i).getMac()))
 			{a[counter++]=i;}
 		}
 	  return a;
 	}
	

 
	

   }
