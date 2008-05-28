package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.Machine;
import model.PartUsage;
import model.Repair;
import model.SparePart;

import service.Service;

public class MainFrame extends JFrame {

	private JButton btnL;
	private JLabel lblAddedSpareParts, lblHospCaos;
	private JLabel lblEnterEndDate, lblEnterStartDate, lblChooseMachine;
	private JList lstParts;
	private JScrollPane scrollPane;
	private JTextField txfAmount, txfEndDate, txfStartDate;
	private JLabel lblEnterAmount, lblSelectSparePart;
	private JComboBox cbxSpareParts, cbxMachines;
	private JButton btnRegisterRepair, btnAdd;

	private int year1, year2, month1, month2, day1, day2, hour1, hour2, min1,
			min2;
	private GregorianCalendar startDate, endDate;

	private Controller controller = new Controller();

	/**
	 * Create the frame
	 */
	public MainFrame() {
		super();
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setBounds(100, 100, 362, 371);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		lblChooseMachine = new JLabel();
		lblChooseMachine.setForeground(new Color(255, 255, 255));
		lblChooseMachine.setText("Choose Machine:");
		lblChooseMachine.setBounds(11, 57, 156, 16);
		getContentPane().add(lblChooseMachine);

		cbxMachines = new JComboBox();
		cbxMachines.setBounds(10, 79, 157, 25);
		getContentPane().add(cbxMachines);

		lblEnterStartDate = new JLabel();
		lblEnterStartDate.setForeground(new Color(255, 255, 255));
		lblEnterStartDate.setText("Enter Start Date:");
		lblEnterStartDate.setBounds(11, 126, 156, 16);
		getContentPane().add(lblEnterStartDate);

		txfStartDate = new JTextField();
		txfStartDate.setBorder(new LineBorder(Color.black, 1, false));
		txfStartDate.setText("2008-05-24 12:05");
		txfStartDate.setBounds(11, 148, 156, 25);
		getContentPane().add(txfStartDate);

		lblEnterEndDate = new JLabel();
		lblEnterEndDate.setForeground(new Color(255, 255, 255));
		lblEnterEndDate.setText("Enter End Date:");
		lblEnterEndDate.setBounds(11, 194, 156, 16);
		getContentPane().add(lblEnterEndDate);

		txfEndDate = new JTextField();
		txfEndDate.setBorder(new LineBorder(Color.black, 1, false));
		txfEndDate.setText("2008-06-12 15:00");
		txfEndDate.setBounds(11, 216, 156, 25);
		getContentPane().add(txfEndDate);

		btnRegisterRepair = new JButton();
		btnRegisterRepair.setMargin(new Insets(2, 4, 2, 4));
		btnRegisterRepair.setForeground(new Color(255, 0, 0));
		btnRegisterRepair.setFont(new Font("Calibri", Font.BOLD, 16));
		btnRegisterRepair.setText("REGISTER REPAIR");
		btnRegisterRepair.setBounds(11, 273, 156, 53);
		btnRegisterRepair.addActionListener(controller);
		getContentPane().add(btnRegisterRepair);

		cbxSpareParts = new JComboBox();
		cbxSpareParts.setBounds(192, 81, 149, 25);
		cbxSpareParts.addActionListener(controller);
		getContentPane().add(cbxSpareParts);

		lblSelectSparePart = new JLabel();
		lblSelectSparePart.setForeground(new Color(255, 255, 255));
		lblSelectSparePart.setText("Select spare part:");
		lblSelectSparePart.setBounds(191, 57, 150, 16);
		getContentPane().add(lblSelectSparePart);

		lblEnterAmount = new JLabel();
		lblEnterAmount.setForeground(new Color(255, 255, 255));
		lblEnterAmount.setText("Enter amount:");
		lblEnterAmount.setBounds(192, 128, 101, 16);
		getContentPane().add(lblEnterAmount);

		txfAmount = new JTextField();
		txfAmount.setBounds(299, 124, 42, 20);
		getContentPane().add(txfAmount);

		btnAdd = new JButton();
		btnAdd.setText("Add");
		btnAdd.setBounds(236, 150, 69, 25);
		btnAdd.addActionListener(controller);
		getContentPane().add(btnAdd);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(192, 211, 149, 116);
		getContentPane().add(scrollPane);

		lstParts = new JList();
		scrollPane.setViewportView(lstParts);

		lblHospCaos = new JLabel();
		lblHospCaos.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospCaos.setForeground(new Color(255, 255, 0));
		lblHospCaos.setFont(new Font("Calibri", Font.BOLD, 36));
		lblHospCaos.setText("HoSP - CAOS");
		lblHospCaos.setBounds(11, 10, 330, 37);
		getContentPane().add(lblHospCaos);

		lblAddedSpareParts = new JLabel();
		lblAddedSpareParts.setForeground(new Color(255, 255, 255));
		lblAddedSpareParts.setText("Added parts (Amount):");
		lblAddedSpareParts.setBounds(192, 194, 149, 16);
		getContentPane().add(lblAddedSpareParts);

		btnL = new JButton();
		btnL.setBackground(Color.ORANGE);
		btnL.setForeground(Color.BLACK);
		btnL.setOpaque(true);
		btnL.setMargin(new Insets(1, 1, 1, 1));
		btnL.setText("[L]");
		btnL.setBounds(306, 10, 35, 31);
		btnL.addActionListener(controller);
		getContentPane().add(btnL);

		controller.updateView();
	}

	private class Controller implements ActionListener {

		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();
		// ...............................................//
		private List<SparePart> addedParts = new ArrayList<SparePart>();
		private List<Integer> amounts = new ArrayList<Integer>();

