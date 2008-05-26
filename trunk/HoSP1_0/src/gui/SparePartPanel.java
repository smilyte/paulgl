package gui;

import gui.Dialog.CreateSpartPart_Dialog;
import gui.Dialog.DeleteSparePart_Dialog;
import gui.Dialog.UpdateSparePart_Dialog;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import model.MachineType;
import model.SparePart;

import service.Service;

public class SparePartPanel extends JPanel {

	private JTextField txtSearch;
	private JLabel lblSearch;
	private JButton btnViewDrawing;
	private JList lstSpareParts;
	private JLabel lblChooseMachineType;
	private JLabel lblSpareParts;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnCreateNew;
	private JScrollPane scrollPaneSpareParts;
	private JComboBox cbxMachineType;

	// Creating object for inner class - Controller
	private Controller controller = new Controller();

	/**
	 * Create the panel
	 */
	public SparePartPanel() {
		super();
		createComponents();
	}

	public void createComponents() {
		cbxMachineType = new JComboBox();
		cbxMachineType.setBounds(10, 36, 152, 20);
		cbxMachineType.addActionListener(controller);
		this.add(this.cbxMachineType);

		this.scrollPaneSpareParts = new JScrollPane();
		this.scrollPaneSpareParts.setBounds(181, 37, 351, 356);
		this.add(this.scrollPaneSpareParts);

		lstSpareParts = new JList();
		lstSpareParts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstSpareParts.setBorder(new LineBorder(Color.black, 1, false));
		this.scrollPaneSpareParts.setViewportView(lstSpareParts);

		btnCreateNew = new JButton();
		btnCreateNew.setMargin(new Insets(2, 4, 2, 4));
		btnCreateNew.setText("Create new...");
		btnCreateNew.setBounds(553, 35, 93, 23);
		btnCreateNew.addActionListener(controller);
		this.add(btnCreateNew);

		btnUpdate = new JButton();
		btnUpdate.setText("Update...");
		btnUpdate.setBounds(553, 87, 93, 23);
		btnUpdate.addActionListener(controller);
		this.add(btnUpdate);

		btnDelete = new JButton();
		btnDelete.setText("Delete");
		btnDelete.setBounds(553, 138, 93, 23);
		btnDelete.addActionListener(controller);
		this.add(this.btnDelete);

		btnViewDrawing = new JButton();
		btnViewDrawing.setMargin(new Insets(2, 4, 2, 4));
		btnViewDrawing.setText("View Drawing");
		btnViewDrawing.setBounds(553, 370, 93, 23);
		this.add(btnViewDrawing);

		lblSearch = new JLabel();
		lblSearch.setText("Search:");
		lblSearch.setBounds(10, 142, 152, 14);
		this.add(lblSearch);

		txtSearch = new JTextField();
		txtSearch.setBounds(10, 162, 152, 20);
		txtSearch.addKeyListener(controller);
		this.add(txtSearch);

		lblSpareParts = new JLabel();
		lblSpareParts.setText("Spare parts:");
		lblSpareParts.setBounds(181, 17, 351, 14);
		this.add(lblSpareParts);

		lblChooseMachineType = new JLabel();
		lblChooseMachineType.setText("Choose machine type:");
		lblChooseMachineType.setBounds(10, 17, 152, 14);
		this.add(lblChooseMachineType);

		// Calling methods from Controller class
		controller.fillLstSpareParts();
		controller.fillCbxMachineType();
	}

	private class Controller implements ActionListener, KeyListener {
		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();

		// ...............................................//
		/**
		 * Fills cbxMachineType with Machine Type list
		 */
		public void fillCbxMachineType() {
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getMachineTypes().toArray());
			cbxModel.insertElementAt("All", 0);
			cbxMachineType.setModel(cbxModel);
			cbxMachineType.setSelectedIndex(0);
		}

		/**
		 * Fills JList with Spare Parts
		 */
		public void fillLstSpareParts() {
			// /** ..............REMOVE DATA FROM JLIST START............... *
			// */
			// lstSpareParts.setModel(new DefaultListModel());
			// DefaultListModel model = (DefaultListModel) lstSpareParts
			// .getModel();
			// model.clear();
			// /** ..............REMOVE DATA FROM JLIST END................. *
			// */
			lstSpareParts.setListData(service.getSpareParts().toArray());
			lstSpareParts.setSelectedIndex(0);
		}

