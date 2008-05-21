package service;

import java.util.GregorianCalendar;

import model.Machine;
import model.MachineType;
import model.Repair;

public class Test {

	private static GregorianCalendar stDate1, eDate1, stDate2, eDate2, stDate3, eDate3, stDate4, eDate4;
	private static Machine m1, m2, m3, m4, m5, m6;
	private static MachineType mt1, mt2, mt3;
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
		Service service = Service.getInstance();
		
		mt1 = new MachineType("MT Turbo 1");
		mt2 = new MachineType("MT Rocket 2");
		mt3 = new MachineType("MT Jazz 3");
		
		service.addMachineType(mt1);
		service.addMachineType(mt2);
		service.addMachineType(mt3);
		
		m1 = new Machine(00000, "Music");
		m2 = new Machine(555555, "Bungle");
		m3 = new Machine(777777, "Cungle");
		m4 = new Machine(22222, "Turtle");
		m5 = new Machine(11111, "Rabit");
		m6 = new Machine(666666, "Dungle");
		
		mt3.addMachine(m1);
		mt2.addMachine(m2);
		mt2.addMachine(m3);
		mt2.addMachine(m4);
		mt1.addMachine(m5);
		mt1.addMachine(m6);
		
		stDate1 = new GregorianCalendar(2008, 1, 13, 8, 25);
		eDate1 = new GregorianCalendar(2008, 4, 17, 10, 03);
		
		stDate2 = new GregorianCalendar(2008, 4, 15, 5, 25);
		eDate2 = new GregorianCalendar(2008, 4, 15, 12, 18);
		
		stDate3 = new GregorianCalendar(2008, 4, 16, 5, 25);
		eDate3 = new GregorianCalendar(2008, 4, 19, 10, 03);
		
		stDate4 = new GregorianCalendar(2008, 4, 16, 5, 25);
		eDate4 = new GregorianCalendar(2008, 4, 16, 9, 03);

		r1 = new Repair(1, stDate1, eDate1, m1);
		r2 = new Repair(2, stDate2, eDate2, m2);
		r3 = new Repair(3, stDate3, eDate3, m2);
		r4 = new Repair(4, stDate4, eDate4, m2);
		
		service.addRepair(r1);
		service.addRepair(r2);
		service.addRepair(r3);
		service.addRepair(r4);
	}

}
