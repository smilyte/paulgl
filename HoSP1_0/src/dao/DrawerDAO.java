/**
 * 
 */
package dao;

import java.util.HashSet;
import java.util.Set;

import model.Drawer;

/**
 * The Drawer DAO class has methods that add, remove, update and return drawers
 * from the containers.
 * 
 * @author Malik
 */
public class DrawerDAO {

	private static DrawerDAO instance = null;

	// container for all drawers
	private Set<Drawer> drawers = new HashSet<Drawer>();

	private DrawerDAO() {

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
	public void addDrawer(Drawer drawer) {
		drawers.add(drawer);
	}

	/**
	 * Remove the drawer from the list of all drawers.
	 */
	public void removeDrawer(Drawer drawer) {
		drawers.remove(drawer);
	}

	/**
	 * Returns a list with all drawers.
	 */
	public Set<Drawer> getDrawers() {
		return drawers;
	}

	/**
	 * Updates the information about the drawers.
	 */
	public void updateRepair(Drawer drawer) {
		// do nothing: the repair is already in the container
	}
}
