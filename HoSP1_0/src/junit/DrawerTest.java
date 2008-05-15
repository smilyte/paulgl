package junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Drawer;

public class DrawerTest {

	@Before
	public void setUp() throws Exception {
//		Drawer d1 = new Drawer(1, 5);
//		Drawer d2 = new Drawer(2, 0);
//		Drawer d3 = new Drawer(3, -1);
//		Drawer d4 = new Drawer(4, a);
//		Drawer d5 = new Drawer(, 5);
		
	}

	@Test
	public void testDrawer() {
		Drawer d1 = new Drawer(1, 5);
		Drawer d2 = new Drawer(2, 0);
		Drawer d3 = new Drawer(2, -500);
		
		assertEquals(5, d1.getBoxes().size());
		assertEquals(0, d2.getBoxes().size());
		assertEquals(0, d3.getBoxes().size());
	}
	
}
