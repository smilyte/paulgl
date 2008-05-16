package gui;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

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
	/**
	 * Create the panel
	 */
	public RepairPanel() {
		super();
		createComponents();
	}
	
	public void createComponents(){
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
		this.add(btnOpenRepair);

		btnRegisterRepair = new JButton();
		btnRegisterRepair.setMargin(new Insets(2, 4, 2, 4));
		btnRegisterRepair.setText("Register repair...");
		btnRegisterRepair.setBounds(212, 198, 105, 23);
		this.add(btnRegisterRepair);

		btnPrint = new JButton();
		btnPrint.setText("Print");
		btnPrint.setBounds(10, 386, 93, 23);
		this.add(btnPrint);

		lblOrderList = new JLabel();
		lblOrderList.setText("Order list:");
		lblOrderList.setBounds(10, 240, 307, 14);
		this.add(lblOrderList);
	}

}