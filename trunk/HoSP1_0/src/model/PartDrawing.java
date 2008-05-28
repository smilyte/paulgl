/**
 * @author Vytas
 */
package model;

import java.awt.Image;

/**
 * PartDrawing class implements Drawing interface.
 * <p>
 * <b>Implemented methods: </b> getDrawing(), setDrawing(Image d)
 * 
 */

public class PartDrawing implements Drawing {

	private Image partDrawing;

	@Override
	public Image getDrawing() {
		return partDrawing;
	}

	@Override
	public void setDrawing(Image d) {
		partDrawing = d;
	}

}
