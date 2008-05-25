package gui;

import gui.Dialog.ErrorDialog;
import gui.Dialog.MachineType_AddPartDialog;
import gui.Dialog.MachineType_Dialog;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import model.Machine;
import model.MachineType;
import model.SparePart;

import service.Service;

public class MachineTypePanel extends JPanel {

	private JLabel lblChooseMachineType;
	private JLabel lblSpareParts;
	private JLabel lblMachines;
	private JList lstMachine;
	private JButton btnRemovePart;
	private JButton btnAddPart;
	private JSeparator separator_2;
	private JList lstParts;
	private JScrollPane scrollPaneMachines;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnCreate;
	private JScrollPane scrollPaneSparePart;
	private JComboBox cbxMachineType;

	private Controller controller = new Controller();

	/**
	 * Create the panel
	 */
	public MachineTypePanel() {
		super();
		createComponents();
	}

	public void createComponents() {
		btnCreate = new JButton();
		btnCreate.setMargin(new Insets(2, 4, 2, 4));
		btnCreate.setBounds(26, 130, 93, 23);
		btnCreate.setText("Create new...");
		btnCreate.addActionListener(controller);
		this.add(btnCreate);

		btnUpdate = new JButton();
		btnUpdate.setMargin(new Insets(2, 4, 2, 4));
		btnUpdate.setText("Update...");
		btnUpdate.setBounds(26, 174, 93, 23);
		btnUpdate.addActionListener(controller);
		this.add(btnUpdate);

		btnDelete = new JButton();
		btnDelete.setText("Delete");
		btnDelete.setBounds(26, 223, 93, 23);
		btnDelete.addActionListener(controller);
		this.add(btnDelete);

		scrollPaneMachines = new JScrollPane();
		scrollPaneMachines.setBounds(253, 50, 198, 270);
		this.add(scrollPaneMachines);

		lstMachine = new JList();
		scrollPaneMachines.setViewportView(lstMachine);

		scrollPaneSparePart = new JScrollPane();
		scrollPaneSparePart.setBounds(499, 50, 181, 270);
		this.add(scrollPaneSparePart);

		lstParts = new JList();
		scrollPaneSparePart.setViewportView(lstParts);

		lblMachines = new JLabel();
		lblMachines.setText("Machines:");
		lblMachines.setBounds(253, 30, 93, 14);
		this.add(lblMachines);

		lblSpareParts = new JLabel();
		lblSpareParts.setText("Spare Parts:");
		lblSpareParts.setBounds(499, 30, 181, 14);
		this.add(lblSpareParts);

		this.separator_2 = new JSeparator();
		this.separator_2.setOrientation(SwingConstants.VERTICAL);
		this.separator_2.setBounds(475, 0, 11, 420);
		this.add(this.separator_2);

		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(230, 0, 11, 420);
		this.add(separator_2);

		this.cbxMachineType = new JComboBox();
		cbxMachineType.setActionCommand("cbxMachineType");
		this.cbxMachineType.setModel(new DefaultComboBoxModel(new String[] {
				"Machine type 1", "Machine type 2", "Machine type 3",
				"Machine type 4" }));
		this.cbxMachineType.setBounds(26, 49, 168, 20);
		cbxMachineType.addActionListener(controller);
		this.add(this.cbxMachineType);

		btnAddPart = new JButton();
		btnAddPart.setText("Add");
		btnAddPart.setBounds(499, 331, 82, 23);
		btnAddPart.addActionListener(controller);
		this.add(btnAddPart);

		btnRemovePart = new JButton();
		btnRemovePart.setText("Remove");
		btnRemovePart.setBounds(600, 331, 80, 23);
		btnRemovePart.addActionListener(controller);
		this.add(btnRemovePart);

		lblChooseMachineType = new JLabel();
		lblChooseMachineType.setText("Choose Machine type:");
		lblChooseMachineType.setBounds(26, 30, 168, 14);
		this.add(lblChooseMachineType);

		controller.updateView();
	}

	private class Controller implements ActionListener {

		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();

		// ...............................................//

		/**
		 * Method which fills JList with Machines
		 */
		public void fillLstMachines(MachineType machineType) {
			List<Machine> listMachines = new ArrayList<Machine>();
			if (machineType != null) {
				lstMachine.setListData(machineType.getMachines().toArray());
			} else {
				for (MachineType mType : service.getMachineTypes()) {
					for (Machine machine : mType.getMachines()) {
						listMachines.add(machine);
					}
				}
				lstMachine.setListData(listMachines.toArray());
			}
		}

