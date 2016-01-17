package dev.kgtltd;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.kgtltd.gfx.Assets;
import dev.kgtltd.gfx.GameCamera;
import dev.kgtltd.gfx.display.Display;
import dev.kgtltd.input.KeyManager;
import dev.kgtltd.state.GameState;
import dev.kgtltd.state.States;

public class Game implements Runnable {

	
	private Display display;
	private int width,height;
	public String title;
	
	public boolean isRunning = false;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private States gameState;

	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	
	public Game(String title,int width,int height){
		
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
		
		
	}
	
	//initialize all the graphics of the game
	private void init(){
		display = new Display(title,width,height);
		//adds the key listener to the frame
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this,50,50);
	
		//setting the game state
		
		gameState = new GameState(this);
		States.setState(gameState);
		
	}
	

	
	//control the timing and update resolution
	private void update(){
		
		keyManager.update();
		
		if(States.getStates() != null){
			States.getStates().update();
		}
	}
	private void render(){
		
		//buffer strategy set to 3 panels
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		//clear the screen
		g.clearRect(0, 0, width, height);
		
		//draw here
		
		if(States.getStates() != null){
			States.getStates().render(g);
		}
		
		//end drawing
		bs.show();
		g.dispose();
	}
	
	
	//thread methods
	public void run(){
		
		//initialize the display and the graphics assets
		init();
		
		int fps = 60;
		double  timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int ticks = 0;
		
		
		
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
	
	public synchronized void start(){
		//if running don't initiate thread
		if(isRunning)
			return;
		
		isRunning = true;
		thread = new Thread(this);
		thread.start();
		
		
	}
	
	public synchronized void stop(){
		//if not running don't initiate 
		if(!isRunning)
			return;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//return the keymanager object for the player class
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	//return the camera current position
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	//return the width and the height of game window
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
}
