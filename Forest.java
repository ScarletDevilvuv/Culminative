package com;

import java.awt.Image;
import java.awt.Toolkit;

public class Forest extends Tile {
	
	private final Image FORESTIMAGE = Toolkit.getDefaultToolkit().getImage("forest.png");
	
	public Forest(int x, int y, char status) {
		super(x, y, status);
		this.foodGranted = 0;
		this.buildingMaterialGranted = 2;
		this.foodMaintenance = 1;
		this.repairMaintenance = 0;
		this.imageFileName = FORESTIMAGE;
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
		this.imageFileName = FORESTIMAGE;
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
		// TODO Auto-generated method stub
		
	}
}
