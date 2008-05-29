package service;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class ServiceTest {
	
	private Service service = Service.getInstance();
	
	// illegal date
	private GregorianCalendar testDate1;
	// today
	private GregorianCalendar testDate2;
	// < 2 months
	private GregorianCalendar testDate3;
	// = 2 months
	private GregorianCalendar testDate4;
	// > 2 months
	private GregorianCalendar testDate5;
	
	private int units1; // illegal
	private int units2; // zero
	private int units3; // test units
	private int units4;	// test units
	private int units5; // test units
	private int units6;	// test units
	
	private int pricePerUnit1; //illegal
	private int pricePerUnit2; // zero
	private int pricePerUnit3; // test value
	private int pricePerUnit4; // test value
	private int pricePerUnit5; // test value
	

	@Before
	public void setUp() throws Exception {
		
		testDate1 = new GregorianCalendar(2008, 0, 1);
		testDate2 = new GregorianCalendar();
		testDate3 = new GregorianCalendar(2008, 5, 15);
		testDate4 = new GregorianCalendar();
		testDate4.roll(GregorianCalendar.MONTH, true);
		testDate4.roll(GregorianCalendar.MONTH, true);
		testDate5 = new GregorianCalendar(2008, 9, 1);
		
		units1 = -1;
		units2 = 0;
		units3 = 2;
		units4 = 4;
		units5 = 5;
		units6 = 7;
		
		pricePerUnit1 = 0;
		pricePerUnit2 = 100;
		pricePerUnit3 = 400;
		pricePerUnit4 = 350;
		pricePerUnit5 = 250;
		
	}

	@Test
	public void testCalcOrderPrice() {
		assertEquals(0, service.calcOrderPrice(testDate1, 10, pricePerUnit2));
		assertEquals(0, service.calcOrderPrice(testDate1, 9, pricePerUnit2));
		assertEquals(0, service.calcOrderPrice(testDate1, 11, pricePerUnit2));
		assertEquals(0, service.calcOrderPrice(testDate1, units1, pricePerUnit2));
		assertEquals(0, service.calcOrderPrice(testDate1, units2, pricePerUnit2));
		
		assertEquals(0, service.calcOrderPrice(testDate2, units1, pricePerUnit3));
		assertEquals(0, service.calcOrderPrice(testDate2, units2, pricePerUnit3));
		assertEquals(800, service.calcOrderPrice(testDate2, units3, pricePerUnit3));
		assertEquals(980, service.calcOrderPrice(testDate2, units4, pricePerUnit5));
		assertEquals(2401, service.calcOrderPrice(testDate2, units6, pricePerUnit4));
		
		assertEquals(0, service.calcOrderPrice(testDate3, units1, pricePerUnit3));
		assertEquals(0, service.calcOrderPrice(testDate3, units2, pricePerUnit3));
		assertEquals(800, service.calcOrderPrice(testDate3, units3, pricePerUnit3));
		assertEquals(980, service.calcOrderPrice(testDate3, units4, pricePerUnit5));
		assertEquals(2401, service.calcOrderPrice(testDate3, units6, pricePerUnit4));
		
		assertEquals(0, service.calcOrderPrice(testDate4, units1, pricePerUnit3));
		assertEquals(0, service.calcOrderPrice(testDate4, units2, pricePerUnit3));
		assertEquals(760, service.calcOrderPrice(testDate4, units3, pricePerUnit3));
		assertEquals(931, service.calcOrderPrice(testDate4, units4, pricePerUnit5));
		assertEquals(1862, service.calcOrderPrice(testDate4, units5, pricePerUnit3));
		
		assertEquals(0, service.calcOrderPrice(testDate5, units1, pricePerUnit3));
		assertEquals(0, service.calcOrderPrice(testDate5, units2, pricePerUnit3));
		assertEquals(760, service.calcOrderPrice(testDate5, units3, pricePerUnit3));
		assertEquals(931, service.calcOrderPrice(testDate5, units4, pricePerUnit5));
		assertEquals(1862, service.calcOrderPrice(testDate5, units5, pricePerUnit3));
		
		assertEquals(0, service.calcOrderPrice(testDate1, units1, pricePerUnit1));
		assertEquals(0, service.calcOrderPrice(testDate2, units2, pricePerUnit1));
		assertEquals(0, service.calcOrderPrice(testDate3, units3, pricePerUnit1));
		assertEquals(0, service.calcOrderPrice(testDate4, units4, pricePerUnit1));
		assertEquals(0, service.calcOrderPrice(testDate5, units5, pricePerUnit1));
	}

}
