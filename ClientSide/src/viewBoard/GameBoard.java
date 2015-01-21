package viewBoard;

import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public abstract class GameBoard extends Canvas {

	String description;
	
	public GameBoard(Composite parent, int style, String description) {
		super(parent, style);
		this.description = description;
	}

	public abstract void createBoardGame();
}
