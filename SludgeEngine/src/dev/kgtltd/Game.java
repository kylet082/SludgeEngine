package dev.kgtltd;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.kgtltd.entity.creature.player.Player;
import dev.kgtltd.gfx.Assets;
import dev.kgtltd.gfx.display.Display;
import dev.kgtltd.input.KeyManager;
import dev.kgtltd.state.GameState;
import dev.kgtltd.state.States;

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
	
	private States gameState;
	
	//Input
	private KeyManager keyManager;

	//game constructor
	public Game(String title,int width,int height){
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
		
	}
	//the initializing component
	private void init(){
		display = new Display(title,width,height);
		//add Key input manager to the JFrame
		display.getFrame().addKeyListener(keyManager);
		
		//create all the objects in the game
		Assets.init();
		
		//create a new game state & set it
		gameState = new GameState(this);
		States.setState(gameState);
	}
	
	@Override
	public void run() {
		
		
		int fps = 60;
		double  timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int ticks = 0;
		

		//initialize the display and the graphics assets
		init();
		
		
		//Game loop
		while(isRunning){
		
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			//update and render every 1 second
			if(delta >= 1){
				
				update();
				render();
				
				ticks++;
				delta--;
			}
			
			//Every second show the fps count
			if(timer >= 1000000000){
				System.out.println("ticks and frames : " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
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
		
		g.drawImage(Assets.player, 10, 10,null);
		//end drawing
		bs.show();
		g.dispose();
	}

	public void update(){
		
		keyManager.update();
		
		if(States.getStates() != null){
			States.getStates().update();
		}
	}
	
	
}
