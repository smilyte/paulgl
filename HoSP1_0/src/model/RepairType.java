package model;
/**
 * @author Malik
 *
 */
public class RepairType {
	
	private String name;
	// link to [MachineTyep] Class(0..* --> 1)
	private MachineType machineTyep;
	/**
	 * Constructor of Repair Type 
	 * @param name
	 * @param machineTyep
	 */
	public RepairType(String name,MachineType machineTyep) {
		this.name = name;
		this.machineTyep = machineTyep;
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
	 * @return the machineTyep
	 */
	public MachineType getMachineTyep() {
		return machineTyep;
	}

	/**
	 * @param machineTyep the machineTyep to set
	 */
	public void setMachineTyep(MachineType machineTyep) {
		this.machineTyep = machineTyep;
	}

	public String toString(){
	return name+"MachineType"+machineTyep;	
	}
}
