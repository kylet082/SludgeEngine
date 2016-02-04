package dev.kgtltd.entity.creature;

import dev.kgtltd.Handler;
import dev.kgtltd.entity.Entity;
import dev.kgtltd.tile.Tile;

public abstract class Creature extends Entity {
	
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_HEALTH = 10;
	//handels default size of entities
	public static final int DEFAULT_CREATURE_WIDTH = 100;
	public static final int DEFAULT_CREATURE_HEIGHT = 100;
	
	protected int health;
	protected float speed;
	
	protected float xMove,yMove;
	
	public Creature(Handler handler,float x, float y,int width, int height) {
		super(handler,x, y,width,height);
		
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		
		xMove = 0;
		yMove = 0;
	}
	
	public void move(){
		moveX();
		moveY();
		
	}
	
	public void moveX(){
		if(xMove > 0){//moving right
			
			int tempX = (int)(x+ xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			
			// check if a collision has occurred moveing right on the top and bottom right corners of the collision box
			if(!collisionWithTile(tempX,(int)(y+ bounds.y) / Tile.TILE_WIDTH) && 
					!collisionWithTile(tempX,(int)(y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
				
				x += xMove;
			}
			
		}else if(xMove < 0){//moving left
			int tempX = (int)(x+ xMove + bounds.x) / Tile.TILE_WIDTH;
			
			// check if a collision has occurred moving left on the top and bottom left corners of the collision box
			if(!collisionWithTile(tempX,(int)(y + bounds.y) / Tile.TILE_WIDTH) && 
					!collisionWithTile(tempX,(int)(y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
				
				x += xMove;
			}
		}
	
	}
	
	
	public void moveY(){
		if(yMove < 0 ){//moving up
			 int tempY = (int)(y + yMove + bounds.y) / Tile.TILE_HEIGHT;
			 
			// check if a collision has occurred moving up on the top and bottom right corners of the collision box
			 if(!collisionWithTile((int)(x + bounds.x ) / Tile.TILE_WIDTH , tempY) &&
					 !collisionWithTile((int)(x + bounds.x + bounds.width ) / Tile.TILE_WIDTH , tempY)){
				 
				 y += yMove;
			 }
			 
		}
		else if(yMove > 0){
		
			int tempY = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			// check if a collision has occurred moving down on the top and bottom right corners of the collision box
			if(!collisionWithTile((int)(x + bounds.x ) / Tile.TILE_WIDTH , tempY) &&
					 !collisionWithTile((int)(x + bounds.x + bounds.width ) / Tile.TILE_WIDTH , tempY)){
				 
				 y += yMove;
			 }
			
		}
		
		
	}
	
	protected boolean collisionWithTile(int x, int y){
		
		return handler.getWorld().getTile(x,y).isSolid();
	}
	
	//GETTERS AND SETTERS
	//movement getters and setters
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	//health settings
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	//player speed setting
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
