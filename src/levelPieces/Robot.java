/** 
 * Walks right until the next square is blocked or the board ends.
 * isn't on the same square  
*/


package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.GameEngine;

public class Robot extends GamePiece implements Moveable {
	boolean dir;
	
    public Robot(int location) { 
    	super('B', "Robot", location); 
    	dir = true;
    }
    
    //override the interactionresult interface to check for only none
    
    @Override 
    public InteractionResult interact(Drawable[] board, int playerLocation) {
        return InteractionResult.NONE;
    }
    
    //override the moveable interface to change piece movement
    //move to the right until it can't, then move left
    
    @Override 
    public void move(Drawable[] board, int playerLocation) {
    	int next = getLocation();
    	boolean found = false;
    	while(!found) {
    		if(this.dir) {
    			for(int i = getLocation() + 1; i < GameEngine.BOARD_SIZE; i++) {
    				if(board[i] == null && !found && i != playerLocation) {
    					next = i;
    					found = true;
    				}
    			}
    		
    			if(!found) {
    				this.dir = false;
    			}

    		} else {
    			for(int i = getLocation() - 1; i >= 0; i--) {
    				if(board[i] == null && !found && i != playerLocation) {
    					next = i;
    					found = true;
    				}
    			}
    		
    			if(!found) {
    			this.dir = true;
    			}
    		}
    	}
        
        if (next < board.length) {
        
            board[getLocation()] = null;
            board[next] = this;
            setLocation(next);
            
        }
    }
}
