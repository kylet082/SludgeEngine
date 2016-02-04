package dev.kgtltd.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage player,grass,dirt,stone,stoneTile,GrsStnEdge1,GrsStnEdge2,GrsStnEdge3,GrsStnEdge4,GrsStnEdge5,GrsStnEdge6
								,GrsStnEdge7,GrsStnEdge8;
	
	private static final int width = 100, height = 100 ;
	public static void init(){
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("textures/character.png"));
		SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("textures/OrigTile1.jpg"));
		
		player  = sheet.crop(0,0, width, height);
		
		grass = tiles.crop(0,0,width/2 -1 ,height/2-1);
		dirt = tiles.crop(100,0,width/2 ,height/2);
		stone = tiles.crop(200, 0, width / 2, height / 2 );
		
		//Grass and stone corner tiles 
		GrsStnEdge1 = tiles.crop(250, 0, width / 2, height / 2);
		GrsStnEdge2 = tiles.crop(300, 0, width / 2, height / 2);
		GrsStnEdge3 = tiles.crop(350, 0, width / 2, height / 2);
		GrsStnEdge4 = tiles.crop(400, 0, width / 2, height / 2);
		GrsStnEdge5 = tiles.crop(450, 0, width / 2, height / 2);
		GrsStnEdge6 = tiles.crop(350, 50, width / 2, height / 2);
		GrsStnEdge7 = tiles.crop(400, 50, width / 2, height / 2);
		GrsStnEdge8 = tiles.crop(450, 50, width / 2, height / 2);
		
		
		/*
		mustardTile = tiles.crop(0,0 , width, height);
		brownTile = tiles.crop(100,0 , width, height);
		stoneTile = tiles.crop(250, 0, width, height);*/
	}
}