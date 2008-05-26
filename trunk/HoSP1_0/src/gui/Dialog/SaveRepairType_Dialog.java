/**
 * @author Elena
 */
package gui.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SaveRepairType_Dialog extends JDialog {

	private JTextField txfName;
	private JLabel lblName;
	private JButton btnCancel;
	private JButton btnOk;

	private String name;

	// Creating object for inner class - Controller
	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public SaveRepairType_Dialog(JDialog owner, String title) {
		super();
		getContentPane().setLayout(null);
		setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(363, 164);
		this.setLayout(null);
		this.setModal(true);

		btnOk = new JButton();
		btnOk.addActionListener(controller);
		btnOk.setText("OK");
		btnOk.setBounds(25, 101, 106, 26);
		getContentPane().add(btnOk);

		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(205, 101, 106, 26);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(controller);

		lblName = new JLabel();
		lblName.setText("Enter name for new repair type:");
		lblName.setBounds(25, 10, 301, 16);
		getContentPane().add(lblName);

		txfName = new JTextField();
		txfName.setBounds(25, 48, 301, 20);
		getContentPane().add(txfName);

	}

	/**
	 * Check if OK button was pressed to close dialog.
	 * 
	 * @return boolean "true" if OK was clicked.
	 */
	public boolean isOK() {
		return controller.closedByOK;
	}

	/**
	 * Returns text of the name field
	 */
	public String getName() {
		return name;
	}

	private class Controller implements ActionListener {
		private boolean closedByOK = false;

		/*
		 * List of actions when buttons are pressed. (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * If OK button is pressed.
			 */
			if (e.getSource() == btnOk) {

				name = txfName.getText();
				// TODO error handling
				closedByOK = true;
				SaveRepairType_Dialog.this.setVisible(false);
			}
			/*
			 * If CANCEL button is pressed.
			 */
			if (e.getSource() == btnCancel) {
				SaveRepairType_Dialog.this.setVisible(false);
			}
		}
	}
}
