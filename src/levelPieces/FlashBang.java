/** 
 * One-use flashbang that pushes the player back from one square away. 
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class FlashBang extends GamePiece {
	
    private boolean spent;
    
    public FlashBang(int location) { 
    	super('F', "FlashBang", location); 
    }
    
    //override the interactionresult interface to check for repel or none
    
    @Override 
    public InteractionResult interact(Drawable[] board, int playerLocation) {
    	
        if (!spent && Math.abs(playerLocation - getLocation()) <= 1) {
        	
            spent = true;
            board[getLocation()] = null;
            return InteractionResult.REPEL;
            
        }
        return InteractionResult.NONE;
    }
}
