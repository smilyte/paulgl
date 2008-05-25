package gui.Dialog;

import gui.RepairPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

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
	private JButton btnSubmit;
	private JButton btnSave;
	private JTextField txfSearch;
	private JList lstAddedSparePart;
	private JTextField txfAmount;
	private GregorianCalendar startDate, endDate;
	private JTextField txfRepairId, txfStartDate, txfStartTime, txfEndDate,
			txfEndTime;
	private JComboBox cbxRepairType, cbxMachineType, cbxMachine;
	private JList lstSparePart;
	private JLabel lblRepareId, lblMachineType, lblSparePart, lblRepairType,
			lblStartDate, lblStartTime, lblEndDate, lblEndTime, lblMachine;
	private JButton btnStart, btnEnd, btnAdd, btnRemove,
			btnCreateNewRepairtype, btnCreate, btnCancel;

	// l object for inner class Controller
	private Controller controller = new Controller();

	private Service service = Service.getInstance();

	List<SparePart> usedList = new ArrayList<SparePart>();
	List<SparePart> display = new ArrayList<SparePart>();

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
		txfRepairId.setEditable(false);
		getContentPane().add(txfRepairId);
		txfRepairId.setBounds(20, 48, 129, 20);

		// Spare Part Label and list in the JScrollPane
		lblSparePart = new JLabel();
		getContentPane().add(lblSparePart);
		lblSparePart.setText("Spare Part:");
		lblSparePart.setBounds(191, 28, 79, 14);

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
		lstAddedSparePart
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
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
		lblMachineType.setBounds(10, 74, 99, 14);
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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 211, 550, 9);
		getContentPane().add(separator);

		// Create button
		btnCreate = new JButton();
		btnCreate.setText("Create");
		btnCreate.setBounds(95, 358, 93, 23);
		getContentPane().add(btnCreate);
		btnCreate.addActionListener(controller);

		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(212, 358, 93, 23);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(controller);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 343, 550, 9);
		getContentPane().add(separator_1);

		JLabel lblAmount = new JLabel();
		lblAmount.setText("Amount");
		lblAmount.setBounds(358, 51, 54, 14);
		getContentPane().add(lblAmount);

		txfAmount = new JTextField();
		txfAmount.setBounds(358, 71, 54, 20);
		getContentPane().add(txfAmount);

		txfSearch = new JTextField();
		txfSearch.setBounds(191, 185, 151, 20);
		txfSearch.addKeyListener(controller);
		getContentPane().add(txfSearch);

		btnSave = new JButton();
		btnSave.setText("Save");
		btnSave.setBounds(454, 182, 106, 26);
		btnSave.addActionListener(controller);
		getContentPane().add(btnSave);

		btnSubmit = new JButton();
		btnSubmit.setText("Submit");
		btnSubmit.setBounds(331, 356, 106, 26);
		btnSubmit.addActionListener(controller);
		getContentPane().add(btnSubmit);

		controller.fillCbxMachineType();

	}

	public void setRepairID(int nr) {
		txfRepairId.setText("" + nr);
	}

	public boolean isCreate() {
		return controller.closedByCreate;
	}

	public boolean isSubmit() {
		return controller.closedBySubmit;
	}

	public Repair getTempRepairData() {
		int nr = Integer.parseInt(txfRepairId.getText());

		String date = txfStartDate.getText();
		String time = txfStartTime.getText();
		int sdYear = Integer.parseInt(date.substring(0, date.indexOf(".")));
		int sdMonth = Integer.parseInt(date.substring(date.indexOf(".")+1, date.lastIndexOf(".")));
		int sdDay = Integer.parseInt(date.substring(date.lastIndexOf(".")+1));
		int sdHour = Integer.parseInt(time.substring(0, time.indexOf(".")));
		int sdMinute = Integer.parseInt(time.substring(time.indexOf(".")+1, time.lastIndexOf(".")));

		Machine m = (Machine) cbxMachine.getSelectedItem();
		Repair r = new Repair(nr, new GregorianCalendar(sdYear, sdMonth - 1,
				sdDay, sdHour, sdMinute), null, m);
		
		return r;
	}

	public void setTempRepairData(Repair r) {
		cbxMachineType.setSelectedItem(r.getMachine().getType());
		cbxMachine.setSelectedItem(r.getMachine());
		txfRepairId.setText(r.getNum() + "");
		btnStart.setEnabled(false);
		txfStartDate.setText(r.getStartDate().get(GregorianCalendar.YEAR) + "."
				+ (r.getStartDate().get(GregorianCalendar.MONTH) + 1) + "."
				+ r.getStartDate().get(GregorianCalendar.DAY_OF_MONTH));
		txfStartTime.setText(r.getStartDate()
				.get(GregorianCalendar.HOUR_OF_DAY)
				+ "."
				+ r.getStartDate().get(GregorianCalendar.MINUTE)
				+ "."
				+ r.getStartDate().get(GregorianCalendar.SECOND));

	}

	private class Controller implements ActionListener, ListSelectionListener,
			KeyListener {

		private boolean closedByCreate = false;
		private boolean closedBySubmit = false;
		private boolean start;

		/**
		 * Fills SparePart list
		 */
		public void fillLstSparePart() {
			MachineType mT = (MachineType) cbxMachineType.getSelectedItem();
			lstSparePart.setListData(mT.getSpareParts().toArray());
		}

		/**
		 * Fills SparePart list with list given
		 */
		public void fillLstSparePart(List<SparePart> list) {
			lstSparePart.setListData(list.toArray());
		}

		/**
		 * Method which fills cbxRepairTypes with Repair Type list
		 */
		public void fillCbxRepairType() {
			MachineType mT = (MachineType) cbxMachineType.getSelectedItem();
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel();
			if (!mT.getRepairTypes().isEmpty()) {
				for (RepairType rt : mT.getRepairTypes()) {
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

		/**
		 * 
		 */
		public void updateView() {
			// int id = cbxMachineType.getSelectedIndex() - 1;
			controller.fillCbxMachine();
			controller.fillLstSparePart();
			controller.fillCbxRepairType();
			display.clear();
			updateDisplay();
		}

		/**
		 * Updates display JList
		 */
		public void updateDisplay() {
			/** ..............REMOVE DATA FROM JLIST START............... * */
			lstAddedSparePart.setModel(new DefaultListModel());
			DefaultListModel model = (DefaultListModel) lstAddedSparePart
					.getModel();
			model.clear();
			/** ..............REMOVE DATA FROM JLIST END................. * */
			lstAddedSparePart.setListData(display.toArray());
		}

		public void actionPerformed(ActionEvent e) {
			// boolean end;

			if (e.getSource() == btnCreate) {

				closedByCreate = true;
				CreateNewRepair_Dialog.this.setVisible(false);

			}

			if (e.getSource() == btnAdd) {
				SparePart sp = null;
				if (lstSparePart.getSelectedIndex() == -1) {
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("Select part to use.");
					return;
				} else {
					sp = (SparePart) lstSparePart.getSelectedValue();
				}
				int amount = -1;
				try {
					amount = Integer.parseInt(txfAmount.getText());
				} catch (NumberFormatException e1) {
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("Please enter amount in digits.");
					return;
				}
				display.add(new SparePart(amount, sp.getNumber(), sp.getBox()));
				updateDisplay();
			}
			if (e.getSource() == btnRemove) {
				SparePart sp = null;
				if (lstAddedSparePart.getSelectedIndex() == -1) {
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("Select part to remove.");
					return;
				} else {
					sp = (SparePart) lstSparePart.getSelectedValue();
				}

				display.remove(sp);
				updateDisplay();
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
				// end=true;
			}
			if (e.getSource() == btnCancel) {
				CreateNewRepair_Dialog.this.setVisible(false);
			}
			if (e.getSource() == cbxMachineType) {
				updateView();
			}
			if (e.getSource() == btnSave) {
				SaveRepairType_Dialog saveRType = new SaveRepairType_Dialog(
						CreateNewRepair_Dialog.this, "Save repair type");
				saveRType.setVisible(true);
				// service.addRepairType(new RepairType())
				// TODO error handling
				saveRType.dispose(); // release MS Windows resources
			}
			if (e.getSource() == btnSubmit) {
				if (display.size() > 0) {
					String date = txfEndDate.getText();
					String time = txfEndTime.getText();
					int edYear = Integer.parseInt(date.substring(0, date.indexOf(".")));
					int edMonth = Integer.parseInt(date.substring((date.indexOf(".")+1), date.lastIndexOf(".")))-1;
					int edDay = Integer.parseInt(date.substring(date.lastIndexOf(".")+1));
					int edHour = Integer.parseInt(time.substring(0, time.indexOf(".")));
					int edMinute = Integer.parseInt(time.substring(time.indexOf(".")+1, time.lastIndexOf(".")));
					GregorianCalendar endDate = new GregorianCalendar(edYear,edMonth,edDay,edHour,edMinute);
					Repair r = getTempRepairData();
					r.setEndDate(endDate);
					service.addRepair(r);
					List<PartUsage> pu = new ArrayList<PartUsage>();
					for (int i = 0; i < display.size(); i++) {
						SparePart partUsed = display.get(i);
						SparePart partInSystem = service.searchPart(partUsed.getNumber()+"").get(0);
						partInSystem.setAmount(partInSystem.getAmount() - partUsed.getAmount());
						pu.add(new PartUsage(partUsed.getAmount(), endDate, r, partInSystem));
						
					}
					r.setPartsUsage(pu);
					controller.closedBySubmit = true;
					CreateNewRepair_Dialog.this.setVisible(false);
				}
				else{
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("Please specify parts used.");
					return;
				}
			}

		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getSource() == txfSearch) {
				MachineType mT = (MachineType) cbxMachineType.getSelectedItem();
				fillLstSparePart(service.searchPart(mT.getSpareParts(),
						txfSearch.getText()));
			}

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub

		}
	}
}
