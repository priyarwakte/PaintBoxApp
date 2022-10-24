package commands;

import java.util.Stack;

import shape.shapeComponent;

public interface commandInterface {
	void execute();
	Stack<shapeComponent> getUndoListResult();
	Stack<shapeComponent> getRedoListResult();
}
