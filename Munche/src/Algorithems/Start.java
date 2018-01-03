package Algorithems;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Filter.Filter;
import Filter.NewFilter;
import Wifi.Wifi;
import Write.WriteKml;
import Write.WriteTxt2;
import Write.WriteTxt3;


public class Start {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	public static int  choose;
	public static int  limitmac;
	public static Boolean failtesting=true;
	
	
	/**
	 * not in use anymore 
	 * this was the class that run everything
	 * in matala0 and 1.
	 * @throws IOException
	 */
	
	public void Start() throws IOException
	{
		 /*  ההפוקנציה שמאחדת בין כל התהליכים ובעצם מתחילה הכל.*/
				NewFilter filter1=new NewFilter();
			    
				///-------איחוד קבצי CSV----
		    //    Writetxt writetxt=new Writetxt();
		        
				//writetxt.Writetext1();
				////-------------------
				int z=0;
			    System.out.println("REMINDER: the files need to be here:"+path);
				
				
			       ///-------בחירת משתמש
			        System.out.println("============================================");
			        System.out.println("    What sort would you like to choose?");
			        System.out.println();
			        System.out.println("Press :|1|-for ID,|3|-for TIME,|4|-for LOCATION,|5|-All Togther,|6|-mac");
			        System.out.println("============================================");

			        Scanner input=new Scanner(System.in);
			        choose=input.nextInt();
			        if(choose!=1&&choose!=3&&choose!=4&&choose!=5&&choose!=6) {System.out.println("====ERROR WRONG CHOISE===");failtesting=false;return;}
			        System.out.println("          You choosed : |"+choose+"|");
			        if(choose==1)
			        {
			            System.out.println("============================================");

			        	System.out.println("Write ID name or part of the ID name: (for example:Bezeq) ");
			        	 input=new Scanner(System.in);
			        	 filter1.setId(input.nextLine());
			        	 
			        }
			        if(choose==3)
			        {   System.out.println("============================================");

		        	 System.out.println("First enter the *first* point HOUR:");
		        	 input=new Scanner(System.in);
		        	 filter1.setHours1(input.nextLine());
		        	 System.out.println("First enter the *first* point Mintues:");
		        	 input=new Scanner(System.in);
		        	 filter1.setMinutes1(input.nextLine());
		        	 System.out.println("First enter the *Second* point HOUR:");
		        	 input=new Scanner(System.in);
		        	 filter1.setHours2(input.nextLine());
		        	 System.out.println("First enter the *second* point Mintues:");
		        	 input=new Scanner(System.in);
		        	 filter1.setMinutes2(input.nextLine());
		        	 Wifi check=new Wifi();
		        	 if(!check.isNumeric(filter1.getHours1())) {System.out.println("FAIL CHOISE");failtesting=false;return;}
		        	 if(!check.isNumeric(filter1.getMinutes1())) {System.out.println("FAIL CHOISE");failtesting=false;return;}
		        	 if(!check.isNumeric(filter1.getHours2())) {System.out.println("FAIL CHOISE");failtesting=false;return;}
		        	 if(!check.isNumeric(filter1.getMinutes2())) {System.out.println("FAIL CHOISE");failtesting=false;return;}

			        	 
			        }
			        if(choose==4)
			        {   System.out.println("============================================");

			        	 System.out.println("First enter the *first* point lat:");
			        	 input=new Scanner(System.in);
			        	 filter1.setLat1(input.nextLine());
			        	 System.out.println("First enter the *first* point lot:");
			        	 input=new Scanner(System.in);
			        	 filter1.setLot1(input.nextLine());
			        	 System.out.println("First enter the *second* point lat:");
			        	 input=new Scanner(System.in);
			        	 filter1.setLat2(input.nextLine());
			        	 System.out.println("First enter the *second* point lot:");
			        	 input=new Scanner(System.in);
			        	 filter1.setLot2(input.nextLine());
			        	 Wifi check=new Wifi();
			        	 if(!check.isNumeric(filter1.getLat1())) {System.out.println("FAIL CHOISE");failtesting=false;return;}
			        	 if(!check.isNumeric(filter1.getLot1())) {System.out.println("FAIL CHOISE");failtesting=false;return;}
			        	 if(!check.isNumeric(filter1.getLat2())) {System.out.println("FAIL CHOISE");failtesting=false;return;}
			        	 if(!check.isNumeric(filter1.getLot2())) {System.out.println("FAIL CHOISE");failtesting=false;return;}

			        	 
			        }
			        ////--------הכנת קבצים-----
			        if(choose!=6)
			        {
					        WriteTxt2 run=new WriteTxt2();
					   	 System.out.println("start");
					   	 run.createTest1List();
					   	 
					   	 run.WriteOrgnized();
					  
					     
					       ///-----הפעלת פילטר לפי המיון----
					       if(choose==1){filter1.filterID();}
					       if(choose==3){filter1.filterTime();}
					       if(choose==4){filter1.filterLocation();}
					       /////--------יצירת KML-----
					       if(choose!=5)
					       {
					    	   
					       WriteKml kml=new WriteKml(filter1.filter_list_temp);
					       
					       kml.createkml2();
					       }
			        }
			        
			        
			        if(choose==6)
			        {  System.out.println("enter how much macs:");
		        	    input=new Scanner(System.in);
		        	    limitmac=input.nextInt();
			        	 WriteTxt3 run=new WriteTxt3();
			        	 run.createTest1List();
			             run.WriteMacalgo();
			        }
			       if(choose==5) {System.out.println("Only created orgnized file");}
			       System.out.println("     ==========================");
			       System.out.println("              FINSHED!");
			       System.out.println("     ==========================");

			       
			        
			    } 
		
		
		
		
	}


