package service;

import java.util.HashSet;
import java.util.Set;

import model.Drawer;
import model.MachineType;
import model.Repair;
import model.SparePart;

public class Service {
	
	private static Service instance = new Service();
	
	private Set<SparePart> spareParts = new HashSet<SparePart>();
	private Set<Repair> repairs = new HashSet<Repair>();
	private Set<MachineType> machineTypes = new HashSet<MachineType>();
	private Set<Drawer> drawers = new HashSet<Drawer>();

	public Service(){
		startUp();
	}
	private void startUp() {
		// TODO Write method for: Create Drawer 
		// TODO Write method for: Create Machine Type
		// TODO Write method for: Create Repair
		
		// TODO Write method for: Update Drawer 
		// TODO Write method for: Update Spare Part
		// TODO Write method for: Update Machine Type
		// TODO Write method for: Update Repair
		
		// TODO Write method for: Delete Drawer 
		// TODO Write method for: Delete Spare Part
		// TODO Write method for: Delete Machine Type
		// TODO Write method for: Delete Repair
		
		// TODO Write method for: calculation(history) of last 24 hours repairs
		// TODO Write method for: calculation(history) of last 7 days (week) repairs
		// TODO Write method for: calculation(history) of last 30 days (month)  repairs
		// TODO Write method for: calculation(history) of last 12 months (year) repairs
		
		// TODO Write method for: calculating minimum amount for the part using formula
	}
	/**
	 * Creates an objects of Spare Part
	 */
	public void createSparePart(int number, int amount){
		SparePart sparePart = new SparePart(number, amount);
		spareParts.add(sparePart);
	}
	
	/**
	 * Updates an object of Spare Part
	 */
	public void updateSparePart(int number, int amount){
		SparePart sparePart = new SparePart(number, amount);
		spareParts.add(sparePart);
	}
	
	/**
	 * @return the instance
	 */
	public static Service getInstance() {
		return instance;
	}
}
