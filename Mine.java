package com;

import java.awt.Image;
import java.awt.Toolkit;

public class Mine extends Tile {
	
	private final Image MINEIMAGE = Toolkit.getDefaultToolkit().getImage("cave.png");
	private final Image GREYMINEIMAGE = Toolkit.getDefaultToolkit().getImage("grey_cave.png");

	public Mine(int x, int y, char status) {
		super(x, y, status);
		this.foodGranted = 0;
		this.buildingMaterialGranted = 3;
		this.foodMaintenance = 2;
		this.repairMaintenance = 0;
		this.imageFileName = BlackTile;
		//There are three statuses:
		//b = bought
		//g = greyed-out
		//u = unseen
		//s = seen (exclusive to Ocean)
		
	}
	
	public Mine(Coordinate c, char status) {
		super(c, status);
		this.foodGranted = 0;
		this.buildingMaterialGranted = 3;
		this.foodMaintenance = 2;
		this.repairMaintenance = 0;
		this.imageFileName = BlackTile;
		//There are three statuses:
		//b = bought
		//g = greyed-out
		//u = unseen
		//s = seen (exclusive to Ocean)
		
	}

	@Override
	public Coordinate getLocation() {
		return super.location;
	}

	@Override
	public void draw() {
		
		
	}

	@Override
	public void makeVisible() {
		this.setStatus('b');
		this.imageFileName = MINEIMAGE;		
		
	}

	@Override
	public void makeGrey() {
		this.setStatus('g');
		this.imageFileName = GREYMINEIMAGE;			
	}
	
}
