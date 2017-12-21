package Junit_tests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import Algorithems.Start;
import Wifi.Wifi;

class Junit_CheckContant {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	/*מכסה בדיקות עבור כל המחלקות:
filter,count,filterfunc,read,sort,start,writekml,writetxt.*/
	/////----------הוא מריץ את כל התוכנה מהתחלה ובודק את תקינות התוכן בכולם להסבר המלא תקרא את הקובץ הסבר שהכנו---
	@Test
	public void CheckContent() throws IOException 
	{ 
		System.out.println("=====================CHECK-CONTENT-TEST==================");
	     System.out.println();
	     System.out.println();
	     System.out.println();
	     System.out.println();
	     System.out.println();

		Start run=new Start();
		run.Start();
	   Wifi check=new Wifi();
	   boolean a=check.failtesting;
	   int syso=0;
	   if(a==false&&syso==0) {System.out.println("CheckContent-FAIL!-WRONG CONTANT");syso=1;}
       assertTrue(a);
		
	}

}
