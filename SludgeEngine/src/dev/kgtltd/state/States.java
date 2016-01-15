package dev.kgtltd.state;

import java.awt.Graphics;

import dev.kgtltd.Game;

public abstract class States {
	
	protected Game game;
	
	//Game State manager
	private static States currentState = null;
	
	//settings current game state
	public static void setState(States state){
		currentState = state;
	}
	
	public static States getStates(){
		return currentState;
	}
	
	
	public States(Game game){
		this.game = game;
	}
	
	//classes
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}
