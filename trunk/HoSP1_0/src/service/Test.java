package service;

import java.util.GregorianCalendar;
import model.MachineType;
import model.Repair;

public class Test {

	private static GregorianCalendar stDate1, eDate1, stDate2, eDate2, stDate3, eDate3, stDate4, eDate4;
	private static MachineType mt1, mt2, mt3;
	private static Repair r1, r2, r3, r4;
	private static Service service = Service.getInstance();

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
		
		int[] machineMonthly = Service.getInstance().getMachineMonthlyDowntime2(mt1.getMachines().get(0));
		for (int i = 0; i < machineMonthly.length; i++) {
			System.out.println(i+": "+machineMonthly[i]);
		}
	}

	public static void SetUp() {
		
		mt1 = new MachineType("MT Turbo 1");
		mt2 = new MachineType("MT Rocket 2");
		mt3 = new MachineType("MT Jazz 3");
		
		service.addMachineType(mt1);
		service.addMachineType(mt2);
		service.addMachineType(mt3);

		mt3.createMachine(500000);
		mt2.createMachine(555555);
		mt2.createMachine(777777);
		mt2.createMachine(22222);
		mt1.createMachine(11111);
		mt1.createMachine(666666);
		
		stDate1 = new GregorianCalendar(2008, 1, 13, 8, 25);
		eDate1 = new GregorianCalendar(2008, 4, 20, 10, 03);
		
		stDate2 = new GregorianCalendar(2008, 4, 15, 5, 25);
		eDate2 = new GregorianCalendar(2008, 4, 15, 12, 18);
		
		stDate3 = new GregorianCalendar(2008, 4, 16, 5, 25);
		eDate3 = new GregorianCalendar(2008, 4, 19, 10, 03);
		
		stDate4 = new GregorianCalendar(2008, 4, 16, 5, 25);
		eDate4 = new GregorianCalendar(2008, 4, 16, 9, 03);

		r1 = new Repair(1, stDate1, eDate1, mt1.getMachines().get(0));
		r2 = new Repair(2, stDate2, eDate2, mt1.getMachines().get(1));
		r3 = new Repair(3, stDate3, eDate3, mt2.getMachines().get(1));
		r4 = new Repair(4, stDate4, eDate4, mt2.getMachines().get(2));
		
		service.addRepair(r1);
		service.addRepair(r2);
		service.addRepair(r3);
		service.addRepair(r4);
	}

}
