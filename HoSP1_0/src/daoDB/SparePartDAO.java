package daoDB;

import java.util.List;
import com.db4o.ObjectContainer;
import model.SparePart;

public class SparePartDAO {
	private static SparePartDAO instance = null;
	
	private ObjectContainer db = DB4OManager.getInstance().getObjectContainer();
	
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
		db.set(sparePart);
		db.commit();
	}

	/**
	 * Deletes an object of Spare Part
	 */
	public void remove(SparePart sparePart) {
		sparePart.getBox().setSp(null);
		db.delete(sparePart);
		db.commit();
	}
	/**
	 * Returns list of spare parts
	 */
	public List<SparePart> getList() {
		return db.get(SparePart.class);
	}
	
	/**
	 * Updates an object of Spare Part
	 */
	public void update(SparePart sparePart){
		db.set(sparePart);
		db.commit();
	}
}
