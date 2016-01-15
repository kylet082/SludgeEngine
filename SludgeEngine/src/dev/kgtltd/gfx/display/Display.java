package dev.kgtltd.gfx.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display{

	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height){
		
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	public void createDisplay(){
		
		//holds the Canvas
		frame = new JFrame(title);
		
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//where all the graphics are projected to
		canvas = new Canvas();
		Dimension d = new Dimension(width,height);
		
		canvas.setPreferredSize(d);
		canvas.setMaximumSize(d);
		canvas.setMinimumSize(d);
		//make sure the keymanager will work by unfocusing the canvas andfocusing on the JFrame
		canvas.setFocusable(false);
		
		//add canvas to JFrame
		frame.add(canvas);
		frame.pack();
		
	}
	
	public Canvas getCanvas(){
		return canvas;
		
	}
	
	public JFrame getFrame(){
		return frame;
	}
}