		/**
		 * Fills JList with Spare Parts
		 * <p>
		 * <b>Requires:</b> list != null
		 */
		public void fillLstSpareParts(List<SparePart> list) {
			// /** ..............REMOVE DATA FROM JLIST START............... *
			// */
			// lstSpareParts.setModel(new DefaultListModel());
			// DefaultListModel model = (DefaultListModel) lstSpareParts
			// .getModel();
			// model.clear();
			// /** ..............REMOVE DATA FROM JLIST END................. *
			// */
			lstSpareParts.setListData(list.toArray());
			lstSpareParts.setSelectedIndex(0);
		}

		/*
		 * List of actions when buttons are pressed. (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * If CREATE button is pressed.
			 */
			if (e.getSource() == btnCreateNew) {
				// New "Create Spare part" dialog is initiated and displayed
				CreateSpartPart_Dialog createSpartPartDialog = new CreateSpartPart_Dialog(
						SparePartPanel.this, "Create Spare Part");

				createSpartPartDialog.setVisible(true);

				// Waiting for modal dialog to close

				if (createSpartPartDialog.isCreate()) {
					// update view
					fillLstSpareParts();
				}
				// Release MS Windows resources
				createSpartPartDialog.dispose();

			}
			/*
			 * If UPDATE button is pressed.
			 */
			if (e.getSource() == btnUpdate) {
				// New "Update Spare part" dialog is initiated and displayed
				UpdateSparePart_Dialog updateSpartPartDialog = new UpdateSparePart_Dialog(
						SparePartPanel.this, "Update Spare Part");

				// Getting an object of selected Spare Part
				SparePart sp = service.getSpareParts().get(
						lstSpareParts.getSelectedIndex());

				// Letting Dialog know about the spare part we want to update
				updateSpartPartDialog.setSparePart(sp);
				updateSpartPartDialog.setAmount(sp.getAmount());
				updateSpartPartDialog.setVisible(true);

				// Waiting for modal dialog to close
				/*
				 * If Dialog was closed by UPDATE button.
				 */
				if (updateSpartPartDialog.isUpdated()) {
					// update view
					fillLstSpareParts();
				}
				// Release MS Windows resources
				updateSpartPartDialog.dispose();
			}

			/*
			 * If DELETE button is pressed.
			 */
			if (e.getSource() == btnDelete) {
				// New "Delete Spare part" dialog is initiated and displayed
				DeleteSparePart_Dialog deleteSpartPartDialog = new DeleteSparePart_Dialog(
						SparePartPanel.this, "Delete Spare Part");
				SparePart sp = service.getSpareParts().get(
						lstSpareParts.getSelectedIndex());
				deleteSpartPartDialog.setSparePart(sp);
				deleteSpartPartDialog.setVisible(true);

				// Waiting for modal dialog to close

				/*
				 * If Dialog was closed by YES button.
				 */
				if (deleteSpartPartDialog.isYes()) {
					// update view
					fillLstSpareParts();
				}
				// Release MS Windows resources
				deleteSpartPartDialog.dispose();

			}
			/*
			 * If MACHINE TYPE in the list was selected.
			 */
			if (e.getSource() == cbxMachineType) {
				if (cbxMachineType.getSelectedIndex() > 0) {
					MachineType mT = (MachineType) cbxMachineType
							.getSelectedItem();
					fillLstSpareParts(mT.getSpareParts());
				} else if (cbxMachineType.getSelectedIndex() == 0) {
					fillLstSpareParts();
				}

			}
		}

		/*
		 * List of actions when keys are pressed. (non-Javadoc)
		 * 
		 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			// not used but must be implemented.

		}

		@Override
		public void keyReleased(KeyEvent e) {
			/*
			 * If a key is pressed while SEARCH text field was focused.
			 */
			if (e.getSource() == txtSearch) {
				//Search for the spare part
				fillLstSpareParts(service.searchPart(txtSearch.getText()));
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// not used,but must be implemented.

		}

	}
}
