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
	
	// link to [Machine] class (<-- 0..*)
	private List<Machine> machines = new ArrayList<Machine>();

	/**
	 * Gets the name of the machine type.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the machine type. 
	 * @param name: name of machine
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns this MAchine Type's spare parts
	 */
	public List<SparePart> getSpareParts() {
		return spareParts;
	}

	/**
	 * Adds a Spare Part to this Machine Type
	 * Requirements: sparePart != null
	 */
	public void addSparePart(SparePart sparePart) {
		if (!spareParts.contains(sparePart)) {
			spareParts.add(sparePart);
		}
	}
	
	/**
	 * Removes a Spare Part from this Machine Type
	 * Requirements: sparePart != null
	 */
	public void removeSparePart(SparePart sparePart) {
		if (spareParts.contains(sparePart)) {
			spareParts.remove(sparePart);
		}
	}
}
