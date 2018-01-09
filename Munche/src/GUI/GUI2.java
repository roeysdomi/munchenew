package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.SampleModel;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JProgressBar;

import Algorithems.Calculate1;
import Algorithems.Start;
import Extra_functions.Count;
import Extra_functions.History;
import Filter.Filterfunc;
import Reads.Read4GUI;
import SQL.MySQL;
import Wifi.Wifi;
import Write.Write4GUI;
import Write.WriteKml;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.sun.java.swing.plaf.windows.resources.windows;

import java.awt.TextField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.Checkbox;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultCaret;
import javax.swing.event.ChangeEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class GUI2 {
	
	
	/**
	 * gui function and run design from gui_design
	 */
	String type; 
	String foldername;
	public static GUI2 obj1;
	boolean loadfiles=false;
	int startwith =0; 
	public static int loadwigile=0;
	public static int load46col=0;
	public static int loaddb=0;
	public ArrayList<Wifi> templist=new ArrayList<>();
    public String line4algo2;
    public int counter=0;
    public int detectfiles=0;
	public static JFrame frame;
	public static String path=System.getProperty("user.dir")+"\\";
	///----------status------------
    final Label MACNUM = new Label("0");
	final Label WIFINUM = new Label("0");
	final Label counthis = new Label(String.valueOf(counter));
	///-----------history----------
	History his=new History();
	//-------------log--------------
	public static JTextArea textArea= new JTextArea();
	///-----------buttons-------------------
	final JButton resetbutton = new JButton("<html>[ Reset All ]</html>");
	final JButton lunch = new JButton("LUNCH !");
	final JButton btnLoad = new JButton("Add+");
	final JButton goback = new JButton("<<-Goback");
	final JButton savefilter = new JButton("SAVE FILTER");
	final JButton load_filter = new JButton("<html>" + "LOAD LAST" + "<br>" + "SAVED FILTER" + "</html>");
	final JButton save_csv46 = new JButton("<html>SAVE 46 COL FORMAT</html>");
	final JButton savekml = new JButton("SAVE TO KML");
	final JButton load_csv46 = new JButton("Add+");
	final JButton lunch_algo1 = new JButton("Lunch!");
	final JButton lunch_aglo2_line = new JButton("Lunch!");
	final JButton algo2_lunch_macs = new JButton("Lunch!");
	final JButton load_db = new JButton("Add+");

	
	
	///--------text input------------------
	final TextField textid = new TextField();
	final TextField time_from = new TextField();
	final TextField time_to = new TextField();
	final TextField point1 = new TextField();
	final TextField point2 = new TextField();
	final static TextField loadfiles_folder = new TextField();
	final TextField wiglefiletext = new TextField();
	final static  TextField folder_csv46 = new TextField();
	final TextField file_csv46 = new TextField();
	final TextField mac_algo1 = new TextField();
	final TextField algo2_line = new TextField();
	final TextField algo2_sig_1 = new TextField();
	final TextField algo2_sig_2 = new TextField();
	final TextField algo2_sig_3 = new TextField();
	final TextField algo2_mac_1 = new TextField();
	final TextField algo2_mac_2 = new TextField();
	final TextField algo2_mac_3 = new TextField();
	public final static TextField wifilimit = new TextField();
	final TextField FILTER1 = new TextField();
	final TextField FILTER2 = new TextField();
	final TextField db_user = new TextField("oop2");
	final TextField db_passw = new TextField("Lambda2();");
	final TextField db_ip = new TextField("5.29.193.52");
	final TextField db_port = new TextField("3306");

	//--------filter checkbox------------
	final JRadioButton ortype = new JRadioButton("OR");
	final JRadioButton andtype = new JRadioButton("AND");
	final JRadioButton not1 = new JRadioButton("NOT");
	final JRadioButton not2 = new JRadioButton("NOT");
	
	
	//--------------------------------------------
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		GUI2 ron = new GUI2();
		ron.obj1=ron;
		ron.GUI21(ron);
		
		ron.frame.setVisible(true);
		
	
	}

	/**
	
 * Create the application.
	 * @throws IOException 
	 */
	public GUI2() {};
	public void GUI21(GUI2 obj) throws IOException {
		GUI_design gr=new GUI_design();
		
		Design();
		Design2();
		loadwigle(obj);
		lunchbutton();
		filtertype();
		goback();
		reset();
		load46col(obj);
		savefilter();
		loadsavedfilter();
		saved46col();
		savetokml();
		lunchalgo1();
		lunchalgo2line();
		lunchalgo2macs();
		
		loaddatabase(obj);
		
	}
    
	/**
	 * Initialize the contents of the frame.
	 */
	
	public void Design2()
	{
		
		//-------קו הפרדה-------
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.GRAY);
		separator.setBounds(133, 12, 2, 347);
		frame.getContentPane().add(separator);
		
		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setForeground(new Color(192, 192, 192));
		separator2.setBounds(252, 198, 8, 161);
		frame.getContentPane().add(separator2);
		
		JSeparator separator3 = new JSeparator();
		separator3.setOrientation(SwingConstants.VERTICAL);
		separator3.setForeground(new Color(192, 192, 192));
		separator3.setBounds(357, 193, 8, 167);
		frame.getContentPane().add(separator3);
		
		JSeparator separator4 = new JSeparator();
		separator4.setOrientation(SwingConstants.VERTICAL);
		separator4.setForeground(new Color(192, 192, 192));
		separator4.setBounds(518, 192, 8, 167);
		frame.getContentPane().add(separator4);
		
		JSeparator separator5 = new JSeparator();
		separator5.setOrientation(SwingConstants.VERTICAL);
		separator5.setForeground(new Color(192, 192, 192));
		separator5.setBounds(623, 169, 8, 191);
		frame.getContentPane().add(separator5);
		
		JLabel lblType = DefaultComponentFactory.getInstance().createLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setBounds(140, 51, 92, 23);
		frame.getContentPane().add(lblType);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(140, 162, 590, 11);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 58, 128, 14);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 128, 128, 4);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 244, 128, 14);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(164, 99, 169, 4);
		frame.getContentPane().add(separator_11);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(0, 33, 128, 14);
		frame.getContentPane().add(separator_7);
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(0, 364, 814, 14);
		frame.getContentPane().add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(0, 412, 814, 4);
		frame.getContentPane().add(separator_9);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(0, 441, 814, 14);
		frame.getContentPane().add(separator_10);
		
		JLabel lblLoadFiles = DefaultComponentFactory.getInstance().createLabel("LOAD FILES :");
		lblLoadFiles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoadFiles.setBounds(140, 174, 92, 14);
		frame.getContentPane().add(lblLoadFiles);
		
		
		
		JLabel lblLog = DefaultComponentFactory.getInstance().createLabel("LOG:");
		lblLog.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLog.setBounds(402, 1, 58, 23);
		frame.getContentPane().add(lblLog);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(140, 51, 128, 17);
		frame.getContentPane().add(separator_5);
		
		JLabel maclbl = DefaultComponentFactory.getInstance().createLabel("Macs:");
		maclbl.setBounds(140, 11, 39, 14);
		frame.getContentPane().add(maclbl);
		
		JLabel lblWifiNet = DefaultComponentFactory.getInstance().createLabel("  WIFI NET:");
		lblWifiNet.setBounds(134, 33, 65, 14);
		frame.getContentPane().add(lblWifiNet);
		
		JLabel lblFolder = DefaultComponentFactory.getInstance().createLabel("Folder:");
		lblFolder.setBounds(140, 207, 92, 20);
		frame.getContentPane().add(lblFolder);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//checkstatus(checkbox1);
		
	}
	public void Design() {
		 
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 840, 649);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		textArea.setBounds(445, 26, 285, 132);
		frame.getContentPane().add(textArea);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(402, 26, 412, 132);
		frame.getContentPane().add(scrollPane);
		
		

		
		JLabel lblFilters = DefaultComponentFactory.getInstance().createLabel("FILTERS:");
		lblFilters.setBounds(10, 36, 78, 20);
		frame.getContentPane().add(lblFilters);
		
		JLabel lblId = DefaultComponentFactory.getInstance().createLabel("    ID:  ");
		lblId.setBounds(0, 79, 39, 14);
		frame.getContentPane().add(lblId);
		
		String g=textid.getText();
		textid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textid.setBounds(10, 99, 71, 23);
		frame.getContentPane().add(textid);
		
		
		JLabel lblTime = DefaultComponentFactory.getInstance().createLabel("  TIME:   ( ex:16:42)");
		lblTime.setBounds(0, 143, 102, 14);
		frame.getContentPane().add(lblTime);
		
		JLabel lblfrom = DefaultComponentFactory.getInstance().createLabel("  [ from : ]");
		lblfrom.setBounds(0, 153, 92, 20);
		frame.getContentPane().add(lblfrom);
		
		
		time_from.setBounds(10, 174, 71, 19);
		//time_from.disable();
		time_from.setEditable(true);
		frame.getContentPane().add(time_from);
		
		JLabel lblto = DefaultComponentFactory.getInstance().createLabel("  [to :]");
		lblto.setBounds(0, 199, 92, 14);
		frame.getContentPane().add(lblto);
		
		
		time_to.setBounds(10, 219, 71, 19);
		frame.getContentPane().add(time_to);
		
		JLabel lblLocation = DefaultComponentFactory.getInstance().createLabel("  LOCATION:");
		lblLocation.setBounds(0, 262, 92, 14);
		frame.getContentPane().add(lblLocation);
		
		JLabel lblLat = DefaultComponentFactory.getInstance().createLabel(" Point1 (Lat,Lot ,Alt)");
		lblLat.setBounds(0, 281, 128, 14);
		frame.getContentPane().add(lblLat);
		
		point1.setBounds(10, 295, 71, 19);
		frame.getContentPane().add(point1);
		point1.getAccessibleContext();
		
		JLabel lblLot = DefaultComponentFactory.getInstance().createLabel("Point2");
		lblLot.setBounds(0, 320, 92, 14);
		frame.getContentPane().add(lblLot);
		
		point2.setBounds(10, 340, 71, 19);
		frame.getContentPane().add(point2);
		//g.drawLine(10, 60, 89, 41);

		
		
		
		MACNUM.setBounds(175, 10, 72, 23);
		frame.getContentPane().add(MACNUM);
		WIFINUM.setBounds(200, 36, 68, 11);
		frame.getContentPane().add(WIFINUM);
		counthis.setFont(new Font("Eras Bold ITC", Font.PLAIN, 14));
		counthis.setBounds(105, 10, 23, 17);
		frame.getContentPane().add(counthis);
			/////-------------פתור לאנץ'---------------
		JLabel lblAlgo = DefaultComponentFactory.getInstance().createLabel("<HTML>ALGO 1: MAC:</HTML>");
		lblAlgo.setBounds(10, 377, 78, 33);
		frame.getContentPane().add(lblAlgo);
		JLabel lblAlgo2 = DefaultComponentFactory.getInstance().createLabel("<HTML>ALGO 2: LINE:</HTML>");
		lblAlgo2.setBounds(10, 412, 78, 33);
		frame.getContentPane().add(lblAlgo2);
		
		mac_algo1.setBounds(94, 384, 239, 20);
		frame.getContentPane().add(mac_algo1);
		mac_algo1.setColumns(10);
		
		algo2_line.setBounds(94, 418, 325, 20);
		frame.getContentPane().add(algo2_line);
		algo2_line.setColumns(10);
		
		
		lunch_algo1.setBounds(339, 371, 89, 40);
		frame.getContentPane().add(lunch_algo1);
		
		JLabel lblWifiLimit = DefaultComponentFactory.getInstance().createLabel("<html>Wifi limit:</html>");
		lblWifiLimit.setBounds(442, 377, 71, 33);
		frame.getContentPane().add(lblWifiLimit);
		
		wifilimit.setBounds(532, 384, 92, 22);
		frame.getContentPane().add(wifilimit);
		wifilimit.setColumns(10);
		
		lunch_aglo2_line.setBounds(425, 417, 89, 23);
		frame.getContentPane().add(lunch_aglo2_line);
		
		JLabel lblAlgoBy = DefaultComponentFactory.getInstance().createLabel("ALGO2 : BY MACS:");
		lblAlgoBy.setBounds(10, 454, 118, 14);
		frame.getContentPane().add(lblAlgoBy);
		
		JLabel lblMac = DefaultComponentFactory.getInstance().createLabel("mac 1:");
		lblMac.setBounds(57, 490, 49, 14);
		frame.getContentPane().add(lblMac);
		
		JLabel lblMac_1 = DefaultComponentFactory.getInstance().createLabel("mac 2:");
		lblMac_1.setBounds(56, 533, 49, 14);
		frame.getContentPane().add(lblMac_1);
		
		JLabel lblMac_2 = DefaultComponentFactory.getInstance().createLabel("mac 3:");
		lblMac_2.setBounds(57, 571, 43, 14);
		frame.getContentPane().add(lblMac_2);
		
		JLabel lblSignalMac = DefaultComponentFactory.getInstance().createLabel("Signal    ,  mac");
		lblSignalMac.setBounds(140, 471, 92, 14);
		frame.getContentPane().add(lblSignalMac);
		
		algo2_sig_1.setBounds(133, 490, 39, 19);
		frame.getContentPane().add(algo2_sig_1);
		
		algo2_sig_2.setBounds(133, 533, 40, 19);
		frame.getContentPane().add(algo2_sig_2);
		
		algo2_sig_3.setBounds(133, 571, 39, 19);
		frame.getContentPane().add(algo2_sig_3);
		
		algo2_mac_1.setBounds(175, 490, 190, 19);
		frame.getContentPane().add(algo2_mac_1);
		
		
		algo2_mac_2.setBounds(175, 533, 190, 19);
		frame.getContentPane().add(algo2_mac_2);
		
		algo2_mac_3.setBounds(175, 571, 190, 19);
		frame.getContentPane().add(algo2_mac_3);
		
		
		algo2_lunch_macs.setBounds(398, 501, 128, 51);
		frame.getContentPane().add(algo2_lunch_macs);

		
		
		
		
		
		
		
		}
	///--------function----
    public void filtertype()
	{
    	/**
    	 * choose the filter type
    	 */
		ortype.setBounds(230, 106, 47, 20);
		frame.getContentPane().add(ortype);
		
		
		andtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ortype.setSelected(false);
				type="and";

			}
		});
		andtype.setBounds(170, 105, 49, 20);
		frame.getContentPane().add(andtype);
		////-------החלפה בין סוג הפילטר-----
		ortype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				andtype.setSelected(false);
				type="or";
				
			}
		});
		
	}
	public void lunchbutton()
	{
		/**
    	 * lunch the filters on the  currect data
    	 */
	    textid.setText("O");
	    time_from.setText("16:22");
	    time_to.setText("16:44");
		lunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createtype();
				if(loadfiles)
				{
				Filterfunc fe=new Filterfunc();
				textArea.append("start \n");
				
				
				fe.statusbox(type);
				
				String idbox=textid.getText(); 
				if(FILTER1.getText().contains("A")||FILTER2.getText().contains("A"))
				{fe.setId(idbox);}
				 
				String from=time_from.getText();
				String to=time_to.getText();
				if(FILTER1.getText().contains("B")||FILTER2.getText().contains("B"))
				{
				fe.setfrom(from);
				fe.setto(to);
				}
				if(FILTER1.getText().contains("C")||FILTER2.getText().contains("C"))
				{
				String po1=point1.getText();
				String po2=point2.getText();
				fe.setpoint1(po1);
				fe.setpoint2(po2);	
				}
				//try {
				//	Write4GUI roey=new Write4GUI (mainlist,textArea);
				//} catch (IOException e1) {
					// TODO Auto-generated catch block
			//		e1.printStackTrace();
			//	}
				ArrayList<Wifi> listnow=new ArrayList<>(templist);
				fe.setGetlist(listnow);	
				
				
				fe.setType(type);
				textArea.append("Run filters /n");
				textArea.setText(System.lineSeparator());
				fe.runfilters();
				
				History sample12 = fe.createhistory();
				his.add2history(sample12);
				
				templist=new ArrayList<>(sample12.list);
				printlist();
				History last=his.returnlast();
				String m=String.valueOf(last.macnum);
				String w=String.valueOf(last.wifinum);

				MACNUM.setText(m);
				WIFINUM.setText(w);
				counter=counter+1;
				counthis.setText(String.valueOf(counter));
				textArea.append("===================\n");
				textArea.append("Add to history \n");
				textArea.append("===================");
				}
				else
				{
					textArea.append("YOU NEED TO LOAD FILES FIRST !\n");
				}
				
			
			}
		});
		lunch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lunch.setBounds(140, 128, 120, 30);
		frame.getContentPane().add(lunch);
	}
	public void loadwigle(final GUI2 obj)
	{
		/**
    	 * load wigile format
    	 */
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loadwigile==0&&load46col==0) {checkfiles(obj);}
				loadfiles=true;
				startwith=1;
				loadwigile=1;
				Read4GUI re=new Read4GUI();
				
				String foldername=loadfiles_folder.getText();
				String filename=wiglefiletext.getText();
				try {
                     if(!foldername.equals("")&&filename.equals(""))
                     {
						templist=new ArrayList<>(re.Readwigles(templist,foldername));
						textArea.append("\n ===LOADED FILE from :!"+foldername+"====\n");
                     }
                     if(!foldername.equals("")&&!filename.equals(""))
                     {
						templist=new ArrayList<>(re.Read_1_wigles(templist, foldername, filename));
						textArea.append("\n ===LOADED FILE from :!"+foldername+"====\n");
                     }
                     status();
                     printlist();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLoad.setBounds(153, 320, 89, 33);
		frame.getContentPane().add(btnLoad);
	}
    public void goback()
    {
    	/**
    	 * bring back all the history
    	 */
    	goback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if()
				if(counter==1) {counter=counter-1;counthis.setText(String.valueOf(counter));resetandload();}
				if(counter>1) 
				{
					counter=counter-1;counthis.setText(String.valueOf(counter));
					his.deletelast();
					History sample=new History();
					sample=his.returnlast();
					templist=new ArrayList<>(sample.list);
					showfilter(sample);
					
					MACNUM.setText(String.valueOf(sample.macnum));
					WIFINUM.setText(String.valueOf(sample.wifinum));
					printlist();
				}
			}
		});
		goback.setBounds(0, 8, 102, 19);
		frame.getContentPane().add(goback);
		
		JLabel lblFolder_1 = DefaultComponentFactory.getInstance().createLabel("file: (ex: wigile2.csv)");
		lblFolder_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFolder_1.setBounds(140, 258, 107, 20);
		frame.getContentPane().add(lblFolder_1);
		
		JLabel lblwigleFormat = DefaultComponentFactory.getInstance().createLabel("(Wigle format)");
		lblwigleFormat.setBounds(140, 193, 92, 20);
		frame.getContentPane().add(lblwigleFormat);
		
		wiglefiletext.setBounds(140, 295, 107, 19);
		wiglefiletext.setText("");
		frame.getContentPane().add(wiglefiletext);
		
		
		resetbutton.setBounds(602, 0, 212, 24);
		frame.getContentPane().add(resetbutton);
		
		JLabel lblCsvCo = DefaultComponentFactory.getInstance().createLabel("csv (46 col Format)");
		lblCsvCo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCsvCo.setBounds(256, 193, 102, 20);
		frame.getContentPane().add(lblCsvCo);
		
		JLabel lbldb = DefaultComponentFactory.getInstance().createLabel("Data base:");
		lbldb.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbldb.setBounds(367, 193, 116, 20);
		frame.getContentPane().add(lbldb);
		
		JLabel dbuser = DefaultComponentFactory.getInstance().createLabel("user:");
		dbuser.setFont(new Font("Tahoma", Font.PLAIN, 10));
		dbuser.setBounds(375, 220, 35, 20);
		frame.getContentPane().add(dbuser);
		
		JLabel dbip = DefaultComponentFactory.getInstance().createLabel("ip:");
		dbip.setFont(new Font("Tahoma", Font.PLAIN, 10));
		dbip.setBounds(375, 270, 31, 20);
		frame.getContentPane().add(dbip);
		
		JLabel dbpass = DefaultComponentFactory.getInstance().createLabel("pass:");
		dbpass.setFont(new Font("Tahoma", Font.PLAIN, 10));
		dbpass.setBounds(374, 244, 36, 20);
		frame.getContentPane().add(dbpass);
		
		JLabel dbport = DefaultComponentFactory.getInstance().createLabel("port:");
		dbport.setFont(new Font("Tahoma", Font.PLAIN, 10));
		dbport.setBounds(375, 295, 40, 20);
		frame.getContentPane().add(dbport);
		
		folder_csv46.setBounds(266, 233, 84, 20);
		frame.getContentPane().add(folder_csv46);
		
		file_csv46.setBounds(268, 295, 82, 19);
		frame.getContentPane().add(file_csv46);
		
		JLabel lblFileexFilenamecsv = DefaultComponentFactory.getInstance().createLabel("file:(ex: filename.csv)");
		lblFileexFilenamecsv.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFileexFilenamecsv.setBounds(258, 262, 107, 14);
		frame.getContentPane().add(lblFileexFilenamecsv);
		
		loadfiles_folder.setBounds(140, 233, 107, 20);
		loadfiles_folder.setText("csv");
		frame.getContentPane().add(loadfiles_folder);
		
		JLabel lblFolder_2 = DefaultComponentFactory.getInstance().createTitle("Folder:");
		lblFolder_2.setBounds(258, 210, 92, 14);
		frame.getContentPane().add(lblFolder_2);
		
		
		
		load_filter.setBounds(532, 193, 84, 154);
		frame.getContentPane().add(load_filter);
		
		JLabel lblSaveFile = new JLabel("SAVE FILE:");
		lblSaveFile.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSaveFile.setBounds(641, 169, 78, 14);
		frame.getContentPane().add(lblSaveFile);
		
		
		savefilter.setBounds(641, 199, 160, 39);
		frame.getContentPane().add(savefilter);
		
		
		save_csv46.setBounds(641, 248, 160, 43);
		frame.getContentPane().add(save_csv46);
		
		
		
		savekml.setBounds(641, 307, 160, 40);
		frame.getContentPane().add(savekml);
    	
    }
    public void status()
    {
    	/**
    	 * show the data status mac and wifi num
    	 */
    	Count co=new Count();
    	MACNUM.setText(String.valueOf(co.countmacs(templist)));
    	WIFINUM.setText(String.valueOf(templist.size()));
    }
    public void reset()
    {   
    	/**
    	 * reset all
    	 */
    	resetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    	templist=new ArrayList<>();
		    	his=new History();
		    	counter=0;
		    	startwith=0;
		    	textid.setText("");
		    	time_from.setText("");
		    	time_to.setText("");
		    	point1.setText("");
		    	point2.setText("");
		    	ortype.setSelected(false);
		    	andtype.setSelected(false);
		    	not1.setSelected(false);
		    	not2.setSelected(false);
		    	WIFINUM.setText("0");
		    	MACNUM.setText("0");
		    	counthis.setText("0");
		    	counter=0;
		    	loadwigile=0;
		    	load46col=0;
		    	loaddb=0;
		    	FILTER1.setText("");
		    	FILTER2.setText("");

			}
		});


    }
    public void resetandload()
    {
    	/**
    	 * resrt and load all
    	 */
    	his=new History();
    	templist=new ArrayList<>();
    	counter=0;
    	textid.setText("");
    	time_from.setText("");
    	time_to.setText("");
    	point1.setText("");
    	point2.setText("");
    	ortype.setSelected(false);
    	andtype.setSelected(false);
    	not1.setSelected(false);
    	not2.setSelected(false);
    	FILTER1.setText("");
    	FILTER2.setText("");
    	
    	/////-------------------
    	if(loadwigile==1) {
    	loadfiles=true;
		Read4GUI re=new Read4GUI();
		
		String foldername=loadfiles_folder.getText();
		String filename=wiglefiletext.getText();
		try {
             if(!foldername.equals("")&&filename.equals(""))
             {
				templist=new ArrayList<>(re.Readwigles(templist,foldername));
				textArea.append("\n ===LOADED FILE from :!"+foldername+"====\n");
             }
             if(!foldername.equals("")&&!filename.equals(""))
             {
				templist=new ArrayList<>(re.Read_1_wigles(templist, foldername, filename));
				textArea.append("\n ===LOADED FILE from :!"+foldername+"====\n");
             }
             status();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	}
    	if(load46col==1)
    	{
    		Read4GUI re=new Read4GUI();
			startwith=2;
			String foldername=folder_csv46.getText();
			String filename=file_csv46.getText();
			try {
				
				re.ReadeCombCsv(templist, foldername, filename);
				textArea.append("\n ===LOADED FILE from :!"+foldername+"====\n");
				loadfiles=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			status();
    	}
    	if(loaddb==1)
    	{
    		loadfiles=true;
			MySQL sq=new MySQL();
			sq._ip=db_ip.getText();
			sq._password=db_passw.getText();
			sq._port=db_port.getText();
			sq._user=db_user.getText();
			sq._url="jdbc:mysql://"+sq._ip+":"+sq._port+"/oop_course_ariel";
	    	templist=sq.AddData(templist);
	    	
	    	
    	}
    	textArea.setText("");
    	printlist();
    	status();
    	textArea.append("\n  FILES WERE REALOADED !\n");

    }
    public void printlist()
    {
    	/**
    	 * print all the list
    	 */
    	for(int i=0;i<templist.size();i++)
		{
			textArea.append(
					templist.get(i).getDeviceid()+
					","+templist.get(i).getTime()+
					","+templist.get(i).getLat()+
					","+templist.get(i).getLot()+
					","+templist.get(i).getHight()+
					 "\n");
		}
    	  DefaultCaret caret = (DefaultCaret)textArea.getCaret();
    	   caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);    	
    	   recountlines(templist);
    }
    public void load46col(final GUI2 obj)
    {
    	/**
    	 * load 46col format
    	 */
    	folder_csv46.setText("INPUT\\target\\");
		file_csv46.setText("_comb_all_BM2_.csv");
		load_csv46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(loadwigile==0&&load46col==0) {checkfiles(obj);}
				Read4GUI re=new Read4GUI();
				startwith=2;
				load46col=1;
				String foldername=folder_csv46.getText();
				String filename=file_csv46.getText();
				try {
					
					re.ReadeCombCsv(templist, foldername, filename);
					textArea.append("\n ===LOADED FILE from :!"+foldername+"====\n");
					loadfiles=true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				status();
				printlist();
			}
		});
		
		load_csv46.setBounds(258, 320, 89, 33);
		frame.getContentPane().add(load_csv46);
		
		
		not1.setBounds(140, 75, 49, 23);
		frame.getContentPane().add(not1);
		
		
		not2.setBounds(254, 75, 49, 23);
		frame.getContentPane().add(not2);
		
		FILTER1.setBounds(192, 79, 55, 19);
		frame.getContentPane().add(FILTER1);
		
		
		FILTER2.setBounds(301, 79, 58, 19);
		frame.getContentPane().add(FILTER2);
		
		JLabel lblIda = DefaultComponentFactory.getInstance().createLabel("for ID enter \"A\"");
		lblIda.setBounds(274, 10, 108, 14);
		frame.getContentPane().add(lblIda);
		
		JLabel lblForTimeEnter = DefaultComponentFactory.getInstance().createLabel("for time enter \"B\"");
		lblForTimeEnter.setBounds(274, 26, 132, 14);
		frame.getContentPane().add(lblForTimeEnter);
		
		JLabel lblForLocationEnter = DefaultComponentFactory.getInstance().createLabel("for location enter \"C\"");
		lblForLocationEnter.setBounds(274, 42, 128, 14);
		frame.getContentPane().add(lblForLocationEnter);
		
		db_user.setBounds(425, 219, 88, 19);
		frame.getContentPane().add(db_user);
		

		db_passw.setBounds(425, 244, 88, 19);
		frame.getContentPane().add(db_passw);
		
		db_ip.setBounds(425, 270, 88, 19);
		frame.getContentPane().add(db_ip);
		
		db_port.setBounds(425, 295, 88, 19);
		frame.getContentPane().add(db_port);
		
		
		load_db.setBounds(375, 320, 89, 33);
		frame.getContentPane().add(load_db);
		
		
    	
    }
    public void savefilter() throws IOException
    {
    	/**
    	 * save the filter
    	 */
    	savefilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(counter==0) {textArea.append("\n YOU NEED TO LUNCH FIRST BEFORE \n SAVEING THE FILTER\n");}
				if(counter>0) {
				Write4GUI re=new Write4GUI();
		    	try {
		    		 History lasthis=his.returnlast();
					re.Savefilter(lasthis);
					textArea.append("\n SAVED FILTER|-STORED IN OUTPUT FOLDER!\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			}
		});
    	
    	
    	
    }
    public void loadsavedfilter() throws IOException
    {
    	/**
    	 * load the filter
    	 */
    	load_filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Read4GUI re=new Read4GUI();
		    	
		    	try {
					his=re.Readsavedfilter(his);
					showfilter(his);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
				
			}
		});
    	
    }
    public void saved46col()
    {
    	/**
    	 * save to 46 col format
    	 */
    	save_csv46.addActionListener(new ActionListener() {
    		
			public void actionPerformed(ActionEvent e) {
				
				try {
					textArea.append("\n SAVED IN 46COL-FORMAT IN OUTPUT FOLDER \n");
					Write4GUI re=new Write4GUI(templist);
					re.WriteOrgnized();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
    }
    public void savetokml()
    {
    	/**
    	 * save to kml format
    	 */
    	savekml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteKml re=new WriteKml(templist);
				try {
				
					re.createkml2();
					textArea.append("\n CREATED KML FILE-LOCATED IN OUTPUT \n ");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
    	
    }
    public void lunchalgo1()
    {  
    	/**
    	 * lunch algo1
    	 */
    	mac_algo1.setText("90:6c:ac:a0:3d:eb");
    	wifilimit.setText("5");
    	
    	lunch_algo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Write4GUI re=new Write4GUI();
				String mac= mac_algo1.getText();
				Calculate1 cal=new Calculate1();
		    	cal.a1=wifilimit.getText();
				
				try {
					re.WriteMacalgo(templist, mac);
					textArea.append("\n RESULT(ALGO1 BY MAC): \n");

					textArea.append("\n "+ re.resultalgo1+ "\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
			}
		});
    }
    public void lunchalgo2line()
    {    
    	/**
    	 * lunch algo2 line
    	 */
    	algo2_line.setText("12/05/17 11:41 AM,model=SM-G950F_device=dreamlte,?,?,?,3,Guest,1c:b9:c4:15:ed:b8,3,-81,Guest,8c:0c:90:ae:16:83,3,-86,Guest,1c:b9:c4:16:ed:3c,3,-91");
          
    	lunch_aglo2_line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				line4algo2=algo2_line.getText();
				Read4GUI read=new Read4GUI();
				Calculate1 cal=new Calculate1();
		    	cal.a1=wifilimit.getText();
				Write4GUI writer=new Write4GUI();
				try {
					writer.targetlist=read.ReadeNoGPSCsv(line4algo2);
					writer.traininglist=new ArrayList<>(templist);
					writer.WriteLiner();
					textArea.append("\n RESULT(ALGO2 BY LINE): \n");
					textArea.append("\n" +writer.resultalgo2_line+"\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
    }
    public void lunchalgo2macs()
    {   
    	/**
    	 * lunch algo2 by macs
    	 */
    	
    	algo2_sig_1.setText("-81");
    	algo2_mac_1.setText("1c:b9:c4:15:ed:b8");
    	algo2_sig_2.setText("-86");
    	algo2_mac_2.setText("8c:0c:90:ae:16:83");
    	algo2_sig_3.setText("-91");
    	algo2_mac_3.setText("1c:b9:c4:16:ed:3c");

    	

    	
    	algo2_lunch_macs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(algo2_sig_1.getText()!=null) {line4algo2="12/05/17 11:41 AM,model=SM-G950F_device=dreamlte,?,?,?,1,Guest,"+algo2_mac_1.getText()+",3,"+algo2_sig_1.getText()+",";}
			if(algo2_sig_2.getText()!=null)  {line4algo2="12/05/17 11:41 AM,model=SM-G950F_device=dreamlte,?,?,?,2,Guest,"+algo2_mac_1.getText()+",3,"+algo2_sig_1.getText()+","+"Guest,"+algo2_mac_2.getText()+",3,"+algo2_sig_2.getText()+",";;}
			if(algo2_sig_3.getText()!=null)  {line4algo2="12/05/17 11:41 AM,model=SM-G950F_device=dreamlte,?,?,?,3,Guest,"+algo2_mac_1.getText()+",3,"+algo2_sig_1.getText()+","+"Guest,"+algo2_mac_2.getText()+",3,"+algo2_sig_2.getText()+","+"Guest,"+algo2_mac_3.getText()+",3,"+algo2_sig_3.getText()+",";;;}
			Calculate1 cal=new Calculate1();
	    	cal.a1=wifilimit.getText();
			Read4GUI read=new Read4GUI();
			Write4GUI writer=new Write4GUI();
			try {
				writer.targetlist=read.ReadeNoGPSCsv(line4algo2);
				writer.traininglist=new ArrayList<>(templist);
				writer.WriteLiner();
				textArea.append("\n RESULT(ALGO2 BY MACS:): \n");
				textArea.append("\n" +writer.resultalgo2_line+"\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			}
		});
    }
    public void recountlines(ArrayList<Wifi> list)
    {  
    	/**
    	 * recount lines of data
    	 */
    	int counter=1;
        int remember=1;
        if(templist.size()==0) {return;}
        remember=templist.get(0).getLine();
    	for(int i=0;i<templist.size();i++)
    	{
    		
    		if(templist.get(i).getLine()!=remember)
    		{remember=templist.get(i).getLine();counter++;templist.get(i).setLine(counter);}
    		if(templist.get(i).getLine()==remember)
    		{templist.get(i).setLine(counter);   }
    		
    	}
    }
    public static void checkfiles(GUI2 obj)
    {
    	/**
    	 * thread check files
    	 */
    	
    	
    	checkfiles4GUI detectfiles=new checkfiles4GUI(path+"\\"+loadfiles_folder.getText() , path+folder_csv46.getText(),obj);
		Thread dani=new Thread(detectfiles);
		dani.start();
		Checkdb4GUI detectfilesdb=new Checkdb4GUI(obj);
		Thread yosi=new Thread(detectfilesdb);
		yosi.start();
		
		
    }
    public void createtype()
    {
    	type="";
    	String no1="";
    	String no2="";
    	String mid="";
    	if(andtype.isSelected()) {mid="&";}
    	if(ortype.isSelected()) {mid="$";}
    	
    	if(not1.isSelected()) {no1="X";}
    	if(not2.isSelected()) {no2="X";}
    	
    	if(!FILTER1.getText().contains("A")&&!FILTER1.getText().contains("B")&&!FILTER1.getText().contains("C"))
    	{textArea.append("\n  YOU CAN ENTER ONLY LETTERS A/B/C ! TRY AGAIN\n");return;}  
    	if(!FILTER2.getText().contains("A")&&!FILTER2.getText().contains("B")&&!FILTER2.getText().contains("C"))
    	{textArea.append("\n  YOU CAN ENTER ONLY LETTERS A/B/C ! TRY AGAIN\n");return;}  
    	if(mid.equals("")) {textArea.append("\n  YOU need to choose or /and \n");;return;}
    	type=no1+FILTER1.getText()+mid+no2+FILTER2.getText();
    	textArea.append("\n"+type+"\n");
    }
    public void showfilter(History sample)
    {    
    	
    	
		
    	String []split= {"x"};
    	if (sample.type.contains("&"))
    	{split=sample.type.split("&");andtype.setSelected(true);}
    	if (sample.type.contains("$"))
    	{split=sample.type.split("\\$");ortype.setSelected(true);}
    	if(split[0].contains("A")) {FILTER1.setText("A");textid.setText(sample.getId());}
    	if(split[0].contains("B")) 
    	{FILTER1.setText("B");time_from.setText(sample.getHours1()+":"+sample.getMinutes1());
		time_to.setText(sample.getHours2()+":"+sample.getMinutes2());}
    	if(split[0].contains("C")) {FILTER1.setText("C");
    	point1.setText(sample.getLat1()+","+sample.getLot1());
		point2.setText(sample.getLat2()+","+sample.getLot2());}
    	if(split[1].contains("A")) 
    	{FILTER2.setText("A");textid.setText(sample.getId());}
    	if(split[1].contains("B")) 
    	{FILTER2.setText("B");time_from.setText(sample.getHours1()+":"+sample.getMinutes1());
		time_to.setText(sample.getHours2()+":"+sample.getMinutes2());}
    	if(split[1].contains("C")) 
    	{FILTER2.setText("C");
    	point1.setText(sample.getLat1()+","+sample.getLot1()+","+sample.hight1);
		point2.setText(sample.getLat2()+","+sample.getLot2()+","+sample.hight2);}
    	if(split[0].contains("X")) {not1.setSelected(true);}
    	if(!split[0].contains("X")) {not1.setSelected(false);}
    	if(split[1].contains("X")) {not2.setSelected(true);}
    	if(!split[1].contains("X")) {not2.setSelected(false);}
    	
    }
    public void loaddatabase(final GUI2 obj)
    {
    	/**
    	 * load the data base
    	 */
    	load_db.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loaddb=1;
				loadfiles=true;
				MySQL sq=new MySQL(obj);
				sq._ip=db_ip.getText();
				sq._password=db_passw.getText();
				sq._port=db_port.getText();
				sq._user=db_user.getText();
				sq._url="jdbc:mysql://"+sq._ip+":"+sq._port+"/oop_course_ariel";
		    	templist=sq.AddData(templist);
		    	printlist();
		    	status();
		    	checkfiles(obj1);
			}
		});
    	
    }

}


