package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DummyDialog extends JDialog {

	private JButton btnOk;
	private JLabel lblTwo;
	private JLabel lblOne;
	
	private Controller controller = new Controller();
	
	/**
	 * Create the dialog
	 */
	public DummyDialog() {
		super();
		getContentPane().setLayout(null);
		setBounds(100, 100, 319, 159);
		this.setModal(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);

		lblOne = new JLabel();
		lblOne.setText("This is a dialog to test concurency.");
		lblOne.setBounds(10, 10, 291, 16);
		getContentPane().add(lblOne);

		lblTwo = new JLabel();
		lblTwo.setText("Press OK to continue..");
		lblTwo.setBounds(10, 59, 291, 16);
		getContentPane().add(lblTwo);

		btnOk = new JButton();
		btnOk.setText("OK");
		btnOk.setBounds(91, 94, 106, 26);
		btnOk.addActionListener(controller);
		getContentPane().add(btnOk);
		//
	}

	private class Controller implements ActionListener {
		// This method is called when a button is pressed.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOk) {
				DummyDialog.this.setVisible(false);
			}
		}
	}
}
