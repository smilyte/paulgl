package model;

import java.util.ArrayList;
import java.util.List;

public class SparePart {

	private int amount;
	private int number;

	// link to [PartUsage] Class(--> 0..*)
	private List<PartUsage> partsUsage = new ArrayList<PartUsage>();

	/**Constructor of SparePart
	 * @param amount
	 * @param number
	 */
	public SparePart(int amount, int number) {
		this.amount = amount;
		this.number = number;
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

}
