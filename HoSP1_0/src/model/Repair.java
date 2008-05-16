package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Malik
 * 
 */
public class Repair {
	private int num;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	// link to [Machine] Class(0..* --> 1)
	private Machine machine;
	// link to [PartUsage] Class(1 --> 0..*)
	private List<PartUsage> partsUsage = new ArrayList<PartUsage>();
	// link to [RepairType] Class(1 --> 0..1)
	private RepairType repairType = null;

	/**
	 * Constructor of Repair
	 * 
	 * @param num
	 * @param startDate
	 * @param endDate
	 * @param machine
	 * @param
	 */
	public Repair(int num, GregorianCalendar startDate,
			GregorianCalendar endDate, Machine machine) {
		this.num = num;
		this.startDate = startDate;
		this.endDate = endDate;
		this.machine = machine;

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return Date
	 */
	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	/**
	 * Adds a person to this group Requires: person != null og person is not in
	 * any other group Note: this method is only for use in classes Person and
	 * Group
	 */
	void addPartUsage(PartUsage partUsage) {
		partsUsage.add(partUsage);
	}

	/**
	 * Moves a person from this group to an other group Requires: group != null
	 */
	public void movePartUsage(PartUsage partUsage, Repair repair) {
		partsUsage.remove(partUsage);
		repair.addPartUsage(partUsage);
	}

	/**
	 * @return the machine
	 */
	public Machine getMachine() {
		return machine;
	}

	/**
	 * @return the partsUsage
	 */
	public List<PartUsage> getPartsUsage() {
		return partsUsage;
	}

	/**
	 * @param partsUsage
	 *            the partsUsage to set
	 */
	public void setPartsUsage(List<PartUsage> partsUsage) {
		this.partsUsage = partsUsage;
	}

	/**
	 * @return the repairType
	 */
	public RepairType getRepairType() {
		return repairType;
	}

	/**
	 * @param repairType
	 *            the repairType to set
	 */
	public void setRepairType(RepairType repairType) {
		this.repairType = repairType;
	}

	public String toString() {
		return num + ": Started: " + startDate.getTime() + " Ended: " + endDate.getTime();
	}

}
