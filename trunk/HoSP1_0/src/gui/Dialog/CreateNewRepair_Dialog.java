package gui.Dialog;

import gui.RepairPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;

import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.*;
import service.Service;

public class CreateNewRepair_Dialog extends JDialog {
	private JList lstAddedSparePart;
	private JTextField textField;
	private GregorianCalendar startDate, endDate;
	private JTextField txfRepairId, txfStartDate, txfStartTime, txfEndDate,
			txfEndTime;
	private JComboBox cbxRepairType, cbxMachineType, cbxMachine;
	private JList lstSparePart;
	private JLabel lblRepareId, lblMachineType, lblSparePart, lblRepairType,
			lblStartDate, lblStartTime, lblEndDate, lblEndTime, lblMachine,
			lblDowntime;
	private JButton btnStart, btnEnd, btnAdd, btnRemove,
			btnCreateNewRepairtype, btnCreate, btnCancel;
	// l object for inner class Controller
	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public CreateNewRepair_Dialog(RepairPanel repairPanel, String string) {

		setResizable(false);
		setTitle("Create New Repair");
		getContentPane().setLayout(null);
		setBounds(100, 100, 601, 427);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setModal(true);

		// Repair ID Label and TextField
		lblRepareId = new JLabel();
		lblRepareId.setText("Repair ID:");
		lblRepareId.setBounds(10, 28, 54, 14);
		getContentPane().add(lblRepareId);

		txfRepairId = new JTextField();
		txfRepairId.setBackground(Color.WHITE);
		txfRepairId.setEditable(false);
		getContentPane().add(txfRepairId);
		txfRepairId.setBounds(20, 48, 129, 20);

		// Spare Part Label and list in the JScrollPane
		lblSparePart = new JLabel();
		getContentPane().add(lblSparePart);
		lblSparePart.setText("Spare Part:");
		lblSparePart.setBounds(191, 28, 63, 14);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		scrollPane.setBounds(191, 48, 151, 130);

		lstSparePart = new JList();
		lstSparePart
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(lstSparePart);
		lstSparePart.addListSelectionListener(controller);

		btnAdd = new JButton();
		btnAdd.setText(">>");
		btnAdd.setBounds(360, 105, 54, 23);
		getContentPane().add(btnAdd);
		btnAdd.addActionListener(controller);

		btnRemove = new JButton();
		btnRemove.setText("<<");
		btnRemove.setBounds(360, 145, 54, 23);
		getContentPane().add(btnRemove);
		btnRemove.addActionListener(controller);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(428, 48, 151, 130);
		getContentPane().add(scrollPane_1);

		lstAddedSparePart = new JList();
		lstAddedSparePart.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(lstAddedSparePart);

		// Repair Type Label and the ComboBox to Repair Type
		lblRepairType = new JLabel();
		getContentPane().add(lblRepairType);
		lblRepairType.setText("Repair Type:");
		lblRepairType.setBounds(10, 166, 69, 14);

		cbxRepairType = new JComboBox();
		getContentPane().add(cbxRepairType);
		cbxRepairType.setBounds(20, 185, 129, 20);
		cbxRepairType.addActionListener(controller);

		// Machine Type Label and the ComboBox to Machine Type
		lblMachineType = new JLabel();
		lblMachineType.setText("Machine Type:");
		lblMachineType.setBounds(10, 74, 79, 14);
		getContentPane().add(lblMachineType);

		cbxMachineType = new JComboBox();
		getContentPane().add(cbxMachineType);
		cbxMachineType.setBounds(20, 94, 129, 20);
		cbxMachineType.addActionListener(controller);

		// Machine Label and the ComboBox to
		lblMachine = new JLabel();
		getContentPane().add(lblMachine);
		lblMachine.setText("Machine:");
		lblMachine.setBounds(10, 120, 54, 14);

		cbxMachine = new JComboBox();
		getContentPane().add(cbxMachine);
		cbxMachine.setBounds(20, 140, 129, 20);
		cbxMachine.addActionListener(controller);

		// Start Date Label, TextField.

		lblStartDate = new JLabel();
		getContentPane().add(lblStartDate);
		lblStartDate.setText("Start Date:");
		lblStartDate.setBounds(10, 226, 54, 14);

		txfStartDate = new JTextField();
		txfStartDate.setBackground(new Color(175, 238, 238));
		txfStartDate.setEditable(false);
		getContentPane().add(txfStartDate);
		txfStartDate.setBounds(10, 246, 79, 20);

		// Start Time Label, TextField.
		lblStartTime = new JLabel();
		getContentPane().add(lblStartTime);
		lblStartTime.setText("Start Time:");
		lblStartTime.setBounds(95, 226, 54, 14);

		txfStartTime = new JTextField();
		txfStartTime.setBackground(new Color(175, 238, 238));
		txfStartTime.setEditable(false);
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
		txfEndDate.setBackground(new Color(175, 238, 238));
		txfEndDate.setEditable(false);
		getContentPane().add(txfEndDate);
		txfEndDate.setBounds(10, 292, 79, 20);

		lblEndTime = new JLabel();
		getContentPane().add(lblEndTime);
		lblEndTime.setText("End Time:");
		lblEndTime.setBounds(95, 272, 54, 14);

		txfEndTime = new JTextField();
		txfEndTime.setBackground(new Color(175, 238, 238));
		txfEndTime.setEditable(false);
		getContentPane().add(txfEndTime);
		txfEndTime.setBounds(95, 292, 79, 20);

		// End Button
		btnEnd = new JButton();
		getContentPane().add(btnEnd);
		btnEnd.setText("End");
		btnEnd.setBounds(191, 291, 93, 23);
		btnEnd.addActionListener(controller);

		// btnCreateNewRepairtype = new JButton();
		// btnCreateNewRepairtype.setText("Create New Repair Type");
		// btnCreateNewRepairtype.setBounds(191, 184, 151, 23);
		// getContentPane().add(btnCreateNewRepairtype);
		// btnCreateNewRepairtype.addActionListener(controller);

		lblDowntime = new JLabel();
		getContentPane().add(lblDowntime);
		lblDowntime.setText("Downtime:");
		lblDowntime.setBounds(10, 325, 54, 14);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 211, 550, 9);
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
		separator_1.setBounds(10, 343, 550, 9);
		getContentPane().add(separator_1);

