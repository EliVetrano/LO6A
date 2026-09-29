/** 
 * Walks right until the next square is blocked or the board ends.
 * isn't on the same square  
*/


package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Robot extends GamePiece implements Moveable {
	
    public Robot(int location) { 
    	super('B', "Robot", location); 
    }
    
    //override the interactionresult interface to check for only none
    
    @Override 
    public InteractionResult interact(Drawable[] board, int playerLocation) {
        return InteractionResult.NONE;
    }
    
    //override the moveable interface to change piece movement
    
    @Override 
    public void move(Drawable[] board, int playerLocation) {
    	int next;
    	boolean dir = true;
    	if(dir) {
    		next = getLocation() + 1;
    	} else {
    		next = getLocation() - 1;
    	}
        
        if (next < board.length && board[next] == null) {
        
            board[getLocation()] = null;
            board[next] = this;
            setLocation(next);
            
        }
    }
}
