package gui.Dialog;


import gui.RepairPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import model.*;
import service.Service;

public class CreateNewRepair_Dialog extends JDialog {
private GregorianCalendar startDate,endDate;
	private JTextField txfRepairId, txfStartDate, txfStartTime, txfEndDate,
			txfEndTime;
	private JComboBox cbxRepairType, cbxMachineType, cbxMachine;
	private JList lstSparePart;
	private JLabel lblRepareId, lblMachineType, lblSparePart, lblRepairType,
			lblStartDate, lblStartTime, lblEndDate, lblEndTime, lblMachine, label_1;
	private JButton btnStart, btnEnd, btnCreateNewRepairtype, btnCreate,
			btnCancel;
	// l object for inner class Controller
	private Controller controller = new Controller();
	

	/**
	 * Create the dialog
	 */
	public CreateNewRepair_Dialog(RepairPanel repairPanel, String string) {

		setResizable(false);
		setTitle("Create New Repair");
		getContentPane().setLayout(null);
		setBounds(100, 100, 459, 427);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setModal(true);

		// Repair ID Label and TextField
		lblRepareId = new JLabel();
		lblRepareId.setText("Repair ID:");
		lblRepareId.setBounds(10, 28, 54, 14);
		getContentPane().add(lblRepareId);

		txfRepairId = new JTextField();
		getContentPane().add(txfRepairId);
		txfRepairId.setBounds(20, 48, 129, 20);

		// Spare Part Label and list in the JScrollPane
		lblSparePart = new JLabel();
		getContentPane().add(lblSparePart);
		lblSparePart.setText("Spare Part:");
		lblSparePart.setBounds(191, 28, 63, 14);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		scrollPane.setBounds(191, 48, 232, 130);

		lstSparePart = new JList();
		scrollPane.setViewportView(lstSparePart);

		// Repair Type Label and the ComboBox to Repair Type
		lblRepairType = new JLabel();
		getContentPane().add(lblRepairType);
		lblRepairType.setText("Repair Type:");
		lblRepairType.setBounds(10, 74, 69, 14);

		cbxRepairType = new JComboBox();
		getContentPane().add(cbxRepairType);
		cbxRepairType.setBounds(20, 93, 129, 20);

		// Machine Type Label and the ComboBox to Machine Type
		lblMachineType = new JLabel();
		lblMachineType.setText("Machine Type:");
		lblMachineType.setBounds(10, 119, 79, 14);
		getContentPane().add(lblMachineType);

		cbxMachineType = new JComboBox();
		getContentPane().add(cbxMachineType);
		cbxMachineType.setBounds(20, 139, 129, 20);

		// Machine Label and the ComboBox to
		lblMachine = new JLabel();
		getContentPane().add(lblMachine);
		lblMachine.setText("Machine:");
		lblMachine.setBounds(10, 165, 54, 14);

		cbxMachine = new JComboBox();
		getContentPane().add(cbxMachine);
		cbxMachine.setBounds(20, 185, 129, 20);

		// Start Date Label, TextField.
		lblStartDate = new JLabel();
		getContentPane().add(lblStartDate);
		lblStartDate.setText("Start Date:");
		lblStartDate.setBounds(10, 226, 54, 14);

		txfStartDate = new JTextField();
		getContentPane().add(txfStartDate);
		txfStartDate.setBounds(10, 246, 79, 20);

		// Start Time Label, TextField.
		lblStartTime = new JLabel();
		getContentPane().add(lblStartTime);
		lblStartTime.setText("Start Time:");
		lblStartTime.setBounds(95, 226, 54, 14);

		txfStartTime = new JTextField();
		getContentPane().add(txfStartTime);
		txfStartTime.setBounds(95, 246, 79, 20);

		// Start Button
		btnStart = new JButton();
		btnStart.setText("Start");
		btnStart.setBounds(191, 245, 93, 23);
		getContentPane().add(btnStart);
		btnStart.addActionListener(controller);

		lblEndDate = new JLabel();
		getContentPane().add(lblEndDate);
		lblEndDate.setText("End Date:");
		lblEndDate.setBounds(10, 272, 54, 14);

		txfEndDate = new JTextField();
		getContentPane().add(txfEndDate);
		txfEndDate.setBounds(10, 292, 79, 20);

		lblEndTime = new JLabel();
		getContentPane().add(lblEndTime);
		lblEndTime.setText("End Time:");
		lblEndTime.setBounds(95, 272, 54, 14);

		txfEndTime = new JTextField();
		getContentPane().add(txfEndTime);
		txfEndTime.setBounds(95, 292, 79, 20);

		btnEnd = new JButton();
		getContentPane().add(btnEnd);
		btnEnd.setText("End");
		btnEnd.setBounds(191, 291, 93, 23);

		btnCreateNewRepairtype = new JButton();
		btnCreateNewRepairtype.setText("Create New Repair Type");
		btnCreateNewRepairtype.setBounds(191, 184, 151, 23);
		getContentPane().add(btnCreateNewRepairtype);
		btnCreateNewRepairtype.addActionListener(controller);

		label_1 = new JLabel();
		getContentPane().add(label_1);
		label_1.setText("New JLabel");
		label_1.setBounds(10, 325, 54, 14);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 218, 421, 2);
		getContentPane().add(separator);

