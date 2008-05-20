package service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.*;

import model.*;

public class Service {

	private static Service instance = new Service();

	// Gets the one and only instance of the Repair DAO class.
	private RepairDAO repairDao = RepairDAO.getInstance();

	// Gets the one and only instance of the SparePartDAO class.
	private SparePartDAO sparePartDao = SparePartDAO.getInstance();

	// Gets the one and only instance of the RepairTypeDAO class.
	private RepairTypeDAO repairTypeDao = RepairTypeDAO.getInstance();
	
	// Gets the one and only instance of the DrawerDAO class.
	private DrawerDAO drawerDAO = DrawerDAO.getInstance();

	// Gets the one and only instance of the MachineTypeDAO class.
	private MachineTypeDAO machineTypeDAO = MachineTypeDAO.getInstance();

	public Service() {
		startUp();
	}
	
	/**
	 * @return the instance
	 */
	public static Service getInstance() {
		return instance;
	}

	private void startUp() {


		// TODO Write method for: calculation(history) of last 7 days (week)
		// repairs
		// TODO Write method for: calculation(history) of last 30 days (month)
		// repairs
		// TODO Write method for: calculation(history) of last 12 months (year)
		// repairs
		// TODO Search for spare parts using 7 digit number.... :)
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
	 * Get Down Time for particular machine. Method returns array list of the
	 * size 12 where each number represents Month of the year. Each month have
	 * integer value which tells how many days machine wasn't working in that
	 * month. Each month can have maximum value of 31.
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

			// If it's the machine we are looking for - Continue
			if (repair.getMachine().equals(machine)) {
				// We take Repair's StartDate and assign it to variable 'date'
				// just to make code shorter.
				date = repair.getStartDate();

				// First condition: If repair has been started and finished in
				// the same month we just get the difference between end date
				// and start date
				if (date.MONTH == repair.getEndDate().MONTH) {
					// Getting number of days machine was broke down this month
					
					downtimeInDays = repair.getEndDate().DAY_OF_MONTH
							- date.DAY_OF_MONTH;
					// Store number of down time days into array by increasing
					// the value. Value can't be higher than 31.
					System.out.println("1: "+downtimeInDays);
					monthlyDown[date.MONTH] += downtimeInDays;
				} else {
					// Second condition: If repair has started in one month and
					// ended in another. We will repeat this loop until we go
					// through all of the months
					while (!finished) {
						// If current month is not the same as end date.
						if (date.MONTH != repair.getEndDate().MONTH) {
							// We get the difference between maximum number of
							// days in that month and current day of month
							downtimeInDays = date.getActualMaximum(date.MONTH)
									- date.DAY_OF_MONTH;
							// Store number of down time days into array by
							// increasing the value.
							// Value can't be higher than 31.
							System.out.println("2: "+downtimeInDays);
							monthlyDown[date.MONTH] += downtimeInDays;
							// Changing the current date by going one month
							// further
							date.set(date.YEAR, date.MONTH + 1, 01);
						} else {
							// But if current month is the same as end date.
							// We get the difference between mend date and
							// current day of month
							downtimeInDays = repair.getEndDate().MONTH
									- date.DAY_OF_MONTH;
							// --,,--
							System.out.println("3: "+downtimeInDays);
							monthlyDown[date.MONTH] += downtimeInDays;
							// Changing value to finish the loop, because we
							// went through all months.
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
		// Converts the difference to days
		long days = time / (1000 * 60 * 60 * 24);
		// Converts the difference to hours
		long hours = (time % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		// Converts the difference to minutes
		long minutes = ((time % (1000 * 60 * 60 * 24)) % (1000 * 60 * 60))
				/ (1000 * 60);

		// Filter 1: If the difference is equal to 0 program returns "None"
		if (days == 0 && hours == 0 && minutes == 0)
			return "None.";
		// Filter 2: If days and hours are equal to 0 than return "minutes"
		else if (days == 0 && hours == 0)
			return minutes + "minutes.";
		// Filter 3: If days are equal to 0 than return "hours" and "minutes"
		else if (days == 0)

			return hours + " hours, " + minutes + "minutes.";
		// Filter 4: If all attributes have value return "days", "hours" and
		else 
			return days + " days, " + hours + " hours, " + minutes + "minutes.";
		
		}

	// *************************************************
	// --------------REPAIR METHODS START--------------------------------

	/**
	 * Adds a repair to the list of all repairs. Requires: repair != null
	 */
	public void addRepair(Repair repair) {
		repairDao.add(repair);
	}

	/**
	 * Remove the repair from the list of all repairs. Requires: repair != null.
	 */
	public void removeRepair(Repair repair) {
		repairDao.remove(repair);
	}

	/**
	 * Updates the information about the repair.
	 */
	public void updateRepair(Repair repair, GregorianCalendar startDate,
			GregorianCalendar endDate) {
		repair.setStartDate(startDate);
		repair.setEndDate(endDate);
		repairDao.update(repair);
	}
	
	/**
	 * Returns a list with all repairs.
	 */
	public List<Repair> getRepairs() {
		return repairDao.getList();
	}

	// --------------REPAIR METHODS END--------------------------------
	
	// -------------- REPAIR TYPE METHODS START -----------------------

	/**
	 * Creates an object of Repair Type
	 */
	public void addRepairType(String name, MachineType machineType) {
		RepairType repairType = new RepairType(name, machineType);
		repairTypeDao.add(repairType);
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
		
		repairTypeDao.update(repairType);
	}

	/**
	 * Deletes an object of Repair Type
	 */
	public void removeRepairType(RepairType repairType) {
		repairTypeDao.remove(repairType);
	}
	
	/**
	 * Returns list of repair types
	 */
	public List<RepairType> getRepairTypes() {
		return repairTypeDao.getList();
	}
	// -------------- REPAIR TYPE METHODS END--------------------------

	// --------------- SPARE PART METHODS START -----------------------
	/**
	 * Creates an object of Spare Part Requires
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
	public void removeSparePart(SparePart sparePart) {
		sparePart.getBox().setSp(null);
		sparePartDao.remove(sparePart);
	}

	/**
	 * Returns List of spare parts
	 */
	public List<SparePart> getSpareParts() {
		return sparePartDao.getList();
	}

	// --------------- SPARE PART METHODS END -------------------------

	
	// --------------- DRAWER METHODS START -----------------------
	//No Update Method: We never update the drawer.
	
	/**
	 * Creates an object of Drawer
	 */
	public void addDrawer(int Id, int numberOfBoxes) {
		Drawer drawer = new Drawer(Id, numberOfBoxes);
		drawerDAO.add(drawer);
	}

	/**
	 * Deletes an object of Drawer
	 */
	public void removeDrawer(Drawer drawer) {
		boolean empty = true;
		for (Box box : drawer.getBoxes()) {
			if (!box.getSparePart().equals(null))
				empty = false;
		}
		if (empty) drawerDAO.remove(drawer);
	}
	
	/**
	 * Returns List of drawers
	 */
	public List<Drawer> getDrawers() {
		return drawerDAO.getList();
	}
	
	// --------------- DRAWER METHODS END   -----------------------
	
	// --------------- MACHINE TYPE METHODS START -----------------
	
	/**
	 * Creates an object of Machine Type
	 */
	public void addMachineType(String name) {
		MachineType machineType = new MachineType(name);
		machineTypeDAO.add(machineType);
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
		machineTypeDAO.update(machineType);
	}

	/**
	 * Deletes an object of Machine Type
	 */
	public void removeMachineType(MachineType machineType) {
		machineTypeDAO.remove(machineType);
	}
	
	/**
	 * Returns List of machines
	 */
	public List<MachineType> getMachineTypes() {
		return machineTypeDAO.getList();
	}
	// --------------- MACHINE TYPE METHODS END   -----------------

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





}
