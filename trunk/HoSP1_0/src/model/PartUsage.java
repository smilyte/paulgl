/**
 * @author Vytas
 */
package model;

import java.util.GregorianCalendar;

public class PartUsage {

	private int amount;
	private GregorianCalendar date;

	/**
	 * <b>Constructor: </b> Creates new part usage
	 * <p>
	 * <b>Requires: </b> amount > 0, date != null, repair != null, sparePart !=
	 * null
	 * <p>
	 * 
	 * @param amount
	 * @param date
	 * @param repair
	 * @param sparePart
	 */

	public PartUsage(int amount, GregorianCalendar date, Repair repair,
			SparePart sparePart) {
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
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the date
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	/**
	 * @return date (Format: YYYY.MM.DD) and amount of spare parts used as
	 *         string.
	 */
	public String toString() {
		return date.get(GregorianCalendar.YEAR) + "."
				+ date.get(GregorianCalendar.MONTH) + "."
				+ date.get(GregorianCalendar.DAY_OF_MONTH) + " - " + amount;
	}

}
