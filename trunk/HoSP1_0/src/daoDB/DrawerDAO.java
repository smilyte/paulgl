package daoDB;

import java.util.List;
import com.db4o.ObjectContainer;
import model.Drawer;


/**
 * The Drawer DAO class has methods that add, remove, update and return drawers
 * from the containers.
 * 
 * @author Malik
 */
public class DrawerDAO {

	private static DrawerDAO instance = null;

	private ObjectContainer db = DB4OManager.getInstance().getObjectContainer();

	private DrawerDAO() {
		
//		db.set(new Drawer(1, 2));
//		db.set(new Drawer(2,3));
//		db.commit();
	}

	/**
	 * Return the one and only instance of the Drawer DAO class.
	 */
	public static DrawerDAO getInstance() {
		if (instance == null)
			instance = new DrawerDAO();
		return instance;
	}

	// .........................................................
	/**
	 * Adds a drawer to the list of all drawers.
	 */
	public void add(Drawer drawer) {
		db.set(drawer);
		db.commit();
	}

	/**
	 * Remove the drawer from the list of all drawers.
	 */
	public void remove(Drawer drawer) {
		db.delete(drawer);
		db.commit();
	}

	/**
	 * Returns a list with all drawers.
	 */
	public List<Drawer> getList() {
		return db.get(Drawer.class);
	}

	/**
	 * Updates the information about the drawers.
	 */
	public void update(Drawer drawer) {
		db.set(drawer);
		db.commit();
	}
}
