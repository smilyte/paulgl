package model;

import java.util.ArrayList;
import java.util.List;

public class SparePart {

	private int amount;
	private int number;

	// link to [PartUsage] Class(--> 0..*)
	private List<PartUsage> partsUsage = new ArrayList<PartUsage>();
	// link to [Drawing] Class(--> 0..1)
	private Drawing drawing;
	// link to [Box] Class(--> 1)
	private Box box= null;

	/**Constructor of SparePart
	 * @param amount how many parts do we have
	 * @param number 7 digit number of a part
	 * @param box Box, where the part is placed
	 */
	public SparePart(int amount, int number, Box box) {
		this.amount = amount;
		this.number = number;
		this.box = box;
		box.setSp(this);
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Adds a partUsage to partsUsage List Requires: partUsage != null
	 */
	void addPartUsage(PartUsage partUsage) {
		partsUsage.add(partUsage);
	}

	public void setDrawing(Drawing drawing) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the partsUsage
	 */
	public List<PartUsage> getPartsUsage() {
		return partsUsage;
	}

	/**
	 * Sets new box for this spare part
	 * @param newBox Box, where the part will be placed
	 * Requires: newBox != null
	 * @author Elena
	 */
	public void setBox(Box newBox){
		if(newBox != null){
			this.box = newBox;
			newBox.setSp(this);
		}
			
	}

	/**
	 * @return box of this part
	 */
	public Box getBox(){
		return box;
	}
	
	public String toString(){
		return number+" ("+amount+")";
	}
	
}
