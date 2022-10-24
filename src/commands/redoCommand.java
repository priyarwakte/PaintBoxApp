package commands;

import java.util.Stack;

import shape.shapeComponent;

public class redoCommand implements commandInterface {
	private Stack<shapeComponent> undoList;
	private Stack<shapeComponent> redoList;
	
	public redoCommand (Stack<shapeComponent> undoList, Stack<shapeComponent> redoList) {
		this.undoList = undoList;
		this.redoList = redoList;
	}
	
	@Override
	public void execute() {
		if(!redoList.isEmpty()) {
			shapeComponent obj = this.redoList.pop();
			obj.draw();
			if(this.undoList.isEmpty())
				this.undoList.add(obj);
			else
				this.undoList.push(obj);
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
