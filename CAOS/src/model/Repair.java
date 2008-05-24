/**
 * @author Malik
 */
package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Repair {
	private int number;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	
	// link to [Machine] Class(0..* --> 1)
	private Machine machine;
	
	// link to [PartUsage] Class(1 --> 0..*)
	private List<PartUsage> partsUsage = new ArrayList<PartUsage>();

	/**
	 * Constructor of Repair
	 * 
	 * @param num
	 * @param startDate
	 * @param endDate
	 * @param machine
	 * @param
	 */
	public Repair(int number, GregorianCalendar startDate,
			GregorianCalendar endDate, Machine machine) {
		this.number = number;
		this.startDate = startDate;
		this.endDate = endDate;
		this.machine = machine;
	}

	public int getNum() {
		return number;
	}

	public void setNum(int num) {
		this.number = num;
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
	 * Adds a partUsage to this repair 
	 * Requires: partUsage != null
	 * 
	 */
	void addPartUsage(PartUsage partUsage) {
		partsUsage.add(partUsage);
	}

	/**
	 * Moves a partUsage from this repair to an other repair
	 * Requires: group != null
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

	public String toString() {
		return number + ": Started: [" + startDate.getTime() + "] Ended: [" + endDate.getTime()+"]";
	}

}
