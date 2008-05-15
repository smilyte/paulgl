/**
 * @author Elena
 */
package model;

public class Box {
	
	private String serialNumber;
	private Drawer drawer;
	
	/**
	 * Creates a box
	 * @param serialNumber serial number of this box
	 * @param drawerNumber drawer number, where this box is.
	 */
	public Box(String serialNumber, Drawer drawer){
		this.serialNumber = serialNumber;
		this.drawer = drawer;
	}

	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @return the drawer
	 */
	public Drawer getDrawer() {
		return drawer;
	}

}
