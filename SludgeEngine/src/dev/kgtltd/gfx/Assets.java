package dev.kgtltd.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage player,graniteTile, mustardTile,brownTile,stoneTile;
	
	private static final int width = 100, height = 100 ;
	public static void init(){
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("textures/character.png"));
		//SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("texturescharacter.png"));
		
		player  = sheet.crop(0,0, width, height);
		/*
		graniteTile= tiles.crop(0,100,width,height);
		mustardTile = tiles.crop(0,0 , width, height);
		brownTile = tiles.crop(100,0 , width, height);
		stoneTile = tiles.crop(250, 0, width, height);*/
	}
}