package gui;

import gui.Dialog.CreateDrawer_Dialog;
import gui.Dialog.CreateSpartPart_Dialog;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

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

	public void createComponents(){
		this.cbxMachineType = new JComboBox();
		this.cbxMachineType.setModel(new DefaultComboBoxModel(new String[] {"All", "Machine type 1", "Machine type 2", "Machine type 3", "Machine type 4", "Machine type 5"}));
		this.cbxMachineType.setBounds(10, 36, 152, 20);
		this.add(this.cbxMachineType);

		this.scrollPaneSpareParts = new JScrollPane();
		this.scrollPaneSpareParts.setBounds(181, 37, 351, 356);
		this.add(this.scrollPaneSpareParts);

		lstSpareParts = new JList();
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
		this.add(btnUpdate);

		this.btnDelete = new JButton();
		this.btnDelete.setText("Delete");
		this.btnDelete.setBounds(553, 138, 93, 23);
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
		this.add(txtSearch);

		lblSpareParts = new JLabel();
		lblSpareParts.setText("Spare parts:");
		lblSpareParts.setBounds(181, 17, 351, 14);
		this.add(lblSpareParts);

		lblChooseMachineType = new JLabel();
		lblChooseMachineType.setText("Choose machine type:");
		lblChooseMachineType.setBounds(10, 17, 152, 14);
		this.add(lblChooseMachineType);
	}
	
	private class Controller implements ActionListener{
		private Service service = Service.getInstance();

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnCreateNew){
				// New "Create Spare part" dialog is initiated and displayed
				CreateSpartPart_Dialog createSpartPartDialog = new CreateSpartPart_Dialog(
						SparePartPanel.this, "Create Spare Part");
				
				createSpartPartDialog.setVisible(true);
				
				// waiting for modal dialog to close
				
				//if (createSpartPartDialog.isCreate()) {
					// update view
					//fillLstDrawers();
				//}
				createSpartPartDialog.dispose(); //release MS Windows resources
			}
			
		}
		
	}

}

