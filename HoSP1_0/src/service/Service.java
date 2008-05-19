package service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sun.util.calendar.BaseCalendar.Date;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;

import dao.*;

import model.*;

public class Service {

	private static Service instance = new Service();

	private Set<RepairType> repairTypes = new HashSet<RepairType>();
	private Set<MachineType> machineTypes = new HashSet<MachineType>();
	private Set<Drawer> drawers = new HashSet<Drawer>();
	private Set<Repair> repairs = new HashSet<Repair>();

	// Gets the one and only instance of the Repair DAO class.
	private RepairDAO repairDao = RepairDAO.getInstance();

	// Gets the one and only instance of the SparePartDAO class.
	private SparePartDAO sparePartDao = SparePartDAO.getInstance();


	// TODO separate dao for spare parts, machines and drawers

	public Service() {
		startUp();
	}

	private void startUp() {

		// TODO Using DAO Change Add, Remove, Update and GetList for:
		// TODO 1. Repair Type - Elena
		// TODO 2. SparePart - Elena
		// TODO 3. MachineType - Malik
		// TODO 4. Drawer - Malik

		// TODO Write method for: Update Drawer // We don't need it :]

		// TODO Write method for: calculation(history) of last 7 days (week)
		// repairs
		// TODO Write method for: calculation(history) of last 30 days (month)
		// repairs
		// TODO Write method for: calculation(history) of last 12 months (year)
		// repairs
		// TODO Search for spare parts using 7 digit number.... :)

		GregorianCalendar stDate1 = new GregorianCalendar(2008, 04, 13, 5, 25);
		GregorianCalendar eDate1 = new GregorianCalendar(2008, 04, 14, 10, 03);

		GregorianCalendar stDate2 = new GregorianCalendar(2008, 04, 15, 5, 25);
		GregorianCalendar eDate2 = new GregorianCalendar(2008, 03, 19, 12, 18);

		GregorianCalendar stDate3 = new GregorianCalendar(2008, 04, 16, 5, 25);
		GregorianCalendar eDate3 = new GregorianCalendar(2008, 04, 18, 10, 03);

		GregorianCalendar stDate4 = new GregorianCalendar(2008, 04, 16, 5, 25);
		GregorianCalendar eDate4 = new GregorianCalendar(2008, 04, 18, 19, 03);

		MachineType mt1 = new MachineType("MT name");
		Machine m1 = new Machine(123123, "Manufacturer", mt1);

		Repair r1 = new Repair(1, stDate1, eDate1, m1);
		Repair r2 = new Repair(2, stDate2, eDate2, m1);
		Repair r3 = new Repair(3, stDate3, eDate3, m1);
		Repair r4 = new Repair(4, stDate4, eDate4, m1);

		addRepair(r1);
		addRepair(r2);
		addRepair(r3);
		addRepair(r4);

	}

	/**
	 * Calculate minimum amount for the spare part
	 * 
	 * @author Vytas
	 */

	public int getMinimumAmount(SparePart sparePart) {
		// Variable 'maxUsage' will be used to return maximum amount of spare
		// part used in one month
		int maxUsage = -1;

		// Variable 'monthlyUse' will hold the amount of spare part used in one
		// month
		int[] monthlyUse = new int[12];

		// We use this variable to remember which was the last month we
		// took to be able to count last 12 months.
		int lastMonth = -1;

		// We are going through one part's list(history) of all part
		// usages from the end of the list in order to have newest
		// records first.
		for (int i = sparePart.getPartsUsage().size(); i > 0; i--) {

			// In this variable we will count number of months we went
			// through in order to know when we have to stop.
			int calculateMonths = 0;

			// We create the object of PartUsage class and assign value
			// to it.
			PartUsage partUsage = sparePart.getPartsUsage().get(i);

			// We create variable of GregorianCalendar and assign part
			// usage date to it.
			GregorianCalendar theDate = partUsage.getDate();

			// We create new variable to store part usage's month.
			int month = theDate.get(GregorianCalendar.MONTH);

			// If last month we checked is not the same when we increase
			// value of 'calculateMonths'
			if (lastMonth != month)
				calculateMonths++;

			lastMonth = month;

			// If we still didn't went through more than 12 months we
			// increase that month's value.
			// (We have to calculate usage based on only last 12 months)
			if (calculateMonths < 12)
				monthlyUse[month] += partUsage.getAmount();
		}

		// Using 'for' loop we go through all months and values and remember
		// the highest amount of parts we used.
		for (int i : monthlyUse) {
			if (maxUsage < i)
				maxUsage = i;
		}

		// We return highest amount of parts we used in one month. = Minimum
		// amount which should be on stock.
		return maxUsage;
	}

