import java.io.IOException;
import java.util.Scanner;

import Algorithems.Start;
import Write.WriteTxt3;
import Write.WriteTxt4;

public class RunAlgorithms {

	public static void main(String[] args) throws IOException {
		System.out.println("============================================");
        System.out.println("   Which algorithm would you like to run?");
        System.out.println();
        System.out.println("Press :|1|-first algorithm,|2|-second  algorithm ");
        System.out.println("============================================");

        Scanner input=new Scanner(System.in);
        int choose=input.nextInt();
        System.out.println("----------------------------------------------------");
        System.out.println("----------choose what is the net limit ?:-----------");
        Scanner input2=new Scanner(System.in);
        Start a1=new Start();
        int choose2=input2.nextInt();
        a1.limitmac=choose2;
        
        if(choose==1)
        {
        	 WriteTxt3 run=new WriteTxt3();
        	 run.createTest1List();
             run.WriteMacalgo();
        }
        if(choose==2)
        {
        	WriteTxt4 run=new WriteTxt4();
        	run.WriteLiner();
        	
        }
           System.out.println("     ==========================");
	       System.out.println("              FINSHED!");
	       System.out.println("     ==========================");

        
	}

}
