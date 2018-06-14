package com;

import java.awt.Image;
import java.awt.Toolkit;

public class Farm extends Tile{
	
	private final Image FARMIMAGE = Toolkit.getDefaultToolkit().getImage("farm.png");
	private final Image GREYFARMIMAGE = Toolkit.getDefaultToolkit().getImage("grey_farm.png");

	public Farm(int x, int y, char status) {
		super(x, y, status);
		this.foodGranted = 3;
		this.buildingMaterialGranted = 0;
		this.foodMaintenance = 0;
		this.repairMaintenance = 1;
		this.imageFileName = BlackTile;
		//There are three statuses:
		//b = bought
		//g = greyed-out
		//u = unseen
		//s = seen (exclusive to Ocean)
		
	}
	
	public Farm(Coordinate c, char status) {
		super(c, status);
		this.foodGranted = 3;
		this.buildingMaterialGranted = 0;
		this.foodMaintenance = 0;
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

	@Override
	public void makeVisible() {
		this.setStatus('b');
		this.imageFileName = FARMIMAGE;
		
	}

	@Override
	public void makeGrey() {
		this.setStatus('g');
		this.imageFileName = GREYFARMIMAGE;			
	}
	

}
