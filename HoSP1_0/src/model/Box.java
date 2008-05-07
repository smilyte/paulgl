package model;

import java.util.List;
import java.util.ArrayList;

public class Box {
	
	private int serialNumber;
	private Drawer drawer;
	
	/**
	 * Creates a box
	 * @param serialNumber serial number of this box
	 * @param drawerNumber drawer number, where this box is.
	 */
	public Box(int serialNumber, Drawer drawer){
		this.serialNumber = serialNumber;
		this.drawer = drawer;
	}

	/**
	 * @return the serialNumber
	 */
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @return the drawer
	 */
	public Drawer getDrawer() {
		return drawer;
	}

}
