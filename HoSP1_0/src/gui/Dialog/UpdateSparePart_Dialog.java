/**
 * @author Elena
 */
package gui.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Box;
import model.Drawer;
import model.SparePart;
import service.Service;

public class UpdateSparePart_Dialog extends JDialog {

	private JCheckBox checkBox;
	private JLabel lblBox;
	private JLabel lblDrawer;
	private JComboBox cbxDrawer;
	private JComboBox cbxBox;
	private JLabel lblMovePart;
	private JButton btnCancel;
	private JButton btnUpdate;
	private JTextField txfNewAmount;
	private JTextField txfAmount;
	private JLabel lblNewPartsArrived;
	private JLabel lblCurrent;

	// Creating object for inner class - Controller
	private Controller controller = new Controller();
	// Creating object for model class - Spare Part
	private SparePart sparePart = null;

	// .............GETTING INSTANCE..................//
	private Service service = Service.getInstance();

	// ...............................................//

	/**
	 * Create the dialog
	 */
	public UpdateSparePart_Dialog(JPanel owner, String title) {
		super();
		getContentPane().setLayout(null);
		setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(256, 336);
		this.setLayout(null);
		this.setModal(true);

		lblCurrent = new JLabel();
		lblCurrent.setText("Current amount:");
		lblCurrent.setBounds(10, 22, 228, 16);
		getContentPane().add(lblCurrent);

		lblNewPartsArrived = new JLabel();
		lblNewPartsArrived.setText("New parts arrived:");
		lblNewPartsArrived.setBounds(10, 70, 111, 16);
		getContentPane().add(lblNewPartsArrived);

		txfAmount = new JTextField();
		txfAmount.setEditable(false);
		txfAmount.setBounds(10, 44, 228, 20);
		getContentPane().add(txfAmount);

		txfNewAmount = new JTextField();
		txfNewAmount.setBounds(10, 92, 228, 20);
		getContentPane().add(txfNewAmount);

		btnUpdate = new JButton();
		btnUpdate.setText("Update");
		btnUpdate.setBounds(10, 259, 106, 26);
		btnUpdate.addActionListener(controller);
		getContentPane().add(btnUpdate);

		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(132, 259, 106, 26);
		btnCancel.addActionListener(controller);
		getContentPane().add(btnCancel);

		lblMovePart = new JLabel();
		lblMovePart.setText("Move Part?");
		lblMovePart.setBounds(10, 118, 78, 16);
		getContentPane().add(lblMovePart);

		cbxBox = new JComboBox();
		cbxBox.setBounds(10, 215, 228, 25);
		cbxBox.addActionListener(controller);
		getContentPane().add(cbxBox);

		cbxDrawer = new JComboBox();
		cbxDrawer.setBounds(10, 162, 228, 25);
		cbxDrawer.addActionListener(controller);
		getContentPane().add(cbxDrawer);

		lblDrawer = new JLabel();
		lblDrawer.setText("Drawer:");
		lblDrawer.setBounds(10, 140, 66, 16);
		getContentPane().add(lblDrawer);

		lblBox = new JLabel();
		lblBox.setText("Box:");
		lblBox.setBounds(10, 193, 66, 16);
		getContentPane().add(lblBox);

		checkBox = new JCheckBox();
		checkBox.setBounds(94, 114, 118, 24);
		checkBox.addItemListener(controller);
		getContentPane().add(checkBox);

		// Calling methods from Controller class
		controller.fillCbxDrawer();
	}

	/**
	 * Check if the "Create" button closed dialog. Returns "true", if yes.
	 */
	public boolean isUpdated() {
		return controller.closedByUpdate;
	}

	/**
	 * Sets data in "Current amount" field.
	 */
	public void setAmount(int amount) {
		txfAmount.setText("" + amount);
	}

	/**
	 * Sets spare part to update.
	 */
	public void setSparePart(SparePart sparePart) {
		this.sparePart = sparePart;
		Drawer d = sparePart.getBox().getDrawer();
		int drawerIndex = service.getDrawers().indexOf(d);
		cbxDrawer.setSelectedIndex(drawerIndex);
		cbxBox.setSelectedIndex(sparePart.getBox().getDrawer().getBoxes()
				.indexOf(sparePart.getBox()));
	}

	private class Controller implements ActionListener, ItemListener {
		private boolean closedByUpdate = false;
		private boolean selected = false;

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

		/**
		 * Fills cbxDrawer with Drawer list
		 */
		public void fillCbxDrawer() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getDrawers().toArray());
			cbxDrawer.setModel(cbxModel);
			cbxDrawer.setSelectedIndex(0);
		}

		/*
		 * List of actions when buttons are pressed. (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * If UPDATE button is pressed.
			 */
			if (e.getSource() == btnUpdate) {
				// checking if data in "amount" field is valid.
				String amountStr = txfNewAmount.getText().trim();
				// if there is nothing typed in...
				if (amountStr.length() == 0) {
					// ... show error message
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog
							.showMessage("Please specify amount of spare parts arrived.");
					return;
				}
				// Initiate object for new amount of this part
				int newAmount = -1;
				// Check if it is a number typed in
				try {
					// If it's a number, value of "amount" is changed
					// successfully
					newAmount = Integer.parseInt(amountStr);
				} catch (NumberFormatException ex) {
					// If it's not a number, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("Please enter amount in numbers.");
					return;
				}
				if (newAmount < 0) {
					// If number entered is negative, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("The ammount must bigger than 0.");
					return;
				}

				// Gets information, where to move part(if needed).
				Box box = null;
				if (selected) {
					box = (Box) cbxBox.getSelectedItem();

					if (box.getSparePart() != null) {
						// If box is not empty, error message appears.
						ErrorDialog errorDialog = new ErrorDialog("Error!");
						errorDialog
								.showMessage("This box is not empty. Select another box.");
						return;
					}
				}
				if (sparePart != null) {
					service.updateSparePart(sparePart, 0, newAmount, null, box);
				}

				// Spare part is updated.

				closedByUpdate = true;
				UpdateSparePart_Dialog.this.setVisible(false);
			}
			/*
			 * If CANCEL button is pressed.
			 */
			if (e.getSource() == btnCancel) {
				UpdateSparePart_Dialog.this.setVisible(false);
			}
			/*
			 * If DRAWER in the list was selected.
			 */
			if (e.getSource() == cbxDrawer) {
				fillCbxBox();
			}
		}

		/*
		 * List of actions when Check Box items state is changed
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {
			/*
			 * If CheckBox was CHECHED.
			 */
			if (e.getSource() == checkBox) {
				selected = true;
			}
			/*
			 * If CheckBox was UNCHECHED.
			 */
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				selected = false;
			}
		}
	}
}
