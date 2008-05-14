package gui.Dialog;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class CreateNewRepair extends JDialog {



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
		setBounds(100, 100, 500, 375);

		JLabel lbrepareId = new JLabel();
		lbrepareId.setText("Repair ID");
		lbrepareId.setBounds(10, 62, 54, 14);
		getContentPane().add(lbrepareId);

		JLabel label_1 = new JLabel();
		label_1.setText("Machine");
		label_1.setBounds(10, 118, 54, 14);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel();
		label_2.setText("spare part");
		label_2.setBounds(207, 29, 54, 14);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel();
		label_3.setText("R.Type");
		label_3.setBounds(10, 92, 69, 14);
		getContentPane().add(label_3);

		list = new JList();
		list.setBounds(207, 49, 224, 83);
		getContentPane().add(list);

		comboBox = new JComboBox();
		comboBox.setBounds(70, 112, 90, 20);
		getContentPane().add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(70, 86, 90, 20);
		getContentPane().add(comboBox_1);

		textField = new JTextField();
		textField.setBounds(70, 59, 90, 20);
		getContentPane().add(textField);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 172, 421, 14);
		getContentPane().add(separator);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 211, 79, 20);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(95, 211, 79, 20);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(10, 249, 79, 20);
		getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setBounds(95, 249, 79, 20);
		getContentPane().add(textField_4);

		JButton button = new JButton();
		button.setText("New JButton");
		button.setBounds(207, 210, 93, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton();
		button_1.setText("New JButton");
		button_1.setBounds(207, 248, 93, 23);
		getContentPane().add(button_1);

		JButton button_2 = new JButton();
		button_2.setText("New JButton");
		button_2.setBounds(258, 138, 93, 23);
		getContentPane().add(button_2);

		JButton button_3 = new JButton();
		button_3.setText("New JButton");
		button_3.setBounds(357, 138, 93, 23);
		getContentPane().add(button_3);

		JButton button_4 = new JButton();
		button_4.setText("New JButton");
		button_4.setBounds(258, 306, 93, 23);
		getContentPane().add(button_4);

		JButton button_5 = new JButton();
		button_5.setText("New JButton");
		button_5.setBounds(357, 306, 93, 23);
		getContentPane().add(button_5);
		//
		
	}

}
