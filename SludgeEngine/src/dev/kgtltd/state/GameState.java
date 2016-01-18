package dev.kgtltd.state;
import java.awt.Graphics;

import dev.kgtltd.Handler;
import dev.kgtltd.entity.creature.player.Player;
import dev.kgtltd.world.World;


public class GameState extends States {

	private Player player;
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		
		//player start position
		world = new World(handler,"res/Worlds/level_1.txt");
		handler.setWorld(world);
		player = new Player(handler,10,10);
			
		
	}
	
	@Override
	public void update() {
		
		world.update();
		//update the player
		player.update();
		
	}

	@Override
	public void render(Graphics g) {
		

		world.render(g);
		//draw the player
		player.render(g);
		
	}

	
}
