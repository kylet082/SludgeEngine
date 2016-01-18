package dev.kgtltd;

import dev.kgtltd.gfx.GameCamera;
import dev.kgtltd.input.KeyManager;
import dev.kgtltd.world.World;
/*Handler class allows for the creation of one handler class 
 to access objects*/


public class Handler {
	
	private Game game;
	private World world;
	
	//Constructor
	public Handler(Game game){
		this.game = game;
	}
	
	//GETTERS AND SETTERS
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
}
