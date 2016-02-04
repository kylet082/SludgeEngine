package dev.kgtltd.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tile = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile stoneTile = new StoneTile(2);
	public static Tile GrsStnEdgeTile = new GrsStnEdgeTile(3);
	public static Tile GrsStnEdgeTile1 = new GrsStnEdgeTile1(4);
	public static Tile GrsStnEdgeTile2 = new GrsStnEdgeTile2(5);
	public static Tile GrsStnEdgeTile3 = new GrsStnEdgeTile3(6);
	public static Tile GrsStnEdgeTile4 = new GrsStnEdgeTile4(7);
	public static Tile GrsStnEdgeTile5 = new GrsStnEdgeTile5(8);
	public static Tile GrsStnEdgeTile6 = new GrsStnEdgeTile6(9);
	public static Tile GrsStnEdgeTile7 = new GrsStnEdgeTile7(1);
	
	
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
