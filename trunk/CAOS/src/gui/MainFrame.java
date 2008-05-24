package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import service.Service;

public class MainFrame extends JFrame {

	private JLabel lblAddedSpareParts, lblHospCaos;
	private JLabel lblEnterEndDate, lblEnterStartDate, lblChooseMachine;	
	private JList lstParts;
	private JScrollPane scrollPane;
	private JTextField addAmount, txfEndDate, txfStartDate;
	private JLabel lblEnterAmount, lblSelectSparePart;
	private JComboBox cbxSpareParts, cbxMachines;
	private JButton btnRegisterRepair, btnAdd;


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
		txfStartDate.setText("2008-05-24");
		txfStartDate.setBounds(11, 148, 156, 25);
		getContentPane().add(txfStartDate);

		lblEnterEndDate = new JLabel();
		lblEnterEndDate.setForeground(new Color(255, 255, 255));
		lblEnterEndDate.setText("Enter End Date:");
		lblEnterEndDate.setBounds(11, 194, 156, 16);
		getContentPane().add(lblEnterEndDate);

		txfEndDate = new JTextField();
		txfEndDate.setBorder(new LineBorder(Color.black, 1, false));
		txfEndDate.setText("2008-06-12");
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

		addAmount = new JTextField();
		addAmount.setBounds(299, 124, 42, 20);
		getContentPane().add(addAmount);

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
	}
	
	private class Controller implements ActionListener {

		// .............GETTING INSTANCE..................//
		private Service service = Service.getInstance();
		// ...............................................//
		
		public void updateView(){
			
			DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(service
					.getMachines().toArray());
			cbxMachines.setModel(cbxModel);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == btnAdd){
				
				//TODO Remove Lock  :)
				
			}
			
			if (e.getSource() == btnRegisterRepair){
				
				//TODO Register Repair
				
			}
			
			if (e.getSource() == cbxSpareParts){
				
				//TODO Add Lock =]
				
			}
		}

		
	}
}
