/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;


import model.Machine;

/**
 * The Machine DAO class has methods that add, remove, update and return machines
 * from the containers.
 * 
 * @author Malik
 */
public class MachineDAO {

		private static MachineDAO instance = null;

		// container for all machineTypes
		private List<Machine> machines = new ArrayList<Machine>();

		private MachineDAO() {

		}

		/**
		 * Return the one and only instance of the Machine DAO class.
		 */
		public static MachineDAO getInstance() {
			if (instance == null)
				instance = new MachineDAO();
			return instance;
		}

		// .........................................................
		/**
		 * Adds a machine to the list of all machines.
		 */
		public void add(Machine machine) {
			machines.add(machine);
		}

		/**
		 * Remove the machine from the list of all machines.
		 */
		public void remove(Machine machine) {
			machines.remove(machine);
		}

		/**
		 * Returns a list with all machines.
		 */
		public List<Machine> getList() {
			return machines;
		}

		/**
		 * Updates the information about the machines.
		 */
		public void update(Machine machine) {
			// do nothing: the machine is already in the container
		}
	}

