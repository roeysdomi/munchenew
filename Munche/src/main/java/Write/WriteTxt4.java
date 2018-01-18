package Write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Algorithems.Calculate1;
import Algorithems.Calculate2;
import Extra_functions.Sort;
import Reads.Read;
import Wifi.Wifi;

public class WriteTxt4 {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	public ArrayList<Wifi> targetlist;
	public ArrayList<Wifi> traininglist;
	public ArrayList<Wifi> temp_targetlist;
	public ArrayList<Wifi> temp_traininglist;
	public ArrayList<Wifi> temp_pielist;
	
	/**
	 * NOT IN USE ANY MORE THAT WHY NOT DOCUMENTED
	 * @throws IOException
	 */
	
public WriteTxt4() throws IOException
{    
	Read re =new Read();
	File folder = new File(System.getProperty("user.dir")+"\\INPUT\\target\\");
	File[] listOfFiles = folder.listFiles();
	String g="";
	for (File file : listOfFiles) {
		if (file.isFile())
		{
	         g=file.getName();
		}
	}
       g=g.replaceAll(".csv", "");
       File folder2 = new File(System.getProperty("user.dir")+"\\INPUT\\nogps\\");
   	File[] listOfFiles2 = folder2.listFiles();
   	String d="";
   	for (File file : listOfFiles2) {
   		if (file.isFile())
   		{
   	         d=file.getName();
   		}
   	}
          d=d.replaceAll(".csv", "");
          Read re2 =new Read();
     re.setCsvfilename("\\INPUT\\target\\"+g);
     re2.setCsvfilename("\\INPUT\\nogps\\"+d);
	targetlist=new ArrayList<>(re2.ReadeNoGPSCsv());
     traininglist=new ArrayList<>(re.ReadeCombCsv());
    this.temp_targetlist=new ArrayList<>();
 	 this.temp_traininglist=new ArrayList<>();
	
}
public void WriteLiner() throws IOException
{   int writecounter=0;
	File file2 = new File(path+"\\tempfiles\\"+"ALGO2_result.csv");
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
		      for(int f=0;f<temp_targetlist.size();f++)
		      {
		      writer.write(temp_targetlist.get(f).getId()+","+temp_targetlist.get(f).getMac()+","+temp_targetlist.get(f).getSignal()+",");
		      }
		      writer.write(System.lineSeparator());
		
			
			
		
		
	}
	writer.close();
	
	
	
	
	
	
}
public double createpie()
	{    double pie=1;
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
{     this.temp_targetlist=new ArrayList<>();
    
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
{     this.temp_traininglist=new ArrayList<>();
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
	for(int i=0;i<temp_traininglist.size();i++)
	{  
		temp_traininglist.get(i).setPie(pie);
	}
	
}
public int [] checkline(int z)
{ int a[]=new int[0]; 
   
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



public static void main (String[]args) throws IOException
{
	WriteTxt4 run=new WriteTxt4();
	/* Wifi wifi1=new Wifi();
     wifi1.setSignal("-50");
     wifi1.setMac("mac1");
     
     Wifi wifi2=new Wifi();
     wifi2.setSignal("-70");
     wifi2.setMac("mac2");

     Wifi wifi3=new Wifi();
     wifi3.setSignal("-90");
     wifi3.setMac("mac3");
     
     Wifi wifi4=new Wifi();
     wifi4.setSignal("-82");
     wifi4.setMac("mac1");
     
     Wifi wifi5=new Wifi();
     wifi5.setSignal("-120");
     wifi5.setMac("mac2");
     
     Wifi wifi6=new Wifi();
     wifi6.setSignal("-82");
     wifi6.setMac("mac3");
     temp_targetlist=new ArrayList<>();
     temp_traininglist=new ArrayList<>();
	run.temp_targetlist.add(wifi1);
	run.temp_targetlist.add(wifi2);
	run.temp_targetlist.add(wifi3);
	run.temp_traininglist.add(wifi4);
	run.temp_traininglist.add(wifi5);
	run.temp_traininglist.add(wifi6);*/
	run.WriteLiner();



}
}
