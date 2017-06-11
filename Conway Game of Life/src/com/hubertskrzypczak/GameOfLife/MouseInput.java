package com.hubertskrzypczak.GameOfLife;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class MouseInput implements MouseListener{

	private ConwayPanel conwayPanel;
	private LinkedList<Tile> tiles;
	
	public MouseInput(ConwayPanel conwayPanel, LinkedList<Tile> tiles) {
		this.conwayPanel = conwayPanel;
		this.tiles = tiles;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Point clickedPoint = e.getPoint();
		
		for(int i = 0; i < tiles.size(); i++) {
			Tile tempTile = tiles.get(i);
			if(tempTile.contains(clickedPoint)) {
				tempTile.setAlive(!tempTile.isAlive());
				conwayPanel.paintImmediately(tempTile);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
