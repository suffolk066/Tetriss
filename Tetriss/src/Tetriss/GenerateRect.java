package Tetriss;

import java.awt.Color;
import java.awt.Graphics;

public class GenerateRect {
	int x, y, w, h;
	Color c;
	
	public GenerateRect(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}
	
	public void drawRect(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, w, h);
	}
	
	public void draw2(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, w, h);
	}
	
	public void setColor(Color c) {
		this.c = c;
	}
}
