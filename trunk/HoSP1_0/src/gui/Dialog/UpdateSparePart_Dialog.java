package gui.Dialog;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class UpdateSparePart_Dialog extends JDialog {

	private JTextField txfamont;
	private JButton butupdate,butcancel;
	private JLabel lbamount;
	/**
	 * Create the dialog
	 */
	public UpdateSparePart_Dialog() {
		setTitle("Update Spare Part");
		setBounds(100, 100, 384, 99);
		getContentPane().setLayout(new FlowLayout(20,10,25));

		lbamount = new JLabel();
		lbamount.setText("Amount:");
		getContentPane().add(lbamount);

		txfamont = new JTextField();
		txfamont.setPreferredSize(new Dimension(150, 25));
		getContentPane().add(txfamont);

		butupdate = new JButton();
		butupdate.setText("Update");
		getContentPane().add(butupdate);

		butcancel = new JButton();
		butcancel.setText("Cancel");
		getContentPane().add(butcancel);
		setResizable(false);
		
	}

}
