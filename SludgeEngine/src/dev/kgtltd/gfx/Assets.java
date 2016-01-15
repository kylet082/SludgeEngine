package dev.kgtltd.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int width = 100, height = 100;
	public static BufferedImage player,tileSheet;

	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("textures/character.png"));
		
		player = sheet.crop(0, 0, width, height);
		
	}
	
	
}
