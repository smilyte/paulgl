package dao;

import java.util.HashSet;
import java.util.Set;

import model.Repair;

/**
 * The Repair DAO class has methods that add, remove, update and return repairs
 * from the containers.
 * @author Vytas
 */

public class RepairDAO{
	
	private static RepairDAO instance = null;
	
	//container for all repairs
	private Set<Repair> repairs = new HashSet<Repair>(); 
	
	
	private RepairDAO() {}
	
	
	/**
	 * Return the one and only instance of the Repair DAO class.
	 */
	public static RepairDAO getInstance() {
		if (instance == null)
			instance = new RepairDAO();
		return instance;
	}
	
	//.........................................................
	/**
	 * Adds a repair to the list of all repairs.
	 */
	public void addRepair(Repair repair) {
		repairs.add(repair);
	}

	/**
	 * Remove the repair from the list of all repairs.
	 */
	public void removeRepair(Repair repair) {
		repairs.remove(repair);
	}

	/**
	 * Returns a list with all repairs.
	 */
	public Set<Repair> getRepairs() {
		return repairs;
	}
	
	/**
	 * Updates the information about the repair.
	 */
	public void updateRepair(Repair repair) {
		//do nothing: the repair is already in the container
	}	
}
