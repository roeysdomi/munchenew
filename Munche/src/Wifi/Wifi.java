package Wifi;

public class Wifi {
	public String wifinum;
	public String mac;
	public String id;
	public String time;
	public String signal;
	public int line;
	public double pie;
	Location loc=new Location();
	
   
	/////---------Junit helper----
	public static Boolean failtesting=true;
	////---------wifi :that create object check contant and comprator ----
	public Wifi()
	{
		
	}
	public void Wifikill(String g)
	{
		/**
		 * mathod that mark the lines that already been used.
		 */
		this.mac=g;
	}
	public Wifi(String g)
	{   
		/**
		 * mathod to sepreate the string and create the wifi objects.
		 */
		
		
		if(!g.equals("1"))
		{
		String []words=g.split(",");
		if(words.length<9) {failtesting=false;System.out.println("contant error");}
		
		this.mac=words[0];
		this.id=words[1];
		this.time=words[3];
		this.signal=words[5];
		this.loc.lat=(words[6]);		
		this.loc.lot=(words[7]);
		this.loc.hight=(words[8]);	
		if(!isNumeric(signal)) {failtesting=false;System.out.println("Error Signal look :"+signal);return;}
		if(!isDate(time)) {{failtesting=false;System.out.println("1Error time look :"+time);return;}}
		if(!isNumeric(loc.getLat())) {failtesting=false;System.out.println("Error Lat look :"+loc.getLat());return;}
		if(!isNumeric(loc.getLot())) {failtesting=false;System.out.println("Error Lot look :"+loc.getLot());return;}
		if(!isNumeric(loc.getHight())) {failtesting=false;System.out.println("Error hight look :"+loc.getHight());return;}

		}
	}
	public void Wififilterd(String g)
	{   /**
		 * mathod to sepreate the string and create the wifi objects.
		 * in filter class
		 */
		if(!g.equals("1"))
		{
		String []words=g.split(",");
		if(words.length<7) {failtesting=false;System.out.println("contant error");}
		this.mac=words[0];
		this.id=words[1];
		this.time=words[2];
		this.signal=words[3];
		this.loc.lat=(words[4]);		
		this.loc.lot=(words[5]);
		this.loc.hight=(words[6]);	
		if(!isNumeric(signal)) {failtesting=false;System.out.println("Error Signal look :"+signal);return;}
		if(!isDate(time)) {{failtesting=false;System.out.println("Error time look :"+time);return;}}
		if(!isNumeric(loc.getLat())) {failtesting=false;System.out.println("Error Lat look :"+loc.getLat());return;}
		if(!isNumeric(loc.getLot())) {failtesting=false;System.out.println("Error Lot look :"+loc.getLot());return;}
		if(!isNumeric(loc.getHight())) {failtesting=false;System.out.println("Error hight look :"+loc.getHight());return;}
		
		}
	}
	public void Wifiorgenized(String g)
	{  
		/**
		 * mathod to sepreate the string and create the wifi objects.
		 * in writetxt2 class.
		 */
		if(!g.equals("1"))
		{
		String []words=g.split(",");
		if(words.length<7) {failtesting=false;System.out.println("contant error");}
		this.mac=words[1];
		this.id=words[2];
		this.time=words[3];
		this.signal=words[4];
		this.loc.lat=(words[5]);		
		this.loc.lot=(words[6]);
		this.loc.hight=(words[7]);	
		if(!isNumeric(signal)) {failtesting=false;System.out.println("Error Signal look :"+signal);return;}
		if(!isDate(time)) {{failtesting=false;System.out.println("Error time look :"+time);return;}}
		if(!isNumeric(loc.getLat())) {failtesting=false;System.out.println("Error Lat look :"+loc.getLat());return;}
		if(!isNumeric(loc.getLot())) {failtesting=false;System.out.println("Error Lot look :"+loc.getLot());return;}
		if(!isNumeric(loc.getHight())) {failtesting=false;System.out.println("Error hight look :"+loc.getHight());return;}
		}
	}
	
	
	public boolean Comperator(String wifi1,String wifi2)
	{ 
	  
	  if(wifi1.equals(wifi2)){return true;}
	  else 
		  return false;
	
	 	
	}
	public boolean IDComperator(Wifi wifi1,Wifi wifi2)
	{ 
	  
	  if(
	     wifi1.getId().equals(wifi2.getId())
	     //wifi1.getTime().equals(wifi2.getTime())&&
	     //wifi1.getLat().equals(wifi2.getLat())&&
	     //wifi2.getLot().equals(wifi2.getLot())&&
	     //wifi2.getHight().equals(wifi2.getHight())
	    )
	  {return true;}
	  else 
		  return false;
	
	 	
	}
	public boolean TimeComperator(Wifi wifi1,Wifi wifi2)
	{ 
	  
	  if(
	    // wifi1.getId().equals(wifi2.getId())
	     wifi1.getTime().equals(wifi2.getTime())
	     //wifi1.getLat().equals(wifi2.getLat())&&
	     //wifi2.getLot().equals(wifi2.getLot())&&
	     //wifi2.getHight().equals(wifi2.getHight())
	    )
	  {return true;}
	  else 
		  return false;
	
	 	
	}
	public boolean LocComperator(Wifi wifi1,Wifi wifi2)
	{ 
	  
	  if(
	    // wifi1.getId().equals(wifi2.getId())
	   //  wifi1.getTime().equals(wifi2.getTime())
	     wifi1.getLat().equals(wifi2.getLat())&&
	     wifi2.getLot().equals(wifi2.getLot())&&
	     wifi2.getHight().equals(wifi2.getHight())
	    )
	  {return true;}
	  else 
		  return false;
	
	 	
	}
	public boolean BigComperator(Wifi wifi1,Wifi wifi2)
	{ 
	  
	  if(
	     wifi1.getId().equals(wifi2.getId())&&
	     wifi1.getTime().equals(wifi2.getTime())&&
	     wifi1.getLat().equals(wifi2.getLat())&&
	     wifi2.getLot().equals(wifi2.getLot())&&
	     wifi2.getHight().equals(wifi2.getHight())
	    )
	  {return true;}
	  else 
		  return false;
	
	 	
	}
	public boolean MacComperator(Wifi wifi1,Wifi wifi2)
	{ 
	  
	  if(
	     wifi1.getMac().equals(wifi2.getMac())
	     
	    )
	  {return true;}
	  else 
		  return false;
	
	 	
	}
	public static boolean isNumeric(String s) 
	{  
		/**
		 * check if number.
		 */
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	   
	}  
   
