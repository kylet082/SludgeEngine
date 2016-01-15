package dev.kgtltd.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet){
		
		this.sheet = sheet;
	}
	
	//crop the sprite sheet to the segments needed
	public BufferedImage crop(int x, int y,int width,int height){
		//returns the segment of the sprite sheet
		return sheet.getSubimage(x,y,width,height);
	}
}
