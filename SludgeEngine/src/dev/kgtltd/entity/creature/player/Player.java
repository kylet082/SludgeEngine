package dev.kgtltd.entity.creature.player;

import java.awt.Color;
import java.awt.Graphics;

import dev.kgtltd.Handler;
import dev.kgtltd.entity.creature.Creature;
import dev.kgtltd.gfx.Assets;

public class Player extends Creature{
	


	private Handler handler;
	
	public Player(Handler handler,float x, float y) {
		super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		this.handler = handler;
		
		//size of the collision box within the player sprite sub-image
		bounds.x = 44;
		bounds.y = 28;
		bounds.width = 24 ;
		bounds.height = 45;
	}


	@Override
	public void update() {
		
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
	}

	@Override
	public void render(Graphics g) {
		
		//case float variables x,y into ints
		g.drawImage(Assets.player, (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()),width,height,null);
		
		/*
		 *check position of t he collision box
		
		
		g.setColor(Color.red);
		g.drawRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);
		 */	
		
	}
	
	private void getInput(){
		
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up){
			yMove = -speed;
		}
		if(handler.getKeyManager().down){
			yMove = +speed;
		}
		if(handler.getKeyManager().left){
			xMove = -speed;
		}
		if(handler.getKeyManager().right){
			xMove = +speed;
		}	
	}
}
