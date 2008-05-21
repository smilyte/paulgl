/**
 * @author Elena
 */
package model;

import java.util.List;
import java.util.ArrayList;

public class Drawer {

	private int id;
	private int numberOfBoxes;
	
	// List of boxes belonging to this drawer.
	// Link attribute to boxes
	private List<Box> boxes = new ArrayList<Box>();
	
	/**
	 * Constructor
	 * Requires numberOfBoxes > 0
	 */
	public Drawer(int id, int numberOfBoxes){
		this.id = id;
		this.numberOfBoxes = numberOfBoxes;
		createBox();
	}
	
	/**
	 * Creates a box and adds it to the drawer.
	 * @param serialNumber number of box
	 * @param drawerNumber this drawer's number
	 */
	public void createBox(){
		for(int i = 0; i < numberOfBoxes; i++){
			String s = ""+id+"_"+(i+1);
			boxes.add(new Box(s, this));
		}
	}

	/**
	 * @return the boxes
	 */
	public List<Box> getBoxes() {
		return boxes;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the numberOfBoxes
	 */
	public int getNumberOfBoxes() {
		return numberOfBoxes;
	}

	public String toString(){
		return id+" ("+getBoxes().size()+")";
	}
}
