package junit;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import model.Machine;
import model.MachineType;
import model.Repair;

import org.junit.Before;
import org.junit.Test;

import service.Service;

public class ServiceTest {
	
	private static Service service;
	private MachineType mt1;
	private Machine m1;
	private Repair r;

	@Before
	public void setUp() throws Exception {
		
		service = Service.getInstance();
		mt1 = new MachineType("MT name");
		m1 = new Machine(123123, "Manufacturer", mt1);
			
	}

	@Test
	public void testGetMinimumAmount() {
		// only black box test possible.
	}

	@Test
	public void testGetTodaysRepairs() {
		assertEquals(2, service.getTodaysRepairs().size());

	}

	@Test
	public void testAddRepair() {
		GregorianCalendar stDate1 = new GregorianCalendar(2008, 04, 13, 5, 25);
		GregorianCalendar eDate1 = new GregorianCalendar(2008, 04, 14, 10, 03);
		r = new Repair(service.getRepairs().size(), stDate1, eDate1, m1);
		service.addRepair(r);
		assertEquals(5, service.getRepairs().size());
	}

	@Test
	public void testUpdateRepair() {
		
		
		
	}

	@Test
	public void testRemoveRepair() {
		// check if removed
	}

	@Test
	public void testCreateRepairType() {
		
	}

	@Test
	public void testUpdateRepairType() {
		
	}

	@Test
	public void testDeleteRepairType() {
	
	}

	@Test
	public void testCreateSparePart() {
		
	}

	@Test
	public void testUpdateSparePart() {
		
	}

	@Test
	public void testDeleteSparePart() {
		
	}

	@Test
	public void testCreateMachineType() {
		
	}

	@Test
	public void testUpdateMachineType() {
		
	}

	@Test
	public void testDeleteMachineType() {
		
	}

	@Test
	public void testCreateDrawer() {
		
	}

	@Test
	public void testDeleteDrawer() {
		
	}

}
