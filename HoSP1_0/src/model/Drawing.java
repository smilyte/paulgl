/**
 * Drawing <<interface>> 
 * @author Vytas
 *
 */
package model;

import java.awt.Image;

public interface Drawing {
	
	// Gets Part's or Machine's drawing and returns it as Image type.
	public Image getDrawing();
	
	// Sets drawing to Part or Machine.
	public void setDrawing(Image img);
}
