package dao;

import java.util.ArrayList;
import java.util.List;

import model.RepairType;

public class RepairTypeDAO {
	private static RepairTypeDAO instance = null;
	
	//container for all repair types
	private List<RepairType> repairTypes = new ArrayList<RepairType>(); 
	
	
	private RepairTypeDAO() {}
	
	
	/**
	 * Return the one and only instance of the RepairTypeDAO class.
	 */
	public static RepairTypeDAO getInstance() {
		if (instance == null)
			instance = new RepairTypeDAO();
		return instance;
	}
	
	//.........................................................
	/**
	 * Adds an object of RepairType
	 */
	public void add(RepairType repairType) {
		repairTypes.add(repairType);
	}

	/**
	 * Updates an object of RepairType
	 */
	public void update(RepairType repairType){
		// nothing to do.

	}

	/**
	 * Deletes an object of RepairType
	 */
	public void remove(RepairType repairType) {
		repairTypes.remove(repairType);
	}
	
	/**
	 * Returns list of repair types
	 */
	public List<RepairType> getList() {
		return repairTypes;
	}
}
