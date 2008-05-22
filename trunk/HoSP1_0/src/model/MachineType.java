package model;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Vytas
 * 
 */
public class MachineType {

	private String name;

	// link to [SparePart] class (--> 0..*)
	private List<SparePart> spareParts = new ArrayList<SparePart>();

	// link to [Machine] class (Aggregation <>--> 0..*)
	private List<Machine> machines = new ArrayList<Machine>();
	
	// link to [RepairTypes] class (--> 0..*)
	private List<RepairType> repairTypes = new ArrayList<RepairType>();

	/**
	 * Constructor of Machine type
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
	 * Adds a Spare Part to this Machine Type Requirements: sparePart != null
	 */
	public void addSparePart(SparePart sparePart) {
		if (!spareParts.contains(sparePart)) {
			spareParts.add(sparePart);
		}
	}

	/**
	 * Removes a Spare Part from this Machine Type Requirements: sparePart !=
	 * null
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

	// .................Repair Type  .......................

	/**
	 * Adds a Repair Type to this Machine Type Requirements: repairType != null
	 */
	public void addRepairType(RepairType repairType) {
		if (!repairTypes.contains(repairType)) {
			repairTypes.add(repairType);
		}
	}

	/**
	 * Removes a Repair Type from this Machine Type Requirements: repairType !=
	 * null
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

	// .................Machine..........................

	/**
	 * Creates a Machine and adds the machine to this machine type
	 */
	public void createMachine(int sNumber, String name) {
		machines.add(new Machine(sNumber, name, this));
	}
	
	/**
	 * Removes a Machine from this Machine Type Requirements: machine !=
	 * null
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
   //................Drawing.........................
	public void setDrawing(Drawing drawing) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString(){
		return name;
	}

}
