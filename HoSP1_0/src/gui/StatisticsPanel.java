package gui;

import gui.Dialog.ErrorDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.MachineType;
import model.Machine;
import model.SparePart;

import service.Service;

public class StatisticsPanel extends JPanel {

	private JLabel lblStatistics;
	private JButton btnDisplay;
	private JList lstStatistics;
	private JScrollPane scrollPane;
	private JComboBox cbxMachines;
	private JTextField txfSparePart;
	private JComboBox cbxStatisticsType;

	private Controller controller = new Controller();

	/**
	 * Create the panel
	 */
	public StatisticsPanel() {
		super();
		setLayout(null);
		createComponents();
	}

	public void createComponents() {
		cbxStatisticsType = new JComboBox();
		cbxStatisticsType.setModel(new DefaultComboBoxModel(new String[] {
				"Choose..", "Spare Parts", "Machines" }));
		cbxStatisticsType.setBounds(10, 10, 130, 25);
		cbxStatisticsType.addActionListener(controller);
		this.add(cbxStatisticsType);

		txfSparePart = new JTextField();
		txfSparePart.setEditable(false);
		txfSparePart.setBounds(146, 12, 130, 20);
		this.add(txfSparePart);

		cbxMachines = new JComboBox();
		cbxMachines.setFocusable(false);
		cbxMachines.setBounds(10, 41, 130, 25);
		cbxMachines.setEnabled(false);
		this.add(cbxMachines);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 469, 269);
		this.add(scrollPane);

		lstStatistics = new JList();
		scrollPane.setViewportView(lstStatistics);

		btnDisplay = new JButton();
		btnDisplay.setText("Display");
		btnDisplay.setBounds(282, 9, 106, 26);
		btnDisplay.setEnabled(false);
		btnDisplay.addActionListener(controller);
		this.add(btnDisplay);

		lblStatistics = new JLabel();
		lblStatistics.setBounds(10, 74, 469, 16);
		this.add(lblStatistics);
	}

	public void setStatisticsType(String type) {
		if (type == "part") {
			txfSparePart.setEditable(true);
			cbxMachines.setEnabled(false);
			btnDisplay.setEnabled(true);
			lblStatistics.setText("Statistics for spare part: ");
		}
		if (type == "machine") {
			txfSparePart.setEditable(false);
			cbxMachines.setEnabled(true);
			btnDisplay.setEnabled(false);
			lblStatistics.setText("Statistics for machine: ");
			controller.fillCbxMachines();
		}
		if (type == "none") {
			txfSparePart.setEditable(false);
			cbxMachines.setEnabled(false);
			btnDisplay.setEnabled(false);
			lblStatistics.setText("");
		}
	}

	private class Controller implements ActionListener {
		private Service service = Service.getInstance();

		public void fillCbxMachines() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel();
			for (MachineType mt : service.getMachineTypes()) {
				for(Machine m : mt.getMachines())
					cbxModel.addElement(m);
			}
			cbxMachines.setModel(cbxModel);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == cbxStatisticsType) {
				if (cbxStatisticsType.getSelectedIndex() == 0)
					setStatisticsType("none");
				if (cbxStatisticsType.getSelectedIndex() == 1)
					setStatisticsType("part");
				if (cbxStatisticsType.getSelectedIndex() == 2)
					setStatisticsType("machine");
			}
			if (e.getSource() == btnDisplay) {
				String numberStr = txfSparePart.getText().trim();
				if (numberStr.length() != 7) {
					// if nothing is typed in, display error
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog
							.showMessage("Please enter 7 digit spare part number.");
					return;
				}
				int number = -1;
				// Check if it is a number typed in
				try {
					number = Integer.parseInt(numberStr);
				} catch (NumberFormatException ex) {
					// If it's not a number, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog
							.showMessage("Please enter 7 digit spare part number.");
					return;
				}
				SparePart sp = service.searchPart(numberStr).get(0);
				if (sp == null) {
					// If no such part exists, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog
							.showMessage("Part with this number does not exist.");
					return;
				} else {
					int[] usage = new int[12];
					try {
						usage = service.getMonthlyPartUsage(sp);
					} catch (ArrayIndexOutOfBoundsException ex) {
						// if there's no usage of the part, error message
						// appears.
						ErrorDialog errorDialog = new ErrorDialog("Error!");
						errorDialog.showMessage("Part has not been used.");
						return;
					}
					fillStatisticsList(usage);
				}

			}

		}

		private void fillStatisticsList(int[] usage) {
			/** ..............REMOVE DATA FROM JLIST START............... * */
			lstStatistics.setModel(new DefaultListModel());
			DefaultListModel model = (DefaultListModel) lstStatistics
					.getModel();
			model.clear();
			/** ..............REMOVE DATA FROM JLIST END................. * */
			List<String> list = new ArrayList<String>();
			GregorianCalendar today = new GregorianCalendar();

			for (int i = 0; i < 12; i++) {
				String s = today.getDisplayName(GregorianCalendar.MONTH,
						GregorianCalendar.LONG, new Locale("dk"));
				list.add(s + "  -  " + usage[i]);
				today.roll(GregorianCalendar.MONTH, false);
			}
			lstStatistics.setListData(list.toArray());
		}

	}
}
