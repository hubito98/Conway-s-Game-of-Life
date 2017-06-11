package com.hubertskrzypczak.GameOfLife;

import java.util.LinkedList;

/**
 * 
 * @author Hubert Skrzypczak
 *
 */

public class Drawer {
	
	private LinkedList<Tile> tiles;
	private int tilesInRow;
	
	/**
	 * 
	 * @param tiles array that cointains all tiles
	 * @param tilesInRow number of tiles in one row
	 */
	public Drawer(LinkedList<Tile> tiles, int tilesInRow) {
		this.tiles = tiles;
		this.tilesInRow = tilesInRow;
	}
	
	
	/**
	 * 
	 * @param middle index of middle tile in structure
	 */
	public void drawFountain(int middle) {
		tiles.get(middle - (2 * tilesInRow) - 2).setAlive(true);
		tiles.get(middle - (2 * tilesInRow) - 1).setAlive(true);
		tiles.get(middle - (2 * tilesInRow) + 1).setAlive(true);
		tiles.get(middle - (2 * tilesInRow) + 2).setAlive(true);
		tiles.get(middle - 1).setAlive(true);
		tiles.get(middle + 1).setAlive(true);
		tiles.get(middle + tilesInRow - 4).setAlive(true);
		tiles.get(middle + tilesInRow - 3).setAlive(true);
		tiles.get(middle + tilesInRow - 1).setAlive(true);
		tiles.get(middle + tilesInRow + 1).setAlive(true);
		tiles.get(middle + tilesInRow + 3).setAlive(true);
		tiles.get(middle + tilesInRow + 4).setAlive(true);
		tiles.get(middle + 2 * tilesInRow - 2).setAlive(true);
		tiles.get(middle + 2 * tilesInRow - 3).setAlive(true);
		tiles.get(middle + 2 * tilesInRow - 4).setAlive(true);
		tiles.get(middle + 2 * tilesInRow + 2).setAlive(true);
		tiles.get(middle + 2 * tilesInRow + 3).setAlive(true);
		tiles.get(middle + 2 * tilesInRow + 4).setAlive(true);
	}
	
	/**
	 * 
	 * @param middle index of middle tile in structure
	 */
	public void drawPulsar(int middle) {
		tiles.get(middle - 6 * tilesInRow - 4).setAlive(true);
		tiles.get(middle - 6 * tilesInRow - 3).setAlive(true);
		tiles.get(middle - 6 * tilesInRow - 2).setAlive(true);
		tiles.get(middle - 6 * tilesInRow + 2).setAlive(true);
		tiles.get(middle - 6 * tilesInRow + 3).setAlive(true);
		tiles.get(middle - 6 * tilesInRow + 4).setAlive(true);
		
		tiles.get(middle - tilesInRow - 4).setAlive(true);
		tiles.get(middle - tilesInRow - 3).setAlive(true);
		tiles.get(middle - tilesInRow - 2).setAlive(true);
		tiles.get(middle - tilesInRow + 2).setAlive(true);
		tiles.get(middle - tilesInRow + 3).setAlive(true);
		tiles.get(middle - tilesInRow + 4).setAlive(true);
		
		tiles.get(middle + tilesInRow - 4).setAlive(true);
		tiles.get(middle + tilesInRow - 3).setAlive(true);
		tiles.get(middle + tilesInRow - 2).setAlive(true);
		tiles.get(middle + tilesInRow + 2).setAlive(true);
		tiles.get(middle + tilesInRow + 3).setAlive(true);
		tiles.get(middle + tilesInRow + 4).setAlive(true);
		
		tiles.get(middle + 6 * tilesInRow - 4).setAlive(true);
		tiles.get(middle + 6 * tilesInRow - 3).setAlive(true);
		tiles.get(middle + 6 * tilesInRow - 2).setAlive(true);
		tiles.get(middle + 6 * tilesInRow + 2).setAlive(true);
		tiles.get(middle + 6 * tilesInRow + 3).setAlive(true);
		tiles.get(middle + 6 * tilesInRow + 4).setAlive(true);
		
		tiles.get(middle - 2 * tilesInRow - 6).setAlive(true);
		tiles.get(middle - 3 * tilesInRow - 6).setAlive(true);
		tiles.get(middle - 4 * tilesInRow - 6).setAlive(true);
		
		tiles.get(middle - 2 * tilesInRow - 1).setAlive(true);
		tiles.get(middle - 3 * tilesInRow - 1).setAlive(true);
		tiles.get(middle - 4 * tilesInRow - 1).setAlive(true);
		
		tiles.get(middle - 2 * tilesInRow + 1).setAlive(true);
		tiles.get(middle - 3 * tilesInRow + 1).setAlive(true);
		tiles.get(middle - 4 * tilesInRow + 1).setAlive(true);
		
		tiles.get(middle - 2 * tilesInRow + 6).setAlive(true);
		tiles.get(middle - 3 * tilesInRow + 6).setAlive(true);
		tiles.get(middle - 4 * tilesInRow + 6).setAlive(true);
		
		tiles.get(middle + 2 * tilesInRow - 6).setAlive(true);
		tiles.get(middle + 3 * tilesInRow - 6).setAlive(true);
		tiles.get(middle + 4 * tilesInRow - 6).setAlive(true);
		
		tiles.get(middle + 2 * tilesInRow - 1).setAlive(true);
		tiles.get(middle + 3 * tilesInRow - 1).setAlive(true);
		tiles.get(middle + 4 * tilesInRow - 1).setAlive(true);
		
		tiles.get(middle + 2 * tilesInRow + 1).setAlive(true);
		tiles.get(middle + 3 * tilesInRow + 1).setAlive(true);
		tiles.get(middle + 4 * tilesInRow + 1).setAlive(true);
		
		tiles.get(middle + 2 * tilesInRow + 6).setAlive(true);
		tiles.get(middle + 3 * tilesInRow + 6).setAlive(true);
		tiles.get(middle + 4 * tilesInRow + 6).setAlive(true);
	}
	
