/**
 * @author Malik and Elena
 */
package gui;

import gui.Dialog.CreateNewRepair_Dialog;
import gui.Dialog.ErrorDialog;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import model.*;
import service.Service;

public class RepairPanel extends JPanel {

	private JLabel lblOrderList;
	private JButton btnPrint;
	private JButton btnRegisterRepair;
	private JButton btnOpenRepair;
	private JList lstOrder;
	private JScrollPane scrollPaneOrder;
	private JScrollPane scrollPaneRepairs;
	private JLabel lblCurrentRepairs;
	private JList lstRepairs;

	// Creating object for inner class - Controller
	private Controller controller = new Controller();

	// List which will held all not finished repairs.
	// Note: Holding this data in the list in real situation is not good. It has
	// to be stored in file to prevent loosing data after program crash.
	private List<Repair> tempRepairs = new ArrayList<Repair>();

	/**
	 * Create the panel
	 */
	public RepairPanel() {
		super();
		createComponents();
	}

	public void createComponents() {
		lblCurrentRepairs = new JLabel();
		lblCurrentRepairs.setText("Current repairs:");
		lblCurrentRepairs.setBounds(10, 16, 295, 14);
		this.add(lblCurrentRepairs);

		scrollPaneRepairs = new JScrollPane();
		scrollPaneRepairs.setBounds(10, 36, 307, 156);
		this.add(scrollPaneRepairs);

		lstRepairs = new JList();
		scrollPaneRepairs.setViewportView(lstRepairs);
		lstRepairs.setBorder(new LineBorder(Color.black, 1, false));

		scrollPaneOrder = new JScrollPane();
		scrollPaneOrder.setBounds(10, 260, 307, 120);
		this.add(scrollPaneOrder);

		lstOrder = new JList();
		scrollPaneOrder.setViewportView(lstOrder);
		lstOrder.setBorder(new LineBorder(Color.black, 1, false));

		btnOpenRepair = new JButton();
		btnOpenRepair.setMargin(new Insets(2, 4, 2, 4));
		btnOpenRepair.setText("Open Repair...");
		btnOpenRepair.setBounds(10, 198, 95, 23);
		btnOpenRepair.addActionListener(controller);
		this.add(btnOpenRepair);

		btnRegisterRepair = new JButton();
		btnRegisterRepair.setMargin(new Insets(2, 4, 2, 4));
		btnRegisterRepair.setText("Register repair...");
		btnRegisterRepair.setBounds(212, 198, 105, 23);
		this.add(btnRegisterRepair);
		btnRegisterRepair.addActionListener(controller);

		btnPrint = new JButton();
		btnPrint.setText("Print");
		btnPrint.setBounds(10, 386, 93, 23);
		this.add(btnPrint);

		lblOrderList = new JLabel();
		lblOrderList.setText("Order list:");
		lblOrderList.setBounds(10, 240, 307, 14);
		this.add(lblOrderList);
	}

	private class Controller implements ActionListener {
		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();

		// ...............................................//

		/**
		 * Updates list of currently stopped machines - repairs in progress.
		 */
		public void updateCurrentRepairs() {
			 /** ..............REMOVE DATA FROM JLIST START............... *
			 */
			 lstRepairs.setModel(new DefaultListModel());
			 DefaultListModel model = (DefaultListModel)
			 lstRepairs.getModel();
			 model.clear();
			 /** ..............REMOVE DATA FROM JLIST END................. *
			 */
			lstRepairs.setListData(tempRepairs.toArray());
			lstRepairs.setSelectedIndex(0);
			
			//Update the order list;
			lstOrder.setListData(service.ToBeOrdered().toArray());
		}

		/*
		 * List of actions when buttons are pressed. (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {
			/*
			 * If REGISTER REPAIR button is pressed.
			 */
			if (e.getSource() == btnRegisterRepair) {

				// Initiate and open "Create new repair" dialog
				CreateNewRepair_Dialog createNewRepairDialog = new CreateNewRepair_Dialog(
						RepairPanel.this, "Create");

				createNewRepairDialog.setRepairID(service.getRepairs().size()
						+ tempRepairs.size());
				createNewRepairDialog.setVisible(true);

				// Waiting for modal dialog to close

				/*
				 * If Dialog was closed by CREATE button.
				 */
				if (createNewRepairDialog.isCreate()) {
					// Following code is executed
					try {
						tempRepairs.add(createNewRepairDialog
								.getTempRepairData());
					} catch (RuntimeException e1) {
						ErrorDialog errorDialog = new ErrorDialog("Error!");
						errorDialog
								.showMessage("The repair was not started so will not be saved");
						return;
					}
					updateCurrentRepairs();
				}

				// Release MS Windows resources
				createNewRepairDialog.dispose();
			}
			/*
			 * If OPEN REPAIR button is pressed.
			 */
			if (e.getSource() == btnOpenRepair) {
				// Opening "create new repair" dialog
				CreateNewRepair_Dialog createNewRepairDialog = new CreateNewRepair_Dialog(
						RepairPanel.this, "Create");
				// Setting the new dialog to display selected repair's data
				Repair r = (Repair) lstRepairs.getSelectedValue();
				createNewRepairDialog.setTempRepairData(r);
				// Removing from temporary repairs list, as it might be
				// submitted
				tempRepairs.remove(r);
				createNewRepairDialog.setVisible(true);

				/*
				 * If Dialog was closed by CREATE button.
				 */
				if (createNewRepairDialog.isCreate()) {
					// data from dialog is saved into tempRepairs list
					tempRepairs.add(createNewRepairDialog.getTempRepairData());
					updateCurrentRepairs();
				}
				// Release MS Windows resources
				createNewRepairDialog.dispose();
			}
		}
	}
}
