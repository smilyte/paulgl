package service;

import java.util.GregorianCalendar;

import model.Machine;
import model.MachineType;
import model.Repair;

public class Test {

	private static GregorianCalendar stDate1, eDate1, stDate2, eDate2, stDate3, eDate3, stDate4, eDate4;
	private static Machine m1, m2, m3;
	private static Repair r1, r2, r3, r4;

	public static void main(String[] args) {

		SetUp();
		
		System.out.println(Service.getInstance().getTodaysRepairs());
		System.out.println();
		System.out.println(new GregorianCalendar().getTime());
	
		System.out.println(r1.getDowntime());
		System.out.println(r2.getDowntime());
		System.out.println(r3.getDowntime());
		System.out.println(r4.getDowntime());
		
		System.out.println();
		
		int[] machineMonthly = Service.getInstance().getMachineDowntime(m1);
		for (int i = 0; i < machineMonthly.length; i++) {
			System.out.println(i+": "+machineMonthly[i]);
		}
	}

	public static void SetUp() {
		m1 = new Machine(0101010, "FOL", new MachineType("C"));
		m2 = new Machine(2222222, "BBB", new MachineType("G"));
		m3 = new Machine(3333333, "AAA", new MachineType("V"));
		
		stDate1 = new GregorianCalendar(2008, 02, 13, 5, 25);
		eDate1 = new GregorianCalendar(2008, 04, 14, 10, 03);
		
		stDate2 = new GregorianCalendar(2008, 04, 15, 5, 25);
		eDate2 = new GregorianCalendar(2008, 04, 15, 12, 18);
		
		stDate3 = new GregorianCalendar(2008, 04, 16, 5, 25);
		eDate3 = new GregorianCalendar(2008, 04, 19, 10, 03);
		
		stDate4 = new GregorianCalendar(2008, 04, 16, 5, 25);
		eDate4 = new GregorianCalendar(2008, 04, 16, 9, 03);

		r1 = new Repair(1, stDate1, eDate1, m1);
		r2 = new Repair(2, stDate2, eDate2, m2);
		r3 = new Repair(3, stDate3, eDate3, m2);
		r4 = new Repair(4, stDate4, eDate4, m2);
		

		Service.getInstance().addRepair(r1);
		Service.getInstance().addRepair(r2);
		Service.getInstance().addRepair(r3);
		Service.getInstance().addRepair(r4);

	}

}
