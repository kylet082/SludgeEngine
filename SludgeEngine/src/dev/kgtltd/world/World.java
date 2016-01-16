package dev.kgtltd.world;

import java.awt.Graphics;

import dev.kgtltd.tile.Tile;

public class World {
	
	//width and height of grid-world
	private int width, height;
	//store the tile id's for world representation
	private int[][] worldTiles;
	
	public World(String path){
		loadWorld(path);
	}
	
	public void update(){}
	
	public void render(Graphics g){
		for(int y = 0;y< height;y++){
			for(int x = 0;x < width;x++){
				 getTile(x,y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
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
		
		
	}
}
