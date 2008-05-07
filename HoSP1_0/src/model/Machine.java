/**
 * 
 */
package model;

import java.util.ArrayList;

/**
 * @author Elena
 *
 */
public class Machine {
	
	private String name;
	
	/*
	 * Link to Machine class (0..*)
	 */
	private ArrayList<Machine> machines = new ArrayList<Machine>();

}
