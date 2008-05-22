package gui;

import gui.Dialog.ErrorDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
					errorDialog.showMessage("Please enter 7 digit spare part number.");
					return;
				}
				int number = -1;
				// Check if it is a number typed in
				try {
					number = Integer.parseInt(numberStr);
				} catch (NumberFormatException ex) {
					// If it's not a number, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("Please enter 7 digit spare part number.");
					return;
				}
				int[] usage = service.getMonthlyPartUsage(service.searchPart(numberStr).get(0));
				fillStatisticsList(usage);
			}

		}

		private void fillStatisticsList(int[] usage) {
			
			
		}

	}
}
