package dev.kgtltd;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import dev.kgtltd.entity.creature.player.Player;

public class Launcher {
	
		public static void main(String []args){
			
			//gets the native size of the screen 
			GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			int width = gd.getDisplayMode().getWidth();
			int height = gd.getDisplayMode().getHeight();
			
			Game game = new Game("Title",width ,height);
			
			game.start();
		}
}
