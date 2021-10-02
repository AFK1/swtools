package org.swtools.client.gui.thems;


public class rect_button {
	private int xPos, yPos, hei, wid;
	
	public int[] info() {
		return new int[] {xPos, yPos, hei, wid};
	}
	
	public void setx(int _x) {
		xPos = _x;
	}
	public void sety(int _y) {
		yPos = _y;
	}
	public void seth(int _h) {
		hei = _h;
	}
	public void setw(int _w) {
		wid = _w;
	}
}
