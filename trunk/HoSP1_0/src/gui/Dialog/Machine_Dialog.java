/**
 * @author Vytas
 * 
 */
package gui.Dialog;

import java.awt.Dimension;
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

import model.*;

import service.Service;


public class Machine_Dialog extends JDialog {
	private JLabel lblMachineType;
	private JComboBox cbxMachineTypes;
	private JTextField txfNumber;
	private JLabel lblNnumber;
	private JButton btnOk, btnCancel;

	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public Machine_Dialog(JPanel owner, String title) {
		super();
		getContentPane().setLayout(null);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(162, 215);
		this.setLayout(null);
		this.setModal(true);
		this.setResizable(false);
		//
		lblNnumber = new JLabel();
		lblNnumber.setBounds(10, 62, 126, 16);
		lblNnumber.setText("Serial Number:");
		getContentPane().add(lblNnumber);

		txfNumber = new JTextField();
		txfNumber.setBounds(10, 82, 126, 20);
		txfNumber.setPreferredSize(new Dimension(100, 20));
		txfNumber.setToolTipText("Type Serial Number for the Machine");
		getContentPane().add(txfNumber);

		btnOk = new JButton();
		btnOk.setBounds(10, 150, 50, 26);
		btnOk.setText("Ok");
		btnOk.addActionListener(controller);
		getContentPane().add(btnOk);

		btnCancel = new JButton();
		btnCancel.setBounds(77, 150, 73, 26);
		btnCancel.setText("Cancel");
		btnCancel.addActionListener(controller);
		getContentPane().add(btnCancel);

		cbxMachineTypes = new JComboBox();
		cbxMachineTypes.setBounds(10, 32, 126, 25);
		getContentPane().add(cbxMachineTypes);

		lblMachineType = new JLabel();
		lblMachineType.setText("Choose machine type:");
		lblMachineType.setBounds(10, 10, 140, 16);
		getContentPane().add(lblMachineType);
	}

	public boolean isOKed() {
		return controller.closedByOk;
	}

	public void setMachine(Machine machine) {
		controller.machine = machine;
		controller.updateView();
	}

	private class Controller implements ActionListener {
		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();
		// ...............................................//
		private boolean closedByOk = false;
		private int serialNumber;
		private Machine machine;

		public void fillCbxMachineTypes() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getMachineTypes().toArray());
			cbxMachineTypes.setModel(cbxModel);
			cbxMachineTypes.setSelectedIndex(0);
		}

		public void updateView() {
			
			if (machine != null) {
				txfNumber.setText("" + machine.getSerialNumber());
				cbxMachineTypes.insertItemAt(machine.getType(), 0);
				cbxMachineTypes.setSelectedIndex(0);
				cbxMachineTypes.setEditable(false);
			} else {
				txfNumber.setText("");
				fillCbxMachineTypes();
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnOk) {
				String sNumber;
				sNumber = txfNumber.getText();

				try {
					// Convert String to Integer
					serialNumber = Integer.parseInt(sNumber);
				} catch (NumberFormatException ex) {
					// Show error message
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("Illegal Serial Number value.");
					return;
				}

				if (serialNumber <= 0) {
					// Show error message
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("Serial Number must be entered.");
					return;
				}
				MachineType selectedType = (MachineType) cbxMachineTypes
						.getSelectedItem();
				machine.setSerialNumber(serialNumber);
				machine.setType(selectedType);

				closedByOk = true;
				Machine_Dialog.this.setVisible(false);
			}

			if (e.getSource() == btnCancel) {
				closedByOk = false;
				Machine_Dialog.this.setVisible(false);
			}
		}
	}

}
