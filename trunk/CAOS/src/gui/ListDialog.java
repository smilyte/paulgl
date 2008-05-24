/**
 * @author Vytas
 * 
 */

package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import service.Service;


public class ListDialog extends JDialog {
	private JList list;
	private JScrollPane scrollPane;
	private JLabel lblMachineType;
	private JButton btnClose;

	private Controller controller = new Controller();

	/**
	 * Create the dialog
	 */
	public ListDialog(JFrame owner, String title) {
		super();
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocation(500, 250);
		this.setSize(547, 374);
		this.setLayout(null);
		this.setModal(true);
		this.setResizable(false);
		//

		btnClose = new JButton();
		btnClose.setBounds(165, 302, 192, 26);
		btnClose.setText("Close");
		btnClose.addActionListener(controller);
		getContentPane().add(btnClose);

		lblMachineType = new JLabel();
		lblMachineType.setForeground(new Color(255, 255, 255));
		lblMachineType.setText("List:");
		lblMachineType.setBounds(10, 27, 140, 16);
		getContentPane().add(lblMachineType);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 518, 247);
		getContentPane().add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);
		
		controller.updateView();
	}

	private class Controller implements ActionListener {
		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();
		// ...............................................//
		
		public void updateView() {
			//TODO Fill List with Spare Parts and amount which needs to be ordered.  <<-- From 'ToBeOrdered' Table
			list.setListData(service.getRepairs().toArray());
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnClose) {
				ListDialog.this.setVisible(false);
			}
		}
		
	}

}
