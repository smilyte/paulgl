/**
 * @author Vytas
 */

package gui.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import service.Service;
import model.MachineType;
import model.SparePart;

public class MachineType_AddPartDialog extends JDialog {

	private JList lstSpareParts;
	private JScrollPane scrollPane;
	private JButton btnCancel;
	private JButton btnOk;
	private JLabel lblSelectPart;

	// Creating object for inner class - Controller
	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public MachineType_AddPartDialog(JPanel owner, String title) {
		super();
		getContentPane().setLayout(null);
		setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(195, 353);
		this.setLayout(null);
		this.setModal(true);

		lblSelectPart = new JLabel();
		lblSelectPart.setText("Select a part you want to add:");
		lblSelectPart.setBounds(10, 21, 204, 16);
		getContentPane().add(lblSelectPart);

		btnOk = new JButton();
		btnOk.setText("OK");
		btnOk.setBounds(10, 280, 69, 26);
		btnOk.addActionListener(controller);
		getContentPane().add(btnOk);

		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(105, 280, 73, 26);
		btnCancel.addActionListener(controller);
		getContentPane().add(btnCancel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 168, 208);
		getContentPane().add(scrollPane);

		lstSpareParts = new JList();
		scrollPane.setViewportView(lstSpareParts);

		// Calling methods from Controller class
		controller.updateView();
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

		// Creating object for model class - Spare Part
		private SparePart sparePart;

		// Creating object for model class - Machine Type
		private MachineType machineType;

		/**
		 * Updates te list
		 */
		public void updateView() {
			lstSpareParts.setListData(service.getSpareParts().toArray());
		}

		/*
		 * List of actions when buttons are pressed. (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			/*
			 * If OK button is pressed.
			 */
			if (e.getSource() == btnOk) {

				if (lstSpareParts.getSelectedIndex() >= 0) {
					sparePart = (SparePart) lstSpareParts.getSelectedValue();
				} else {
					// Show error message
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					errorDialog.showMessage("You have to select Spare Part.");
					return;
				}

				machineType.addSparePart(sparePart);
				closedByOk = true;
				MachineType_AddPartDialog.this.setVisible(false);

			}
			/*
			 * If CANCEL button is pressed.
			 */
			if (e.getSource() == btnCancel) {
				closedByOk = false;
				MachineType_AddPartDialog.this.setVisible(false);
			}
		}
	}
}
