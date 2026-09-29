/** 
 * A coin that awards one point and disappears when collected. 
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Coin extends GamePiece {
	
    private boolean collected;
    
    public Coin(int location) { 
    	super('C', "Coin", location); 
    }
    
    @Override public InteractionResult interact(Drawable[] board, int playerLocation) {
        if (!collected && playerLocation == getLocation()) {
        	
            collected = true;
            board[getLocation()] = null;
            
            return InteractionResult.GET_POINT;
        }
        return InteractionResult.NONE;
    }
}