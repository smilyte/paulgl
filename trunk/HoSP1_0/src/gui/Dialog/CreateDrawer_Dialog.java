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

import model.Drawer;

public class CreateDrawer_Dialog extends JDialog {

	private JButton btnCancel;
	private JButton btnCreate;
	private JLabel lblNrOfBox;
	private JTextField txtNrOfBox;
	private JLabel lblNumber;
	private JTextField txtNumber;

	private Drawer drawer = null;

	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public CreateDrawer_Dialog(JPanel owner, String title) {
		super();
		getContentPane().setLayout(null);
		setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(254, 353);
		this.setLayout(null);
		this.setModal(true);

		txtNumber = new JTextField();
		txtNumber.setEditable(false);
		txtNumber.setBounds(10, 56, 174, 20);
		getContentPane().add(txtNumber);

		lblNumber = new JLabel();
		lblNumber.setText("Number:");
		lblNumber.setBounds(10, 36, 66, 16);
		getContentPane().add(lblNumber);

		txtNrOfBox = new JTextField();
		txtNrOfBox.setBounds(10, 109, 174, 20);
		getContentPane().add(txtNrOfBox);

		lblNrOfBox = new JLabel();
		lblNrOfBox.setText("Number of boxes:");
		lblNrOfBox.setBounds(10, 89, 174, 16);
		getContentPane().add(lblNrOfBox);

		btnCreate = new JButton();
		btnCreate.addActionListener(controller);
		btnCreate.setText("Create");
		btnCreate.setBounds(10, 280, 106, 26);
		getContentPane().add(btnCreate);

		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(136, 280, 106, 26);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(controller);

	}

	public void setDrawerNumber(int nr) {
		txtNumber.setText("" + nr);
	}

	public boolean isCreate() {
		return controller.closedByCreate;
	}

	private class Controller implements ActionListener {
		private boolean closedByCreate = false;
		private Service service = Service.getInstance();

		// This method is called when a button is pressed.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCreate) {
				String nrStr = txtNrOfBox.getText().trim();
				if (nrStr.length() == 0)
					return; // TODO error dialog
				int nr = -1;
				try {
					nr = Integer.parseInt(nrStr);
				} catch (NumberFormatException ex) {
					return;
					// TODO error dialog
				}

				if (nr < 0) {
					// TODO: notify user
					return;
				}

				/** ** update storage *** */
				int drawerNumber = service.getDrawers().get(service.getDrawers().size()-1).getId()+1;
				if (drawer == null) {
					service.addDrawer(new Drawer(drawerNumber, nr));
				}

				closedByCreate = true;
				CreateDrawer_Dialog.this.setVisible(false);
			}
			if (e.getSource() == btnCancel) {
				CreateDrawer_Dialog.this.setVisible(false);
			}
		}
	}
}
