package model;

public class PartUsage {
	
	private int amount;
	private String date; // Or Date type?
	

	public PartUsage(int amount, String date, Repair repair, SparePart sparePart) {
		this.amount = amount;
		this.date = date;
		repair.addPartUsage(this);
		sparePart.addPartUsage(this);
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	
	

}
