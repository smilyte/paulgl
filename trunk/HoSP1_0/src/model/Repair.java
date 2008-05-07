package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Malik
 *
 */
public class Repair {
	private int num;
	private Date startDate;
	private Date endDate;
	// link to [Machine] Class(--> 1)
	private Machine machine;
	// link to [PartUsage] Class(--> 0..*)
	private List<PartUsage> partsUsage = new ArrayList<PartUsage>();
	
	/**
	 * @param num
	 * @param startDate
	 * @param endDate
	 * @param machine
	 */
	public Repair(int num, Date startDate, Date endDate,Machine machine) {
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

	public Date getStartDate() {
		return startDate;
	}
	
//	/**
//	 * Adds a person to this group
//	 * Requires: person != null og person is not in any other group 
//	 * Note: this method is only for use in classes Person and Group	 */
//	void addPartUsage(PartUsage partUsage) {
//		partsUsage.add(partsUsage);
//	}
//	/**
//	 * Moves a person from this group to an other group
//	 * Requires: group != null
//	 */
//	public void movePartUsage(PartUsage partUsage, Repair repair) {
//		partsUsage.remove(partUsage);
//		repair.addPartUsage(partUsage);
//	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return Date
	 */
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the machine
	 */
	public Machine getMachine() {
		return machine;
	}
	public String toString(){
		return num+" "+ startDate;
	}

	

}
