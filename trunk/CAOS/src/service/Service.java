package service;

import java.util.GregorianCalendar;
import java.util.List;
import dao.*;
import model.*;

public class Service {
	private static Machine m1, m2, m3, m4, m5, m6;

	private static Service instance;

	// Gets the one and only instance of the Repair DAO class.
	private RepairDAO repairDao = RepairDAO.getInstance();

	// Gets the one and only instance of the SparePartDAO class.
	private SparePartDAO sparePartDao = SparePartDAO.getInstance();

	// Gets the one and only instance of the MachineTypeDAO class.
	private MachineDAO machineDAO = MachineDAO.getInstance();

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

	private void startUp() {
		// creating new machines
		m1 = new Machine(000000);
		m2 = new Machine(555555);
		m3 = new Machine(777777);
		m4 = new Machine(222222);
		m5 = new Machine(111111);
		m6 = new Machine(6666666);

		// adding machines to containers
		addMachine(m1);
		addMachine(m2);
		addMachine(m3);
		addMachine(m4);
		addMachine(m5);
		addMachine(m6);

		// creating new spare parts
		addSparePart(new SparePart(10, 1111111));
		addSparePart(new SparePart(20, 3333333));
		addSparePart(new SparePart(5, 5555555));
		addSparePart(new SparePart(100, 7777777));
	}

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
	public void updateSparePart(SparePart sparePart, int number, int amount) {
		if (number != 0)
			sparePart.setNumber(number);
		if (amount > 0)
			sparePart.setAmount(sparePart.getAmount() + amount);

		sparePartDao.update(sparePart);
	}

	/**
	 * Deletes an object of SparePart
	 */
	public void removeSparePart(SparePart sparePart) {
		sparePartDao.remove(sparePart);
	}

	/**
	 * Returns List of spare parts
	 */
	public List<SparePart> getSpareParts() {
		return sparePartDao.getList();
	}

	// --------------- SPARE PART METHODS END -------------------------

	// --------------- MACHINE METHODS START -----------------
	/**
	 * Creates an object of Machine
	 */
	public void addMachine(Machine machine) {
		machineDAO.add(machine);
	}

	/**
	 * Updates an object of Machine
	 */
	public void updateMachine(Machine machine, int number) {
		if (number > 0 && ("" + number).length() == 7)
			machine.setSerialNumber(number);
		machineDAO.update(machine);
	}

	/**
	 * Deletes an object of Machine
	 */
	public void removeMachineType(Machine machine) {
		machineDAO.remove(machine);
	}

	/**
	 * Returns List of machines
	 */
	public List<Machine> getMachines() {
		return machineDAO.getList();
	}
	// --------------- MACHINE METHODS END -----------------
}
