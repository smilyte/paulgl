/**
 * @author Malik
 */
package model;

public class TypeUsage {
	private int amount;

	/**
	 * <b>Constructor: </b> Creates new type usage
	 * <p>
	 * <b>Requires: </b> amount > 0
	 * <p>
	 * 
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

	/**
	 * @return amount of this type usage as string.
	 */
	public String toString() {
		return "" + amount;
	}

}
