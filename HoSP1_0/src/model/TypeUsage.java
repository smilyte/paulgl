package model;

/**
 * @author Malik
 * 
 */
public class TypeUsage {
	private int amount;

	/**
	 * @param amount
	 */
	public TypeUsage(int amount) {

		this.amount = amount;
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

	public String toString() {
		return amount + "Amount";
	}

}
