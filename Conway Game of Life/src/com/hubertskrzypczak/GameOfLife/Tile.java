package com.hubertskrzypczak.GameOfLife;

import java.awt.Rectangle;

/**
 * 
 * @author Hubert Skrzypczak
 *
 */

public class Tile extends Rectangle{
	
	public static final int length = 15;

	private boolean alive, soonAlive;
	
	/**
	 * 
	 * @param x first coordinate of tile
	 * @param y second coordinate of tile
	 */
	public Tile(int x, int y){
		this.x = x;
		this.y = y;
		this.width = length;
		this.height = length;
		this.alive = false;
		this.soonAlive = false;
	}
	
	public void setAlive(boolean isAlive) {
		this.alive = isAlive;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	
	public void setSoonAlive(boolean soonAlive) {
		this.soonAlive = soonAlive;
	}
	
	public boolean isSoonAlive() {
		return soonAlive;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getLength() {
		return length;
	}
}
