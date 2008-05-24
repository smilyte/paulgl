/**
 * @author Elena
 * 
 */

package model;

public class Machine {

	private int number;

	/**
	 * Creates a new machine with number which is unique
	 * 
	 * @param serialNumber
	 *            Serial number of machine
	 */
	public Machine(int serialNumber) {
		this.number = serialNumber;
	}

	/**
	 * @return the serialNumber
	 */
	public int getSerialNumber() {
		return number;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(int serialNumber) {
		this.number = serialNumber;
	}
		
	public String toString(){
		return "Number:"+number;
	}
}
