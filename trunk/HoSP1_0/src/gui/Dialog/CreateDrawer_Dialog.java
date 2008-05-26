/**
 * This dialog creates new drawer and adds it to the system.
 * 
 * @author Elena
 */
package gui.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.Service;

import model.Drawer;

public class CreateDrawer_Dialog extends JDialog {

	private JButton btnCancel;
	private JButton btnCreate;
	private JLabel lblNrOfBox;
	private JTextField txtNrOfBox;
	private JLabel lblNumber;
	private JTextField txtNumber;

	// Creating object for inner class - Controller
	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public CreateDrawer_Dialog(JPanel owner, String title) {
		super();
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(254, 353);
		this.setLayout(null);
		this.setModal(true);

		txtNumber = new JTextField();
		txtNumber.setEditable(false);
		txtNumber.setBounds(10, 56, 174, 20);
		getContentPane().add(txtNumber);

		lblNumber = new JLabel();
		lblNumber.setText("Number:");
		lblNumber.setBounds(10, 36, 66, 16);
		getContentPane().add(lblNumber);

		txtNrOfBox = new JTextField();
		txtNrOfBox.setBounds(10, 109, 174, 20);
		getContentPane().add(txtNrOfBox);

		lblNrOfBox = new JLabel();
		lblNrOfBox.setText("Number of boxes:");
		lblNrOfBox.setBounds(10, 89, 174, 16);
		getContentPane().add(lblNrOfBox);

		btnCreate = new JButton();
		btnCreate.setText("Create");
		btnCreate.setBounds(10, 280, 106, 26);
		btnCreate.addActionListener(controller);
		getContentPane().add(btnCreate);

		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(136, 280, 106, 26);
		btnCancel.addActionListener(controller);
		getContentPane().add(btnCancel);
	}

	/**
	 * Method sets number of a new drawer.
	 * 
	 * @param nr
	 *            int, number for new drawer
	 */
	public void setDrawerNumber(int nr) {
		txtNumber.setText("" + nr);
	}

	/**
	 * Check if the "Create" button closed dialog.
	 */
	public boolean isCreate() {
		return controller.closedByCreate;
	}

	private class Controller implements ActionListener {
		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();

		// ...............................................//
		// Creating object for model class - Drawer
		private Drawer drawer = null;

		private boolean closedByCreate = false;

		/*
		 * List of actions when buttons are pressed. (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			/*
			 * If CREATE button is pressed.
			 */
			if (e.getSource() == btnCreate) {
				String nrStr = txtNrOfBox.getText().trim();

				// if there is nothing typed in...
				if (nrStr.length() == 0) {

					// ... error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					// Text of the error message:
					errorDialog.showMessage("Please enter ammount");

					// Waiting for error dialog to close

					// release MS Windows resources
					errorDialog.dispose();
					return;
				}

				// Initiate object for amount of boxes
				int nr = -1;

				// Check if it is a number typed in
				try {
					// If it's a number, value of "nr" is changed successfully
					nr = Integer.parseInt(nrStr);
				} catch (NumberFormatException ex) {
					// If it's not a number, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					// Text of the error message:
					errorDialog.setLblText("You must use numbers.");
					errorDialog.setVisible(true);

					// Waiting for error dialog to close

					// release MS Windows resources
					errorDialog.dispose();
					return;
				}

				if (nr < 0) {
					// If number entered is negative, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					// Text of the error message:
					errorDialog.setLblText("The ammount must bigger than 0.");
					errorDialog.setVisible(true);

					// Waiting for error dialog to close

					// release MS Windows resources
					errorDialog.dispose();
					return;
				}

				// New number of a drawer is the last number +1.
				int drawerNumber = service.getDrawers().get(
						service.getDrawers().size() - 1).getId() + 1;
				if (drawer == null) {
					service.addDrawer(new Drawer(drawerNumber, nr));
				}
				// new drawer is created.

				closedByCreate = true;
				CreateDrawer_Dialog.this.setVisible(false);
			}

			/*
			 * If CANCEL button is pressed.
			 */
			if (e.getSource() == btnCancel) {
				closedByCreate = false;
				CreateDrawer_Dialog.this.setVisible(false);
			}
		}
	}
}
