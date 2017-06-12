package com.hubertskrzypczak.GameOfLife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Hubert Skrzypczak
 *
 */

public class ConwayPanel extends JPanel{
	
	public static final int WIDTH = 1260, HEIGHT = 650;
	private LinkedList<Tile> tiles;
	private int tilesInRow, tilesInColumn, middleTileIndex;
	private Drawer drawer;
	private JComboBox<String> structureChooser;
	private JButton startStopButton, restartButton;
	private JSlider speedSlider;
	private int changesSpeed;
	private MouseInput mouseInput;
	private boolean running = false;
	
	public ConwayPanel() {
		init();
	}
	
	public void init() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		initTiles();
		drawer = new Drawer(tiles, tilesInRow);
		initComboBox();
		initButtons();
		initSlider();
		initMouseInput();
	}

	public void initTiles() {
		tiles = new LinkedList<>();
		
		for(int i = 0; i < (HEIGHT - 50) / Tile.length; i++) {
			for(int j = 0; j < WIDTH / Tile.length; j++) {
				tiles.add(new Tile(j * Tile.length, (i * Tile.length) + 50));
			}
		}
		
		tilesInRow = WIDTH / Tile.length;
		tilesInColumn = (HEIGHT - 50) / Tile.length;
		
		middleTileIndex = (tilesInColumn / 2 - 1) * tilesInRow + (tilesInRow / 2 - 1);
	}
	
	public void initComboBox() {
		String[] items = {"Select", "Fountain", "Triple Fountain", "Pulsar",
				"Gospel glider gun"};
		structureChooser = new JComboBox<>(items);
		structureChooser.setToolTipText("Select structure to draw on area");
		structureChooser.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String selectedItem = (String) structureChooser.getSelectedItem();
				
				switch (selectedItem) {
				case "Fountain":
					resetTiles();
					drawer.drawFountain(middleTileIndex);
					repaint();
					break;

				case "Triple Fountain":
					resetTiles();
					drawer.drawFountain(middleTileIndex + 2 * tilesInRow + tilesInRow / 3);
					drawer.drawFountain(middleTileIndex - 3 * tilesInRow);
					drawer.drawFountain(middleTileIndex + 2 * tilesInRow - tilesInRow / 3);
					repaint();
					break;
					
				case "Pulsar":
					resetTiles();
					drawer.drawPulsar(middleTileIndex);
					repaint();
					break;
					
				case "Gospel glider gun":
					resetTiles();
					drawer.drawGospelGun(middleTileIndex - (tilesInColumn / 4) * tilesInRow);
					repaint();
					break;
				}
			}
		});
		
		add(structureChooser);
	}
	
	
	
	public void initButtons() {
		startStopButton = new JButton("Start");
		startStopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startStopAction();
			}
		});
		
		restartButton = new JButton("Restart");
		restartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resetAction();
			}
		});
		
		add(startStopButton);
		add(restartButton);
	}
	
	public void startStopAction() {
		if(running) {
			running = false;
			startStopButton.setText("Start");
			speedSlider.setEnabled(true);
		} 
		else {
			running = true;
			startStopButton.setText("Stop");
			speedSlider.setEnabled(false);
		}
	}
	
	public void resetAction() {
		running = false;
		resetTiles();
		startStopButton.setText("Start");
		structureChooser.setSelectedIndex(0);
		speedSlider.setEnabled(true);
	}
	
	public void resetTiles() {
		for(int i = 0; i < tiles.size(); i++) {
			tiles.get(i).setSoonAlive(false);
			tiles.get(i).setAlive(false);
		}
		repaint();
	}
	
	public void initSlider() {
		speedSlider = new JSlider(SwingConstants.HORIZONTAL, 100, 900, 500);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		speedSlider.setMajorTickSpacing(400);
		speedSlider.setMinorTickSpacing(50);
		speedSlider.setSnapToTicks(true);
		speedSlider.setToolTipText("Select delay in milisecs between cycles (enabled when app stoped)");
		speedSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				changesSpeed = speedSlider.getValue();
			}
		});
		
		changesSpeed = speedSlider.getValue();
		
		add(speedSlider);
	}
	
	public void initMouseInput() {
		mouseInput = new MouseInput(this, tiles);
		addMouseListener(mouseInput);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(running) {
			changeTiles();
		}
		
		for(int i = 0; i < tiles.size(); i++) {
			Tile tempTile = tiles.get(i);
			if(tempTile.isAlive()){
				g2d.setColor(new Color(220, 50, 50));
			}else {
				g2d.setColor(new Color(15, 15, 15));
			}
			
			g2d.fill(tempTile);
			g2d.setColor(Color.GRAY);
			g2d.draw(tempTile);
		}
		
		
		if(running) {
			repaint();
		}
	}
	
