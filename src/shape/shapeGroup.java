package shape;

import java.util.Iterator;
import java.util.Stack;

import commands.redoCommand;
import commands.undoCommand; 

public class shapeGroup extends shapeComponent {
	private Stack<shapeComponent> undoList = new Stack<shapeComponent>();
	private Stack<shapeComponent> redoList = new Stack<shapeComponent>();
	public boolean undoCount = false;
	public boolean redoCount = false;
	public void add(shapeComponent c) {
		redoList.clear();
		if(undoList.isEmpty())
			undoList.add(c);
		else
			undoList.push(c);
		}   
	@Override
	public void draw() {
        Iterator value = undoList.iterator(); 
        while (value.hasNext()) { 
            ((shapeComponent) value.next()).draw();
        	} 
		}
	
	public void undo() {
		undoCommand undofunc = new undoCommand(undoList, redoList);
		undofunc.execute();
		this.undoList = undofunc.getUndoListResult();
		this.redoList = undofunc.getRedoListResult();
	}
	
	public void redo() {
		redoCommand redofunc = new redoCommand(undoList, redoList);
		redofunc.execute();
		this.undoList = redofunc.getUndoListResult();
		this.redoList = redofunc.getRedoListResult();
	}
}
