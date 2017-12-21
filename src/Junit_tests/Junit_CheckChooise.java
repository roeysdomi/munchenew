package Junit_tests;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import Algorithems.Start;

class Junit_CheckChooise {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	@Test
	public void CheckChoise() throws IOException 
	{  /*מכסה את כל המקרים של הכנסת לא תקין .*/
		 System.out.println("=====================CHECK-CHOISE-TEST==================");
	     System.out.println();
	     System.out.println();
	     System.out.println();
	     System.out.println();
	     System.out.println();
	     System.out.println("****Enter wrong number if u want fail ***");

		Start run=new Start();
		run.Start();
		 boolean a=run.failtesting;
       assertTrue(a);
		
	}
}
