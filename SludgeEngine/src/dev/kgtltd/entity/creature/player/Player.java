package dev.kgtltd.entity.creature.player;

import java.awt.Graphics;

import dev.kgtltd.Game;
import dev.kgtltd.entity.creature.Creature;
import dev.kgtltd.gfx.Assets;

public class Player extends Creature{
	
	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x,y,Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
		this.game = game;
	}
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up){
			yMove = -speed;
		}
		if(game.getKeyManager().down){
			yMove = speed;
		}
		if(game.getKeyManager().left){
			xMove = -speed;
		}
		if(game.getKeyManager().right){
			xMove = speed;
		}
	}
	
	@Override
	public void update(){
	
		getInput();
		move();
	}
	
	@Override
	public void render(Graphics g){
		g.drawImage(Assets.player,(int)x,(int)y,width,height,null);
	}


}
