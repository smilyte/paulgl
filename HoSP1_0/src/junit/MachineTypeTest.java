package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.MachineType;

public class MachineTypeTest {
	
	private MachineType mt;

	@Before
	public void setUp() throws Exception {
		mt = new MachineType("Type1");
		
	}

	@Test
	public void testAddSparePart() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveSparePart() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateMachine() {
		fail("Not yet implemented");
	}

}
