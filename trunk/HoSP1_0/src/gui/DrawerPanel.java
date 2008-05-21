package gui;

import gui.Dialog.CreateDrawer_Dialog;
import gui.Dialog.DeleteDrawer_Dialog;
import gui.Dialog.ErrorDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import service.Service;

public class DrawerPanel extends JPanel {

	private JButton btnDelete;
	private JButton btnCreateDrawer;
	private JLabel lblBoxNr;
	private JList listBoxes_Parts;
	private JScrollPane scrollPane_1;
	private JLabel lblDrawers;
	private JList lstDrawers;
	private JScrollPane scrollPane;

	private Controller controller = new Controller();

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

		lstDrawers = new JList();
		lstDrawers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lstDrawers);
		lstDrawers.addListSelectionListener(controller);

		lblDrawers = new JLabel();
		lblDrawers.setText("Drawers:");
		lblDrawers.setBounds(27, 19, 182, 14);
		this.add(lblDrawers);

		btnCreateDrawer = new JButton();
		btnCreateDrawer.addActionListener(controller);
		btnCreateDrawer.setText("Create Drawer...");
		btnCreateDrawer.setBounds(495, 37, 115, 23);
		this.add(btnCreateDrawer);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(257, 39, 176, 329);
		this.add(scrollPane_1);

		listBoxes_Parts = new JList();
		scrollPane_1.setViewportView(listBoxes_Parts);
		listBoxes_Parts.addListSelectionListener(controller);
		
		lblBoxNr = new JLabel();
		lblBoxNr.setText("Box Nr  - Part:");
		lblBoxNr.setBounds(257, 19, 176, 14);
		this.add(lblBoxNr);

		btnDelete = new JButton();
		btnDelete.setText("Delete");
		btnDelete.setBounds(495, 94, 115, 23);
		this.add(btnDelete);
		btnDelete.addActionListener(controller);

		
		controller.fillLstDrawers();
	}

	/**
	 * 
	 * @author Elena
	 *
	 */
	private class Controller implements ActionListener, ListSelectionListener {
		private Service service = Service.getInstance();
		
		// Fills drawers list
		public void fillLstDrawers() {
			lstDrawers.setListData(service.getDrawers().toArray());
		}
		
		private void updateView() {

			/** ..............REMOVE DATA FROM JLIST START............... * */
			listBoxes_Parts.setModel(new DefaultListModel());
			DefaultListModel model = (DefaultListModel) listBoxes_Parts.getModel();
			model.clear();
			/** ..............REMOVE DATA FROM JLIST END................. * */ 
			
			int i = -1;
			if(lstDrawers.getSelectedIndex() == -1) i = 0;
			else i = lstDrawers.getSelectedIndex();
			
			listBoxes_Parts.setListData(service.getDrawers().get(i).getBoxes().toArray());
		}

		// List of actions when buttons are pressed.
		public void actionPerformed(ActionEvent e) {
			
			// List of actions when "Create" button is pressed.
			if (e.getSource() == btnCreateDrawer) {
				// New "Create drawer" dialog is initiated and displayed
				CreateDrawer_Dialog createDrawerDialog = new CreateDrawer_Dialog(
						DrawerPanel.this, "Create Drawer");
				createDrawerDialog.setDrawerNumber(service.getDrawers().get(service.getDrawers().size()-1).getId()+1);
				createDrawerDialog.setVisible(true);

				// waiting for modal dialog to close
				
				if (createDrawerDialog.isCreate()) {
					// update view
					fillLstDrawers();
				}
				createDrawerDialog.dispose(); //release MS Windows resources
			}
			
			// List of actions when "Delete" button is pressed
			if (e.getSource() == btnDelete){
				// New "Delete drawer" dialog is initiated
				DeleteDrawer_Dialog deleteDrawerDialog = new DeleteDrawer_Dialog(
						DrawerPanel.this, "Delete Drawer");
				// We find which drawer is to be deleted.
				int i = -1;
				if(lstDrawers.getSelectedIndex() == -1) {
					// If nothing is selected, error message appears.
					ErrorDialog errorDialog = new ErrorDialog("Error!");
					// Text of the error message:
					errorDialog.setLblText("Please select drawer to delete.");
					errorDialog.setVisible(true);

					// Waiting for error dialog to close

					errorDialog.dispose(); // release MS Windows resources
					return;
				}
				else i = lstDrawers.getSelectedIndex();
				deleteDrawerDialog.setDrawer(service.getDrawers().get(i));
				deleteDrawerDialog.setVisible(true);
				
				// waiting for modal dialog to close
				
				if (deleteDrawerDialog.isYes()) {
					// The dialog is closed by creating drawer, so we update list.
					fillLstDrawers();
				}
				deleteDrawerDialog.dispose(); //release MS Windows resources
			}
		}

		// List of actions when selection is changed.
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == lstDrawers) {
				if (!e.getValueIsAdjusting()) {
					updateView();
				}
			}
			
		}

	}

}
