package com;

import java.awt.Image;
import java.awt.Toolkit;

public class Ocean extends Tile {
	
	private final Image OCEANIMAGE = Toolkit.getDefaultToolkit().getImage("ocean.png");
	private final Image GREYOCEANIMAGE = Toolkit.getDefaultToolkit().getImage("grey_ocean.png");

	public Ocean (int x, int y, char status) {
		super(x, y, status);
		this.foodGranted = 0;
		this.buildingMaterialGranted = 0;
		this.foodMaintenance = 0;
		this.repairMaintenance = 0;
		this.imageFileName = GREYOCEANIMAGE;
		//There are three statuses:
		//b = bought
		//g = greyed-out
		//u = unseen
		//s = seen (exclusive to Ocean)
		
	}
	
	public Ocean (Coordinate c, char status) {
		super(c, status);
		this.foodGranted = 0;
		this.buildingMaterialGranted = 0;
		this.foodMaintenance = 0;
		this.repairMaintenance = 0;
		this.imageFileName = GREYOCEANIMAGE;
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
		this.setStatus('s');
		this.imageFileName = OCEANIMAGE;		
	}

	@Override
	public void makeGrey() {
		// TODO Auto-generated method stub
		
	}
	
}
