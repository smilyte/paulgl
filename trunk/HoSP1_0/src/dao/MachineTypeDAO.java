/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;


import model.MachineType;

/**
 * The MachineType DAO class has methods that add, remove, update and return machineTypes
 * from the containers.
 * 
 * @author Malik
 */
public class MachineTypeDAO {

		private static MachineTypeDAO instance = null;

		// container for all machineTypes
		private List<MachineType> machineTypes = new ArrayList<MachineType>();

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
			machineTypes.add(machineType);
		}

		/**
		 * Remove the machineType from the list of all machineTypes.
		 */
		public void remove(MachineType machineType) {
			machineTypes.remove(machineType);
		}

		/**
		 * Returns a list with all machineTypes.
		 */
		public List<MachineType> getList() {
			return machineTypes;
		}

		/**
		 * Updates the information about the machineTypes.
		 */
		public void update(MachineType machineType) {
			// do nothing: the machineType is already in the container
		}
	}

