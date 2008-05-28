/**
 * 
 * @author Vytas
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class MachineType {

	private String name;

	// link to [SparePart] class (--> 0..*)
	private List<SparePart> spareParts = new ArrayList<SparePart>();

	// link to [Machine] class (Aggregation <>--> 0..*)
	private List<Machine> machines = new ArrayList<Machine>();

	// link to [RepairTypes] class (--> 0..*)
	private List<RepairType> repairTypes = new ArrayList<RepairType>();

	/**
	 * <b>Constructor: </b> Creates new Machine type
	 * <p>
	 * 
	 * @param name
	 */
	public MachineType(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	// .................Spare Part.......................

	/**
	 * Adds a Spare Part to this Machine Type
	 * <p>
	 * <b>Requires: </b> sparePart != null
	 */
	public void addSparePart(SparePart sparePart) {
		if (!spareParts.contains(sparePart)) {
			spareParts.add(sparePart);
		}
	}

	/**
	 * Removes a Spare Part from this Machine Type
	 * <p>
	 * <b>Requires: </b> sparePart != null
	 */
	public void removeSparePart(SparePart sparePart) {
		if (spareParts.contains(sparePart)) {
			spareParts.remove(sparePart);
		}
	}

	/**
	 * @return the spareParts
	 */
	public List<SparePart> getSpareParts() {
		return spareParts;
	}

	// .................Repair Type..Start.................

	/**
	 * Adds a Repair Type to this Machine Type
	 * <p>
	 * <b>Requires: </b> repairType != null
	 */
	public void addRepairType(RepairType repairType) {
		if (!repairTypes.contains(repairType)) {
			repairTypes.add(repairType);
		}
	}

	/**
	 * Removes a Repair Type from this Machine Type
	 * <p>
	 * <b>Requires: </b> repairType != null
	 */
	public void removeRepairType(RepairType repairType) {
		if (repairTypes.contains(repairType)) {
			repairTypes.remove(repairType);
		}
	}

	/**
	 * @return the repair types
	 */
	public List<RepairType> getRepairTypes() {
		return repairTypes;
	}

	// .................Repair Type..End...................

	// .................Machine..Start.....................

	/**
	 * Creates a Machine and adds the machine to this machine type
	 */
	public void createMachine(int serialNumber) {
		machines.add(new Machine(serialNumber, this));
	}

	/**
	 * Removes a Machine from this Machine Type
	 * <p>
	 * <b>Requires: </b> machine != null
	 */
	public void removeMachine(Machine machine) {
		if (machines.contains(machine)) {
			machines.remove(machine);
		}
	}

	/**
	 * @return this Machine Type's machines
	 */
	public List<Machine> getMachines() {
		return machines;
	}

	// .................Machine..End........................

	// ................Drawing..Start.......................

	// not implemented

	// ................Drawing..End.......................

	/**
	 * @return name of the machine type as string.
	 */
	public String toString() {
		return name;
	}
}
