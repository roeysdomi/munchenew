package Algorithems;
import java.io.IOException;
import java.util.ArrayList;

import GUI.GUI2;
import Wifi.Calc1parms;
import Wifi.Wifi;

public class Calculate1 {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	public ArrayList<Wifi> enterlist;
	public ArrayList<Calc1parms> weightlist;
	public ArrayList<Calc1parms> result;
	public static String a1;
	int algo2=0;;
	
/** 
 * class that handle all the calculate of the first algorithem.
 * 
 * @param list
 */
public Calculate1()
{}
public Calculate1( ArrayList<Wifi> list)
	{
		this.enterlist=new ArrayList<>(list);
		this.weightlist=new ArrayList<>();
		this.result=new ArrayList<>();
	}
public void runCalculate1( ) throws IOException
{  
	/**
	 * run all the procces
	 */
	
	if(enterlist.size()!=0)
	{
		Creatweightlist();
	   createresult();
	}
}

public void Creatweightlist()
{ 
	/**
	 * first the function create the list of all the 
	 * location of the same mac only its written after the manipulation of the algorithem.
	 */
	for (int i=0;i<enterlist.size();i++)
	{
		double Signal=Double.valueOf(enterlist.get(i).getSignal());
		double lat=Double.valueOf(enterlist.get(i).getLat());
		double lot=Double.valueOf(enterlist.get(i).getLot());
		double hight=Double.valueOf(enterlist.get(i).getHight());
		double weight=0;;
		if(algo2==0)
		{
		 weight=1/(Signal*Signal);
		}
		if(algo2==1)
		{
			 weight=enterlist.get(i).getPie();
		}
	    //----------create weight list------
		double newlat=lat*weight;
		double newlot=lot*weight;
		double newhight=hight*weight;
		
		Calc1parms com=new Calc1parms();
		com.setLat(newlat);
		com.setLot(newlot);
		com.setHight(newhight);
		com.setWeight(weight);
		com.setMac(enterlist.get(i).getMac());
		com.setId(enterlist.get(i).getId());
		weightlist.add(i,com);
	}
}
public void createresult() throws IOException
{    
	/**
	 * this function sums up al the lats ,lot,hight,
	 * togther as the algorithem requierd
	 */
	double sumlat=0;
     double sumlot=0;
     double sumhight=0;
     double sumweight=0;
     //Start a1=new Start();
    
     int a2=Integer.valueOf(a1);
     int size=a2;
     if(size>weightlist.size()) {size=weightlist.size();}
     
    
	for(int i=0;i<size;i++)
	{
		
		 sumlat=sumlat+weightlist.get(i).getLat();
		 sumlot=sumlot+weightlist.get(i).getLot();
		 sumhight=sumhight+weightlist.get(i).getHight();
		 sumweight=sumweight+weightlist.get(i).getWeight();
	}
	Calc1parms com=new Calc1parms();
	double finallat=sumlat/sumweight;
	double finallot=sumlot/sumweight;
	double finalhight=sumhight/sumweight;
	
	com.setLat(finallat);
	com.setLot(finallot);
	com.setHight(finalhight);
	com.setWeight(sumweight);
	com.setMac(enterlist.get(0).getMac());
	com.setId(enterlist.get(0).getId());
	result.add(0,com);
}
public int getAlgo2() {
	return algo2;
}
public void setAlgo2(int algo2) {
	this.algo2 = algo2;
}
	

////--------get and set-------



}