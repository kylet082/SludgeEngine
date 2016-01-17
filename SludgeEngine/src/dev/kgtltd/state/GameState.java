package dev.kgtltd.state;
import java.awt.Graphics;

import dev.kgtltd.Game;
import dev.kgtltd.entity.creature.player.Player;
import dev.kgtltd.world.World;


public class GameState extends States {

	private Player player;
	private World world;
	
	public GameState(Game game){
		super(game);
		
		//player start position
		player = new Player(game,10,10);
		world = new World(game,"res/Worlds/level_1.txt");	
		
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
