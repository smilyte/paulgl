package gui.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateMachineType_Dialog extends JDialog {

	private JButton btnCancel;
	private JButton btnCreate;
	private JButton btnBrowse;
	private JLabel lblDrawing;
	private JTextField txtDrawing;
	private JLabel lblName;
	private JTextField txtName;
	
	/**
	 * Create the dialog
	 */
	public CreateMachineType_Dialog(JFrame owner, String title) {
		super(owner);
		getContentPane().setLayout(null);
		setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(254, 353);
		this.setLayout(null);
		this.setModal(true);

		txtName = new JTextField();
		txtName.setBounds(10, 56, 174, 20);
		getContentPane().add(txtName);

		lblName = new JLabel();
		lblName.setText("Name:");
		lblName.setBounds(10, 36, 66, 16);
		getContentPane().add(lblName);

		txtDrawing = new JTextField();
		txtDrawing.setBounds(10, 109, 174, 20);
		getContentPane().add(txtDrawing);

		lblDrawing = new JLabel();
		lblDrawing.setText("Drawing:");
		lblDrawing.setBounds(10, 89, 66, 16);
		getContentPane().add(lblDrawing);

		btnBrowse = new JButton();
		btnBrowse.setText("Browse...");
		btnBrowse.setBounds(10, 135, 87, 20);
		getContentPane().add(btnBrowse);

		btnCreate = new JButton();
		btnCreate.setText("Create");
		btnCreate.setBounds(10, 280, 106, 26);
		getContentPane().add(btnCreate);

		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(136, 280, 106, 26);
		getContentPane().add(btnCancel);

	}

	@SuppressWarnings("unused")
	private class Controller implements ActionListener {

		// This method is called when a button is pressed.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCreate) {

			}
			if (e.getSource() == btnCancel) {

			}
		}
	}
}
