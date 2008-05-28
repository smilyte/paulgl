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
	private List<PartUsage> partUsages = new ArrayList<PartUsage>();

	// link to [RepairType] Class(1 --> 0..1)
	private RepairType repairType = null;

	/**
	 * <b>Constructor: </b> Creates of Repair
	 * <p>
	 * <b>Requires: </b> startDate != null, endDate != null, machine != null
	 * <p>
	 * 
	 * @param num
	 * @param startDate
	 * @param endDate
	 * @param machine
	 */
	public Repair(int number, GregorianCalendar startDate,
			GregorianCalendar endDate, Machine machine) {
		this.number = number;
		this.startDate = startDate;
		this.endDate = endDate;
		this.machine = machine;
	}

	/**
	 * @return number of repair
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets number
	 * <p>
	 * <b>Requires:</b> number > 0
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return start date of this repair
	 */

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	/**
	 * Sets start date to this repair
	 * <p>
	 * <b>Requires: </b> startDate != null
	 */
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return end date of this repair
	 */
	public GregorianCalendar getEndDate() {
		return endDate;
	}

	/**
	 * Sets end date to this repair
	 * <p>
	 * <b>Requires: </b> endDate != null
	 */
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	// .................Machine..Start...................
	/**
	 * @return the machine
	 */
	public Machine getMachine() {
		return machine;
	}

	// .................Machine..End.....................

	// .................Part Usage..Start................
	/**
	 * Adds a part usage to this repair
	 * <p>
	 * <b>Requires: </b> partUsage != null
	 * 
	 */
	public void addPartUsage(PartUsage partUsage) {
		partUsages.add(partUsage);
	}

	/**
	 * @return the list of all part usages of this repair
	 */
	public List<PartUsage> getPartUsages() {
		return partUsages;
	}

	// .................Part Usage..End..................

	// .................Repair Type..Start...............
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

	// .................Repair Type..End.................

	/**
	 * @return down time of this repair.
	 *         <p>
	 *         Format: XX days XX hours XX minutes
	 * 
	 * @author Malik
	 */
	public String getDowntime() {
		long time;
		// Gets the difference between the dates
		time = endDate.getTimeInMillis() - startDate.getTimeInMillis();
		// Converts the difference to days
		long days = time / (1000 * 60 * 60 * 24);
		// Converts the difference to hours
		long hours = (time % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		// Converts the difference to minutes
		long minutes = ((time % (1000 * 60 * 60 * 24)) % (1000 * 60 * 60))
				/ (1000 * 60);
		// Filter 1: If the difference is equal to 0 program return "None"
		if (days == 0 && hours == 0 && minutes == 0)
			return "None.";
		// Filter 2: If days and hours are equal to 0 than return "minutes"
		else if (days == 0 && hours == 0)
			return minutes + "minutes.";
		// Filter 3: If days are equal to 0 than return "hours" and "minutes"
		else if (days == 0)
			return hours + " hours, " + minutes + "minutes.";
		// Filter 4: If all attributes have value return "days", "hours" and
		// "minutes"
		else
			return days + " days, " + hours + " hours, " + minutes + "minutes.";
	}

	/**
	 * @return number of repair, repair's Start and End time as string.
	 */
	public String toString() {
		if(endDate != null)
			return number + ": Started: [" + startDate.getTime() + "] Ended: ["
				+ endDate.getTime() + "]";
		else
			return number + ": Started: [" + startDate.getTime() + "] Ended: []";
	}

}
