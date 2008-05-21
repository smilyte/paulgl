package gui.Dialog;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateSpartPart_Dialog extends JDialog {

	private JComboBox cbBoxNr,cbDrawNr;
	private JTextField txfNumber,txfamount;
	private JLabel lbnumber,lbamunt;
	private JButton butcreate,butcancel;
	
	/**
	 * Create the dialog
	 * @param string 
	 * @param  
	 */
	public CreateSpartPart_Dialog(JPanel owner, String title) {
		super();
		getContentPane().setLayout(null);
		//setTitle("Create New Spare Parts");
		//setBounds(100, 100, 212, 255);
		//getContentPane().setLayout(new FlowLayout(10,10,20));
		//getContentPane().setLayout(null);
		setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(254, 353);
		//this.setLayout(null);
		this.setModal(true);
		
		

		//
		lbnumber = new JLabel();
		lbnumber.setBounds(0, 0, 0, 0);
		lbnumber.setText("Number:");
		getContentPane().add(lbnumber);

		txfNumber = new JTextField();
		txfNumber.setBounds(-10000, 0, 100, 20);
		txfNumber.setPreferredSize(new Dimension(100, 20));
		txfNumber.setToolTipText("Please insert the 7 diget number of the Spare part");
		getContentPane().add(txfNumber);

		lbamunt = new JLabel();
		lbamunt.setBounds(0, 0, 0, 0);
		lbamunt.setText("Amount:");
		getContentPane().add(lbamunt);

		txfamount = new JTextField();
		txfamount.setBounds(-10000, 0, 100, 20);
		txfamount.setPreferredSize(new Dimension(100, 20));
		getContentPane().add(txfamount);

		JLabel lbdrawNr = new JLabel();
		lbdrawNr.setBounds(0, 0, 0, 0);
		getContentPane().add(lbdrawNr);
		lbdrawNr.setText("Draw Nr:");

		cbDrawNr = new JComboBox();
		cbDrawNr.setBounds(0, 0, 0, 0);
		getContentPane().add(cbDrawNr);

		JLabel lbboxnNr = new JLabel();
		lbboxnNr.setBounds(0, 0, 0, 0);
		getContentPane().add(lbboxnNr);
		lbboxnNr.setText("Box Nr  :");

		cbBoxNr = new JComboBox();
		cbBoxNr.setBounds(0, 0, 0, 0);
		getContentPane().add(cbBoxNr);

		butcreate = new JButton();
		butcreate.setBounds(0, 0, 0, 0);
		butcreate.setText("Create");
		getContentPane().add(butcreate);

		butcancel = new JButton();
		butcancel.setBounds(0, 0, 248, 326);
		butcancel.setText("Cancel");
		getContentPane().add(butcancel);
		
	}

}