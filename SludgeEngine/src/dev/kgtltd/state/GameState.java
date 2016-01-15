package dev.kgtltd.state;
import java.awt.Graphics;

import dev.kgtltd.Game;
import dev.kgtltd.entity.creature.player.Player;


public class GameState extends States {

	private Player player;
	
	public GameState(Game game){
		super(game);
		
		//player start position
		player = new Player(game,10,10);
	}
	
	@Override
	public void update() {
		
		//update the player
		player.update();
	}

	@Override
	public void render(Graphics g) {
		
		
		//draw the player
		player.render(g);
		
		
	}

	
	
	
}