public void changeTiles() {
		
		long currentTime = System.currentTimeMillis();
		
		for(int i = 0; i < tiles.size() && running; i++) {
			int counter = 0;
			Tile tempTile = tiles.get(i);
			//left top corner
			if( i == 0) {
				if(tiles.get(1).isAlive()) counter++;
				if(tiles.get(tilesInRow).isAlive()) counter++;
				if(tiles.get(tilesInRow + 1).isAlive()) counter++;
			}
			//right top corner
			else if( i == tilesInRow - 1) {
				if(tiles.get(i - 1).isAlive()) counter++;
				if(tiles.get(i + tilesInRow).isAlive()) counter++;
				if(tiles.get(i + tilesInRow - 1).isAlive()) counter++;
			}
			//top side
			else if( i < tilesInRow) {
				if(tiles.get(i - 1).isAlive()) counter++;
				if(tiles.get(i + 1).isAlive()) counter++;
				if(tiles.get(i + tilesInRow - 1).isAlive()) counter++;
				if(tiles.get(i + tilesInRow).isAlive()) counter++;
				if(tiles.get(i + tilesInRow + 1).isAlive()) counter++;				
			}
			//left bottom corner
			else if( i == tiles.size() - tilesInRow + 1) {
				if(tiles.get(i + 1).isAlive()) counter++;
				if(tiles.get(i - tilesInRow).isAlive()) counter++;
				if(tiles.get(i - tilesInRow + 1).isAlive()) counter++;
			}
			//right bottom corner
			else if( i == tiles.size()) {
				if(tiles.get(i - 1).isAlive()) counter++;
				if(tiles.get(i - tilesInRow).isAlive()) counter++;
				if(tiles.get(i - tilesInRow - 1).isAlive()) counter++;
			}
			//bottom side
			else if( i > tiles.size() - tilesInRow) {
				if(tiles.get(i - 1).isAlive()) counter++;
				if( i + 1 < tiles.size()){
					if(tiles.get(i + 1).isAlive()) counter++;
				}
				if(tiles.get(i - tilesInRow - 1).isAlive()) counter++;
				if(tiles.get(i - tilesInRow).isAlive()) counter++;
				if(tiles.get(i - tilesInRow + 1).isAlive()) counter++;				
			}
			//left side
			else if( i % tilesInRow == 0) {
				if(tiles.get(i + 1).isAlive()) counter++;
				if(tiles.get(i - tilesInRow).isAlive()) counter++;
				if(tiles.get(i - tilesInRow + 1).isAlive()) counter++;
				if(i + tilesInRow < tiles.size()){
				if(tiles.get(i + tilesInRow).isAlive()) counter++;
				if(tiles.get(i + tilesInRow + 1).isAlive()) counter++;
				}
			}
			//right side
			else if( (i % tilesInRow) + 1 == tilesInRow) {
				if(tiles.get(i - 1).isAlive()) counter++;
				if(tiles.get(i - tilesInRow).isAlive()) counter++;
				if(tiles.get(i - tilesInRow - 1).isAlive()) counter++;
				if(tiles.get(i + tilesInRow).isAlive()) counter++;
				if(tiles.get(i + tilesInRow - 1).isAlive()) counter++;
			}
			//inside
			else {
				if(tiles.get(i - 1).isAlive()) counter++;
				if(tiles.get(i + 1).isAlive()) counter++;
				if(tiles.get(i - tilesInRow).isAlive()) counter++;
				if(tiles.get(i - tilesInRow - 1).isAlive()) counter++;
				if(tiles.get(i - tilesInRow + 1).isAlive()) counter++;
				if(tiles.get(i + tilesInRow).isAlive()) counter++;
				if(tiles.get(i + tilesInRow - 1).isAlive()) counter++;
				if(tiles.get(i + tilesInRow + 1).isAlive()) counter++;
			}
			
			if(tempTile.isAlive()) {
				if(counter == 2 || counter == 3){
					tempTile.setSoonAlive(true);
				}else {
					tempTile.setSoonAlive(false);
				}
			} 
			//if tile isn't alive
			else {
				//if three neighbours alive then tile become alive
				if(counter == 3) {
					tempTile.setSoonAlive(true);
				}
			}
		}
		
		/*
		 * if game was paused during this function
		 * then return
		 */
		if(!running) {
			return;
		}
		
		for(int i = 0; i < tiles.size(); i++) {
			Tile tempTile = tiles.get(i);
			if(tempTile.isSoonAlive()) {
				tempTile.setAlive(true);
			}else {
				tempTile.setAlive(false);
			}
		}
		
		if(running) {
			try{
				Thread.sleep(changesSpeed - (System.currentTimeMillis() - currentTime));
			}catch(Exception e) {
				System.out.println("Obliczenia trwały dłużej niż " + changesSpeed + " milisekund");
			}
		}
	}
}
