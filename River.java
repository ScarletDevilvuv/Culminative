package com;

import java.awt.Image;
import java.awt.Toolkit;

public class River extends Tile {
	
	private final Image RIVERIMAGE = Toolkit.getDefaultToolkit().getImage("grey_river.png");
	private final Image GREYRIVERIMAGE = Toolkit.getDefaultToolkit().getImage("grey_river.png");

	public River(int x, int y, char status) {
		super(x, y, status);
		this.foodGranted = (int)(Math.random() * (4) + 1);
		this.buildingMaterialGranted = (int)(Math.random() * (4) + 1);
		this.foodMaintenance = 1;
		this.repairMaintenance = 1;
		this.imageFileName = BlackTile;
		//There are three statuses:
		//b = bought
		//g = greyed-out
		//u = unseen
		//s = seen (exclusive to Ocean)
		
	}
	
	public River(Coordinate c, char status) {
		super(c, status);
		this.foodGranted = (int)(Math.random() * (4) + 1);
		this.buildingMaterialGranted = (int)(Math.random() * (4) + 1);
		this.foodMaintenance = 1;
		this.repairMaintenance = 1;
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
	public Image getImageFileName() {
		return imageFileName;
	}

	@Override
	public void makeVisible() {
		this.setStatus('b');
		this.imageFileName = RIVERIMAGE;		

	}

	@Override
	public void makeGrey() {
		this.setStatus('g');
		this.imageFileName = GREYRIVERIMAGE;		
		
	}
}
