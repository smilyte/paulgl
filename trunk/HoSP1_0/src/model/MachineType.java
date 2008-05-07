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

	// link to [Machine] class (Agr<>--> 0..*)
	private List<Machine> machines = new ArrayList<Machine>();

	public MachineType(String name) {
		super();
		this.name = name;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the spareParts
	 */
	public List<SparePart> getSpareParts() {
		return spareParts;
	}

	/**
	 * @param spareParts the spareParts to set
	 */
	public void setSpareParts(List<SparePart> spareParts) {
		this.spareParts = spareParts;
	}

	/**
	 * @param machines the machines to set
	 */
	public void setMachines(List<Machine> machines) {
		this.machines = machines;
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

	// .................Machine..........................
	/**
	 * Returns this Machine Type's machines
	 */
	public List<Machine> getMachines() {
		return machines;
	}

	/**
	 * Adds a Machine to this Machine Type Requirements: machine != null
	 */
	public void addMachine(Machine machine) {
		if (!machines.contains(machine)) {
			machines.add(machine);
		}
	}

	/**
	 * Removes a Machine from this Machine Type Requirements: machine != null
	 */
	public void removeMachine(Machine machine) {
		if (machines.contains(machine)) {
			machines.remove(machine);
		}
	}
}
