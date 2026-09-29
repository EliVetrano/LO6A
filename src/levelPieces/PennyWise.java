/** 
 * Moves randomly one or two squares, regardless of the player's location. 
 */

package levelPieces;

import java.util.ArrayList;
import java.util.Random;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class PennyWise extends GamePiece implements Moveable {
	
    private final Random random = new Random();
    
    public PennyWise(int location) { 
    	super('Y', "PennyWise", location); 
    }
    
    @Override 
    public InteractionResult interact(Drawable[] board, int playerLocation) {
    	
        boolean jumped = playerJumped(playerLocation);
        
    	if(!jumped && Math.abs(playerLocation - getLocation()) <= 1) {
    		return InteractionResult.HIT;
    	} else {
    		return InteractionResult.NONE;
    	}
    }
    
    @Override 
    public void move(Drawable[] board, int playerLocation) {
    	
        ArrayList<Integer> choices = new ArrayList<Integer>();
        
        for (int distance = 1; distance <= 2; distance++) {
            int left = getLocation() - distance;
            int right = getLocation() + distance;
            
            if (left >= 0 && board[left] == null) {
            	choices.add(left);
            }
            if (right < board.length && board[right] == null) {
            	choices.add(right);
            }
        }
        
        if (choices.isEmpty()) {
        	return;
        }
        
        int next = choices.get(random.nextInt(choices.size()));
        board[getLocation()] = null;
        board[next] = this;
        setLocation(next);
    }
}