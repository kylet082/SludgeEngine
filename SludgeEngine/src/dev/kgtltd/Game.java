package dev.kgtltd;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.kgtltd.gfx.ImageLoader;
import dev.kgtltd.gfx.display.Display;

public class Game implements Runnable {

	//Variables for the display obj
	private Display display;
	public String title = "title";
	public int width,height;
	
	private Thread thread;
	private boolean isRunning = false;
	
	//handle pixel projections
	private BufferStrategy bs;
	private Graphics g;
	

	
	public Game(String title,int width,int height){
		this.width = width;
		this.height = height;
		this.title = title;
				
		
	}
	//the initializing component
	private void init(){
		display = new Display(title,width,height);
		
		
	}
	
	@Override
	public void run() {
		
		init();
		
		while(isRunning){
			
			update();
			render();
			
		}
		
		stop();
		
	}
	
	//working directly with the thread
	public synchronized  void start(){
		
		if(isRunning)
			return;
		
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	//stop the thread
	public synchronized void stop(){
		if(!isRunning)
			return;
		
		isRunning = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void render(){
		//buffer strategy object settings to 3 buffers
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		//use graphics object to draw the buffer strategy
		g = bs.getDrawGraphics();
		//clear the screen
		g.clearRect(0,0,width,height);
		
		//draw here
	
		//end drawing
		bs.show();
		g.dispose();
	}

	public void update(){
		
	}
}
