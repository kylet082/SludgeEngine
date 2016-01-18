package dev.kgtltd.entity.creature;

import dev.kgtltd.Handler;
import dev.kgtltd.entity.Entity;

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
		x += xMove;
		y+= yMove;
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
