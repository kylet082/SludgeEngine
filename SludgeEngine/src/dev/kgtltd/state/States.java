package dev.kgtltd.state;

import java.awt.Graphics;
import dev.kgtltd.Handler;

public abstract class States {
	
	protected Handler handler;
	
	//Game State manager
	private static States currentState = null;
	
	//settings current game state
	public static void setState(States state){
		currentState = state;
	}
	
	public static States getStates(){
		return currentState;
	}
	
	
	public States(Handler handler){
		this.handler = handler;
	}
	
	//classes
	public abstract void update();
	
	public abstract void render(Graphics g);
	
}
