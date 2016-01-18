package dev.kgtltd.entity;

import java.awt.Graphics;

import dev.kgtltd.Handler;

//component based entity system NB Read about it!!!

//This Code will be running via an entity based system. 
		

public abstract class Entity {
	
	//keeps track of the position
	protected float x,y;
	//size of the entity
	protected int width,height;
	
	protected Handler handler;
	
	public Entity(Handler handler,float x,float y,int width ,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void update();
	
	public abstract void render(Graphics g);

}