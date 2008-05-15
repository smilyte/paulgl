/**
 * @author Elena
 * 
 */
package model;

public class Machine {

	private int serialNumber;
	private String manufacturer;
	private MachineType type;

	// TODO make connection to MachineDrawing class

	/**
	 * Creates a new machine of one and only type
	 * 
	 * @param serialNumber
	 *            Serial number of machine
	 * @param manufacturer
	 *            The manufacturer of machine
	 */
	public Machine(int serialNumber, String manufacturer, MachineType type) {
		this.serialNumber = serialNumber;
		this.manufacturer = manufacturer;
		this.type = type;
	}

	/**
	 * Sets type of machine Requires newType != null
	 */
	public void setType(MachineType newType) {
		type = newType;
	}

	/**
	 * @return the type
	 */
	public MachineType getType() {
		return type;
	}

	/**
	 * @return the serialNumber
	 */
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}
