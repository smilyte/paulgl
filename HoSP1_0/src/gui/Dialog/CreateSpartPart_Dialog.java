package gui.Dialog;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateSpartPart_Dialog extends JDialog {

	private JComboBox cbBoxNr,cbDrawNr;
	private JTextField txfNumber,txfamount;
	private JLabel lbnumber,lbamunt;
	private JButton butcreate,butcancel;
	
	/**
	 * Create the dialog
	 */
	public CreateSpartPart_Dialog() {
		
		setTitle("Create New Spare Parts");
		setBounds(100, 100, 212, 286);
		getContentPane().setLayout(new FlowLayout(10,10,20));
		//
		lbnumber = new JLabel();
		lbnumber.setText("Number:");
		getContentPane().add(lbnumber);

		txfNumber = new JTextField();
		txfNumber.setPreferredSize(new Dimension(100, 20));
		txfNumber.setToolTipText("Please insert the 7 diget number of the Spare part");
		getContentPane().add(txfNumber);

		lbamunt = new JLabel();
		lbamunt.setText("Amount:");
		getContentPane().add(lbamunt);

		txfamount = new JTextField();
		txfamount.setPreferredSize(new Dimension(100, 20));
		getContentPane().add(txfamount);

		JLabel lbboxnNr = new JLabel();
		getContentPane().add(lbboxnNr);
		lbboxnNr.setText("Box Nr:");

		cbBoxNr = new JComboBox();
		getContentPane().add(cbBoxNr);

		JLabel lbdrawNr = new JLabel();
		lbdrawNr.setText("Draw Nr:");
		getContentPane().add(lbdrawNr);

		cbDrawNr = new JComboBox();
		getContentPane().add(cbDrawNr);

		butcreate = new JButton();
		butcreate.setText("Create");
		getContentPane().add(butcreate);

		butcancel = new JButton();
		butcancel.setText("Cancel");
		getContentPane().add(butcancel);
		
	}

}