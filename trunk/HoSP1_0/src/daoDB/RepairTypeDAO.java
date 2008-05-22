package daoDB;

import java.util.List;
import com.db4o.ObjectContainer;
import model.RepairType;

public class RepairTypeDAO {
	private static RepairTypeDAO instance = null;
	
	private ObjectContainer db = DB4OManager.getInstance().getObjectContainer();
	
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
		db.set(repairType);
		db.commit();
	}

	/**
	 * Deletes an object of RepairType
	 */
	public void remove(RepairType repairType) {
		db.delete(repairType);
		db.commit();
	}
	
	/**
	 * Returns list of repair types
	 */
	public List<RepairType> getList() {
		return db.get(RepairType.class);
	}
	
	/**
	 * Updates an object of RepairType
	 */
	public void update(RepairType repairType){
		db.set(repairType);
		db.commit();
	}
}