	/**
	 * 
	 * @param middle index of middle tile in structure
	 */
	public void drawGospelGun(int middle) {
		tiles.get(middle - 4 * tilesInRow + 7).setAlive(true);
		
		tiles.get(middle - 3 * tilesInRow + 7).setAlive(true);
		tiles.get(middle - 3 * tilesInRow + 5).setAlive(true);
		
		tiles.get(middle - 2 * tilesInRow - 5).setAlive(true);
		tiles.get(middle - 2 * tilesInRow - 4).setAlive(true);
		tiles.get(middle - 2 * tilesInRow + 4).setAlive(true);
		tiles.get(middle - 2 * tilesInRow + 3).setAlive(true);
		tiles.get(middle - 2 * tilesInRow + 18).setAlive(true);
		tiles.get(middle - 2 * tilesInRow + 17).setAlive(true);
		
		tiles.get(middle - tilesInRow - 6).setAlive(true);
		tiles.get(middle - tilesInRow - 2).setAlive(true);
		tiles.get(middle - tilesInRow + 18).setAlive(true);
		tiles.get(middle - tilesInRow + 17).setAlive(true);
		tiles.get(middle - tilesInRow + 4).setAlive(true);
		tiles.get(middle - tilesInRow + 3).setAlive(true);
		
		tiles.get(middle - 17).setAlive(true);
		tiles.get(middle - 16).setAlive(true);
		tiles.get(middle - 7).setAlive(true);
		tiles.get(middle - 1).setAlive(true);		
		tiles.get(middle + 4).setAlive(true);
		tiles.get(middle + 3).setAlive(true);
		
		tiles.get(middle + tilesInRow - 17).setAlive(true);
		tiles.get(middle + tilesInRow - 16).setAlive(true);
		tiles.get(middle + tilesInRow - 7).setAlive(true);
		tiles.get(middle + tilesInRow - 3).setAlive(true);
		tiles.get(middle + tilesInRow - 1).setAlive(true);
		tiles.get(middle + tilesInRow).setAlive(true);
		tiles.get(middle + tilesInRow + 7).setAlive(true);
		tiles.get(middle + tilesInRow + 5).setAlive(true);
		
		tiles.get(middle + 2 * tilesInRow - 7).setAlive(true);
		tiles.get(middle + 2 * tilesInRow - 1).setAlive(true);
		tiles.get(middle + 2 * tilesInRow + 7).setAlive(true);
		
		tiles.get(middle + 3 * tilesInRow - 6).setAlive(true);
		tiles.get(middle + 3 * tilesInRow - 2).setAlive(true);
		
		tiles.get(middle + 4 * tilesInRow - 5).setAlive(true);
		tiles.get(middle + 4 * tilesInRow - 4).setAlive(true);

	}
	
}
