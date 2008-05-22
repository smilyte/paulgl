package model;
/**
 * @author Malik
 *
 */
public class RepairType {
	
	private String name;
	
	//TODO Link to Type Usage --> 0..*
	
	/**
	 * Constructor of Repair Type 
	 * @param name
	 * @param machineType
	 */
	public RepairType(String name,MachineType machineType) {
		this.name = name;
		machineType.addRepairType(this);
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

	public String toString(){
	return name;	
	}
}
