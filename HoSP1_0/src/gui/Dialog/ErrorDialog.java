/**
 * Custom error dialog. When created, a custom message can be set. 
 * Designed to make program more user friendly.
 * 
 * @author Elena
 */
package gui.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.swtdesigner.SwingResourceManager;

public class ErrorDialog extends JDialog {

	private JLabel label;
	private JLabel lblQuestion;
	private JButton btnOK;

	// Creating object for inner class - Controller
	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public ErrorDialog(String title) {
		super();
		getContentPane().setLayout(null);
		setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(363, 164);
		this.setLayout(null);
		this.setModal(true);

		btnOK = new JButton();
		btnOK.addActionListener(controller);
		btnOK.setText("OK");
		btnOK.setBounds(121, 101, 106, 26);
		getContentPane().add(btnOK);

		lblQuestion = new JLabel();
		lblQuestion.setBounds(111, 18, 200, 77);
		getContentPane().add(lblQuestion);

		label = new JLabel();
		label.setIcon(SwingResourceManager.getIcon(ErrorDialog.class,
				"excl3.gif"));
		label.setBounds(30, 18, 75, 77);
		getContentPane().add(label);
	}

	/**
	 * Custom error text.
	 * 
	 * @param text
	 *            text to be displayed in message.
	 */
	public void setLblText(String text) {
		lblQuestion.setText("<html><b>" + text + "</b></html>");
	}

	/**
	 * Shows Option pane dialog with text inside
	 * 
	 * @param msg
	 */
	public void showMessage(String msg) {
		// ... error message appears.
		// Text of the error message:
		this.setLblText(msg);
		this.setVisible(true);
		// Waiting for error dialog to close

		// release MS Windows resources
		this.dispose();
	}

	private class Controller implements ActionListener {
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
			if (e.getSource() == btnOK) {
				ErrorDialog.this.setVisible(false);
			}
		}
	}
}
