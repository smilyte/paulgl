package model;

import java.util.List;
import java.util.ArrayList;

public class Drawer {

	private int number;
	
	private List<Box> boxes = new ArrayList<Box>();
	
	/**
	 * Constructor
	 */
	public Drawer(int number){
		this.number = number;
	}
	
	/**
	 * Creates a box and adds it to the drawer.
	 * @param serialNumber number of box
	 * @param drawerNumber this drawer's number
	 */
	public void createBox(int serialNumber){
		boxes.add(new Box(serialNumber, this));
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the boxes
	 */
	public List<Box> getBoxes() {
		return boxes;
	}
	
	
}
