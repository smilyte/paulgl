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

import model.Drawer;

public class DeleteDrawer_Dialog extends JDialog {

	private JLabel label;
	private JLabel lblQuestion;
	private JButton btnNo;
	private JButton btnYes;

	// Creating object for inner class - Controller
	private Controller controller = new Controller();

	// Creating object for moddel class - Drawer
	private Drawer drawer = null;

	/**
	 * Create the dialog
	 */
	public DeleteDrawer_Dialog(JPanel owner, String title) {
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
				.setText("<html><b>Are you sure you want to delete this drawer? The action cannot be undone.</b></html>");
		lblQuestion.setBounds(111, 18, 200, 77);
		getContentPane().add(lblQuestion);

		label = new JLabel();
		label.setIcon(SwingResourceManager.getIcon(DeleteDrawer_Dialog.class,
				"excl3.gif"));
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
	 * Sets drawer to delete.
	 */
	public void setDrawer(Drawer d) {
		this.drawer = d;
	}

	private class Controller implements ActionListener {
		private boolean closedByYes = false;
		private Service service = Service.getInstance();

		/*
		 * List of actions when buttons are pressed. (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * If YES button is pressed.
			 */
			if (e.getSource() == btnYes) {

				service.removeDrawer(drawer);

				closedByYes = true;
				DeleteDrawer_Dialog.this.setVisible(false);
			}
			/*
			 * If NO button is pressed.
			 */
			if (e.getSource() == btnNo) {
				DeleteDrawer_Dialog.this.setVisible(false);
			}
		}
	}
}
