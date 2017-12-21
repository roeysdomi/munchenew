package Filter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Wifi.Wifi;


public class Filter {
	
	String path=System.getProperty("user.dir")+"\\tempfiles\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	public ArrayList<Wifi> Filter_list_temp;
	public  String  lat1;
	public  String lot1;
	public  String  lat2;
	public  String lot2;
	public  String id;
	public  String hours1;
	public  String hours2;
	public  String minutes1;
	public  String minutes2;
    
	
	
	
   ///-------filter function----------
	
	
	public void filterID() throws IOException
	{   Filterfunc a1=new Filterfunc();
		///---------write to---------
		File file2=new File(path+"filterd.csv");
		file2.createNewFile();
		FileWriter writer=new FileWriter(file2);
		///-----convert orgnized-----
		a1.convertcsvtotxt("\\tempfiles\\orgnized");
		//----------readfrom-------------
		File file1=new File(path+"orgnized.txt");
		Scanner sc=new Scanner(file1);
		while(sc.hasNextLine())
		{   String g=sc.nextLine();
 
		if(g.contains(id)&&(!g.contains("WigleWifi"))&&(!g.contains("CurrentLatitude"))&&!g.equals(","))
			{   
				String[] words=g.split(",");
				int rows=Integer.valueOf(words[0]);
				if(rows>=10){rows=70;}
				if(rows<10){rows=rows*7;}
				int counter=0;
				for(int i=0;i<rows;i++)
				{
					writer.write(words[i+1]+",");counter++;
					
					if(counter==7){writer.write(System.lineSeparator());counter=0;}				
					
				}
			}
		}
		sc.close();
		writer.close();
	}	
    public void filterTime() throws IOException
	{   Filterfunc a1=new Filterfunc();
		///---------write to---------

		File file2=new File(path+"filterd.csv");
		file2.createNewFile();
		FileWriter writer=new FileWriter(file2);
		///-----convert orgnized-----
		a1.convertcsvtotxt("orgnized");
		//----------readfrom-------------
		File file1=new File(path+"orgnized.txt");
		Scanner sc=new Scanner(file1);
		while(sc.hasNextLine())
		{   String g=sc.nextLine();
             
			if((!g.contains("WigleWifi"))&&(!g.contains("CurrentLatitude"))&&!g.equals(","))
			{     Wifi wifi1=new Wifi();
			      wifi1.Wifiorgenized(g);
				if(checkTime(wifi1.getTime()))
			      {
						String[] words=g.split(",");
						int rows=Integer.valueOf(words[0]);
						int counter=0;
						if(rows>=10){rows=70;}
						if(rows<10){rows=rows*7;}
						for(int i=0;i<rows;i++)
						{
							
							writer.write(words[i+1]+",");counter++;
							if(counter==7){writer.write(System.lineSeparator());counter=0;}				
							
						}
			      }
		
			}
		}
		sc.close();
		writer.close();
	}
    public boolean checklocation(String lot3,String lat3)
{
  boolean a=true;
  ////------הגדרת משתנים
  double xlat1=Double.valueOf(lat1);
  double xlot1=Double.valueOf(lot1);
  double xlat2=Double.valueOf(lat2);
  double xlot2=Double.valueOf(lot2);
  double xlat3=Double.valueOf(lat3);
  double xlot3=Double.valueOf(lot3);
  /////--------------בדיקה
  if((xlat1<=xlat3&&xlat3<=xlat2)||(xlat2<=xlat3&&xlat3<=xlat1)){a=true;}
  else
  {return false;};
  if((xlot1<=xlot3&&xlot3<=xlot2)||(xlot2<=xlot3&&xlot3<=xlot1)){a=true;}
  else
  {return false;};

 return a;
}
    public boolean checkTime(String time)
    { boolean a=false;
       String[] firstsplit=time.split(" ");
       String []secondsplit=firstsplit[1].split(":");
       int hours3=Integer.valueOf(secondsplit[0]);
       int minutes3=Integer.valueOf(secondsplit[1]);


      ////------הגדרת משתנים
      int Hours1=Integer.valueOf(hours1);
      int Minutes1=Integer.valueOf(minutes1);
      int Hours2=Integer.valueOf(hours2);
      int Minutes2=Integer.valueOf(minutes2);
      int Hours3=Integer.valueOf(hours3);
      int Minutes3=Integer.valueOf(minutes3);
      /////--------------בדיקה
      if(Hours1<=hours3&&hours3<=Hours2||Hours2<=hours3&&hours3<=Hours1)
      {
    	  if(Minutes1<=minutes3&&minutes3<=Minutes2||Minutes2<=minutes3&&minutes3<Minutes1)
    	  {  return true;  }
      }
      if(Hours1==hours3&&hours3==Hours2)
      {
    	  if(Minutes1<=minutes3&&minutes3<Minutes2||Minutes2<=minutes3&&minutes3<Minutes1)
    	  {  return true;  }
      }
      
      
	return a;
    
    
    }
    public void filterLocation() throws IOException
	{   Filterfunc a1=new Filterfunc();
		///---------write to---------
       

		File file2=new File(path+"filterd.csv");
		file2.createNewFile();
		FileWriter writer=new FileWriter(file2);
		///-----convert orgnized-----
		a1.convertcsvtotxt("orgnized");
		//----------readfrom-------------
		File file1=new File(path+"orgnized.txt");
		Scanner sc=new Scanner(file1);
		while(sc.hasNextLine())
		{   String g=sc.nextLine();

			
			  if((!g.contains("WigleWifi"))&&(!g.contains("CurrentLatitude"))&&!g.equals(","))
				{String[] words=g.split(",");
				if(checklocation(words[6], words[5]))
				////////----העתקה-------
				{
				int rows=Integer.valueOf(words[0]);
				int counter=0;
				if(rows>=10){rows=70;}
				if(rows<10){rows=rows*7;}
				for(int i=0;i<rows;i++)
				{
					
					writer.write(words[i+1]+",");counter++;
					if(counter==7){writer.write(System.lineSeparator());counter=0;}				
					
				}
				}
				}
		}
		sc.close();
		writer.close();
	}
////-------get and set-------------
	
	
	public String getLat1() {
		return lat1;
	}
	public void setLat1(String lat1) {
		this.lat1 = lat1;
	}
	public String getLot1() {
		return lot1;
	}
	public void setLot1(String lot1) {
		this.lot1 = lot1;
	}
	public String getLat2() {
		return lat2;
	}
	public void setLat2(String lat2) {
		this.lat2 = lat2;
	}
	public String getLot2() {
		return lot2;
	}
	public void setLot2(String lot2) {
		this.lot2 = lot2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getHours1() {
		return hours1;
	}

	public void setHours1(String hours1) {
		this.hours1 = hours1;
	}

	public String getHours2() {
		return hours2;
	}

	public void setHours2(String hours2) {
		this.hours2 = hours2;
	}

	public String getMinutes1() {
		return minutes1;
	}

	public void setMinutes1(String minutes1) {
		this.minutes1 = minutes1;
	}

	public String getMinutes2() {
		return minutes2;
	}

	public void setMinutes2(String minutes2) {
		this.minutes2 = minutes2;
	}
	
}
