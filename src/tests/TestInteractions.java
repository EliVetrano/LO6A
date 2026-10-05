package tests;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.GameEngine;
import levelPieces.Trap;
import levelPieces.Coin;
import levelPieces.Robot;
import levelPieces.FlashBang;
import levelPieces.Rainbow;
import levelPieces.PennyWise;
import levelPieces.Medusa;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestInteractions {
    /*
     * Test that Trap kills player (interaction) only when player is on same location
    */
    @Test
    public void testTrap() {
    	Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
    	Trap spike = new Trap(13);
    	gameBoard[13] = spike;
    	// Kill points if player on same space
    	assertEquals(InteractionResult.KILL, spike.interact(gameBoard, 13));
    	// These loops ensure no interaction if not on same space
    	for (int i=0; i<13; i++)
    		assertEquals(InteractionResult.NONE, spike.interact(gameBoard, i));
    	for (int i=14; i<GameEngine.BOARD_SIZE; i++)		
    		assertEquals(InteractionResult.NONE, spike.interact(gameBoard, i));
    	}
    
    /*
     * Test that coin gives a point to the player and disappears 
    */
    @Test
    public void testCoin() {
    	Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
    	Coin point = new Coin(13);
    	gameBoard[13] = point;
    	// These loops ensure no interaction if not on same space
    	for (int i=0; i<13; i++)
    		assertEquals(InteractionResult.NONE, point.interact(gameBoard, i));
    	for (int i=14; i<GameEngine.BOARD_SIZE; i++)	
    		assertEquals(InteractionResult.NONE, point.interact(gameBoard, i));
    	// Give points if player on same space	
    	assertEquals(InteractionResult.GET_POINT, point.interact(gameBoard, 13));
    	// Check that coin disappears after giving a point
    	assertEquals(InteractionResult.NONE, point.interact(gameBoard, 13));
    	}
    
    @Test
    public void testRobot() {
    	Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
    	Robot bot = new Robot(13);
    	gameBoard[13] = bot;
    	//robot should never have an interaction with the player
    	for (int i=0; i<GameEngine.BOARD_SIZE; i++)	
    		assertEquals(InteractionResult.NONE, bot.interact(gameBoard, i));
    	}
    
    @Test
    public void testFlashBang() {
    	Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
    	FlashBang light = new FlashBang(13);
    	gameBoard[13] = light;
    	// These loops ensure no interaction if not close enough
    	for (int i=0; i<12; i++)
    		assertEquals(InteractionResult.NONE, light.interact(gameBoard, i));
    	for (int i=15; i<GameEngine.BOARD_SIZE; i++)	
    		assertEquals(InteractionResult.NONE, light.interact(gameBoard, i));
    	// Repels player if they get close	
    	assertEquals(InteractionResult.REPEL, light.interact(gameBoard, 13));
    	// Check that flashbang disappears after use
    	assertEquals(InteractionResult.NONE, light.interact(gameBoard, 13));
    	}
    
    @Test
    public void testRainbow() {
    	Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
    	Rainbow color = new Rainbow(13);
    	gameBoard[13] = color;
    	// Advances points if player on same space
    	assertEquals(InteractionResult.ADVANCE, color.interact(gameBoard, 13));
    	// These loops ensure no interaction if not on same space
    	for (int i=0; i<13; i++)
    		assertEquals(InteractionResult.NONE, color.interact(gameBoard, i));
    	for (int i=14; i<GameEngine.BOARD_SIZE; i++)		
    		assertEquals(InteractionResult.NONE, color.interact(gameBoard, i));
    	}
    
    @Test
    public void testPennyWise() {
    	Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
    	PennyWise clown = new PennyWise(13);
    	gameBoard[13] = clown;
    	// These loops ensure no interaction if not close enough
    	for (int i=0; i<12; i++)
    		assertEquals(InteractionResult.NONE, clown.interact(gameBoard, i));
    	for (int i=15; i<GameEngine.BOARD_SIZE; i++)	
    		assertEquals(InteractionResult.NONE, clown.interact(gameBoard, i));
    	// Hits player if they get close	
    	assertEquals(InteractionResult.HIT, clown.interact(gameBoard, 12));
    	assertEquals(InteractionResult.HIT, clown.interact(gameBoard, 13));
    	assertEquals(InteractionResult.HIT, clown.interact(gameBoard, 14));
    	}
    
    @Test
    public void testMedusa() {
    	Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
    	Medusa snake = new Medusa(13);
    	gameBoard[13] = snake;
    	// These loops ensure no interaction if not close enough
    	for (int i=0; i<12; i++)
    		assertEquals(InteractionResult.NONE, snake.interact(gameBoard, i));
    	for (int i=15; i<GameEngine.BOARD_SIZE; i++)	
    		assertEquals(InteractionResult.NONE, snake.interact(gameBoard, i));
    	// Kills player if they get close	
    	assertEquals(InteractionResult.KILL, snake.interact(gameBoard, 13));
    	assertEquals(InteractionResult.KILL, snake.interact(gameBoard, 12));
    	assertEquals(InteractionResult.KILL, snake.interact(gameBoard, 14));
    	}

}
