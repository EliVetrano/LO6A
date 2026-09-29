/** 
 * Walks right until the next square is blocked or the board ends. 
*/


package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Robot extends GamePiece implements Moveable {
	
    public Robot(int location) { 
    	super('B', "Robot", location); 
    }
    
    @Override public InteractionResult interact(Drawable[] board, int playerLocation) {
        return InteractionResult.NONE;
    }
    
    @Override public void move(Drawable[] board, int playerLocation) {
        int next = getLocation() + 1;
        
        if (next < board.length && board[next] == null) {
        	
            board[getLocation()] = null;
            board[next] = this;
            setLocation(next);
            
        }
    }
}
