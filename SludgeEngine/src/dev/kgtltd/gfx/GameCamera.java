package dev.kgtltd.gfx;

import dev.kgtltd.Game;
import dev.kgtltd.entity.Entity;

public class GameCamera {
	
	private float xOffset,yOffset;
	private Game game;
	
	//holds the camera position 
	public GameCamera(Game game,float xOffset,float yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.game = game;
	}
	
	//holds the cameras movement
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
	}
	
	//center the camera on the game entity/ player
	public void centerOnEntity(Entity e){
		
		xOffset = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
	}

	
	//GETTERS AND SETTERS for camera position
	public float getxOffset() {
		return xOffset;
	}
	
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
