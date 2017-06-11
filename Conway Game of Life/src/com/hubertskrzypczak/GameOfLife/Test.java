package com.hubertskrzypczak.GameOfLife;

import java.awt.EventQueue;

/**
 * This program is implementation of
 * Game of Life by Conway
 * @author Hubert Skrzypczak
 *
 */

public class Test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ConwayFrame();
			}
		});
	}
}
