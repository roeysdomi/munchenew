package Wifi;
public class Calc1parms {
	String path=System.getProperty("user.dir")+"\\";
	String csvpath=System.getProperty("user.dir")+"\\csv\\";
	
	double Lat;
	double Lot;
	double hight;
	double weight;
	String mac;
	String Id;
	
	/***
	 * class the created specifcly for the calc1 algorithem
	 * he only foucs on the object of wifi that really matter for the 
	 * procces of the first algorithem.
	 */
	
	
	public Calc1parms()
	{
		
	}
////-----get and set--------




	public double getLat() {
		return Lat;
	}




	public void setLat(double lat) {
		Lat = lat;
	}




	public double getLot() {
		return Lot;
	}




	public void setLot(double lot) {
		Lot = lot;
	}




	public double getHight() {
		return hight;
	}




	public void setHight(double hight) {
		this.hight = hight;
	}




	public double getWeight() {
		return weight;
	}




	public void setWeight(double weight) {
		this.weight = weight;
	}




	public String getMac() {
		return mac;
	}




	public void setMac(String mac) {
		this.mac = mac;
	}




	public String getId() {
		return Id;
	}




	public void setId(String id) {
		Id = id;
	}
	
}
