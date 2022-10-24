package gui;

import shape.shapeComponent;
import shape.shapeGroup;

import java.awt.Graphics;

import shape.Box;
import shape.Circle;
import shape.shapeEnums;

public class canvasGUIController{
	shapeEnums buttonClicked; 
	shapeComponent component;
	public canvasGUIController() {
	      super();
	      this.component = new shapeGroup();
	}
	
	public void canvasClicked(int x, int y, Graphics g) {
		switch(this.buttonClicked) {
			case Box:
				this.component.add(new Box(x, y, 100, 100, g));
				break;
			case Circle:
			default:
				this.component.add(new Circle(x, y, 100, 100, g));
				break;
		}
		this.component.draw();
		System.out.println("canvasClicked" + x + " " + y);
	}

	public void circleButtonClicked() {
		// TODO Auto-generated method stub
		this.buttonClicked = shapeEnums.Circle;
		System.out.println("circleButtonClicked");
	}

	public void boxButtonClicked() {
		// TODO Auto-generated method stub
		this.buttonClicked = shapeEnums.Box;
		System.out.println("boxButtonClicked");
	}

	public void undoButtonClicked() {
		this.component.undo();
	}

	public void redoButtonClicked() {
		this.component.redo();
	}
	
	}
