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
import java.awt.TextField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.Checkbox;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
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

public class GUI2 {
	
	String type; 
	String foldername;
	boolean loadfiles=false;
	int startwith =0; 
	public ArrayList<Wifi> templist=new ArrayList<>();

    public int counter=0;
	public static JFrame frame;
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

	///--------text input------------------
	final TextField textid = new TextField();
	final TextField time_from = new TextField();
	final TextField time_to = new TextField();
	final TextField point1 = new TextField();
	final TextField point2 = new TextField();
	final TextField loadfiles_folder = new TextField();
	final TextField wiglefiletext = new TextField();
	final TextField folder_csv46 = new TextField();
	final TextField file_csv46 = new TextField();
	final TextField mac_algo1 = new TextField();
	final TextField algo2_line = new TextField();

	public final static TextField wifilimit = new TextField();


	//--------filter checkbox------------
	final JRadioButton ortype = new JRadioButton("OR");
	final JRadioButton andtype = new JRadioButton("AND");
	final JRadioButton checkbox1 = new JRadioButton("");
	final JRadioButton checkbox2 = new JRadioButton("");
	final JRadioButton checkbox3 = new JRadioButton("");
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GUI2() throws IOException {
		Design();
		Design2();
		loadwigle();
		lunchbutton();
		filtertype();
		goback();
		reset();
		load46col();
		savefilter();
		loadsavedfilter();
		saved46col();
		savetokml();
		lunchalgo1();
		lunchalgo2line();
		
		
		
	}
    
	/**
	 * Initialize the contents of the frame.
	 */
	//--------DESGIN----
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
		separator3.setBounds(357, 199, 8, 161);
		frame.getContentPane().add(separator3);
		
		JSeparator separator4 = new JSeparator();
		separator4.setOrientation(SwingConstants.VERTICAL);
		separator4.setForeground(new Color(192, 192, 192));
		separator4.setBounds(463, 199, 8, 161);
		frame.getContentPane().add(separator4);
		
		JLabel lblType = DefaultComponentFactory.getInstance().createLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblType.setBounds(140, 51, 92, 23);
		frame.getContentPane().add(lblType);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(140, 162, 465, 14);
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
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(0, 33, 128, 14);
		frame.getContentPane().add(separator_7);
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(0, 364, 624, 14);
		frame.getContentPane().add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(0, 412, 624, 4);
		frame.getContentPane().add(separator_9);
		
		JLabel lblLoadFiles = DefaultComponentFactory.getInstance().createLabel("LOAD FILES :");
		lblLoadFiles.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoadFiles.setBounds(140, 174, 92, 14);
		frame.getContentPane().add(lblLoadFiles);
		
		
		
		JLabel lblLog = DefaultComponentFactory.getInstance().createLabel("LOG:");
		lblLog.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLog.setBounds(292, 0, 84, 23);
		frame.getContentPane().add(lblLog);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(140, 51, 142, 17);
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
		frame.setBounds(100, 100, 650, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		textArea.setBounds(0, 2, 128, 4);
		frame.getContentPane().add(textArea);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(283, 26, 341, 132);
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
		
		JLabel lblLat = DefaultComponentFactory.getInstance().createLabel(" Point1  (ex: Lat,Lot )");
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

		
		
		checkbox1.setBounds(45, 79, 29, 14);
		frame.getContentPane().add(checkbox1);
		checkbox2.setBackground(UIManager.getColor("Button.background"));
		//-------בחירת זמן
		checkbox2.setBounds(104, 153, 18, 23);
		frame.getContentPane().add(checkbox2);
		//----------בחירת מיקום
		
		checkbox3.setBounds(70, 258, 23, 23);
		frame.getContentPane().add(checkbox3);
		MACNUM.setBounds(175, 10, 72, 23);
		frame.getContentPane().add(MACNUM);
		WIFINUM.setBounds(200, 36, 68, 11);
		frame.getContentPane().add(WIFINUM);
		counthis.setFont(new Font("Eras Bold ITC", Font.PLAIN, 14));
		counthis.setBounds(105, 10, 23, 17);
		frame.getContentPane().add(counthis);
			/////-------------פתור לאנץ'---------------
	
	    ///--------type button--------

		
		
		
		
		
		
		
		
		}
	
