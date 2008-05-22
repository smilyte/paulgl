package gui.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.Service;
import model.MachineType;

public class MachineType_Dialog extends JDialog {

	private JButton btnCancel;
	private JButton btnOk;
	private JButton btnBrowse;
	private JLabel lblDrawing;
	private JTextField txtDrawing;
	private JLabel lblName;
	private JTextField txfName;
	
	private Controller controller = new Controller();
	/**
	 * Create the dialog
	 */
	public MachineType_Dialog(JPanel owner, String title) {
		super();
		getContentPane().setLayout(null);
		setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(254, 353);
		this.setLayout(null);
		this.setModal(true);

		txfName = new JTextField();
		txfName.setBounds(10, 56, 174, 20);
		getContentPane().add(txfName);

		lblName = new JLabel();
		lblName.setText("Name:");
		lblName.setBounds(10, 36, 66, 16);
		getContentPane().add(lblName);

		txtDrawing = new JTextField();
		txtDrawing.setBounds(10, 109, 174, 20);
		getContentPane().add(txtDrawing);

		lblDrawing = new JLabel();
		lblDrawing.setText("Drawing:");
		lblDrawing.setBounds(10, 89, 66, 16);
		getContentPane().add(lblDrawing);

		btnBrowse = new JButton();
		btnBrowse.setText("Browse...");
		btnBrowse.setBounds(10, 135, 87, 20);
		getContentPane().add(btnBrowse);

		btnOk = new JButton();
		btnOk.setText("OK");
		btnOk.setBounds(10, 280, 106, 26);
		getContentPane().add(btnOk);

		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(136, 280, 106, 26);
		getContentPane().add(btnCancel);

	}

	public boolean isOKed() {
		return controller.closedByOk;
	}

	public void setMachineType(MachineType machineType) {
		controller.machineType = machineType;
		controller.updateView();
	}
	@SuppressWarnings("unused")
	private class Controller implements ActionListener {
		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();
		// ...............................................//
		private boolean closedByOk = false;
		private String name;
		private MachineType machineType;

		public void updateView() {
			
			if (machineType != null) {
				txfName.setText("" + machineType.getName());
			} else {
				txfName.setText("");
			}
		}
		
		
		// This method is called when a button is pressed.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOk) {

			}
			if (e.getSource() == btnCancel) {

			}
		}
	}
}
