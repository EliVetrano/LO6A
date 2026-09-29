/** 
 * A gate drawn on the board without any interaction. 
 */

package levelPieces;

import gameEngine.Drawable;

public class Gate implements Drawable {
	
    @Override 
    public void draw() { 
    	System.out.print('G'); 
    }
}
