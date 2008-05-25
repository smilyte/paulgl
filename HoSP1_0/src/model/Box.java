/**
 * @author Elena
 */
package model;

public class Box {

	private String serialNumber;
	private Drawer drawer;
	private SparePart sparePart = null;

	/**
	 * <b>Constructor</b> Creates new box
	 * <p>
	 * 
	 * @param serialNumber
	 *            serial number of this box
	 * @param drawerNumber
	 *            drawer number, where this box is.
	 */
	public Box(String serialNumber, Drawer drawer) {
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

	/**
	 * @return the spare part of this box
	 */
	public SparePart getSparePart() {
		return sparePart;
	}

	/**
	 * @param sp
	 *            the new spare part to this drawer.
	 *            <p>
	 *            Requires: This drawer to be empty.
	 */
	public void setSp(SparePart sp) {
		this.sparePart = sp;
	}

	/**
	 * @return Serial number and spare part as a string.
	 */
	public String toString() {
		return serialNumber + " - " + sparePart;
	}

}
