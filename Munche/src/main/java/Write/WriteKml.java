package Write;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Reads.Read;
import Wifi.Wifi;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;


public class WriteKml {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	public ArrayList<Wifi> kml_list;
	/**
	 * This class handle all the process that create the kml file 
	 * for google earth.
	 * @throws IOException
	 */
	
	public WriteKml(ArrayList<Wifi> list)
	{
		kml_list=new ArrayList<Wifi>(list);
		
	}
	////////-----------create kml function-----
	
	
	public void createkml() throws IOException
	{   
		/**
		 * create kml mathod not in use anymore.
		 */
		
		
		Read a1=new Read();
	    a1.setCsvfilename("filterd");
		a1.convertcsvtotxt();
		a1.setLoc(path+"filterd.txt");
		ArrayList<String>temp=a1.converttocsv2();
		///--------יצירת מסמך KML---
		File file1=new File(path+"\\OUTPUT\\"+"googlearth-ver1.kml");
		file1.createNewFile();
		FileWriter writer=new FileWriter(file1);
		////--------------פתיח--------------
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.write(System.lineSeparator());
		
		writer.write("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
		writer.write(System.lineSeparator());
		writer.write("<Document>");
	    writer.write(System.lineSeparator());
		///////-----------נקודות----------
		for(int i=0;i<temp.size();i++)
		{   Wifi point=new Wifi();
	         point.Wififilterd(temp.get(i));
			writer.write("<Placemark>");
		    writer.write(System.lineSeparator());
			writer.write("<name><![CDATA["+point.getId()+"]]></name>");
		    writer.write(System.lineSeparator());

		    writer.write("<description><![CDATA[BSSID: <b>"+point.getId()+"</b><br/>Capabilities: <b>[ESS]</b><br/>Frequency: <b>"+point.getSignal()+"</b><br/><br/>Date:");
		    writer.write(System.lineSeparator());
		
		    writer.write("<b>"+point.getTime()+"</b>]]>");
		    writer.write(System.lineSeparator());
		    writer.write("<![CDATA["+" lat:"+point.getLat()+"]]>");
		    writer.write(System.lineSeparator());
		    writer.write("<![CDATA["+", lot:"+point.getLot()+"]]></description>");
		    writer.write(System.lineSeparator());
		    writer.write("<Point>");
		    writer.write(System.lineSeparator());

		    writer.write("<coordinates>"+point.getLot()+","+point.getLat()+","+point.getHight()+"</coordinates>");
		    writer.write("</Point>");
		    writer.write(System.lineSeparator());
		    writer.write("</Placemark>");
			writer.write(System.lineSeparator());
			
		   
		}
		/////-----------סגירה--------
		
		writer.write("</Document>");
	    writer.write(System.lineSeparator());
		
		   
		 writer.write("</kml>");
		 writer.write(System.lineSeparator());

		
		writer.close();
	  }	
	
	
	public String createtimesrap(String time)
    {
		/**
		 * create the stracture of the timestamp
		 */
    	String []g=time.split(" ");
    	String a=g[0]+"T";
    	return a+g[1];
    }
	
	
	public void createkml2()throws IOException
	{    
		
		/**
		 * read from the filterd csv file and convert to kml file.
		 */
		
		////-----ךקיחת קובץ קריאה 
	    
	     
		///------------כתיבת  הKML
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument().withName("JAK Example1").withOpen(true);

		// create a Folder
		Folder folder = doc.createAndAddFolder();
		folder.withName("WIFI newtworks").withOpen(true);

		// create Placemark elements
		for(int i =0;i<kml_list.size();i++)
		{  
			kml_list.get(i).getLat();
			 ////---------casting
		 //  double hight=Double.valueOf(point.getHight());
		   String id=kml_list.get(i).getId();
		   double lat=Double.valueOf(kml_list.get(i).getLat());
		   double lot=Double.valueOf(kml_list.get(i).getLot());
           String Time=createtimesrap(kml_list.get(i).getTime());
		createPlacemarkWithChart(doc, folder, lot, lat, id,1,Time);
		}
	   
		//-------- print and save
		kml.marshal(new File(path+"\\OUTPUT\\"+"googlearth-ver2.kml"));
		
	}
    
	private static void createPlacemarkWithChart(Document document, Folder folder, double longitude, double latitude, 
		    String continentName, int coveredLandmass,String timestmp) {

			
			Style style = document.createAndAddStyle();
			style.withId("style_" + continentName) // set the stylename to use this style from the placemark
			    .createAndSetIconStyle().withScale(1.0); // set size and icon
			style.createAndSetLabelStyle().withColor("ff43b3ff").withScale(1.0); // set color and size of the continent name

			Placemark placemark = folder.createAndAddPlacemark();
			// use the style for each continent
			placemark.withName(continentName)
			    .withStyleUrl("#style_" + continentName)
			    // 3D chart imgae
			    .withDescription(
			        "<![CDATA[BSSID: <b>"+continentName+"</b><br/>Lat: <b>"+latitude+"</b><br/>Lot: <b>"+longitude+"</b><br/>Name: <b>"+continentName+"</b>")
			    // coordinates and distance (zoom level) of the viewer
			    .createAndSetLookAt().withLongitude(longitude).withLatitude(latitude).withAltitude(0).withRange(12000000);
			
			placemark.createAndSetPoint().addToCoordinates(longitude, latitude); // set coordinates
			placemark.createAndSetTimeStamp().setWhen(timestmp);
			
			
		}
	
}
