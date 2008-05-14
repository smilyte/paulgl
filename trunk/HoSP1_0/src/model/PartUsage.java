package model;

import java.util.Date;

public class PartUsage {
	
	private int amount;
	private Date date; 	

	public PartUsage(int amount, Date date, Repair repair, SparePart sparePart) {
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
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	
	

}
