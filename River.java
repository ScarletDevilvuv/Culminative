package com;

import java.awt.Image;
import java.awt.Toolkit;

public class River extends Tile {
	
	private final Image RIVERIMAGE = Toolkit.getDefaultToolkit().getImage("River.png");
	
	public River(int x, int y, char status) {
		super(x, y, status);
		this.foodGranted = (int)(Math.random() * (4) + 1);
		this.buildingMaterialGranted = (int)(Math.random() * (4) + 1);
		this.foodMaintenance = 1;
		this.repairMaintenance = 1;
		this.imageFileName = RIVERIMAGE;
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
		this.imageFileName = RIVERIMAGE;
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
}
