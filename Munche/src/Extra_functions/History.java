package Extra_functions;
import java.util.ArrayList;

import Wifi.Wifi;

public class History {
	
	
	/**
	 * this is is linked list based idea which help us to go
	 * back and load the previous content .
	 */
	public ArrayList<Wifi> list;
	public History next;
	public History head;
	public String type;
	public  String  lat1;
	public  String lot1;
	public  String  lat2;
	public  String lot2;
	public  String hight1;
	public  String hight2;
	
	public  String id;
	public  String hours1;
	public  String hours2;
	public  String minutes1;
	public  String minutes2;
	public int macnum;
	public int wifinum;
	
	
	
	
   public History()
   {
	   
	    ArrayList<Wifi> list=new ArrayList<>(); 
		 
   }
   public void add2history(History sample)
   
   {
	   
	    /**
	     * add to the histoy
	     */
	   if(head==null)
	   {
		   head=sample;
		   Count co=new Count();
		   head.macnum=co.countmacs(sample.list);
		   head.wifinum=sample.list.size();
		   
		   return;
	   }
	   if(head!=null)
	   {
		   History currect=head;
		   while(currect.next!=null)
		   {
			   currect=currect.next;
			   
		   }
		   currect.next=sample;
		   Count co=new Count();		 
		   currect.next.macnum= co.countmacs(sample.list);
		   currect.next.wifinum=sample.list.size();
		   
	   }
	   
   }
   public History returnlast()
   {
	   /**
	    * return the last history
	    */
	   History currect=head;
	   while(currect.next!=null)
	   {
		   currect=currect.next;
	   }
	   return currect;
   }
   public History deletelast()
   {
	   /**
	    * delete the last history
	    */
	   History currect=head;
	   while(currect.next.next!=null)
	   {
		   currect=currect.next;
	   }
	  currect.next=null;
	  return currect;
   }
   
   
 //---------get and set--------------  

public ArrayList<Wifi> getList() {
	return list;
}
public void setList(ArrayList<Wifi> list) {
	this.list = list;
}
public History getNext() {
	return next;
}
public void setNext(History next) {
	this.next = next;
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
   
  //---------get and set--------------
   
}
