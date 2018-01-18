package Filter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Extra_functions.History;
import Wifi.Wifi;


public class Filterfunc {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
    
	
	
	/**
	 * this is the class that connect with the gui
	 * he mange all the procces of the filters and choose how to work in every case.
	 */

	public ArrayList<Wifi> getlist;
	
	public ArrayList<Wifi> outlist;

	public String type;
	public  String  lat1;
	public  String lot1;
	public  String  lat2;
	public  String lot2;
	public  String  hight1;
	public  String hight2;
	public  String id;
	public  String hours1;
	public  String hours2;
	public  String minutes1;
	public  String minutes2;
////-------function helper for filter-----
		
	public void statusbox(String t)
	{   
		/**
		 * set all the boxes
		 */
		
		outlist=new ArrayList<>();
		type=t;
		
	}
	public void runfilters()
	{
		/**
		 * set type box
		 */
		if(type.contains("$")) {filter_or();}
		if(type.contains("&")) {filter_and();}
      
	}
	public void filter_and()
	{
		/*
		 * 
		 * filter and
		 */
		
		String choosenbox[]=type.split("&");
		for(int i=0;i<getlist.size();i++)
		{
			int counter=0;
			if(choosenbox[0].equals("A")||choosenbox[1].equals("A")) 
			{
				if(getlist.get(i).getDeviceid().contains(id)) {counter++;;}
				
			}
			if(choosenbox[0].equals("XA")||choosenbox[1].equals("XA")) 
			{
				if(!getlist.get(i).getDeviceid().contains(id)) {counter++;;}
				
			}
			if(choosenbox[0].equals("B")||choosenbox[1].equals("B")) 
			{
				if(checkTime(getlist.get(i).getTime())) {counter++;}
				
			}
			if(choosenbox[0].equals("XB")||choosenbox[1].equals("XB")) 
			{
				if(!checkTime(getlist.get(i).getTime())) {counter++;}
				
			}
			if(choosenbox[0].equals("C")||choosenbox[1].equals("C")) 
			{
				if(checklocation(getlist.get(i).getLot(), getlist.get(i).getLat(),getlist.get(i).getHight())) {counter++;}
				
			}
			if(choosenbox[0].equals("XC")||choosenbox[1].equals("XC")) 
			{
				if(!checklocation(getlist.get(i).getLot(), getlist.get(i).getLat(),getlist.get(i).getHight())) {counter++;}
				
			}
			
			
			if(counter==2) {outlist.add(getlist.get(i));}
			
			
		}
	}
	
	public void filter_or()
	{
		/**
 		 * filteror
 		 */
		String choosenbox[]=type.split("\\$");
		for(int i=0;i<getlist.size();i++)
		{
			int counter=0;
			if(choosenbox[0].equals("A")||choosenbox[1].equals("A")) 
			{
				if(getlist.get(i).getDeviceid().contains(id)) {counter++;;}
				
			}
			if(choosenbox[0].equals("XA")||choosenbox[1].equals("XA")) 
			{
				if(!getlist.get(i).getDeviceid().contains(id)) {counter++;;}
				
			}
			if(choosenbox[0].equals("B")||choosenbox[1].equals("B")) 
			{
				if(checkTime(getlist.get(i).getTime())) {counter++;}
				
			}
			if(choosenbox[0].equals("XB")||choosenbox[1].equals("XB")) 
			{
				if(!checkTime(getlist.get(i).getTime())) {counter++;}
				
			}
			if(choosenbox[0].equals("C")||choosenbox[1].equals("C")) 
			{
				if(checklocation(getlist.get(i).getLot(), getlist.get(i).getLat(),getlist.get(i).getHight())) {counter++;}
				
			}
			if(choosenbox[0].equals("XC")||choosenbox[1].equals("XC")) 
			{
				if(!checklocation(getlist.get(i).getLot(), getlist.get(i).getLat(),getlist.get(i).getHight())) {counter++;}
				
			}
			
			
			if(counter>=1) {outlist.add(getlist.get(i));}
			
			
		}
	}
	
	public History createhistory()
	{
		/**
 		 * create the history based to the filterfunc
 		 */
		History sample=new History();
		sample.setType(type);
		sample.setList(outlist);
		sample.setHours1(hours1);
		sample.setHours2(hours2);
		sample.setMinutes1(minutes1);
		sample.setMinutes2(minutes2);
		sample.setId(id);
		sample.setLat1(lat1);
		sample.setLot1(lot1);
		sample.hight1=(hight1);
		sample.setLat2(lat2);
		sample.setLot2(lot2);
		sample.hight2=(hight2);

		return sample;
	}
////------filters----	
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
	public boolean checklocation(String lot3,String lat3,String hight3)
	  {
	    boolean a=true;
	    ////------הגדרת משתנים
	    double xlat1=Double.valueOf(lat1);
	    double xlot1=Double.valueOf(lot1);
	    double xhight1=Double.valueOf(hight1);
	    double xlat2=Double.valueOf(lat2);
	    double xlot2=Double.valueOf(lot2);
	    double xhight2=Double.valueOf(hight2);
	    double xlat3=Double.valueOf(lat3);
	    double xlot3=Double.valueOf(lot3);
	    double xhight3=Double.valueOf(hight3);

	    /////--------------בדיקה
	    if((xlat1<=xlat3&&xlat3<=xlat2)||(xlat2<=xlat3&&xlat3<=xlat1)){a=true;}
	    else
	    {return false;};
	    if((xlot1<=xlot3&&xlot3<=xlot2)||(xlot2<=xlot3&&xlot3<=xlot1)){a=true;}
	    else
	    {return false;};
	    if((xhight1<=xhight3&&xhight3<=xhight2)||(xhight2<=xhight3&&xhight3<=xhight1)){a=true;}
	    else
	    {return false;};

	   return a;
	  }
	
	
	///-------get and set--------
	
	public void setfrom(String g)
	{
		String []split=g.split(":");
		hours1=new String(split[0]);
		minutes1=new String(split[1]);
		
		
	}
	public void setto(String g)
	{
		String []split=g.split(":");
		hours2=new String(split[0]);
		minutes2=new String(split[1]);
	}
	public void setpoint1(String g)
	{
		String []split=g.split(",");
		lat1=new String(split[0]);
		lot1=new String(split[1]);
	    hight1=new String(split[2]);
	}
	public void setpoint2(String g)
	{
		String []split=g.split(",");
		lat2=new String(split[0]);
		lot2=new String(split[1]);
		hight2=new String(split[2]);
	}
	public ArrayList<Wifi> getGetlist() {
		return getlist;
	}
	public void setGetlist(ArrayList<Wifi> getlist) {
		this.getlist = getlist;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	
	
