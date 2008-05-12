package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DrawerPanel extends JPanel {

	private JButton btnDelete;
	private JButton btnCreateDrawer;
	private JLabel lblBoxNr;
	private JList listBoxes_Parts;
	private JScrollPane scrollPane_1;
	private JLabel lblDrawers;
	private JList listDrawers;
	private JScrollPane scrollPane;
	/**
	 * Create the panel
	 */
	public DrawerPanel() {
		super();
		createComponents();
	}
	
	public void createComponents() {
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 39, 182, 329);
		this.add(scrollPane);

		listDrawers = new JList();
		scrollPane.setViewportView(listDrawers);

		lblDrawers = new JLabel();
		lblDrawers.setText("Drawers:");
		lblDrawers.setBounds(27, 19, 182, 14);
		this.add(lblDrawers);

		btnCreateDrawer = new JButton();
		btnCreateDrawer.setText("Create Drawer...");
		btnCreateDrawer.setBounds(495, 37, 115, 23);
		this.add(btnCreateDrawer);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(257, 39, 176, 329);
		this.add(scrollPane_1);

		listBoxes_Parts = new JList();
		scrollPane_1.setViewportView(listBoxes_Parts);

		lblBoxNr = new JLabel();
		lblBoxNr.setText("Box Nr  - Part:");
		lblBoxNr.setBounds(257, 19, 176, 14);
		this.add(lblBoxNr);

		btnDelete = new JButton();
		btnDelete.setText("Delete");
		btnDelete.setBounds(495, 94, 115, 23);
		this.add(btnDelete);
		
	}

}
