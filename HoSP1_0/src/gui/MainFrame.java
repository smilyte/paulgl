package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import service.Service;

public class MainFrame extends JFrame {

	private JPanel panel_5;
	private JPanel panel_4;
	private JPanel panel_3;
	private JPanel panel_2;
	private JPanel panel_1;
	private JPanel panel;
	private JTabbedPane tabbedPane;

	/**
	 * Create the frame
	 */
	public MainFrame() {
		super();
		getContentPane().setLayout(new BorderLayout());
		setBounds(100, 100, 725, 482);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		/*
		 * Added Window listener to know wen program is closing. Before program
		 * closes it deletes Db4o file.
		 */
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Service.getInstance().closeDb4o();
			}
		});

		// Created Tabbed pane which will hold all our panels
		tabbedPane = new JTabbedPane();
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		/*
		 * Creating new panels and assigning to different classes which we have
		 * in GUI package.
		 */
		panel = new RepairPanel();
		panel.setLayout(null);
		tabbedPane.addTab("Repair", null, panel, null);

		panel_1 = new SparePartPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("Spare Part", null, panel_1, null);

		panel_2 = new MachineTypePanel();
		panel_2.setLayout(null);
		tabbedPane.addTab("Machine Type", null, panel_2, null);

		panel_3 = new MachinePanel();
		panel_3.setLayout(null);
		tabbedPane.addTab("Machine", null, panel_3, null);

		panel_4 = new DrawerPanel();
		panel_4.setLayout(null);
		tabbedPane.addTab("Drawer", null, panel_4, null);

		panel_5 = new StatisticsPanel();
		panel_5.setLayout(null);
		tabbedPane.addTab("Statistics", null, panel_5, null);

	}
}
