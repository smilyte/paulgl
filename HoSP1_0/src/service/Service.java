package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import model.Drawer;
import model.Drawing;
import model.Machine;
import model.MachineType;
import model.PartUsage;
import model.Repair;
import model.RepairType;
import model.SparePart;

public class Service {

	private static Service instance = new Service();

	private Set<SparePart> spareParts = new HashSet<SparePart>();
	private Set<Repair> repairs = new HashSet<Repair>();
	private Set<RepairType> repairTypes = new HashSet<RepairType>();
	private Set<MachineType> machineTypes = new HashSet<MachineType>();
	private Set<Drawer> drawers = new HashSet<Drawer>();

	public Service() {
		startUp();
	}

	private void startUp() {

		// TODO Write method for: Update Drawer // We don't need it :]

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
	 */

	public int getMinimumAmount(SparePart sparePart) {
		// Variable 'maxUsage' will be used to return maximum amount of spare
		// part used in one month
		int maxUsage = -1;

		// Variable 'monthlyUse' will hold the amount of spare part used in one
		// month
		int[] monthlyUse = new int[12];

		// Using For Each Loop we are taking one spare part at a time
		for (SparePart sP : spareParts) {

			// We compare taken spare part with the one we are looking for. We
			// Continue only when we find required spare part.
			// Requirement: sparePart == sP
			if (sparePart.equals(sP)) {

				// We use this variable to remember which was the last month we
				// took to be able to count last 12 months.
				int lastMonth = -1;

				// We are going through one part's list(history) of all part
				// usages from the end of the list in order to have newest
				// records first.
				for (int i = sP.getPartsUsage().size(); i > 0; i--) {

					// In this variable we will count number of months we went
					// through in order to know when we have to stop.
					int calculateMonths = 0;

					// We create the object of PartUsage class and assign value
					// to it.
					PartUsage partUsage = sP.getPartsUsage().get(i);

					// We create variable of GregorianCalendar and assign part
					// usage date to it.
					GregorianCalendar theDate = partUsage.getDate();

					//We create new variable to store part usage's month.
					int month = theDate.MONTH;

					//If last month we checked is not the same when we increase value of 'calculateMonths'
					if (lastMonth != month)
						calculateMonths++;

					lastMonth = month;

					//If we still didn't went through more than 12 months we increase that month's value.
					//(We have to calculate usage based on only last 12 months)
					if (calculateMonths < 12)
						monthlyUse[month] += partUsage.getAmount();
				}
			}
			//Using 'for' loop we go through all months and values and remember the highest amount of parts we used. 
			for (int i : monthlyUse) {
				if (maxUsage < i)
					maxUsage = i;
				;
			}
		}
		//We return highest amount of parts we used in one month.  = Minimum amount which should be on stock.
		return maxUsage;
	}

	/**
	 * Calculate repairs for the last 24 hours Requirement: hours <= 24
	 * 
	 * long days = time/(1000*60*60*24); long hours =
	 * (time%(1000*60*60*24))/(1000*60*60); long minutes =
	 * ((time%(1000*60*60*24))%(1000*60*60))/(1000*60);
	 * 
	 */
	public List<Repair> calculateRepairsToday() {
		// We create the list where we will store repairs which meet the
		// requirement
		List<Repair> calcList = new ArrayList<Repair>();
		// Getting the Time And Date from the computer
		GregorianCalendar today = (GregorianCalendar) GregorianCalendar
		.getInstance(TimeZone.getDefault());
		
		// We are taking each repair at a time and calculating
		for (Repair repair : repairs) {
			// Calculate the difference between Todays's Date and End Date
			long time = today.getTimeInMillis()
					- repair.getEndDate().getTimeInMillis();
			// Converts that difference to hours
			long hours = (time % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
			// If hours are less than 24 we add this repair to the list.
			if (hours <= 24)
				calcList.add(repair);
		}
		
		// Return Repairs list with repairs made in last 24 hours.
		return calcList;
	}

	/**
	 * Creates an object of Repair
	 */
	public void createRepair(int num, GregorianCalendar startDate,
			GregorianCalendar endDate, Machine machine) {
		Repair repair = new Repair(num, startDate, endDate, machine);
		repairs.add(repair);
	}

	/**
	 * Updates an object of Repair
	 */
	public void updateRepair(Repair repair, GregorianCalendar startDate,
			GregorianCalendar endDate, Machine machine) {
		if (startDate != null)
			repair.setStartDate(startDate);
		if (endDate != null)
			repair.setStartDate(endDate);
	}

	/**
	 * Deletes an object of Repair
	 */
	public void deleteRepair(Repair repair) {
		repairs.remove(repair);
	}

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

	/**
	 * Creates an object of Spare Part
	 */
	public void createSparePart(int number, int amount) {
		SparePart sparePart = new SparePart(number, amount);
		spareParts.add(sparePart);
	}

	/**
	 * Updates an object of Spare Part
	 */
	public void updateSparePart(SparePart sparePart, int number, int amount,
			Drawing drawing) {
		if (number != 0)
			sparePart.setNumber(number);
		if (amount < 0)
			sparePart.setAmount(amount);
		if (drawing != null)
			sparePart.setDrawing(drawing);
	}

	/**
	 * Deletes an object of Spare Part
	 */
	public void deleteSparePart(SparePart sparePart) {
		spareParts.remove(sparePart);
	}

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
	 * @return the instance
	 */
	public static Service getInstance() {
		return instance;
	}
}
