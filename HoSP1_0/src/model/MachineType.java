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
	public List<SparePart> getSpareParts() {
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

	public void setDrawing(Drawing drawing) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString(){
		return name;
	}

}
