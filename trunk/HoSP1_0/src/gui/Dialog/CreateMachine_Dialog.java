/**
 * 
 */
package gui.Dialog;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.Service;

/**
 * @author V
 *
 */
public class CreateMachine_Dialog extends JDialog {
	private JLabel lblName;
	private JTextField txtField;
	private JTextField txfNumber;
	private JLabel lblNnumber;
	private JButton btnOk,btnCancel;
	
	private Controller controller = new Controller();
	
	/**
	 * Create the dialog
	 */
	public CreateMachine_Dialog(JPanel owner, String title) {
	super();
	getContentPane().setLayout(null);
	this.setTitle(title);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setLocation(500, 250);
	this.setSize(163, 218);
	this.setLayout(null);
	this.setModal(true);
	this.setResizable(false);
	//
	lblNnumber = new JLabel();
	lblNnumber.setBounds(10, 22, 84, 16);
	lblNnumber.setText("Serial Number:");
	getContentPane().add(lblNnumber);

	txfNumber = new JTextField();
	txfNumber.setBounds(10, 44, 100, 20);
	txfNumber.setPreferredSize(new Dimension(100, 20));
	txfNumber.setToolTipText("Type Serial Number for the Machine");
	getContentPane().add(txfNumber);

	lblName = new JLabel();
	lblName.setBounds(10, 70, 36, 16);
	lblName.setText("Name:");
	getContentPane().add(lblName);

	txtField = new JTextField();
	txtField.setBounds(10, 92, 100, 20);
	txtField.setPreferredSize(new Dimension(100, 20));
	getContentPane().add(txtField);

	btnOk = new JButton();
	btnOk.setBounds(10, 150, 50, 26);
	btnOk.setText("Ok");
	btnOk.addActionListener(controller);
	getContentPane().add(btnOk);

	btnCancel = new JButton();
	btnCancel.setBounds(77, 150, 73, 26);
	btnCancel.setText("Cancel");
	btnCancel.addActionListener(controller);
	getContentPane().add(btnCancel);
	}
	
	public boolean isOKed() {
    	return controller.closedByOk;
    	}
	
	private class Controller implements ActionListener {
		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();
		// ...............................................//
		private boolean closedByOk = false;
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOk){
				closedByOk = true;
				CreateMachine_Dialog.this.setVisible(false);
			}
		
			if (e.getSource() == btnCancel) {
				closedByOk = false;
				CreateMachine_Dialog.this.setVisible(false);
			}
			
		}
		
		
	}
    	


}
