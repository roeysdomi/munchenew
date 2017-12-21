package Junit_tests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class Junit_checkfiles {
 
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	
	/*  מכסה את כל הבדיקות של קובץ לא זמין עבור:
מחלקה: writetxt-כל הפונקציות.
מחלקה:read-כל הפונקציות.
מחלקה:filter-כל הפונקציות שמסננות (לא כולל פונקציות העזר).
מחלקה:Start-כל הפונקציות.
מחלקה:writekml-כל הפונקציות...
 */
	@Test

		public  void Checkfiles() 
		{ 
			System.out.println("=====================CHECK-FILES-TEST==================");
		     System.out.println();
		     System.out.println();
		     System.out.println();
		     System.out.println();
		     System.out.println();
		 boolean a=false;
		 File folder = new File(path);
	     File[] listOfFiles = folder.listFiles();
	      int count=0;
	      int tryfind=0;
		  while(count<9&&tryfind<40) 
		  {
			     for (int i = 0; i < listOfFiles.length; i++)
			     { 
			    	 if (listOfFiles[i].isFile())
			    	 {
			    		 if(listOfFiles[i].getName().equals("unicwifi.txt")) {count++;}
			    		 if(listOfFiles[i].getName().equals("test1.txt")) {count++;}
			    		 if(listOfFiles[i].getName().equals("test1.csv")) {count++;}
			    		 if(listOfFiles[i].getName().equals("tempcount.txt")) {count++;}
			    		 if(listOfFiles[i].getName().equals("orgnized.txt")) {count++;}
			    		 if(listOfFiles[i].getName().equals("orgnized.csv")) {count++;}
			    		 if(listOfFiles[i].getName().equals("fixmac.txt")) {count++;}
			    		 if(listOfFiles[i].getName().equals("filterd.txt")) {count++;}
			    		 if(listOfFiles[i].getName().equals("filterd.csv")) {count++;}
			    		 
			    	 } 
			    	 
			    	 tryfind++;
			     }
		  }
		  File folder2 = new File(csvpath);
		  File[] listOfFiles2 = folder.listFiles();
		  int checkcsv=1;
		  if(listOfFiles2.length==0) { checkcsv=0;}
		  
		  if(count==9&&checkcsv==1) {a=true;System.out.println("Checkfiles-SUCCSES!-no missing files");}
		  if(count!=9||checkcsv==0) {a=false;System.out.println("Checkfiles-Fail!-Missing files");}
	      assertTrue(a);
			
		}
	}


