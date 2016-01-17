package dev.kgtltd.world;

import java.awt.Graphics;

import dev.kgtltd.Game;
import dev.kgtltd.tile.Tile;
import dev.kgtltd.utils.Utils;

public class World {
	
	private Game game;
	//width and height of grid-world
	private int width, height;
	//spawning position of the player
	private int spawnX, spawnY;
	//store the tile id's for world representation
	private int[][] worldTiles;
	
	
	public World(Game game,String path){
		this.game = game;
		loadWorld(path);
		
	}
	
	public void update(){}
	
	public void render(Graphics g){
		for(int y = 0;y< height;y++){
			for(int x = 0;x < width;x++){
				 getTile(x,y).render(g,(int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset() ),
						 (int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x,int y){
		//Retrieve the tile associated with tile id 
		//that has been store at location x, y in the world
		Tile t = Tile.tile[worldTiles[x][y]];
		if(t == null){
			return Tile.grassTile;
		}
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		
		//array to store the world file data - delimiter "space"
		String[] tokens = file.split("\\s+");
		
		//set world width and height
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		
		//set the players spawning position
		spawnX = Utils.parseInt(tokens[2]);
		spawnY= Utils.parseInt(tokens[3]);
		
		worldTiles= new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x< width;x++){
				worldTiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
		
	}
}
