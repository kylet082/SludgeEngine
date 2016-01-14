package dev.kgtltd;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Launcher {
	
	public static void main(String[] args){
		
		//Retrieve the Systems native screen size 
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
		//new game started
		Game game = new Game("GameTitle",width,height);
		game.start();
	}
	
	
}
