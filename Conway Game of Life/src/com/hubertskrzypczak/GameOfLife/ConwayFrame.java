package com.hubertskrzypczak.GameOfLife;

import javax.swing.JFrame;

/**
 * 
 * @author Hubert Skrzypczak
 *
 */

public class ConwayFrame extends JFrame{
	
	
	public ConwayFrame() {
		super("Conway's Game of Life");
		add(new ConwayPanel());
		init();
	}
	
	public void init(){
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
