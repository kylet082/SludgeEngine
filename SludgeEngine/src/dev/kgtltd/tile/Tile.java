package dev.kgtltd.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tile = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	
	
	protected BufferedImage texture;
	protected  final int  id;
	
	public static final int TILE_WIDTH = 50,TILE_HEIGHT = 50;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tile[id] = this;
	}
	
	public void update(){
		
	}
	
	public void render(Graphics g,int x,int y){
		g.drawImage(texture, x, y,TILE_WIDTH,TILE_HEIGHT, null);
	}
	
	public int getId(){
		return id;
	}
	
	public boolean isSolid(){
		return false;
	}
}
