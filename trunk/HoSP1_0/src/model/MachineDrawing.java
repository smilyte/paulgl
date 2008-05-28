/**
 * @author Vytas
 */
package model;

import java.awt.Image;

/**
 * MachineDrawing class implements Drawing interface.
 * <p>
 * <b>Implemented methods: </b>
 * getDrawing(), setDrawing(Image d)
 *
 */
public class MachineDrawing implements Drawing {
	private Image machineDrawing;

	@Override
	public Image getDrawing() {
		return machineDrawing;
	}
	@Override
	public void setDrawing(Image d) {
		machineDrawing = d;
	}
}


