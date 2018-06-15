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
		this.foodMaintenance = 1;
		this.repairMaintenance = 1;
		this.imageFileName = Toolkit.getDefaultToolkit().getImage("Base.png");
		//There are three statuses:
		//b = bought
		//g = greyed-out
		//u = unseen
		//s = seen (exclusive to Ocean)
		
	}

	public MainTile (Coordinate c, char status) {
		super(c, status);
		this.foodGranted = 0;
		this.buildingMaterialGranted = 0;
		this.foodMaintenance = 1;
		this.repairMaintenance = 1;
		this.imageFileName = Toolkit.getDefaultToolkit().getImage("Base.png");;
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

	@Override
	public void makeVisible() {

	}

	@Override
	public void makeGrey() {

	}
	
	public void upgrade (){
		if (Logic.getTurnCounter() % 5 == 0){
			upgradeLv++;
			this.foodMaintenance += 1;
			this.repairMaintenance += 1;
		}

	}

}