	/**
	 * Returns list with repairs which have been finished repairing in last 24
	 * hours Requirement: hours <= 24
	 * 
	 * 
	 */
	public List<Repair> getTodaysRepairs() {
		// We create the list where we will store repairs which meet the
		// requirement
		List<Repair> calcList = new ArrayList<Repair>();
		// Getting the Time And Date from the computer
		GregorianCalendar today = new GregorianCalendar();
		// We are taking each repair at a time and calculating

		for (Repair repair : getRepairs()) {
			// Calculate the difference between Todays's Date and End Date
			long time = today.getTimeInMillis()
					- repair.getEndDate().getTimeInMillis();
			// Converts that difference to hours
			long hours = time / (1000 * 60 * 60);
			// If hours are equal or less than 24 we add this repair to the
			// list.
			if (hours > 0 && hours <= 24) {
				calcList.add(repair);
			}
		}

		// Return Repairs list with repairs made in last 24 hours.
		return calcList;
	}

	/**
	 * Get Down Time for particular machine.
	 * Method returns array list of the size 12 where each number represents Month of the year.
	 * Each month have integer value which tells how many days machine wasn't working in that month.
	 * Each month can have maximum value of 31.  
	 * 
	 * @author Vytas
	 */

	@SuppressWarnings("static-access")
	public int[] getMachineDowntime(Machine machine) {
		// This variable will store number of days. Maximum value will be 31.
		int downtimeInDays;
		// This variable will be used to make code shorter.
		GregorianCalendar date;
		// This variable is representing whole year. It will store numbers of
		// days machine was broke down in each month.
		int[] monthlyDown = new int[12];
		// This variable will be used in 'while' loop
		boolean finished = false;

		// We use 'for each' to go through all list of repairs
		for (Repair repair : getRepairs()) {

			//If it's the machine we are looking for - Continue
			if (repair.getMachine().equals(machine)){
				
			// We take Repair's StartDate and assign it to variable 'date' just
			// to make code shorter.
			date = repair.getStartDate();

			// First condition: If repair has been started and finished in the
			// same month we just get the difference between end date and start
			// date
			if (date.MONTH == repair.getEndDate().MONTH) {
				//Getting number of days machine was broke down this month
				downtimeInDays = repair.getEndDate().DAY_OF_MONTH
						- date.DAY_OF_MONTH;
				//Store number of down time days into array by increasing the value.
				//Value can't be higher than 31.
				monthlyDown[date.MONTH] += downtimeInDays;
			} else {
				//Second condition: If repair has started in one month and ended in another.
				// We will repeat this loop until we go through all of the months
				while (!finished) {
					//If current month is not the same as end date.
					if (date.MONTH != repair.getEndDate().MONTH) {
						//We get the difference between maximum number of days in that month and current day of month 
						downtimeInDays = date.getActualMaximum(date.MONTH)
								- date.DAY_OF_MONTH;
						//Store number of down time days into array by increasing the value.
						//Value can't be higher than 31.
						monthlyDown[date.MONTH] += downtimeInDays;
						//Changing the current date by going one month further 
						date.set(date.YEAR, date.MONTH + 1, 01);
					} else {
						// But if current month is the same as end date.
						// We get the difference between mend date and current day of month 
						downtimeInDays = repair.getEndDate().MONTH
								- date.DAY_OF_MONTH;
						// --,,--
						monthlyDown[date.MONTH] += downtimeInDays;
						//Changing value to finish the loop, because we went through all months.
						finished = true;
					}
				}
			}
		}
		}
		return monthlyDown;
	}

	// *************************************************
	public String getDowntime(long timeInMils) {
		long time = timeInMils;
		long days = time / (1000 * 60 * 60 * 24); // Converts the difference
		// to days
		long hours = (time % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60); // Converts
		// the
		// difference
		// to
		// hours
		long minutes = ((time % (1000 * 60 * 60 * 24)) % (1000 * 60 * 60))
				/ (1000 * 60); // Converts the difference to minutes
		if (days == 0 && hours == 0 && minutes == 0)
			return "None."; // Filter 1: If the difference is equal to 0 program
		// return "None"
		else if (days == 0 && hours == 0)
			return minutes + "minutes."; // Filter 2: If days and hours are
		// equal to 0 than return "minutes"
		else if (days == 0)
			return hours + " hours, " + minutes + "minutes.";// Filter 3: If
		// days are
		// equal to 0
		// than return
		// "hours" and
		// "minutes"
		else
			return days + " days, " + hours + " hours, " + minutes + "minutes.";// Filter
		// 4:
		// If
		// all
		// atributes
		// has
		// value
		// return
		// "days",
		// "hours"
		// and
		// "minutes"
	}

