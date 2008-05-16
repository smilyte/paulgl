package model;

import java.awt.Image;

public class MachineDrawing implements Drawing {
	private Image machineDrawing;

	@Override
	public Image getDrawing() {
		return machineDrawing;
	}

	@Override
	public void setDrawing(Image img) {
		machineDrawing = img;
	}

}
