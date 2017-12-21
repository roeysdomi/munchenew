package Algorithems;
import Wifi.Wifi;

public class Calculate2 {
	final int power=2;
	final int norm=10000;
   	final double sigdiff=0.4;
	final int mindiff=3;
	final int diffnosig=100;
	/////------
	int sig;
	double diff;
	double w;
	double pi;
	int input;
	public double Calculate2(Wifi wifinput ,Wifi wifitrain)
	{     double input=Double.valueOf(wifinput.getSignal());
		  double sig=Double.valueOf(wifitrain.getSignal());
		  if(sig==-120) {diff=100;}
		  if(sig!=-120)
		  {
		  double hefresh= Math.abs((input-sig));
		  double max= Math.max(hefresh, mindiff);
		  this.diff=max;
	      }
		  double firstpower=Math.pow(diff, sigdiff);
		  double secondpower=Math.pow(input, power);
		double weight =norm/(firstpower*secondpower);
		 return weight;
	}
	
	
	
	
}
