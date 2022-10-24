package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Box extends shapeComponent {
	private int x,y;
	private int height;
	private int width;
	private Graphics graphics;
	public Box(int x, int y, int h, int w, Graphics graphics) {
		this.x = x;
		this.y = y;
		this.height = h;
		this.width = w;
		this.graphics = graphics;
	}
	@Override
	public void draw() {
		this.graphics.setColor(Color.red);
		this.graphics.drawRect(this.x, this.y, this.height, this.width);	
	}
	@Override
	public void erase() {
		this.graphics.setColor(Color.white);
		this.graphics.drawRect(this.x, this.y, this.height, this.width);
	}
}