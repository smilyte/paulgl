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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Adds a partUsage to partsUsage List Requires: partUsage != null
	 */
	void addPartUsage(PartUsage partUsage) {
		partsUsage.add(partUsage);
	}

}
