package gui.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.swtdesigner.SwingResourceManager;

import service.Service;

import model.SparePart;

public class DeleteSparePart_Dialog extends JDialog {

	private JLabel label;
	private JLabel lblQuestion;
	private JButton btnNo;
	private JButton btnYes;

	private SparePart sparePart = null;

	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public DeleteSparePart_Dialog(JPanel owner, String title) {
		super();
		getContentPane().setLayout(null);
		setResizable(false);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(363, 164);
		this.setLayout(null);
		this.setModal(true);

		btnYes = new JButton();
		btnYes.addActionListener(controller);
		btnYes.setText("Yes");
		btnYes.setBounds(25, 101, 106, 26);
		getContentPane().add(btnYes);

		btnNo = new JButton();
		btnNo.setText("No");
		btnNo.setBounds(205, 101, 106, 26);
		getContentPane().add(btnNo);
		btnNo.addActionListener(controller);

		lblQuestion = new JLabel();
		lblQuestion
				.setText("<html><b>Are you sure you want to delete this part? The action cannot be undone.</b></html>");
		lblQuestion.setBounds(111, 18, 200, 77);
		getContentPane().add(lblQuestion);

		label = new JLabel();
		label.setIcon(SwingResourceManager.getIcon(
				DeleteSparePart_Dialog.class, "excl3.gif"));
		label.setBounds(30, 18, 75, 77);
		getContentPane().add(label);

	}

	/**
	 * Checks if user chose to delete spare part.
	 * 
	 * @return boolean "true" if yes was clicked.
	 */
	public boolean isYes() {
		return controller.closedByYes;
	}

	/**
	 * Sets spare part to delete.
	 */
	public void setSparePart(SparePart sp) {
		this.sparePart = sp;
	}

	private class Controller implements ActionListener {
		private boolean closedByYes = false;
		private Service service = Service.getInstance();

		// This method is called when a button is pressed.
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnYes) {

				service.removeSparePart(sparePart);

				closedByYes = true;
				DeleteSparePart_Dialog.this.setVisible(false);
			}
			if (e.getSource() == btnNo) {
				DeleteSparePart_Dialog.this.setVisible(false);
			}
		}
	}
}