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
	 * @param text text to be displayed in message.
	 */
	public void setLblText(String text) {
		lblQuestion.setText("<html><b>" + text + "</b></html>");
	}

	private class Controller implements ActionListener {
		// This method is called when a button is pressed.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOK) {
				ErrorDialog.this.setVisible(false);
			}
		}
	}
}
