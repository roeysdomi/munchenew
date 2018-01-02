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
    

	public ArrayList<Wifi> getlist;
	
	public ArrayList<Wifi> outlist;

	public String type;
	public String choosenbox;
	public  String  lat1;
	public  String lot1;
	public  String  lat2;
	public  String lot2;
	public  String id;
	public  String hours1;
	public  String hours2;
	public  String minutes1;
	public  String minutes2;
////-------function helper for filter-----
		
	public void statusbox(boolean check1,boolean check2,boolean check3)
	{   
		
		outlist=new ArrayList<>();
		if(check1) {choosenbox="A";}
		if(check2) {choosenbox="B";}
		if(check2) {choosenbox="C";}
		if(check1&&check2) {choosenbox="AB";}
		if(check1&&check3) {choosenbox="AC";}
		if(check2&&check3) {choosenbox="BC";}
		if(check1&&check2&check3) {choosenbox="ABC";}
		
	}
	public void runfilters()
	{
		if(type=="or") {filter_or();}
		if(type=="and") {filter_and();}

	}
	public void filter_and()
	{
		for(int i=0;i<getlist.size();i++)
		{
			if(choosenbox=="A") 
			{
				if(getlist.get(i).getDeviceid().contains(id)) {outlist.add(getlist.get(i));}
				
			}
			if(choosenbox=="B") 
			{
				if(checkTime(getlist.get(i).getTime())) {outlist.add(getlist.get(i));}
				
			}
			if(choosenbox=="C") 
			{
				if(checklocation(getlist.get(i).getLot(), getlist.get(i).getLat())) {outlist.add(getlist.get(i));}
				
			}
			
			if(choosenbox=="AB")
			{
				if(getlist.get(i).getDeviceid().contains(id)&&checkTime(getlist.get(i).getTime())) {outlist.add(getlist.get(i));}
			}
			
			if(choosenbox=="AC")
			{
				if(getlist.get(i).getDeviceid().contains(id)&&checklocation(getlist.get(i).getLot(), getlist.get(i).getLat())) {outlist.add(getlist.get(i));}
			}
			
			if(choosenbox=="BC")
			{
				if(checkTime(getlist.get(i).getTime())&&checklocation(getlist.get(i).getLot(), getlist.get(i).getLat())) {outlist.add(getlist.get(i));}
			}
			if(choosenbox=="ABC")
			{
				if(getlist.get(i).getDeviceid().contains(id)&&checkTime(getlist.get(i).getTime())&&checklocation(getlist.get(i).getLot(), getlist.get(i).getLat())) {outlist.add(getlist.get(i));}
			}
			
			
			
			
		}
	}
	public void filter_or()
	{
		for(int i=0;i<getlist.size();i++)
		{
			if(choosenbox=="A") 
			{
				if(getlist.get(i).getDeviceid().contains(id)) {outlist.add(getlist.get(i));}
				
			}
			if(choosenbox=="B") 
			{
				if(checkTime(getlist.get(i).getTime())) {outlist.add(getlist.get(i));}
				
			}
			if(choosenbox=="C") 
			{
				if(checklocation(getlist.get(i).getLot(), getlist.get(i).getLat())) {outlist.add(getlist.get(i));}
				
			}
			
			if(choosenbox=="AB")
			{
				if(getlist.get(i).getDeviceid().contains(id)||checkTime(getlist.get(i).getTime())) {outlist.add(getlist.get(i));}
			}
			
			if(choosenbox=="AC")
			{
				if(getlist.get(i).getDeviceid().contains(id)||checklocation(getlist.get(i).getLot(), getlist.get(i).getLat())) {outlist.add(getlist.get(i));}
			}
			
			if(choosenbox=="BC")
			{
				if(checkTime(getlist.get(i).getTime())||checklocation(getlist.get(i).getLot(), getlist.get(i).getLat())) {outlist.add(getlist.get(i));}
			}
			if(choosenbox=="ABC")
			{
				if(getlist.get(i).getDeviceid().contains(id)||checkTime(getlist.get(i).getTime())||checklocation(getlist.get(i).getLot(), getlist.get(i).getLat())) {outlist.add(getlist.get(i));}
			}
			
			
			
			
		}
	}
	
	public History createhistory()
	{
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
		sample.setLat2(lat2);
		sample.setLot2(lot2);
		sample.choosenbox=choosenbox;
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
		
	}
	public void setpoint2(String g)
	{
		String []split=g.split(",");
		lat2=new String(split[0]);
		lot2=new String(split[1]);
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
	
	
