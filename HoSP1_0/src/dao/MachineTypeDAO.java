/**
 * 
 */
package dao;

import java.util.HashSet;
import java.util.Set;

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
		private Set<MachineType> machineTypes = new HashSet<MachineType>();

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
		public void addMachineType(MachineType machineType) {
			machineTypes.add(machineType);
		}

		/**
		 * Remove the machineType from the list of all machineTypes.
		 */
		public void removeMachineType(MachineType machineType) {
			machineTypes.remove(machineType);
		}

		/**
		 * Returns a list with all machineTypes.
		 */
		public Set<MachineType> getMachineTypes() {
			return machineTypes;
		}

		/**
		 * Updates the information about the machineTypes.
		 */
		public void updateMachineType(MachineType machineType) {
			// do nothing: the machineType is already in the container
		}
	}

