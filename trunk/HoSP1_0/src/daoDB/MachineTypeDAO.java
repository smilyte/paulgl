/**
 * 
 */
package daoDB;

import java.util.List;
import com.db4o.ObjectContainer;
import model.MachineType;

/**
 * The MachineType DAO class has methods that add, remove, update and return machineTypes
 * from the containers.
 * 
 * @author Malik
 */
public class MachineTypeDAO {

		private static MachineTypeDAO instance = null;

		private ObjectContainer db = DB4OManager.getInstance().getObjectContainer();

		private MachineTypeDAO() {

		}

		/**
		 * Return the one and only instance of the MachineType DAO class.
		 */
		public static MachineTypeDAO getInstance() {
			if (instance == null)
				instance = new MachineTypeDAO();
			return instance;
		}

		// .........................................................
		/**
		 * Adds a machineType to the list of all machineTypes.
		 */
		public void add(MachineType machineType) {
			db.set(machineType);
			db.commit();
		}

		/**
		 * Remove the machineType from the list of all machineTypes.
		 */
		public void remove(MachineType machineType) {
			db.delete(machineType);
			db.commit();
		}

		/**
		 * Returns a list with all machineTypes.
		 */
		public List<MachineType> getList() {
			return db.get(MachineType.class);
		}

		/**
		 * Updates the information about the machineTypes.
		 */
		public void update(MachineType machineType) {
			// do nothing: the machineType is already in the container
		}
	}

