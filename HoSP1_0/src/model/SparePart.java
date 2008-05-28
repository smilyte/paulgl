/**
 * @author Vytas
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class SparePart {

	private int amount;
	private int number;

	// link to [PartUsage] Class(--> 0..*)
	private List<PartUsage> partUsages = new ArrayList<PartUsage>();

	// link to [TypeUsage] Class(--> 0..*)
	private List<TypeUsage> typeUsages = new ArrayList<TypeUsage>();
	// no methods implemented
	
	// link to [PartDrawing] Class(--> 0..1)
	private PartDrawing drawing;

	// link to [Box] Class(-- 1)
	private Box box = null;

	/**
	 * <b>Constructor: </b> Creates new spare part.
	 * <p>
	 * <b>Requires: </b> box != null
	 * 
	 * @param amount
	 *            how many parts do we have
	 * @param number
	 *            7 digit number of a part
	 * @param box
	 *            Box, where the part is placed
	 */
	public SparePart(int amount, int number, Box box) {
		this.amount = amount;
		this.number = number;
		this.box = box;
		box.setSp(this);
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	// .................Part Usage..Start................
	/**
	 * Adds a part usage to this spare part
	 * <p>
	 * <b>Requires: </b> partUsage != null
	 * 
	 */
	public void addPartUsage(PartUsage partUsage) {
		partUsages.add(partUsage);
	}

	/**
	 * @return the list of all part usages of this repair
	 */
	public List<PartUsage> getPartUsages() {
		return partUsages;
	}

	// .................Part Usage..End..................

	// .................Drawing..Start...................
	/**
	 * @return the drawing
	 */
	public Drawing getDrawing() {
		return drawing;
	}

	/**
	 * Sets drawing to this spare part.
	 * 
	 * @param drawing
	 */
	public void setDrawing(PartDrawing drawing) {
		this.drawing = drawing;
	}

	// .................Drawing..End...................

	// .................Box..Start.....................
	/**
	 * Sets new box for this spare part
	 * 
	 * @param newBox
	 *            Box, where the part will be placed
	 *            <p>
	 *            <b>Requires:</b> newBox != null
	 * @author Elena
	 */
	public void setBox(Box newBox) {
		if (newBox != null) {
			this.box = newBox;
			newBox.setSp(this);
		}
	}

	/**
	 * @return box of this part
	 */
	public Box getBox() {
		return box;
	}

	// .................Box..End.....................

	/**
	 * @return number of spare part and amount on stock as string.
	 */
	public String toString() {
		return number + " (" + amount + ")";
	}

}
