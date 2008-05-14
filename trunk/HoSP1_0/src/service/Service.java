package service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import model.Drawer;
import model.Drawing;
import model.Machine;
import model.MachineType;
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

		// TODO Write method for: calculation(history) of last 24 hours repairs
		// TODO Write method for: calculation(history) of last 7 days (week)
		// repairs
		// TODO Write method for: calculation(history) of last 30 days (month)
		// repairs
		// TODO Write method for: calculation(history) of last 12 months (year)
		// repairs

		// TODO Write method for: calculating minimum amount for the part using
		// formula
	}

	/**
	 * Creates an object of Repair
	 */
	public void createRepair(int num, Date startDate, Date endDate, Machine machine) {
		Repair repair = new Repair(num, startDate, endDate, machine);
		repairs.add(repair);
	}
	
	/**
	 * Updates an object of Repair
	 */
	public void updateRepair(Repair repair, Date startDate, Date endDate, Machine machine) {
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
	public void updateRepairType(RepairType repairType, String name, MachineType machineType) {
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
	public void updateMachineType(MachineType machineType, String name, Drawing drawing) {
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
