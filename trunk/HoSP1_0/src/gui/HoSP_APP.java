package gui;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class HoSP_APP {

	/**Launch the application
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Set Look And Feel for the program - default system look and feel.
		 */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out
					.println("Error setting look and feel: " + e.getMessage());
		}

		/**
		 * Creates new frame of MainFrame and makes it visible
		 */
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

}
