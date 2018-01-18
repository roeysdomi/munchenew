package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Reads.Read;
import Wifi.Wifi;

public class GUI_design extends GUI2 {
	
	public GUI2 ron;
	
	
	/**
	 * 
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
		separator4.setBounds(463, 169, 8, 191);
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
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(0, 441, 624, 4);
		frame.getContentPane().add(separator_10);
		
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
		frame.setBounds(100, 100, 650, 664);
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
		
		algo2_mac_1.setBounds(175, 490, 158, 19);
		frame.getContentPane().add(algo2_mac_1);
		
		
		algo2_mac_2.setBounds(175, 533, 158, 19);
		frame.getContentPane().add(algo2_mac_2);
		
		algo2_mac_3.setBounds(175, 571, 158, 19);
		frame.getContentPane().add(algo2_mac_3);
		
		
		algo2_lunch_macs.setBounds(398, 501, 128, 51);
		frame.getContentPane().add(algo2_lunch_macs);

		
		
		
		
		
		
		
		}
	
}
