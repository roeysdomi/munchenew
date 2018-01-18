package Junit_tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Reads.Read;
import Wifi.Wifi;

public class Checkcontent {

	@Test
	public void test() throws IOException {
		
		
		
		
		Read ro=new Read();
		ro.Readwiglestest("csv");
		Wifi check=new Wifi();
		boolean a=check.failtesting;
		
		
		assertTrue(a);
		
	}

}
