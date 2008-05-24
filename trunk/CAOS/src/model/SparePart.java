package model;

//import java.util.ArrayList;
//import java.util.List;

public class SparePart {

	private int amount;
	private int number;

//	// link to [PartUsage] Class(--> 0..*)
//	private List<PartUsage> partsUsage = new ArrayList<PartUsage>();

	/**Constructor of SparePart
	 * @param amount how many parts do we have
	 * @param number 7 digit number of a part
	 * @param box Box, where the part is placed
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

//	/**
//	 * Adds a partUsage to partsUsage List Requires: partUsage != null
//	 */
//	void addPartUsage(PartUsage partUsage) {
//		partsUsage.add(partUsage);
//	}
//
//	/**
//	 * @return the partsUsage
//	 */
//	public List<PartUsage> getPartsUsage() {
//		return partsUsage;
//	}

	public String toString(){
		return number+" ("+amount+")";
	}
	
}