		// Create button
		btnCreate = new JButton();
		btnCreate.setText("Create");
		btnCreate.setBounds(231, 358, 93, 23);
		getContentPane().add(btnCreate);
		btnCreate.addActionListener(controller);

		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(330, 358, 93, 23);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(controller);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 343, 421, 2);
		getContentPane().add(separator_1);
	

	}
	
	public boolean isOKed() {
		return controller.closedByOk;
		}

	private class Controller implements ActionListener {
		private Service service = Service.getInstance();
		private boolean closedByOk = false;
		
		/**
		 * Method which fills cbxRepairTypes with Repair Type list
		 */
		public void fillCbxRepairType() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getRepairTypes().toArray());
			cbxModel.insertElementAt("All", 0);
			cbxRepairType.setModel(cbxModel);
			cbxRepairType.setSelectedIndex(0);
		}

		/**
		 * Method which fills cbxMachineType with Machine Type list
		 */
		public void fillCbxMachineType() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getMachineTypes().toArray());
			cbxModel.insertElementAt("All", 0);
			cbxMachineType.setModel(cbxModel);
			cbxMachineType.setSelectedIndex(0);
		}

		/**
		 * Method which fills cbxMachine with Machine list
		 */
		public void fillCbxMachine(MachineType mT) {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(mT.getMachines().toArray());
			cbxModel.insertElementAt("All", 0);
			cbxMachine.setModel(cbxModel);
			cbxMachine.setSelectedIndex(0);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCreateNewRepairtype)
			{	
			CreateNewRepairType_Dialog createNRTD = new CreateNewRepairType_Dialog(
					CreateNewRepair_Dialog.this, "Create Machine");
			createNRTD.setVisible(true);

			}
			if (e.getSource() == btnCreate){
				
				closedByOk = true;
				CreateNewRepair_Dialog.this.setVisible(false);

			}
			if (e.getSource() == btnStart) {
			startDate = new GregorianCalendar();

			DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, getLocale());
			DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, getLocale());

			txfStartDate.setText(dateFormatter.format(startDate));
			txfStartTime.setText(timeFormatter.format(startDate));

			btnStart.setEnabled(false);
//			start = true;
		}  
			if (e.getSource() == btnEnd) {
			endDate = new GregorianCalendar();

			DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, getLocale());
			DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT, getLocale());

			txfEndDate.setText(dateFormatter.format(endDate));
			txfEndTime.setText(timeFormatter.format(endDate));
			
			btnEnd.setEnabled(false);
//			ended=true;
		} if (e.getSource() == btnCancel) {
			CreateNewRepair_Dialog.this.setVisible(false);
		}
	}
}}
