package dao;

import java.util.ArrayList;
import java.util.List;

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
	private List<Drawer> drawers = new ArrayList<Drawer>();

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
	public void add(Drawer drawer) {
		drawers.add(drawer);
	}

	/**
	 * Remove the drawer from the list of all drawers.
	 */
	public void remove(Drawer drawer) {
		drawers.remove(drawer);
	}

	/**
	 * Returns a list with all drawers.
	 */
	public List<Drawer> getList() {
		return drawers;
	}

	/**
	 * Updates the information about the drawers.
	 */
	public void update(Drawer drawer) {
		// do nothing: the drawer is already in the container
	}
}
