/** 
 * A one-use trap that kills the player when they land on it. 
 * */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;


public class Trap extends GamePiece {
    private boolean sprung;

    public Trap(int location) { 
    	super('T', "Trap", location); 
    }
    
    //override the interactionresult interface to check for kill or none
    //will check if it has already been used

    @Override public InteractionResult interact(Drawable[] board, int playerLocation) {
        if (!sprung && playerLocation == getLocation()) {
            sprung = true;
            board[getLocation()] = null;
            return InteractionResult.KILL;
        }
        return InteractionResult.NONE;
    }
}