	///--------function----
    public void filtertype()
	{
		ortype.setBounds(140, 75, 49, 23);
		frame.getContentPane().add(ortype);
		
		andtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ortype.setSelected(false);
				type="and";

			}
		});
		andtype.setBounds(191, 75, 49, 23);
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
		lunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loadfiles)
				{
				Filterfunc fe=new Filterfunc();
				textArea.append("start \n");
				
				
				fe.statusbox(checkbox1.isSelected(), checkbox2.isSelected(), checkbox3.isSelected());
				if(checkbox1.isSelected())
				{ String idbox=textid.getText(); fe.setId(idbox);}
				if(checkbox2.isSelected())
				{ 
					String from=time_from.getText();
					String to=time_to.getText();
					fe.setfrom(from);
					fe.setto(to);
				}
				if(checkbox3.isSelected())
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
				if(ortype.isSelected()) {type="or";}
				if(andtype.isSelected()) {type="and";}

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
		lunch.setBounds(151, 100, 89, 51);
		frame.getContentPane().add(lunch);
	}
	public void loadwigle()
	{
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadfiles=true;
				startwith=1;
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
					if(sample.type.equals("or")) {andtype.setSelected(false);ortype.setSelected(true);type="or";}
					if(sample.type.equals("and")) {ortype.setSelected(false);andtype.setSelected(true);type="and";}
					if(sample.choosenbox.contains("A")){checkbox1.setSelected(true);textid.setText(sample.getId());}
					if(sample.choosenbox.contains("B"))
					{
						checkbox2.setSelected(true);
						time_from.setText(sample.getHours1()+":"+sample.getMinutes1());
						time_to.setText(sample.getHours2()+":"+sample.getMinutes2());
					}
					if(sample.choosenbox.contains("C"))
					{
						checkbox3.setSelected(true);
						point1.setText(sample.getLat1()+","+sample.getLot1());
						point2.setText(sample.getLat2()+","+sample.getLot2());
					}
					if(!sample.choosenbox.contains("A")){checkbox1.setSelected(false);textid.setText("");}
					if(!sample.choosenbox.contains("B")){checkbox2.setSelected(false);time_from.setText("");time_to.setText("");}
					if(!sample.choosenbox.contains("C")){checkbox3.setSelected(false);
					point1.setText("");
					point2.setText("");
					}
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
		
		
		resetbutton.setBounds(518, 0, 116, 24);
		frame.getContentPane().add(resetbutton);
		
		JLabel lblCsvCo = DefaultComponentFactory.getInstance().createLabel("csv (46 col Format)");
		lblCsvCo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCsvCo.setBounds(256, 193, 116, 20);
		frame.getContentPane().add(lblCsvCo);
		
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
		
		
		
		load_filter.setBounds(369, 192, 84, 154);
		frame.getContentPane().add(load_filter);
		
		JLabel lblSaveFile = new JLabel("SAVE FILE:");
		lblSaveFile.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSaveFile.setBounds(463, 174, 71, 14);
		frame.getContentPane().add(lblSaveFile);
		
		
		savefilter.setBounds(473, 199, 151, 39);
		frame.getContentPane().add(savefilter);
		
		
		save_csv46.setBounds(472, 244, 152, 43);
		frame.getContentPane().add(save_csv46);
		
		
		
		savekml.setBounds(473, 299, 151, 40);
		frame.getContentPane().add(savekml);
    	
    }
    public void status()
    {
    	Count co=new Count();
    	MACNUM.setText(String.valueOf(co.countmacs(templist)));
    	WIFINUM.setText(String.valueOf(templist.size()));
    }
    public void reset()
    {   
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
		    	checkbox1.setSelected(false);
		    	checkbox2.setSelected(false);
		    	checkbox3.setSelected(false);
		    	WIFINUM.setText("0");
		    	MACNUM.setText("0");
		    	counthis.setText("0");
		    	counter=0;
			}
		});


    }
    public void resetandload()
    {
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
    	checkbox1.setSelected(false);
    	checkbox2.setSelected(false);
    	checkbox3.setSelected(false);
    	
    	/////-------------------
    	if(startwith==1) {
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
    	if(startwith==2)
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
    	printlist();

    }
    public void printlist()
    {
    	for(int i=0;i<templist.size();i++)
		{
			textArea.append(
					templist.get(i).getDeviceid()+
					","+templist.get(i).getTime()+
					","+templist.get(i).getLat()+
					","+templist.get(i).getLot()+
					 "\n");
		}
    }
    public void load46col()
    {
    	folder_csv46.setText("INPUT\\target\\");
		file_csv46.setText("_comb_all_BM2_.csv");
		load_csv46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				printlist();
			}
		});
		
		load_csv46.setBounds(258, 320, 89, 33);
		frame.getContentPane().add(load_csv46);
		
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

    	
    }
    public void savefilter() throws IOException
    {
    	
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
    	load_filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Read4GUI re=new Read4GUI();
		    	
		    	try {
					his=re.Readsavedfilter(his);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	if(his.type.equals("or")) {ortype.setSelected(true);andtype.setSelected(false);}
		    	if(his.type.equals("and")) {andtype.setSelected(true);ortype.setSelected(false);}
		    	
		    	if(his.choosenbox.contains("A"))
		    	{checkbox1.setSelected(true);textid.setText(his.id);}
		    	if(his.choosenbox.contains("B"))
		    	{checkbox2.setSelected(true);time_from.setText(his.hours1+":"+his.minutes1);time_to.setText(his.hours2+":"+his.minutes2);;}
		    	if(his.choosenbox.contains("C"))
		    	{checkbox3.setSelected(true);point1.setText(his.lat1+","+his.lot1);point2.setText(his.lat2+","+his.lot2);;}
		    	////----not-------
		    	if(!his.choosenbox.contains("A"))
		    	{checkbox1.setSelected(false);textid.setText("");}
		    	if(!his.choosenbox.contains("B"))
		    	{checkbox2.setSelected(false);time_from.setText("");time_to.setText("");;}
		    	if(!his.choosenbox.contains("C"))
		    	{checkbox3.setSelected(false);point1.setText("");point2.setText("");;}
				
			}
		});
    	
    }
    public void saved46col()
    {
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
    {   mac_algo1.setText("90:6c:ac:a0:3d:eb");
    	wifilimit.setText("5");
    	Calculate1 cal=new Calculate1();
    	cal.a1=wifilimit.getText();
    	lunch_algo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Write4GUI re=new Write4GUI();
				String mac= mac_algo1.getText();
				
				
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
    {     algo2_line.setText("12/05/17 11:41 AM,model=SM-G950F_device=dreamlte,?,?,?,1,Guest,90:6c:ac:a0:3d:eb,3,-76");
    	lunch_aglo2_line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String line=algo2_line.getText();
				Read4GUI read=new Read4GUI();
				Write4GUI writer=new Write4GUI();
				try {
					writer.targetlist=read.ReadeNoGPSCsv(line);
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

}


