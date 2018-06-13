package com;

import java.awt.Image;
import java.awt.Toolkit;

public class Forest extends Tile {
	
	private final Image FORESTIMAGE = Toolkit.getDefaultToolkit().getImage("forest.png");
	private final Image GREYFORESTIMAGE = Toolkit.getDefaultToolkit().getImage("grey_forest.png");

	public Forest(int x, int y, char status) {
		super(x, y, status);
		this.foodGranted = 0;
		this.buildingMaterialGranted = 2;
		this.foodMaintenance = 1;
		this.repairMaintenance = 0;
		this.imageFileName = BlackTile;
		//There are three statuses:
		//b = bought
		//g = greyed-out
		//u = unseen
		//s = seen (exclusive to Ocean)
		
	}
	
	public Forest(Coordinate c, char status) {
		super(c, status);
		this.foodGranted = 0;
		this.buildingMaterialGranted = 2;
		this.foodMaintenance = 1;
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
		this.imageFileName = FORESTIMAGE;		
	}

	@Override
	public void makeGrey() {
		this.setStatus('g');
		this.imageFileName = GREYFORESTIMAGE;		
	}
}
