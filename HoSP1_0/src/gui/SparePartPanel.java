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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

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

	private Controller controller = new Controller();

	/**
	 * Create the panel
	 */
	public SparePartPanel() {
		super();
		createComponents();
	}

	public void createComponents() {
		this.cbxMachineType = new JComboBox();
		this.cbxMachineType.setModel(new DefaultComboBoxModel(new String[] {
				"All", "Machine type 1", "Machine type 2", "Machine type 3",
				"Machine type 4", "Machine type 5" }));
		this.cbxMachineType.setBounds(10, 36, 152, 20);
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

		controller.fillLstSpareParts();
	}

	private class Controller implements ActionListener, KeyListener {
		private Service service = Service.getInstance();

		// Fills spare part list
		public void fillLstSpareParts() {
			/** ..............REMOVE DATA FROM JLIST START............... * */
			lstSpareParts.setModel(new DefaultListModel());
			DefaultListModel model = (DefaultListModel) lstSpareParts
					.getModel();
			model.clear();
			/** ..............REMOVE DATA FROM JLIST END................. * */
			lstSpareParts.setListData(service.getSpareParts().toArray());
			lstSpareParts.setSelectedIndex(0);
		}

		public void fillLstSpareParts(List<SparePart> list) {
			/** ..............REMOVE DATA FROM JLIST START............... * */
			lstSpareParts.setModel(new DefaultListModel());
			DefaultListModel model = (DefaultListModel) lstSpareParts
					.getModel();
			model.clear();
			/** ..............REMOVE DATA FROM JLIST END................. * */
			lstSpareParts.setListData(list.toArray());
			lstSpareParts.setSelectedIndex(0);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCreateNew) {
				// New "Create Spare part" dialog is initiated and displayed
				CreateSpartPart_Dialog createSpartPartDialog = new CreateSpartPart_Dialog(
						SparePartPanel.this, "Create Spare Part");

				createSpartPartDialog.setVisible(true);

				// waiting for modal dialog to close

				if (createSpartPartDialog.isCreate()) {
					// update view
					fillLstSpareParts();
				}
				createSpartPartDialog.dispose();
				// release MS Windows resources
			}
			if (e.getSource() == btnUpdate) {
				// New "Update Spare part" dialog is initiated and displayed
				UpdateSparePart_Dialog updateSpartPartDialog = new UpdateSparePart_Dialog(
						SparePartPanel.this, "Update Spare Part");
				SparePart sp = service.getSpareParts().get(
						lstSpareParts.getSelectedIndex());
				updateSpartPartDialog.setSparePart(sp);
				updateSpartPartDialog.setAmount(sp.getAmount());
				updateSpartPartDialog.setVisible(true);

				// waiting for modal dialog to close

				if (updateSpartPartDialog.isUpdated()) {
					// update view
					fillLstSpareParts();
				}
				updateSpartPartDialog.dispose();
				// release MS Windows resources
			}
			if (e.getSource() == btnDelete) {
				// New "Delete Spare part" dialog is initiated and displayed
				DeleteSparePart_Dialog deleteSpartPartDialog = new DeleteSparePart_Dialog(
						SparePartPanel.this, "Delete Spare Part");
				SparePart sp = service.getSpareParts().get(
						lstSpareParts.getSelectedIndex());
				deleteSpartPartDialog.setSparePart(sp);
				deleteSpartPartDialog.setVisible(true);

				// waiting for modal dialog to close

				if (deleteSpartPartDialog.isYes()) {
					// update view
					fillLstSpareParts();
				}
				deleteSpartPartDialog.dispose();
				// release MS Windows resources
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// not used but must implement.

		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("key down was pressed");
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("key up was pressed");
			}
			if(e.getSource() == txtSearch){
				fillLstSpareParts(service.searchPart(txtSearch.getText()));
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// not used,but must implement.

		}

	}
}
