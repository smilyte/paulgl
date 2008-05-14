package gui.Dialog;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateSpartPart_Dialog extends JDialog {

	private JComboBox comboBox;
	private JTextField txfNumber,txfamount;
	private JLabel lbnumber,lbamunt;
	private JButton butcreate,butcancel;
	

	/**
	 * Create the dialog
	 */
	public CreateSpartPart_Dialog() {
		
		setTitle("Create New Spare Parts");
		setBounds(100, 100, 215, 322);

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

		JLabel lpboxnum = new JLabel();
		getContentPane().add(lpboxnum);
		lpboxnum.setText("Box Num:");

		comboBox = new JComboBox();
		getContentPane().add(comboBox);

		butcreate = new JButton();
		butcreate.setText("Create");
		getContentPane().add(butcreate);

		butcancel = new JButton();
		butcancel.setText("Cancel");
		getContentPane().add(butcancel);
		getContentPane().setLayout(new FlowLayout(20,20,50));
		//
	}

}