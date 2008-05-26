/**
 * @author Vytas
 */
package gui;

import gui.Dialog.ErrorDialog;
import gui.Dialog.Machine_Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.*;
import service.Service;

public class MachinePanel extends JPanel {

	private JList lstMachine;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnCreate;
	private JLabel lblMachines;
	private JLabel lblChooseMachine;
	private JScrollPane scrollPaneMachine;
	private JComboBox cbxMachineTypes;

	// Creating object for inner class - Controller
	public Controller controller = new Controller();

	/**
	 * Create the panel
	 */
	public MachinePanel() {
		super();
		createComponents();
	}

	public void createComponents() {

		scrollPaneMachine = new JScrollPane();
		scrollPaneMachine.setBounds(222, 43, 265, 324);
		this.add(scrollPaneMachine);

		lstMachine = new JList();
		scrollPaneMachine.setViewportView(lstMachine);

		cbxMachineTypes = new JComboBox();
		cbxMachineTypes.setBounds(10, 42, 152, 20);
		cbxMachineTypes.addActionListener(controller);
		this.add(cbxMachineTypes);

		lblChooseMachine = new JLabel();
		lblChooseMachine.setText("Choose Machine Type:");
		lblChooseMachine.setBounds(10, 23, 152, 14);
		this.add(lblChooseMachine);

		lblMachines = new JLabel();
		lblMachines.setText("Machines:");
		lblMachines.setBounds(222, 23, 265, 14);
		this.add(lblMachines);

		btnCreate = new JButton();
		btnCreate.setText("Create...");
		btnCreate.setBounds(521, 41, 93, 23);
		btnCreate.addActionListener(controller);
		this.add(btnCreate);

		btnUpdate = new JButton();
		btnUpdate.setText("Update...");
		btnUpdate.setBounds(521, 104, 93, 23);
		btnUpdate.addActionListener(controller);
		this.add(btnUpdate);

		btnDelete = new JButton();
		btnDelete.setText("Delete");
		btnDelete.setBounds(521, 163, 93, 23);
		btnDelete.addActionListener(controller);
		this.add(btnDelete);

		// Calling methods from Controller class
		controller.updateView();
		controller.fillCbxMachineTypes();
	}

	private class Controller implements ActionListener {

		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();

		// ...............................................//

		/**
		 * Fills JList with Machines
		 */
		public void fillLstMachines(MachineType machineType) {
			List<Machine> listMachines = new ArrayList<Machine>();
			if (machineType != null)
				lstMachine.setListData(machineType.getMachines().toArray());
			else {
				for (MachineType mType : service.getMachineTypes()) {
					for (Machine machine : mType.getMachines()) {
						listMachines.add(machine);
					}
				}
				lstMachine.setListData(listMachines.toArray());
			}
		}

		/**
		 * Fills JComboBox with Machine Type list
		 */
		public void fillCbxMachineTypes() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getMachineTypes().toArray());
			cbxModel.insertElementAt("All", 0);
			cbxMachineTypes.setModel(cbxModel);
			cbxMachineTypes.setSelectedIndex(0);
		}

		/**
		 * Fills the list of Machines and update combo box of
		 * machine types
		 */
		public void updateView() {
			// Getting selected index
			int id = cbxMachineTypes.getSelectedIndex() - 1;

			if (id >= 0) {
				MachineType machineType = (MachineType) cbxMachineTypes
						.getSelectedItem();
				fillLstMachines(machineType);
			} else
				fillLstMachines(null);
			fillCbxMachineTypes();
		}
		/* List of actions when buttons are pressed.
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			/*
			 * If CREATE button is pressed.
			 */
			if (e.getSource() == btnCreate) {
				// Creating new instance of the Dialog
				Machine_Dialog createMachineDialog = new Machine_Dialog(
						MachinePanel.this, "Create Machine");

				// Creating new instance of Machine
				Machine machine = new Machine(0, null);
				// Letting Dialog know about new created machine
				createMachineDialog.setMachine(machine);
				// Making Dialog window visible
				createMachineDialog.setVisible(true);

				// Waiting for modal dialog to close

				/*
				 * If dialog was closed by OK button.
				 */
				if (createMachineDialog.isOKed()) {
					// We create machine, set serial number to it and update the lists
					machine.getType().createMachine(machine.getSerialNumber());
					updateView();
				}
				// Release MS Windows resources
				createMachineDialog.dispose();
			}
			/*
			 * If UPDATE button is pressed.
			 */
			if (e.getSource() == btnUpdate) {

				// Getting an object of selected Machine
				Machine machine = (Machine) lstMachine.getSelectedValue();

				if (machine != null) {
					// Creating new instance of the Dialog
					Machine_Dialog createMachineDialog = new Machine_Dialog(
							MachinePanel.this, "Update Machine");
					// Letting Dialog know about the machine we want to update
					createMachineDialog.setMachine(machine);
					// Making Dialog window visible
					createMachineDialog.setVisible(true);

					// Waiting for modal dialog to close

					/*
					 * If Dialog was closed by OK button.
					 */
					if (createMachineDialog.isOKed()) {
						// We update the lists
						updateView();
					}
					// Release MS Windows resources
					createMachineDialog.dispose();

				} else {
					// Show error message
					ErrorDialog errorDialog = new ErrorDialog("Error");
					errorDialog
							.showMessage("You have to select a machine first.");
					return;
				}
			}
			/*
			 * If DELETE button is pressed.
			 */
			if (e.getSource() == btnDelete) {

				// Getting an object of selected Machine
				Machine machine = (Machine) lstMachine.getSelectedValue();

				// If selected machine is not null we remove machine and update
				// view
				if (machine != null) {
					machine.getType().removeMachine(machine);
					updateView();
				} else {
					// Show error message
					ErrorDialog errorDialog = new ErrorDialog("Error");
					errorDialog
							.showMessage("You have to select a machine first.");
					return;
				}
			}
			/*
			 * If MACHINE TYPE in the list was selected.
			 */
			if (e.getSource() == cbxMachineTypes) {
				updateView();
			}
		}
	}
}
