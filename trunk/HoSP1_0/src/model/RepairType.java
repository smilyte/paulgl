package model;
/**
 * @author Malik
 *
 */
public class RepairType {
	
	private String name;
	
	// link to [MachineTyep] Class(0..* --> 1)
	private MachineType machineType;
	
	/**
	 * Constructor of Repair Type 
	 * @param name
	 * @param machineType
	 */
	public RepairType(String name,MachineType machineType) {
		this.name = name;
		this.machineType = machineType;
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
	 * @return the machineType
	 */
	public MachineType getMachineType() {
		return machineType;
	}

	/**
	 * @param machineType the machineType to set
	 */
	public void setMachineType(MachineType machineType) {
		this.machineType = machineType;
	}

	public String toString(){
	return name+"MachineType"+machineType;	
	}
}
