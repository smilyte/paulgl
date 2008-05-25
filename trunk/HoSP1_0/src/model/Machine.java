/**
 * @author Elena
 * 
 */
package model;

public class Machine {

	private int serialNumber;
	private MachineType type;

	// TODO make connection to MachineDrawing class

	/**
	 * <b>Constructor:</b> Creates a new machine of one and only type
	 * <p>
	 * <b>Requires:</b> machineType != null
	 * 
	 * @param serialNumber
	 *            Serial number of machine
	 * @param machineType
	 */
	public Machine(int serialNumber, MachineType machineType) {
		this.serialNumber = serialNumber;
		this.type = machineType;
	}

	/**
	 * Sets type of machine
	 * <p>
	 * <b>Requires:</b> newType != null
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
	 * @return serial number of the machine as string.
	 */
	public String toString() {
		return "" + serialNumber;
	}
}
