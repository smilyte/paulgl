package gui.Dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class CreateNewRepair extends JDialog {



	private JComboBox comboBox_2;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JList list;
	/**
	 * Create the dialog
	 */
	public CreateNewRepair() {
		super();
		getContentPane().setLayout(null);
		setBounds(100, 100, 470, 427);

		JLabel lbrepareId = new JLabel();
		lbrepareId.setText("Repair ID:");
		lbrepareId.setBounds(10, 28, 54, 14);
		getContentPane().add(lbrepareId);

		JLabel lbmachineType = new JLabel();
		lbmachineType.setText("Machine Type:");
		lbmachineType.setBounds(10, 119, 79, 14);
		getContentPane().add(lbmachineType);

		JLabel label_2 = new JLabel();
		label_2.setText("spare part");
		label_2.setBounds(191, 28, 54, 14);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel();
		label_3.setText("Repair Type:");
		label_3.setBounds(10, 74, 69, 14);
		getContentPane().add(label_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 48, 232, 156);
		getContentPane().add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);

		comboBox = new JComboBox();
		comboBox.setBounds(20, 139, 129, 20);
		getContentPane().add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(20, 93, 129, 20);
		getContentPane().add(comboBox_1);

		textField = new JTextField();
		textField.setBounds(20, 48, 129, 20);
		getContentPane().add(textField);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 218, 421, 2);
		getContentPane().add(separator);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 246, 79, 20);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(95, 246, 79, 20);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(10, 292, 79, 20);
		getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setBounds(95, 292, 79, 20);
		getContentPane().add(textField_4);

		JButton butstart = new JButton();
		butstart.setText("Start");
		butstart.setBounds(191, 245, 93, 23);
		getContentPane().add(butstart);

		JButton butend = new JButton();
		butend.setText("End");
		butend.setBounds(191, 291, 93, 23);
		getContentPane().add(butend);

		JButton butcreate = new JButton();
		butcreate.setText("Create");
		butcreate.setBounds(231, 358, 93, 23);
		getContentPane().add(butcreate);

		JButton butcancel = new JButton();
		butcancel.setText("Cancel");
		butcancel.setBounds(330, 358, 93, 23);
		getContentPane().add(butcancel);

		JLabel label = new JLabel();
		label.setText("End Date:");
		label.setBounds(10, 272, 54, 14);
		getContentPane().add(label);

		JLabel lbendTime = new JLabel();
		lbendTime.setText("End Time:");
		lbendTime.setBounds(95, 272, 54, 14);
		getContentPane().add(lbendTime);

		JLabel lbstartDate = new JLabel();
		lbstartDate.setText("Start Date:");
		lbstartDate.setBounds(10, 226, 54, 14);
		getContentPane().add(lbstartDate);

		JLabel lbstartTime = new JLabel();
		lbstartTime.setText("Start Time:");
		lbstartTime.setBounds(95, 226, 54, 14);
		getContentPane().add(lbstartTime);

		JLabel lbmachine = new JLabel();
		lbmachine.setText("Machine:");
		lbmachine.setBounds(10, 165, 54, 14);
		getContentPane().add(lbmachine);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(20, 185, 129, 20);
		getContentPane().add(comboBox_2);

		JLabel label_1 = new JLabel();
		label_1.setText("New JLabel");
		label_1.setBounds(10, 336, 54, 14);
		getContentPane().add(label_1);
		//
		
	}

}
