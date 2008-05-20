package gui.Dialog;

import gui.MachinePanel;
import gui.RepairPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

	private JTextField txfrepairId, txfstartDate, txfstartTime, txfendDate,
			txfendTime;
	private JComboBox cbxRepairType, cbxMachineType, cbxMachine;
	private JList listsparePart;
	private JLabel lbrepareId, lbmachineType, lbsparePart, lbrepairType,
			lbstartDate, lbstartTime, label, lbendTime, lbmachine, label_1;
	private JButton butstart, butend, btncreateNewRepairtype, butcreate,
			butcancel;
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
		// this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);

		// Repair ID Label and TextField
		lbrepareId = new JLabel();
		lbrepareId.setText("Repair ID:");
		lbrepareId.setBounds(10, 28, 54, 14);
		getContentPane().add(lbrepareId);

		txfrepairId = new JTextField();
		getContentPane().add(txfrepairId);
		txfrepairId.setBounds(20, 48, 129, 20);

		// Spare Part Label and list in the JScrollPane
		lbsparePart = new JLabel();
		getContentPane().add(lbsparePart);
		lbsparePart.setText("Spare Part:");
		lbsparePart.setBounds(191, 28, 63, 14);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		scrollPane.setBounds(191, 48, 232, 130);

		listsparePart = new JList();
		scrollPane.setViewportView(listsparePart);

		// Repair Type Label and the ComboBox to Repair Type
		lbrepairType = new JLabel();
		getContentPane().add(lbrepairType);
		lbrepairType.setText("Repair Type:");
		lbrepairType.setBounds(10, 74, 69, 14);

		cbxRepairType = new JComboBox();
		getContentPane().add(cbxRepairType);
		cbxRepairType.setBounds(20, 93, 129, 20);

		// Machine Type Label and the ComboBox to Machine Type
		lbmachineType = new JLabel();
		lbmachineType.setText("Machine Type:");
		lbmachineType.setBounds(10, 119, 79, 14);
		getContentPane().add(lbmachineType);

		cbxMachineType = new JComboBox();
		getContentPane().add(cbxMachineType);
		cbxMachineType.setBounds(20, 139, 129, 20);

		// Machine Label and the ComboBox to
		lbmachine = new JLabel();
		getContentPane().add(lbmachine);
		lbmachine.setText("Machine:");
		lbmachine.setBounds(10, 165, 54, 14);

		cbxMachine = new JComboBox();
		getContentPane().add(cbxMachine);
		cbxMachine.setBounds(20, 185, 129, 20);

		// Start Date Label, TextField.
		lbstartDate = new JLabel();
		getContentPane().add(lbstartDate);
		lbstartDate.setText("Start Date:");
		lbstartDate.setBounds(10, 226, 54, 14);

		txfstartDate = new JTextField();
		getContentPane().add(txfstartDate);
		txfstartDate.setBounds(10, 246, 79, 20);

		// Start Time Label, TextField.
		lbstartTime = new JLabel();
		getContentPane().add(lbstartTime);
		lbstartTime.setText("Start Time:");
		lbstartTime.setBounds(95, 226, 54, 14);

		txfstartTime = new JTextField();
		getContentPane().add(txfstartTime);
		txfstartTime.setBounds(95, 246, 79, 20);

		// Start Button
		butstart = new JButton();
		butstart.setText("Start");
		butstart.setBounds(191, 245, 93, 23);
		getContentPane().add(butstart);
		butstart.addActionListener(controller);

		label = new JLabel();
		getContentPane().add(label);
		label.setText("End Date:");
		label.setBounds(10, 272, 54, 14);

		txfendDate = new JTextField();
		getContentPane().add(txfendDate);
		txfendDate.setBounds(10, 292, 79, 20);

		lbendTime = new JLabel();
		getContentPane().add(lbendTime);
		lbendTime.setText("End Time:");
		lbendTime.setBounds(95, 272, 54, 14);

		txfendTime = new JTextField();
		getContentPane().add(txfendTime);
		txfendTime.setBounds(95, 292, 79, 20);

		butend = new JButton();
		getContentPane().add(butend);
		butend.setText("End");
		butend.setBounds(191, 291, 93, 23);

		btncreateNewRepairtype = new JButton();
		btncreateNewRepairtype.setText("Create New Repair Type");
		btncreateNewRepairtype.setBounds(191, 184, 151, 23);
		getContentPane().add(btncreateNewRepairtype);
		btncreateNewRepairtype.addActionListener(controller);

		label_1 = new JLabel();
		getContentPane().add(label_1);
		label_1.setText("New JLabel");
		label_1.setBounds(10, 325, 54, 14);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 218, 421, 2);
		getContentPane().add(separator);

		// Create button
		butcreate = new JButton();
		butcreate.setText("Create");
		butcreate.setBounds(231, 358, 93, 23);
		getContentPane().add(butcreate);
		butcreate.addActionListener(controller);

		butcancel = new JButton();
		butcancel.setText("Cancel");
		butcancel.setBounds(330, 358, 93, 23);
		getContentPane().add(butcancel);
		butcancel.addActionListener(controller);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 343, 421, 2);
		getContentPane().add(separator_1);

	}

	private class Controller implements ActionListener {
		private Service service = Service.getInstance();

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btncreateNewRepairtype)
				;
			CreateNewRepairType_Dialog createNRTD = new CreateNewRepairType_Dialog(
					CreateNewRepair_Dialog.this, "Create Machine");
			createNRTD.setVisible(true);

			{
			}
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
		public void fillCbxMachine() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getMachineTypes().toArray());
			cbxModel.insertElementAt("All", 0);
			cbxMachine.setModel(cbxModel);
			cbxMachine.setSelectedIndex(0);
		}
	}
}
