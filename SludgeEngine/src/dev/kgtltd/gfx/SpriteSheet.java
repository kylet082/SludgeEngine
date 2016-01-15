package dev.kgtltd.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
		
	}
	
	//crop method
	public BufferedImage crop(int x, int y, int width, int height){
		//returns a segment of the selected sprite sheet
		return sheet.getSubimage(x, y, width, height);
	}
}
