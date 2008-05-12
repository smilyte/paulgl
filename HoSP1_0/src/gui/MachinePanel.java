package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MachinePanel extends JPanel {


	private JList lstMachine;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnCreate;
	private JLabel lblMachines;
	private JLabel lblChooseMachine;
	private JScrollPane scrollPaneMachine;
	private JComboBox cbxMachineType1;

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

		cbxMachineType1 = new JComboBox();
		cbxMachineType1.setModel(new DefaultComboBoxModel(new String[] {"All", "Machine Type 1", "Machine Type 2", "Machine Type 3"}));
		cbxMachineType1.setBounds(10, 42, 152, 20);
		this.add(cbxMachineType1);

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
		this.add(btnCreate);

		btnUpdate = new JButton();
		btnUpdate.setText("Update...");
		btnUpdate.setBounds(521, 104, 93, 23);
		this.add(btnUpdate);

		btnDelete = new JButton();
		btnDelete.setText("Delete");
		btnDelete.setBounds(521, 163, 93, 23);
		this.add(btnDelete);
	}
}
