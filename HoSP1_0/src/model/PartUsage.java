package model;

public class PartUsage {
	
	private int amount;
	private String date; // Or Date type?
	
	// link to [SparePart] class (<-- 1)
	private SparePart sparePart;
	// link to [Repair] class (<-- 1)
	private Repair repair;
	
	public PartUsage(int amount, String date, Repair repair, SparePart sparePart) {
		this.amount = amount;
		this.date = date;
		this.repair = repair;
		this.sparePart = sparePart;
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

	/**
	 * @return the sparePart
	 */
	public SparePart getSparePart() {
		return sparePart;
	}

	/**
	 * @param sparePart the sparePart to set
	 */
	public void setSparePart(SparePart sparePart) {
		this.sparePart = sparePart;
	}

	/**
	 * @return the repair
	 */
	public Repair getRepair() {
		return repair;
	}

	/**
	 * @param repair the repair to set
	 */
	public void setRepair(Repair repair) {
		this.repair = repair;
	}
	
	

}