    public static boolean isDate(String s)
    { 
    	/**
    	 * check if its date.
    	 */
      boolean a=true;
      if(!(s.contains(":")&&(s.contains("-")||s.contains("/")))) {return false;}
      String []check=s.split("-|:|/| ");
      for(int i=0;i<check.length;i++)
      {
    	  if(!isNumeric(check[i])&&!check[i].equals("")) {return false;}
      }
    	return a;
    }
	/////---------get and set------------
	public String getWifinum() {
		return wifinum;
	}

///------------get and set---------
	public void setWifinum(String wifinum) {
		this.wifinum = wifinum;
	}


	public String getMac() {
		return mac;
	}


	public void setMac(String mac) {
		this.mac = mac;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getSignal() {
		return signal;
	}


	public void setSignal(String signal) {
		this.signal = signal;
	}
	public String getLat() {
		return loc.lat;
	}
	public void setLat(String loc) {
		this.loc.setLat( loc);
	}
	public String getLot() {
		return loc.lot;
	}
	public void setLot(String loc) {
		this.loc.lot = loc;
	}
	public String getHight() {
		return loc.hight;
	}
	public void sethight(String loc) {
		this.loc.hight = loc;
	}
	public static Boolean getFailtesting() {
		return failtesting;
	}
	public static void setFailtesting(Boolean failtesting) {
		Wifi.failtesting = failtesting;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public double getPie() {
		return pie;
	}
	public void setPie(double pie) {
		this.pie = pie;
	}
	
}
	