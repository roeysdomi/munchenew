package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Wifi.Wifi;

public  class checkfiles4GUI implements Runnable  {
    public String folderwigle;
    public String folder46col;
    public GUI2 ron;
    String path=System.getProperty("user.dir")+"\\";
    /**
		 * the thread function that run in the background and check change in the files
		 */
    
    
    public checkfiles4GUI(String wigle,String folder46col,GUI2 obj)
	
	{
    	ron=obj;
    	
    	
		this.folderwigle=wigle;
		this.folder46col=folder46col;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		checkfiles();
		
	}
	
	
	
	
	
	public boolean checkfiles()
	{  
		String a1=readlastdate(folderwigle);
		String a2=readlastdate(folder46col);
		String b=a1+a2;
		boolean a=false;
		while(!a)
		{
			
           String c=readlastdate(folderwigle)+readlastdate(folder46col);
           if(!c.equals(b)) {ron.resetandload();b=c;JOptionPane.showMessageDialog(null, "DETECT FILE CHANGE");}
			
		}
		return a;
	}
    public String readlastdate(String g)
    {
    	File folder = new File(g);
		File[] listOfFiles = folder.listFiles();
		ArrayList<Wifi> listout=new ArrayList<>();
		int counter=1;
		String date="";
			for (File file : listOfFiles)
			{
			
				if (file.isFile()&&file.getName().contains("csv"))
				{
			        date=date+file.lastModified();
			    }
		      
			}
		 return date;
    }
	
}
