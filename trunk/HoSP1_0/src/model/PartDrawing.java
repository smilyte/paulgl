package model;

import java.awt.Image;

public class PartDrawing implements Drawing {

	private Image partDrawing;

	@Override
	public Image getDrawing() {
		return partDrawing;
	}

	@Override
	public void setDrawing(Image img) {
		partDrawing = img;
	}

}
