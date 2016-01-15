package dev.kgtltd.gfx.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display{

	private JFrame frame;
	
	private Canvas canvas;
	
	public Display(String title,int width,int height){
		
		frame = new JFrame(title);
		
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		//Set the JFrame to hold the focus
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
	
	//access JFrame for input
	public JFrame getFrame(){
		return frame;
	}
}