		JLabel lblAmount = new JLabel();
		lblAmount.setText("Amount");
		lblAmount.setBounds(358, 51, 54, 14);
		getContentPane().add(lblAmount);

		textField = new JTextField();
		textField.setBounds(358, 71, 54, 20);
		getContentPane().add(textField);

		controller.fillCbxMachineType();

	}

	public boolean isOKed() {
		return controller.closedByOk;
	}

	private class Controller implements ActionListener, ListSelectionListener {
		private Service service = Service.getInstance();
		private boolean closedByOk = false;
		private boolean start;

		public void setRepairID(int nr) {
			txfRepairId.setText("" + nr);
		}

		// Fills SparePart list
		public void fillLstSparePart() {
			MachineType mT = (MachineType) cbxMachineType.getSelectedItem();
			lstSparePart.setListData(mT.getSpareParts().toArray());
		}

		/**
		 * Method which fills cbxRepairTypes with Repair Type list
		 */
		public void fillCbxRepairType() {
			 MachineType mT = (MachineType) cbxMachineType.getSelectedItem();
			 DefaultComboBoxModel cbxModel = new
			 DefaultComboBoxModel();
			 if (!mT.getRepairTypes().isEmpty()){
				 for(RepairType rt: mT.getRepairTypes()){
					 cbxModel.addElement(rt);
				 }
			 }
			 cbxRepairType.setModel(cbxModel);
			// cbxRepairType.setSelectedIndex(0);
		}

		/**
		 * Method which fills cbxMachineType with Machine Type list
		 */
		public void fillCbxMachineType() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getMachineTypes().toArray());
			cbxMachineType.setModel(cbxModel);
			cbxMachineType.setSelectedIndex(0);
		}

		/**
		 * Method which fills cbxMachine with Machine list
		 */
		public void fillCbxMachine() {
			MachineType mT = (MachineType) cbxMachineType.getSelectedItem();
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(mT
					.getMachines().toArray());
			cbxMachine.setModel(cbxModel);
			cbxMachine.setSelectedIndex(0);
		}

		// public void prepareData(Repair r){
		//			
		// DateFormat dateFormatter =
		// DateFormat.getDateInstance(DateFormat.DEFAULT, getLocale());
		// DateFormat timeFormatter =
		// DateFormat.getTimeInstance(DateFormat.DEFAULT, getLocale());
		// txfStartDate.setText(dateFormatter.format(service.getStartDate()));
		// txfStartTime.setText(timeFormatter.format(service.getStartDate()));
		// btnStart.setEnabled(false);
		// btnEnd.setEnabled(true);
		// }

		public void prepareSummary() {
			lblDowntime.setText("Downtime: "
					+ service.getDowntime(startDate, endDate));
			btnCreate.setVisible(false);
			btnCancel.setText("Close");
			btnEnd.setEnabled(false);
			txfRepairId.setEditable(false);
			txfStartDate.setEnabled(true);
			txfStartDate.setEditable(false);
			txfStartTime.setEnabled(true);
			txfStartTime.setEditable(false);
			txfEndDate.setEditable(false);
			cbxMachine.setEnabled(false);
			cbxRepairType.setEnabled(false);
			txfEndTime.setEditable(false);

		}

		/**
		 * Clears JList and calls method to fill the list of Machines
		 */
		public void updateView() {
			//int id = cbxMachineType.getSelectedIndex() - 1;
			controller.fillCbxMachine();
			controller.fillLstSparePart();
			controller.fillCbxRepairType();
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCreateNewRepairtype) {
				CreateNewRepairType_Dialog createNRTD = new CreateNewRepairType_Dialog(
						CreateNewRepair_Dialog.this, "Create Machine");
				createNRTD.setVisible(true);

			}
			if (e.getSource() == btnCreate) {

				closedByOk = true;
				CreateNewRepair_Dialog.this.setVisible(false);

			}
			if (e.getSource() == btnStart) {
				startDate = new GregorianCalendar();

				DateFormat dateFormatter = DateFormat.getDateInstance(
						DateFormat.DEFAULT, getLocale());
				DateFormat timeFormatter = DateFormat.getTimeInstance(
						DateFormat.DEFAULT, getLocale());

				txfStartDate.setText(dateFormatter.format(startDate.getTime()));
				txfStartTime.setText(timeFormatter.format(startDate.getTime()));

				btnStart.setEnabled(false);
				start = true;
			}
			if (e.getSource() == btnEnd) {
				endDate = new GregorianCalendar();

				DateFormat dateFormatter = DateFormat.getDateInstance(
						DateFormat.DEFAULT, getLocale());
				DateFormat timeFormatter = DateFormat.getTimeInstance(
						DateFormat.DEFAULT, getLocale());

				txfEndDate.setText(dateFormatter.format(endDate.getTime()));
				txfEndTime.setText(timeFormatter.format(endDate.getTime()));

				btnEnd.setEnabled(false);
				// ended=true;
			}
			if (e.getSource() == btnCancel) {
				CreateNewRepair_Dialog.this.setVisible(false);
			}
			if (e.getSource() == cbxMachineType) {
			   updateView();
			}

		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
