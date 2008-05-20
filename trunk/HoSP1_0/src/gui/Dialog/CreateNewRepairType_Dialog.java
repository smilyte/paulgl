package gui.Dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import service.Service;

public class CreateNewRepairType_Dialog extends JDialog {
	private JList list_1;
	private JTextField txfname, txfamount;
	private JComboBox cbSparePart;
	private JButton butadd, butremove, butok, butcancel;
	private JLabel lbname, lbamount, lbsparePart, lbaddedSparePart;

	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public CreateNewRepairType_Dialog() {

		setBounds(100, 100, 251, 416);
		getContentPane().setLayout(null);
		setTitle("Create New Repair Type");

		lbname = new JLabel();
		lbname.setText("Name:");
		lbname.setBounds(10, 34, 54, 14);
		getContentPane().add(lbname);

		txfname = new JTextField();
		txfname.setBounds(85, 30, 134, 20);
		getContentPane().add(txfname);

		lbsparePart = new JLabel();
		lbsparePart.setText("Spare Part:");
		lbsparePart.setBounds(10, 54, 57, 20);
		getContentPane().add(lbsparePart);

		cbSparePart = new JComboBox();
		cbSparePart.setBounds(85, 56, 134, 20);
		getContentPane().add(cbSparePart);

		lbamount = new JLabel();
		lbamount.setText("Amount:");
		lbamount.setBounds(10, 80, 54, 14);
		getContentPane().add(lbamount);

		txfamount = new JTextField();
		txfamount.setBounds(85, 82, 134, 20);
		getContentPane().add(txfamount);

		butadd = new JButton();
		butadd.setText("Add");
		butadd.setBounds(86, 121, 54, 23);
		getContentPane().add(butadd);

		butremove = new JButton();
		butremove.setText("Remove");
		butremove.setBounds(146, 121, 73, 23);
		getContentPane().add(butremove);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 150, 209, 2);
		getContentPane().add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 209, 128);
		getContentPane().add(scrollPane);

		list_1 = new JList();
		scrollPane.setViewportView(list_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 319, 209, 14);
		getContentPane().add(separator_1);

		butok = new JButton();
		butok.setText("OK");
		butok.setBounds(10, 339, 93, 23);
		getContentPane().add(butok);
		butok.addActionListener(controller);

		butcancel = new JButton();
		butcancel.setText("Cancel");
		butcancel.setBounds(126, 339, 93, 23);
		getContentPane().add(butcancel);

		lbaddedSparePart = new JLabel();
		lbaddedSparePart.setText("Added Spare Part:");
		lbaddedSparePart.setBounds(10, 165, 93, 14);
		getContentPane().add(lbaddedSparePart);
	}

	private class Controller implements ActionListener {
		private Service service = Service.getInstance();

		public void actionPerformed(ActionEvent e) {

			{

			}
		}
	}
}
