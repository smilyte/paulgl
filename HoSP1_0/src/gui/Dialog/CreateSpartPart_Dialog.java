package gui.Dialog;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateSpartPart_Dialog extends JDialog {

	private JTextField txfNumber,txfamount;
	private JLabel lbnumber,lbamunt;
	private JButton butcreate,butcancel;
	

	/**
	 * Create the dialog
	 */
	public CreateSpartPart_Dialog() {
		
		setTitle("Create New Spare Parts");
		getContentPane().setLayout(null);
		setBounds(100, 100, 265, 229);

		lbnumber = new JLabel();
		lbnumber.setText("Number:");
		lbnumber.setBounds(10, 51, 54, 14);
		getContentPane().add(lbnumber);

		txfNumber = new JTextField();
		txfNumber.setToolTipText("Please insert the 7 diget number of the Spare part");
		txfNumber.setBounds(70, 48, 120, 20);
		getContentPane().add(txfNumber);

		lbamunt = new JLabel();
		lbamunt.setText("Amount:");
		lbamunt.setBounds(10, 87, 54, 14);
		getContentPane().add(lbamunt);

		txfamount = new JTextField();
		txfamount.setBounds(70, 84, 120, 20);
		getContentPane().add(txfamount);

		butcreate = new JButton();
		butcreate.setText("Create");
		butcreate.setBounds(47, 149, 93, 23);
		getContentPane().add(butcreate);

		butcancel = new JButton();
		butcancel.setText("Cancel");
		butcancel.setBounds(146, 149, 93, 23);
		getContentPane().add(butcancel);
		//
	}

}
