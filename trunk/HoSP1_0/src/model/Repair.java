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

	
	public String getDowntime() {
		long time; 
		time = endDate.getTimeInMillis() - startDate.getTimeInMillis();  //Gets the difference between the dates
		long days = time/(1000*60*60*24);                  //Converts the difference to days
		long hours = (time%(1000*60*60*24))/(1000*60*60);  //Converts the difference to hours
		long minutes = ((time%(1000*60*60*24))%(1000*60*60))/(1000*60); //Converts the difference to minutes
		if (days == 0 && hours == 0 && minutes == 0) return "None."; //Filter 1: If the difference is equal to 0 program return "None"
		else if (days == 0 && hours == 0) return minutes+"minutes."; //Filter 2: If days and hours are equal to 0 than return "minutes"
		else if (days == 0) return hours+" hours, "+minutes+"minutes.";//Filter 3: If days are equal to 0 than return "hours" and "minutes"
		else return days+" days, "+hours+" hours, "+minutes+"minutes.";//Filter 4: If all atributes has value return "days", "hours" and "minutes"
	}

	public String toString() {
		return num + ": Started: [" + startDate.getTime() + "] Ended: [" + endDate.getTime()+"]";
	}

}
