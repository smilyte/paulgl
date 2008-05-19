package dao;

import java.util.ArrayList;
import java.util.List;

import model.SparePart;

public class SparePartDAO {
	private static SparePartDAO instance = null;
	
	//container for all spare parts
	private List<SparePart> spareParts = new ArrayList<SparePart>(); 
	
	
	private SparePartDAO() {}
	
	
	/**
	 * Return the one and only instance of the SparePartDAO class.
	 */
	public static SparePartDAO getInstance() {
		if (instance == null)
			instance = new SparePartDAO();
		return instance;
	}
	
	//.........................................................
	/**
	 * Adds an object of SparePart
	 */
	public void add(SparePart sparePart) {
		spareParts.add(sparePart);
	}

	/**
	 * Updates an object of Spare Part
	 */
	public void update(SparePart sparePart){
		// nothing to do.

	}

	/**
	 * Deletes an object of Spare Part
	 */
	public void delete(SparePart sparePart) {
		sparePart.getBox().setSp(null);
		spareParts.remove(sparePart);
	}
	
	public List<SparePart> getList() {
		return spareParts;
	}
}