	// *************************************************
	// --------------REPAIR METHODS START--------------------------------

	/**
	 * Adds a repair to the list of all repairs. Requires: repair != null
	 */
	public void addRepair(Repair repair) {
		repairDao.addRepair(repair);
	}

	/**
	 * Remove the repair from the list of all repairs. Requires: repair != null.
	 */
	public void removeRepair(Repair repair) {
		repairDao.removeRepair(repair);
	}

	/**
	 * Returns a list with all repairs.
	 */
	public Set<Repair> getRepairs() {
		return repairDao.getRepairs();
	}

	/**
	 * Updates the information about the repair.
	 */
	public void updateRepair(Repair repair, GregorianCalendar startDate,
			GregorianCalendar endDate) {
		repair.setStartDate(startDate);
		repair.setEndDate(endDate);
		repairDao.updateRepair(repair);
	}

	// --------------REPAIR METHODS END--------------------------------

	/**
	 * Creates an object of Repair Type
	 */
	public void createRepairType(String name, MachineType machineType) {
		RepairType repairType = new RepairType(name, machineType);
		repairTypes.add(repairType);
	}

	/**
	 * Updates an object of Repair Type
	 */
	public void updateRepairType(RepairType repairType, String name,
			MachineType machineType) {
		if (!name.equals(""))
			repairType.setName(name);
		if (machineType != null)
			repairType.setMachineType(machineType);
	}

	/**
	 * Deletes an object of Repair Type
	 */
	public void deleteRepairType(RepairType repairType) {
		repairTypes.remove(repairType);
	}

	// --------------- SPARE PART METHODS -----------------------------
	/**
	 * Creates an object of Spare Part
	 * Requires 
	 */
	public void addSparePart(SparePart sparePart) {
		sparePartDao.add(sparePart);
	}

	/**
	 * Updates an object of SparePart
	 */
	public void updateSparePart(SparePart sparePart, int number, int amount,
			Drawing drawing, Box box) {
		if (number != 0)
			sparePart.setNumber(number);
		if (amount < 0)
			sparePart.setAmount(amount);
		if (drawing != null)
			sparePart.setDrawing(drawing);
		if (box != null)
			movePart(box, sparePart);
		
		sparePartDao.update(sparePart);
	}

	/**
	 * Deletes an object of SparePart
	 */
	public void deleteSparePart(SparePart sparePart) {
		sparePart.getBox().setSp(null);
		sparePartDao.delete(sparePart);
	}
	
	public Set<SparePart> getSpareParts() {
		return sparePartDao.getList();
	}

	// --------------- SPARE PART METHODS END -------------------------
	
	
	/**
	 * Creates an object of Machine Type
	 */
	public void createMachineType(String name) {
		MachineType machineType = new MachineType(name);
		machineTypes.add(machineType);
	}

	/**
	 * Updates an object of Machine Type
	 */
	public void updateMachineType(MachineType machineType, String name,
			Drawing drawing) {
		if (!name.equals(""))
			machineType.setName(name);
		if (drawing != null)
			machineType.setDrawing(drawing);
	}

	/**
	 * Deletes an object of Machine Type
	 */
	public void deleteMachineType(MachineType machineType) {
		machineTypes.remove(machineType);
	}

	/**
	 * Creates an object of Drawer
	 */
	public void createDrawer(int Id, int numberOfBoxes) {
		Drawer drawer = new Drawer(Id, numberOfBoxes);
		drawers.add(drawer);
	}

	/**
	 * Deletes an object of Drawer
	 */
	public void deleteDrawer(Drawer drawer) {
		drawers.remove(drawer);
	}

	/**
	 * Moves spare part to newBox. Requires box to be empty, newBox != null and
	 * sp != null
	 * 
	 * @author Elena
	 */
	public void movePart(Box newBox, SparePart sp) {
		if (newBox.getSparePart() == null) {
			sp.getBox().setSp(null);
			sp.setBox(newBox);
		}
	}

	/**
	 * @return the instance
	 */
	public static Service getInstance() {
		return instance;
	}

	public Set<RepairType> getRepairTypes() {
		return repairTypes;
	}

	public Set<MachineType> getMachineTypes() {
		return machineTypes;
	}

	public Set<Drawer> getDrawers() {
		return drawers;
	}

}
