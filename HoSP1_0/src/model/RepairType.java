package model;

/**
 * @author Malik
 * 
 */
public class RepairType {

	private String name;

	// TODO Link to Type Usage --> 0..*

	// link to [PartUsage] Class(1 --> 0..*)
	// private List<TypeUsage> typeUsage = new ArrayList<TypeUsage>();
	/**
	 * Constructor of Repair Type
	 * 
	 * @param name
	 * @param machineType
	 */
	public RepairType(String name) {
		this.name = name;

	}

	/**
	 * Adds a partUsage to this repair type Requires: partUsage != null
	 * 
	 */
	// void addPartUsage(TypeUsage typeUsage) {
	// typeUsage.add(typeUsage);
	// }
	/**
	 * Moves a partUsage from this repair to an other repair type Requires:
	 * group != null
	 */
	// public void movePartUsage(TypeUsage typeUsage) {
	// typeUsage.remove(typeUsage);
	// typeUsage.addPartUsage(typeUsage);
	// }
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

	public String toString() {
		return name;
	}

}
