package dev.kgtltd.entity.creature;

import dev.kgtltd.entity.Entity;

public abstract class Creature extends Entity {
	
	protected int health;
	protected float speed;
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_HEALTH = 10;
	public static final int DEFAULT_WIDTH = 100;
	public static final int DEFAULT_HEIGHT = 100;
	protected float xMove;
	protected float yMove;
	

	public Creature(float x, float y,int width, int height) {
		super(x, y,width,height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	public void move(){
		x += xMove;
		y += yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
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
	
}
