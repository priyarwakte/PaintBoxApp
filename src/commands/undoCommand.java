package commands;

import java.util.Stack;

import shape.shapeComponent;

public class undoCommand implements commandInterface {
	private Stack<shapeComponent> undoList;
	private Stack<shapeComponent> redoList;

	public undoCommand (Stack<shapeComponent> undoList, Stack<shapeComponent> redoList) {
		this.undoList = undoList;
		this.redoList = redoList;
	}
	
	@Override
	public void execute() {
		if(!this.undoList.isEmpty()) {
			shapeComponent obj = this.undoList.pop();
			obj.erase();
			if(this.redoList.isEmpty())
				this.redoList.add(obj);
			else
				this.redoList.push(obj);	
			}
	}

	@Override
	public Stack<shapeComponent> getUndoListResult() {
		return (this.undoList);
	}

	@Override
	public Stack<shapeComponent> getRedoListResult() {
		return (this.redoList);
	}
	

}
