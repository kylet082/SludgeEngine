package dev.kgtltd.state;

import java.awt.Font;
import java.awt.Graphics;

import dev.kgtltd.Handler;



public class MenuState extends States {
	
	protected Handler handler;
	
	public MenuState(Handler handler){
		super(handler);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		Font f = new Font ("Dialog",Font.BOLD,14);
		g.setFont(f);
		g.drawString("Click To Play", 250, 250);
		
		System.out.println("Testing git");
		
	}
	
}
