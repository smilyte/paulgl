package model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Vytas
 * 
 */
public class MachineType {

	private String name;

	// link to [SparePart] class (--> 0..*)
	private Set<SparePart> spareParts = new HashSet<SparePart>();

	// link to [Machine] class (Aggregation <>--> 0..*)
	private Set<Machine> machines = new HashSet<Machine>();

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

	/**
	 * @return the spareParts
	 */
	public Set<SparePart> getSpareParts() {
		return spareParts;
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
	 * Creates a Machine and adds the machine to this machine type
	 */
	public void addMachine(Machine machine) {
		machines.add(machine);
	}

	/**
	 * @return this Machine Type's machines
	 */
	public Set<Machine> getMachines() {
		return machines;
	}

	public void setDrawing(Drawing drawing) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString(){
		return name;
	}

}
