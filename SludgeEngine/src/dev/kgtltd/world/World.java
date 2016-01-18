package dev.kgtltd.world;

import java.awt.Graphics;

import dev.kgtltd.Handler;
import dev.kgtltd.tile.Tile;
import dev.kgtltd.utils.Utils;

public class World {
	
	private Handler handler;
	//width and height of grid-world
	private int width, height;
	//spawning position of the player
	private int spawnX, spawnY;
	//store the tile id's for world representation
	private int[][] worldTiles;
	
	
	public World(Handler handler,String path){
		this.handler = handler;
		loadWorld(path);
		
	}
	
	public void update(){}
	
	public void render(Graphics g){
		
		//add  or subtract 1 to see the affects of rendering tile optimization 
		//render Tiles from the point of the Offset of the screen
		int xStart = (int) Math.max(0,handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int)Math.min(width,(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH +1);
		int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart;y< yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				 getTile(x,y).render(g,(int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset() ),
						 (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		
		//renders every tile in the world
		/*
		for(int y = 0;y< height;y++){
			for(int x = 0;x < width;x++){
				 getTile(x,y).render(g,(int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset() ),
						 (int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
			}
		}*/
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
