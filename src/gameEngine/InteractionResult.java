package gameEngine;

/**
 * Interacting with a game piece must yield one of these results.
 * 
 * @author Mark Baldwin
 * @author Cyndi Rader
 * 
 */
//added the REPEL action
public enum InteractionResult {
	HIT, KILL, ADVANCE, GET_POINT, REPEL, NONE;
}
