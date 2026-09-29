/** 
 * Randomly wanders one square and advances when the player lands on it. 
*/

package levelPieces;

import java.util.ArrayList;
import java.util.Random;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;


public class Rainbow extends GamePiece implements Moveable {
	
    private final Random random = new Random();
    
    public Rainbow(int location) { 
    	super('R', "Rainbow", location); 
    }

    @Override 
    public InteractionResult interact(Drawable[] board, int playerLocation) {
    	
    	if(playerLocation == getLocation()) {
    		return InteractionResult.ADVANCE;
    	} else {
    		return InteractionResult.NONE;
    	}
    }

    @Override 
    public void move(Drawable[] board, int playerLocation) {
    	
        ArrayList<Integer> choices = new ArrayList<Integer>();
        int left = getLocation() - 1;
        int right = getLocation() + 1;
        
        if (left >= 0 && board[left] == null) {
        	choices.add(left);
        }
        
        if (right < board.length && board[right] == null) {
        	choices.add(right);
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