package Filter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Filterfunc {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
    public static int  choose;
    /**
     * function that is used in filter class specifcly for this class.
     * its convert csv file to txt file .
     * @param fileloc
     * @throws IOException
     */
////-------function helper for filter-----
		
	public void convertcsvtotxt(String fileloc) throws IOException
	{ /*  ממיר קובץ סיאססויי למסמך טקסט(צריך להכניס מיקום) בסטרינג.*/
		
		File file1=new File(path+"\\tempfiles\\orgnized"+".txt");
		file1.createNewFile();
		FileWriter writer= new FileWriter(file1);
	    Scanner scanner = new Scanner(new File(path+"\\tempfiles\\orgnized"+".csv"));
	    scanner.useDelimiter(",");

	    while(scanner.hasNext()){
	    	String line=scanner.next();
	        writer.write(line+",");
	    }
	    writer.close();
	    scanner.close();
	}
}
	
	
