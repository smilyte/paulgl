package gui;

import gui.Dialog.CreateDrawer_Dialog;
import gui.Dialog.DeleteDrawer_Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

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

	private class Controller implements ActionListener, ListSelectionListener {
		private Service service = Service.getInstance();
		
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

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCreateDrawer) {
				CreateDrawer_Dialog createDrawerDialog = new CreateDrawer_Dialog(
						DrawerPanel.this, "Create Drawer");
				createDrawerDialog.setDrawerNumber(service.getDrawers().get(service.getDrawers().size()-1).getId()+1);
				createDrawerDialog.setVisible(true);

				// waiting for modal dialog to close
				
				if (createDrawerDialog.isCreate()) {
					/**** update view ****/
					fillLstDrawers();
				}
				createDrawerDialog.dispose(); //release MS Windows resources
			}
			if (e.getSource() == btnDelete){
				DeleteDrawer_Dialog deleteDrawerDialog = new DeleteDrawer_Dialog(
						DrawerPanel.this, "Delete Drawer");
				int i = -1;
				if(lstDrawers.getSelectedIndex() == -1) i = 0;
				else i = lstDrawers.getSelectedIndex();
				deleteDrawerDialog.setDrawer(service.getDrawers().get(i));
				deleteDrawerDialog.setVisible(true);
				
				// waiting for modal dialog to close
				
				if (deleteDrawerDialog.isYes()) {
					/**** update view ****/
					fillLstDrawers();
				}
				deleteDrawerDialog.dispose(); //release MS Windows resources
			}

		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == lstDrawers) {
				if (!e.getValueIsAdjusting()) {
					updateView();
				}
			}
			
		}

	}

}
