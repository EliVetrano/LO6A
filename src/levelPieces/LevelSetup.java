/*
 * figured out how to use instanceof with GeekforGeeks https://www.geeksforgeeks.org/java/instanceof-keyword-in-java/ 
 */

package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.GameEngine;

public class LevelSetup{
	private int pLocation;
	private Drawable[] board;
	private ArrayList<Moveable> mPieces;
	private ArrayList<GamePiece> intPieces;
	
	public LevelSetup() {}
	
	public void createLevel(int num) {
		board = new Drawable[GameEngine.BOARD_SIZE];
		mPieces = new ArrayList<Moveable>();
		intPieces = new ArrayList<GamePiece>();
		if (num == 1) {
            addTo(new FlashBang(7));
            addTo(new Coin(4));
            addTo(new Coin(10));
            addTo(new PennyWise(12));
            addTo(new Robot(2));
            addTo(new Rainbow(16));
            addTo(new Medusa(20));
            board[0] = new Gate();
        } else if (num == 2) {
            addTo(new FlashBang(12));
            addTo(new Coin(7));
            addTo(new Coin(17));
            addTo(new PennyWise(14));
            addTo(new Robot(6));
            addTo(new Rainbow(18));
            addTo(new Medusa(20));
            board[0] = new Gate();
        }
	}
	
	private void addTo(GamePiece piece) {
        piece.setPrevLocation(pLocation);
		
		board[piece.getLocation()] = piece;
		intPieces.add(piece);
		
		if(piece instanceof Moveable) {
			mPieces.add((Moveable) piece);
		}
		
	}
	
	public Drawable[] getBoard() {
		return board;
	}
	
	public ArrayList<Moveable> getMovingPieces(){
		return mPieces;
	}
	
	public ArrayList<GamePiece> getInteractingPieces() {
		return intPieces;
	}
	
	public int getPlayerStartLoc(){
		return pLocation;
	}
	
}
