package service;

import gui.Dialog.ErrorDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import daoDB.*;
import daoDB.DB4OManager;
import model.*;

public class Service {
	private static GregorianCalendar stDate1, eDate1, stDate2, eDate2, stDate3,
			eDate3, stDate4, eDate4;
	private static MachineType mt1, mt2, mt3;
	private static Repair r1, r2, r3, r4;

	private static Service instance;

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
		if (instance == null)
			instance = new Service();
		return instance;
	}

	/**
	 * Closes the db4o database.
	 */
	public void closeDb4o() {
		DB4OManager.getInstance().getObjectContainer().close();
	}

	private void startUp() {

		mt1 = new MachineType("MT Turbo 1");
		mt2 = new MachineType("MT Rocket 2");
		mt3 = new MachineType("MT Jazz 3");

		addMachineType(mt1);
		addMachineType(mt2);
		addMachineType(mt3);

		mt3.createMachine(00000, "Music");
		mt2.createMachine(555555, "Bungle");
		mt2.createMachine(777777, "Cungle");
		mt2.createMachine(22222, "Turtle");
		mt1.createMachine(11111, "Rabit");
		mt1.createMachine(666666, "Dungle");

		stDate1 = new GregorianCalendar(2008, 02, 13, 5, 25);
		eDate1 = new GregorianCalendar(2008, 04, 14, 10, 03);

		stDate2 = new GregorianCalendar(2008, 04, 15, 5, 25);
		eDate2 = new GregorianCalendar(2008, 04, 15, 12, 18);

		stDate3 = new GregorianCalendar(2008, 04, 16, 5, 25);
		eDate3 = new GregorianCalendar(2008, 04, 19, 10, 03);

		stDate4 = new GregorianCalendar(2008, 04, 16, 5, 25);
		eDate4 = new GregorianCalendar(2008, 04, 16, 9, 03);

		r1 = new Repair(1, stDate1, eDate1, mt1.getMachines().get(0));
		r2 = new Repair(2, stDate2, eDate2, mt1.getMachines().get(1));
		r3 = new Repair(3, stDate3, eDate3, mt2.getMachines().get(1));
		r4 = new Repair(4, stDate4, eDate4, mt2.getMachines().get(2));

		addRepair(r1);
		addRepair(r2);
		addRepair(r3);
		addRepair(r4);

		addDrawer(new Drawer(1, 5));
		addDrawer(new Drawer(2, 6));

		// data for spareparts
		addSparePart(new SparePart(10, 1111111, getDrawers().get(0).getBoxes()
				.get(1)));
		addSparePart(new SparePart(20, 3333333, getDrawers().get(0).getBoxes()
				.get(0)));
		addSparePart(new SparePart(5, 5555555, getDrawers().get(1).getBoxes()
				.get(1)));
		addSparePart(new SparePart(100, 7777777, getDrawers().get(1).getBoxes()
				.get(2)));
		addSparePart(new SparePart(50, 1231231, getDrawers().get(0).getBoxes()
				.get(2)));
		addSparePart(new SparePart(67, 2211221, getDrawers().get(0).getBoxes()
				.get(3)));
		addSparePart(new SparePart(14, 7234212, getDrawers().get(1).getBoxes()
				.get(0)));
		addSparePart(new SparePart(45, 5432345, getDrawers().get(1).getBoxes()
				.get(4)));

		GregorianCalendar date = new GregorianCalendar(2008, 3, 10);
		GregorianCalendar date2 = new GregorianCalendar(2007, 11, 5);
		GregorianCalendar date3 = new GregorianCalendar(2008, 4, 20);

		PartUsage p3 = new PartUsage(5, date2, r1, getSpareParts().get(0));
		PartUsage p2 = new PartUsage(3, date, r1, getSpareParts().get(0));
		PartUsage p1 = new PartUsage(2, date3, r1, getSpareParts().get(0));
		
		mt1.addSparePart(getSpareParts().get(0));
		mt1.addSparePart(getSpareParts().get(1));
		mt1.addSparePart(getSpareParts().get(2));
		mt2.addSparePart(getSpareParts().get(3));
		mt2.addSparePart(getSpareParts().get(4));
		mt2.addSparePart(getSpareParts().get(5));
		mt3.addSparePart(getSpareParts().get(6));
		mt3.addSparePart(getSpareParts().get(7));

		// TODO Write method for: calculation(history) of last 7 days (week)
		// repairs
		// TODO Write method for: calculation(history) of last 30 days (month)
		// repairs
		// TODO Write method for: calculation(history) of last 12 months (year)
		// repairs
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
	public int[] getMachineMonthlyDowntime2(Machine machine) {
		// This variable is representing whole year. It will store numbers of
		// days machine was broke down in each month.
		int[] monthlyDown = new int[12];

		long daysMachineWasDown;

		// We use 'for each' to go through all list of repairs
		for (Repair repair : getRepairs()) {

			GregorianCalendar firstDate = repair.getStartDate();

			if (repair.getMachine().equals(machine)) {

				long timeMachineWasDown = repair.getEndDate().getTimeInMillis()
						- repair.getStartDate().getTimeInMillis();
				daysMachineWasDown = (timeMachineWasDown / (1000 * 60 * 60)) / 24;

				while (daysMachineWasDown > 0) {

					if (firstDate.get(GregorianCalendar.MONTH) == repair
							.getEndDate().get(GregorianCalendar.MONTH)) {
						monthlyDown[repair.getStartDate().get(
								GregorianCalendar.MONTH)] += daysMachineWasDown + 1;
						daysMachineWasDown = 0;
					}

					else {
						int days = 0;
						days = firstDate
								.getActualMaximum(firstDate.DAY_OF_MONTH)
								- firstDate.get(GregorianCalendar.DAY_OF_MONTH)
								+ 1;

						monthlyDown[firstDate.get(GregorianCalendar.MONTH)] += days;

						daysMachineWasDown -= days;

						firstDate.set(firstDate.get(GregorianCalendar.YEAR),
								firstDate.get(GregorianCalendar.MONTH) + 1, 01);
					}
				}
			}
		}
		return monthlyDown;
	}

	@SuppressWarnings("static-access")
	public int[] getMachineMonthlyDowntime(Machine machine) {
		// This variable will store number of days. Maximum value will be 31.
		long downtimeInDays = 0;
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

				System.out.println("lialia: "
						+ date.getActualMaximum(date.DAY_OF_MONTH));
				// First condition: If repair has been started and finished in
				// the same month we just get the difference between end date
				// and start date
				if (date.get(GregorianCalendar.MONTH) == repair.getEndDate()
						.get(GregorianCalendar.MONTH)) {
					// Getting number of days machine was broke down this month

					// downtimeInDays =
					// repair.getEndDate().get(GregorianCalendar.DAY_OF_MONTH)
					// - date.get(GregorianCalendar.DAY_OF_MONTH);
					downtimeInDays = repair.getEndDate().getTimeInMillis()
							- date.getTimeInMillis();
					downtimeInDays = downtimeInDays / (1000 * 60 * 60);
					downtimeInDays = downtimeInDays / 24;
					// Store number of down time days into array by increasing
					// the value. Value can't be higher than 31.
					System.out.println("1d: " + downtimeInDays);
					monthlyDown[date.get(GregorianCalendar.MONTH)] += downtimeInDays;
				} else {
					// Second condition: If repair has started in one month and
					// ended in another. We will repeat this loop until we go
					// through all of the months
					while (!finished) {
						// If current month is not the same as end date.
						if (date.get(GregorianCalendar.MONTH) != repair
								.getEndDate().get(GregorianCalendar.MONTH)) {
							// We get the difference between maximum number of
							// days in that month and current day of month
							downtimeInDays = date
									.getActualMaximum(date.DAY_OF_MONTH)
									- date.get(GregorianCalendar.DAY_OF_MONTH);
							// Store number of down time days into array by
							// increasing the value.
							// Value can't be higher than 31.
							System.out.println("2d: " + downtimeInDays);
							monthlyDown[date.get(GregorianCalendar.MONTH)] += downtimeInDays;
							// Changing the current date by going one month
							// further
							date.set(date.get(GregorianCalendar.YEAR), date
									.get(GregorianCalendar.MONTH) + 1, 01);
						} else {
							// But if current month is the same as end date.
							// We get the difference between mend date and
							// current day of month
							downtimeInDays = repair.getEndDate().get(
									GregorianCalendar.DAY_OF_MONTH)
									- date.get(GregorianCalendar.DAY_OF_MONTH);
							// --,,--
							System.out.println("3d: " + downtimeInDays);
							monthlyDown[date.get(GregorianCalendar.MONTH)] += downtimeInDays + 1;
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
	public void addRepairType(RepairType repairType) {
		repairTypeDao.add(repairType);
	}

	/**
	 * Updates an object of Repair Type
	 */
	public void updateRepairType(RepairType repairType, String name) {
		if (!name.equals(""))
			repairType.setName(name);
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
		if (amount > 0)
			sparePart.setAmount(sparePart.getAmount() + amount);
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
	// No Update Method: We never update the drawer.

	/**
	 * Creates an object of Drawer
	 */
	public void addDrawer(Drawer drawer) {
		drawerDAO.add(drawer);
	}

	/**
	 * Deletes an object of Drawer
	 */
	public void removeDrawer(Drawer drawer) {
		boolean empty = true;
		for (Box box : drawer.getBoxes()) {
			if (box.getSparePart() != null)
				empty = false;
		}
		if (empty)
			drawerDAO.remove(drawer);
		else {
			// If number entered is negative, error message appears.
			ErrorDialog errorDialog = new ErrorDialog("Error!");
			// Text of the error message:
			errorDialog
					.setLblText("This drawer has parts. You cannot remove drawer with parts in it. Please move them first.");
			errorDialog.setVisible(true);

			// Waiting for error dialog to close

			errorDialog.dispose(); // release MS Windows resources
			return;
		}
	}

	/**
	 * Returns List of drawers
	 */
	public List<Drawer> getDrawers() {
		return drawerDAO.getList();
	}

	// --------------- DRAWER METHODS END -----------------------

	// --------------- MACHINE TYPE METHODS START -----------------

	/**
	 * Creates an object of Machine Type
	 */
	public void addMachineType(MachineType machineType) {
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

	// --------------- MACHINE TYPE METHODS END -----------------

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

	public String getDowntime(GregorianCalendar startDate,
			GregorianCalendar endDate) {
		long time;
		time = endDate.getTimeInMillis() - startDate.getTimeInMillis(); // Gets
																		// the
																		// difference
																		// between
																		// the
																		// dates
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

	/**
	 * Dynamic search for spare parts. Search returns all spare parts from the
	 * list, that have a number starting with given text.
	 * 
	 * @param number
	 *            number of spare part we are looking for.
	 */
	public List<SparePart> searchPart(String number) {
		// list of spare parts that the method will return.
		List<SparePart> returnList = new ArrayList<SparePart>();
		// we go through given list
		for (SparePart sparePart : getSpareParts()) {
			String sp = "" + sparePart.getNumber();
			// if current spare part number starts with given text, we add it to
			// returnList
			if (sp.startsWith(number))
				returnList.add(sparePart);
		}
		return returnList;
	}

	/**
	 * Dynamic search for spare parts, searching only through given list. Search
	 * returns all spare parts from the list given, that have a number starting
	 * with given text.
	 * 
	 * @param number
	 *            number of spare part we are looking for.
	 * @param list
	 *            list of spare parts you want to look through.
	 */
	public List<SparePart> searchPart(List<SparePart> list, String number) {
		// list of spare parts that the method will return.
		List<SparePart> returnList = new ArrayList<SparePart>();
		// we go through given list
		for (SparePart sparePart : list) {
			String sp = "" + sparePart.getNumber();
			// if current spare part number starts with given text, we add it to
			// returnList
			if (sp.startsWith(number))
				returnList.add(sparePart);
		}
		return returnList;
	}

	/**
	 * getMonthlyPartUsage()
	 */
	public int[] getMonthlyPartUsage(SparePart sparePart) {
		int[] usage = new int[12];
		// date of the last usage.
		GregorianCalendar today = new GregorianCalendar();
		// einam per visa array
		for (int i = sparePart.getPartsUsage().size() - 1; i > -1; i--) {
			// dabartinis usage
			PartUsage currentUsage = sparePart.getPartsUsage().get(i);
			today = new GregorianCalendar();
			// if we reached year usage which is more than 1 year old, we stop
			// main cycle.
			if (today.get(GregorianCalendar.YEAR)
					- currentUsage.getDate().get(GregorianCalendar.YEAR) > 1) {
				i = -1;
			}
			// if we reached usage which is more than 12 months ago, we stop
			// main cycle.
			else if (12 - currentUsage.getDate().get(
					GregorianCalendar.MONTH
							+ today.get(GregorianCalendar.MONTH)) > 12) {
				i = -1;
			}
			else {
				// we look for a place in array, where to put the part
				// we check all last 12 months and stop when found
				for (int k = 0; k < 12; k++) {
					// jeigu dabartinio usage ir siandienos menesiai sutampa
					if (currentUsage.getDate().get(GregorianCalendar.MONTH) == today
							.get(GregorianCalendar.MONTH)) {
						// System.out.println(k);
						usage[k] += currentUsage.getAmount();
						k = 12;
					} else {
						if (today.get(GregorianCalendar.MONTH) == 0) {
							today.roll(Calendar.YEAR, false);
							today.roll(Calendar.MONTH, false);
						} else
							today.roll(Calendar.MONTH, false);
					}
				}
			}
		}
		return usage;
	}
}