		public void updateView() {

			DefaultComboBoxModel cbxModel1 = new DefaultComboBoxModel(service
					.getMachines().toArray());
			cbxMachines.setModel(cbxModel1);

			DefaultComboBoxModel cbxModel2 = new DefaultComboBoxModel(service
					.getSpareParts().toArray());
			cbxSpareParts.setModel(cbxModel2);
		}

		public void formDates() {
			String date1 = txfStartDate.getText();
			String date2 = txfEndDate.getText();
			try {

				year1 = Integer.parseInt(date1.substring(0, 4));
				month1 = Integer.parseInt(date1.substring(5, 7));
				day1 = Integer.parseInt(date1.substring(8, 10));
				hour1 = Integer.parseInt(date1.substring(11, 13));
				min1 = Integer.parseInt(date1.substring(14, date1.length()));

				year2 = Integer.parseInt(date2.substring(0, 4));
				month2 = Integer.parseInt(date2.substring(5, 7));
				day2 = Integer.parseInt(date2.substring(8, 10));
				hour2 = Integer.parseInt(date2.substring(11, 13));
				min2 = Integer.parseInt(date2.substring(14, date1.length()));

				startDate = new GregorianCalendar(year1, month1, day1, hour1,
						min1);
				endDate = new GregorianCalendar(year2, month2, day2, hour2,
						min2);

			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null,
//						"<html>Incorrect date format. Format: YYYY-MM-DD HH:MM <html/>",
//						"Date format error", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
		
		public void fillPartsList(){
			List<String> list = new ArrayList<String>();
			
			for (int i = 0; i < addedParts.size(); i++) {
				
				list.add(addedParts.get(i).toString()+"-  Amount: " + amounts.get(i).toString());
				
			}
			lstParts.setListData(list.toArray());
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnAdd) {
				int amount = 0;

				try {
					amount = Integer.parseInt(txfAmount.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
							"You didn't specified the amount.", "Error",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				SparePart sparePart = (SparePart) cbxSpareParts
						.getSelectedItem();
				System.out.println(sparePart);
				addedParts.add(sparePart);
				amounts.add(amount);
	
				
				
				try {
					//create connection 
					Connection myConnection;
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					myConnection = DriverManager.getConnection("jdbc:odbc:smileSql","sa", "h353i62");
					// set the correct isolation level
					myConnection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);  
				// 	start the transaction	
					myConnection.setAutoCommit(false);  
					
					// Check the existence and find the balance for the first account 
					String sql = "SELECT s.amount FROM SparePart s WHERE s.number = ?";
					PreparedStatement stmt = myConnection.prepareStatement(sql);
					stmt.clearParameters();
					System.out.println(sparePart.getNumber());
					stmt.setInt(1, sparePart.getNumber());
					ResultSet res=stmt.executeQuery();
					int oldAmount;
					if (res.next()) {
						oldAmount = res.getInt(1);
						if (oldAmount < amount)
							throw new Myexception("There is not enough parts in stock",myConnection);
					}
					else
						throw new Myexception("Part is not selected",myConnection);
					res.close();
					
					// the stop to test the concurrency
					DummyDialog dummyDialog = new DummyDialog();
					dummyDialog.setVisible(true);
					dummyDialog.dispose(); // release MS Windows resources
					
					//calculate new balances
					oldAmount = oldAmount - amount; // updated amount for spare part in database
					//make the updates
					sql = "update SparePart set amount = ? where number = ?";
					stmt = myConnection.prepareStatement(sql);
					stmt.clearParameters();
					stmt.setInt(1, oldAmount);
					stmt.setInt(2, sparePart.getNumber());
					stmt.execute();
					myConnection.commit();
					System.out.println("The parts have been reduced");	
					fillPartsList();
				}
				catch (Myexception ex) {
					System.out.println(ex.getMessage());
					try {
						ex.con.rollback();
					}
					catch (java.sql.SQLException e1) {}
					    System.out.println(ex.getMessage());
					    }
				catch (java.sql.SQLException e1) {
					System.out.println(e1.getMessage());
					addedParts.remove(sparePart);
					amounts.remove(amounts.size()-1);
				}
				catch (Exception ex) {
					System.out.println("error:  "+ex.getMessage());
				}				
				txfAmount.setText("");
	
			}

			if (e.getSource() == btnRegisterRepair) {

				//Program stops if user didn't add any spare parts to a repair.
				if (addedParts.size() <=0){
					JOptionPane.showMessageDialog(null,
							"You didn't add any spare parts to this repair.",
							"Error", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
					
				formDates();
				Machine machine = (Machine) cbxMachines.getSelectedItem();

				Repair repair = new Repair(service.getRepairs().size() + 1,
						startDate, endDate, machine);

				SparePart sparePart;

				for (int i = 0; i < addedParts.size(); i++) {
					sparePart = addedParts.get(i);
					int amount = amounts.get(i);
					PartUsage partUsage = new PartUsage(amount, startDate,
							repair, sparePart);
					repair.addPartUsage(partUsage);
				}

				JOptionPane.showMessageDialog(null,
						"<html>Repair for " + machine
								+ " has been registered",
						"Repair Complete", JOptionPane.INFORMATION_MESSAGE);

				service.addRepair(repair);
				//Deleting old data
				addedParts.clear();
				amounts.clear();
				updateView();
				fillPartsList();
				// TODO Register Repair
				

			}
			if (e.getSource() == btnL) {

				ListDialog listDialog = new ListDialog(
						MainFrame.this, "View List");

				listDialog.setVisible(true);
				// waiting for modal dialog to close

				// release MS Windows resources
				listDialog.dispose(); 

			}

			if (e.getSource() == cbxSpareParts) {

				
			}
		}

	}
}
