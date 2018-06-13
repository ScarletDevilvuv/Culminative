package com;

import java.awt.Image;
import java.awt.Toolkit;

public class MainTile extends Tile {
	
	final int AMOUNT_OF_FOOD_NEEDED_TO_KEEP = 5;
	private Image ImageFileName;

	public MainTile(int x, int y, char status) {
		super(x, y, status);
		this.foodGranted = 0;
		this.buildingMaterialGranted = 0;
		this.foodMaintenance = 2;
		this.repairMaintenance = 2;
		this.imageFileName = Toolkit.getDefaultToolkit().getImage("Base.png");
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
