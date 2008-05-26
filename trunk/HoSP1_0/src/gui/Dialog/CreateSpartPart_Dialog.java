package gui.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Box;
import model.SparePart;

import service.Service;

public class CreateSpartPart_Dialog extends JDialog {

	private JButton btnCancel;
	private JButton btnCreate;
	private JComboBox cbxBox;
	private JComboBox cbxDrawer;
	private JTextField txfAmount;
	private JTextField txfNumber;
	private JLabel lblBox;
	private JLabel lblDrawer;
	private JLabel lblAmount;
	private JLabel lblNumber;

	// Creating object for inner class - Controller
	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public CreateSpartPart_Dialog(JPanel owner, String title) {
		super();
		getContentPane().setLayout(null);
		setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(254, 271);
		this.setLayout(null);
		this.setModal(true);

		lblNumber = new JLabel();
		lblNumber.setText("Number:");
		lblNumber.setBounds(10, 10, 66, 16);
		getContentPane().add(lblNumber);

		lblAmount = new JLabel();
		lblAmount.setText("Amount:");
		lblAmount.setBounds(10, 58, 66, 16);
		getContentPane().add(lblAmount);

		lblDrawer = new JLabel();
		lblDrawer.setText("Drawer:");
		lblDrawer.setBounds(10, 124, 66, 16);
		getContentPane().add(lblDrawer);

		lblBox = new JLabel();
		lblBox.setText("Box:");
		lblBox.setBounds(10, 155, 66, 16);
		getContentPane().add(lblBox);

		txfNumber = new JTextField();
		txfNumber.setBounds(10, 32, 228, 20);
		getContentPane().add(txfNumber);

		txfAmount = new JTextField();
		txfAmount.setBounds(10, 80, 228, 20);
		getContentPane().add(txfAmount);

		cbxDrawer = new JComboBox();
		cbxDrawer.setBounds(82, 120, 156, 25);
		cbxDrawer.addActionListener(controller);
		getContentPane().add(cbxDrawer);

		cbxBox = new JComboBox();
		cbxBox.setBounds(82, 151, 156, 25);
		cbxBox.addActionListener(controller);
		getContentPane().add(cbxBox);

		btnCreate = new JButton();
		btnCreate.setText("Create");
		btnCreate.setBounds(10, 203, 106, 26);
		btnCreate.addActionListener(controller);
		getContentPane().add(btnCreate);

		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(132, 203, 106, 26);
		btnCancel.addActionListener(controller);
		getContentPane().add(btnCancel);

		controller.fillCbxDrawer();
	}

	/**
	 * Check if the "Create" button closed dialog. Returns "true", if yes.
	 */
	public boolean isCreate() {
		return controller.closedByCreate;
	}

	private class Controller implements ActionListener {
		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();

		// ...............................................//
		// Creating object for model class - SparePart
		private SparePart sparePart = null;

		private boolean closedByCreate = false;

		/**
		 * Fills cbxDrawer with Drawer list
		 */
		public void fillCbxDrawer() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getDrawers().toArray());
			cbxDrawer.setModel(cbxModel);
			cbxDrawer.setSelectedIndex(0);
		}

		/**
		 * Fills cbxBox with Box list
		 */
		public void fillCbxBox() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getDrawers().get(cbxDrawer.getSelectedIndex()).getBoxes()
					.toArray());
			cbxBox.setModel(cbxModel);
			cbxBox.setSelectedIndex(0);
		}

		/*
		 * List of actions when buttons are pressed. (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			/*
			 * If CREATE button is pressed.
			 */
			if (e.getSource() == btnCreate) {
				// Checking if data in "number" field is valid.
				String numberStr = txfNumber.getText().trim();
				// if there is nothing typed in or it's not a 7 digit number...
				if (numberStr.length() != 7) {
					// ... error message is displayed
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog
							.showMessage("Pleaste type in 7 digit number for spare part.");
					return;
				}
				// Check if it is a number typed in
				int number = -1;
				try {
					// If it's a number, value of "amount" is changed
					// successfully
					number = Integer.parseInt(numberStr);
				} catch (NumberFormatException ex) {
					// If it's not a number, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog
							.showMessage("Please enter number of spare parts in digits.");
					return;
				}
				// checking if data in "amount" field is valid.
				String amountStr = txfAmount.getText().trim();
				// if there is nothing typed in...
				if (amountStr.length() == 0 || amountStr.length() > 7) {

					// ... show error message
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog
							.showMessage("Please specify amount of new spare parts.");
					return;
				}
				// Initiate object for amount of this part
				int amount = -1;
				// Check if it is a number typed in
				try {
					// If it's a number, value of "amount" is changed
					// successfully
					amount = Integer.parseInt(amountStr);
				} catch (NumberFormatException ex) {
					// If it's not a number, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("Please enter amount in numbers.");
					return;
				}
				if (amount < 0) {
					// If number entered is negative, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("The ammount must bigger than 0.");
					return;
				}
				Box bx = service.getDrawers().get(cbxDrawer.getSelectedIndex())
						.getBoxes().get(cbxBox.getSelectedIndex());
				if (bx.getSparePart() != null) {
					// If box is not empty, display error.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog
							.showMessage("This box is not empty. Please select empty box.");
					return;
				} else {
					if (sparePart == null) {
						service.addSparePart(new SparePart(amount, number, bx));
					}
				}

				// new Spare part is created.

				closedByCreate = true;
				CreateSpartPart_Dialog.this.setVisible(false);
			}
			/*
			 * If CANCEL button is pressed.
			 */
			if (e.getSource() == btnCancel) {
				CreateSpartPart_Dialog.this.setVisible(false);
			}
			/*
			 * If DRAWER in the list was selected.
			 */
			if (e.getSource() == cbxDrawer) {
				fillCbxBox();
			}
		}
	}
}