		/**
		 * Method which fills JList with Spare Parts
		 */
		public void fillLstParts(MachineType machineType) {
			if (machineType == null) {
				/** ..............REMOVE DATA FROM JLIST START............... * */
				lstParts.setModel(new DefaultListModel());
				DefaultListModel model = (DefaultListModel) lstParts.getModel();
				model.clear();
				/** ..............REMOVE DATA FROM JLIST END................. * */
			} else
				lstParts.setListData(machineType.getSpareParts().toArray());
		}

		/**
		 * Method which fills cbxMachineType with Machine Type list
		 */
		public void fillCbxMachineType(int a) {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getMachineTypes().toArray());
			cbxMachineType.setModel(cbxModel);
			cbxMachineType.insertItemAt("All", 0);
			cbxMachineType.setSelectedIndex(0);
			// if (a >= 0) {
			try {
				cbxMachineType.setSelectedIndex(a + 1);
			} catch (Exception e) {
				return;
			}
		}

		/**
		 * Clears JList and calls method to fill the list of Machines
		 */
		public void updateView() {

			int id = cbxMachineType.getSelectedIndex() - 1;
			fillCbxMachineType(id);

			if (id < 0) {
				fillLstMachines(null);
				fillLstParts(null);
			} else {
				try {
					MachineType machineType = (MachineType) cbxMachineType
							.getSelectedItem();
					// System.out.println(machineType.getMachines().toString());
					fillLstMachines(machineType);
					fillLstParts(machineType);

				} catch (Exception ex) {
					return;
				}
			}

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnCreate) {
				MachineType_Dialog machineTypeDialog = new MachineType_Dialog(
						MachineTypePanel.this, "Create Machine Type");

				MachineType machineType = new MachineType("");
				machineTypeDialog.setMachineType(machineType);

				machineTypeDialog.setVisible(true);

				// waiting for modal dialog to close

				if (machineTypeDialog.isOKed()) {
					service.addMachineType(machineType);
					updateView();
				}
				// release MS Windows resources
				machineTypeDialog.dispose();

			}
			if (e.getSource() == btnUpdate) {
				MachineType machineType;
				try {
					machineType = (MachineType) cbxMachineType
							.getSelectedItem();
				} catch (Exception ex) {
					// Show error message
					ErrorDialog errorDialog = new ErrorDialog("Error");
					errorDialog
							.showMessage("You have to select a machine type first.");
					return;
				}
				MachineType_Dialog machineTypeDialog = new MachineType_Dialog(
						MachineTypePanel.this, "Update Machine Type");

				machineTypeDialog.setMachineType(machineType);
				machineTypeDialog.setVisible(true);

				// waiting for modal dialog to close

				if (machineTypeDialog.isOKed()) {
					updateView();
				}
				// release MS Windows resources
				machineTypeDialog.dispose();

			}

			if (e.getSource() == btnDelete) {
				MachineType machineType;
				try {
					machineType = (MachineType) cbxMachineType
							.getSelectedItem();
				} catch (Exception ex) {
					return;
				}

				if (machineType != null) {
					service.removeMachineType(machineType);
					updateView();
				} else {
					// Show error message
					ErrorDialog errorDialog = new ErrorDialog("Error");
					errorDialog
							.showMessage("You have to select a machine type first.");

					return;
				}
			}
			if (e.getSource() == btnAddPart) {
				MachineType machineType;

				try {

					machineType = (MachineType) cbxMachineType
							.getSelectedItem();

				} catch (Exception ex) {
					// Show error message
					ErrorDialog errorDialog = new ErrorDialog("Error");
					errorDialog
							.showMessage("You have to select a machine type first.");

					return;
				}

				MachineType_AddPartDialog machineTypeAddDialog = new MachineType_AddPartDialog(
						MachineTypePanel.this, "Create Machine Type");

				machineTypeAddDialog.setMachineType(machineType);

				machineTypeAddDialog.setVisible(true);

				// waiting for modal dialog to close

				if (machineTypeAddDialog.isOKed()) {
					updateView();
				}
				// release MS Windows resources
				machineTypeAddDialog.dispose();

			}
			if (e.getSource() == btnRemovePart) {
				if (lstParts.getSelectedIndex() >= 0) {
					MachineType machineType = (MachineType) cbxMachineType
							.getSelectedItem();
					SparePart sparePart = (SparePart) lstParts
							.getSelectedValue();
					machineType.removeSparePart(sparePart);
				} else {
					// Show error message
					ErrorDialog errorDialog = new ErrorDialog("Error");
					errorDialog
							.showMessage("You have to select a spare part first.");
				}
				updateView();
			}
			if (e.getSource() == cbxMachineType) {
				updateView();
			}

		}
	}

}
