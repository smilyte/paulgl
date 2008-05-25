/**
 * @author Malik
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class RepairType {

	private String name;

	// link to [TypeUsage] Class(1 --> 0..*)
	private List<TypeUsage> typeUsages = new ArrayList<TypeUsage>();

	/**
	 * <b>Constructor: </b> Creates new repair type
	 * <p>
	 * 
	 * @param name
	 * @param machineType
	 */
	public RepairType(String name) {
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

	// .................Type Usage..Start................
	/**
	 * Adds a type usage to this repair
	 * <p>
	 * <b>Requires: </b> typeUsage != null
	 * 
	 */
	void addTypeUsage(TypeUsage typeUsage) {
		typeUsages.add(typeUsage);
	}

	/**
	 * Moves a type usage from this repair type to an other repair type
	 * <p>
	 * <b>Requires: </b> repair != null
	 */
	public void moveTypeUsage(TypeUsage typeUsage, RepairType repairType) {
		typeUsages.remove(typeUsage);
		repairType.addTypeUsage(typeUsage);
	}

	/**
	 * @return the list of all type usages of this repair type
	 */
	public List<TypeUsage> getTypeUsages() {
		return typeUsages;
	}

	/**
	 * Sets type usage list to this type usage list
	 * 
	 * @param typeusages
	 * 
	 */
	public void setTypeUsages(List<TypeUsage> typeUsages) {
		this.typeUsages = typeUsages;
	}

	// .................Type Usage..End..................

	/**
	 * @return name of this type usage as string.
	 */
	public String toString() {
		return name;
	}

}
