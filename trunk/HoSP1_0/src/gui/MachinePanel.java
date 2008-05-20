package gui;

import gui.Dialog.CreateMachine_Dialog;

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
	private JComboBox cbxMachineType;
	
	private Controller controller = new Controller();

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

		cbxMachineType = new JComboBox();
	//	cbxMachineType.setModel(new DefaultComboBoxModel());
		cbxMachineType.setBounds(10, 42, 152, 20);
		cbxMachineType.addActionListener(controller);
		this.add(cbxMachineType);

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
		
		//
		controller.updateView();
		controller.fillCbxMachineType();
		
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
			if(machineType != null)
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
		 * Method which fills cbxMachineType1 with Machine Type list
		 */
		public void fillCbxMachineType() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(
					service.getMachineTypes().toArray());
			cbxModel.insertElementAt("All",	0);
			cbxMachineType.setModel(cbxModel);
			cbxMachineType.setSelectedIndex(0);
		}
		
		/**
		 * Clears JList and calls method to fill the list of Machines
		 */
		public void updateView() {
			int id = cbxMachineType.getSelectedIndex() - 1;
			
			/** ..............REMOVE DATA FROM JLIST START............... * */
			lstMachine.setModel(new DefaultListModel());
			DefaultListModel model = (DefaultListModel) lstMachine.getModel();
			model.clear();
			/** ..............REMOVE DATA FROM JLIST END................. * */
			
				if (id >= 0){
					MachineType machineType = (MachineType) cbxMachineType.getSelectedItem();
					fillLstMachines(machineType);
				}
				else
					fillLstMachines(null);	
		}
		
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == "btnCreate"){
				        CreateMachine_Dialog createMachineDialog = new CreateMachine_Dialog(MachinePanel.this, "Create Machine");
				        createMachineDialog.setVisible(true);
			}
			if (e.getSource() == "btnUpdate"){
				Machine machine = (Machine) lstMachine.getSelectedValue();
				if(machine != null){

				}
			}
			if (e.getSource() == "btnDelete"){
				
			}
			if (e.getSource() == cbxMachineType) {
				updateView();
			}
		}
	}
}
