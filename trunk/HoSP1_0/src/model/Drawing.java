package model;

import java.awt.Image;
/**
 * Drawing <<interface>> 
 * @author Vytas
 *
 */
public interface Drawing {
	
	// Gets Part's or Machine's drawing and returns it as Image type.
	public Image getDrawing();
	
	// Sets drawing to Part or Machine.
	public void setDrawing(Image img);
}
