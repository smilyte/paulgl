package model;

import java.util.List;
import java.util.ArrayList;

public class Box {
	
	private int serialNumber;
	private Drawer drawer;
	
	private List<SparePart> parts = new ArrayList<SparePart>();
	
	/**
	 * Creates a box
	 * @param serialNumber serial number of this box
	 * @param drawerNumber drawer number, where this box is.
	 */
	public Box(int serialNumber, Drawer drawer){
		this.serialNumber = serialNumber;
		this.drawer = drawer;
	}

}
