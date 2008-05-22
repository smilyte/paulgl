package daoDB;

import java.util.List;
import com.db4o.ObjectContainer;
import model.Repair;

/**
 * The Repair DAO class has methods that add, remove, update and return repairs
 * from the containers.
 * @author Vytas
 */

public class RepairDAO{
	
	private static RepairDAO instance = null;
	
	private ObjectContainer db = DB4OManager.getInstance().getObjectContainer();
	
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
	public void add(Repair repair) {
		db.set(repair);
		db.commit();
	}

	/**
	 * Remove the repair from the list of all repairs.
	 */
	public void remove(Repair repair) {
		db.delete(repair);
		db.commit();
	}

	/**
	 * Returns a list with all repairs.
	 */
	public List<Repair> getList() {
		return db.get(Repair.class);
	}
	
	/**
	 * Updates the information about the repair.
	 */
	public void update(Repair repair) {
		db.set(repair);
		db.commit();
	}	
}
