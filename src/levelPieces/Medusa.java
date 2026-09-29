/** 
 * Medusa kills anyone on her square or one square away. 
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Medusa extends GamePiece {
	
    public Medusa(int location) { 
    	super('M', "Medusa", location); 
    }
    
    //override the interactionresult interface to check for kill or none
    
    @Override 
    public InteractionResult interact(Drawable[] board, int playerLocation) {
    	
    	if(Math.abs(playerLocation - getLocation()) <= 1) {
    		return InteractionResult.KILL;
    	} else {
    		return InteractionResult.NONE;
    	}
    	
    }
}
