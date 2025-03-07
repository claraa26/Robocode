package jab;

public class ModuleBot extends Module {
	protected Movement getSelectedMovement() {		
		return new RandomMove(this);
	}
}