/**
 * 
 */
package gui.Dialog;

import gui.MachinePanel;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author V
 *
 */
public class CreateMachine_Dialog extends JDialog {
	private JTextField txfNumber;
	private JLabel lbnumber;
	private JButton butOk,butcancel;
	
	/**
	 * Create the dialog
	 */
	public CreateMachine_Dialog(JPanel owner, String string) {
	super();
	setTitle(string);
	setBounds(100, 100, 212, 255);
	getContentPane().setLayout(new FlowLayout(10,10,20));
	//
	lbnumber = new JLabel();
	lbnumber.setText("Serial Number:");
	getContentPane().add(lbnumber);

	txfNumber = new JTextField();
	txfNumber.setPreferredSize(new Dimension(100, 20));
	txfNumber.setToolTipText("Type Serial Number for the Machine");
	getContentPane().add(txfNumber);

	butOk = new JButton();
	butOk.setText("Ok");
	getContentPane().add(butOk);

	butcancel = new JButton();
	butcancel.setText("Cancel");
	getContentPane().add(butcancel);
	}


}
