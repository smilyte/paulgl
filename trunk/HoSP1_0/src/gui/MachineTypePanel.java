package gui;

import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MachineTypePanel extends JPanel {

	private JLabel lblChooseMachineType;
	private JLabel lblSpareParts;
	private JLabel lblMachines;
	private JList lstMachine;
	private JButton btnRemovePart;
	private JButton btnAddPart;
	private JButton btnRemoveMachine;
	private JButton btnAddMachine;
	private JSeparator separator_2;
	private JList lstParts;
	private JScrollPane scrollPaneMachines;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnCreateNew;
	private JScrollPane scrollPaneSparePart;
	private JComboBox cbxMachineType;
	/**
	 * Create the panel
	 */
	public MachineTypePanel() {
		super();
		createComponents();
	}

	public void createComponents(){
		btnCreateNew = new JButton();
		btnCreateNew.setMargin(new Insets(2, 4, 2, 4));
		btnCreateNew.setBounds(26, 130, 93, 23);
		btnCreateNew.setText("Create new...");
		this.add(btnCreateNew);

		btnUpdate = new JButton();
		btnUpdate.setMargin(new Insets(2, 4, 2, 4));
		btnUpdate.setText("Update...");
		btnUpdate.setBounds(26, 174, 93, 23);
		this.add(btnUpdate);

		btnDelete = new JButton();
		btnDelete.setText("Delete");
		btnDelete.setBounds(26, 223, 93, 23);
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
		this.cbxMachineType.setModel(new DefaultComboBoxModel(new String[] {"Machine type 1", "Machine type 2", "Machine type 3", "Machine type 4"}));
		this.cbxMachineType.setBounds(26, 49, 168, 20);
		this.add(this.cbxMachineType);

		btnAddMachine = new JButton();
		btnAddMachine.setText("Add");
		btnAddMachine.setBounds(253, 331, 80, 23);
		this.add(btnAddMachine);

		btnRemoveMachine = new JButton();
		btnRemoveMachine.setText("Remove");
		btnRemoveMachine.setBounds(358, 331, 93, 23);
		this.add(btnRemoveMachine);

		btnAddPart = new JButton();
		btnAddPart.setText("Add");
		btnAddPart.setBounds(499, 331, 82, 23);
		this.add(btnAddPart);

		btnRemovePart = new JButton();
		btnRemovePart.setText("Remove");
		btnRemovePart.setBounds(600, 331, 80, 23);
		this.add(btnRemovePart);

		lblChooseMachineType = new JLabel();
		lblChooseMachineType.setText("Choose Machine type:");
		lblChooseMachineType.setBounds(26, 30, 168, 14);
		this.add(lblChooseMachineType);
	}

}

