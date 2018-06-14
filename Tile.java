package com;

import java.awt.Image;
import java.awt.Toolkit;


abstract class Tile {

	private final Image BLACKIMAGE = Toolkit.getDefaultToolkit().getImage("black.png");

	private char status; 
	protected Coordinate location;
	protected int foodGranted;
	protected int buildingMaterialGranted;
	protected int foodMaintenance;
	protected int repairMaintenance;
	protected Image imageFileName;
	protected int upgradeLv;
	protected Image ColourImageFileName;
	protected Image BlackTile = BLACKIMAGE;

	public Tile (int x, int y, char status) {
		location = new Coordinate (x, y);
		this.status = status;
		upgradeLv = 1;
		//There are three statuses:
		//b = bought
		//g = greyed-out
		//u = unseen
		//s = seen (exclusive to Ocean)
	}



	public Tile (Coordinate c, char status) {
		location = c;
		this.status = status;
		upgradeLv = 1;
		//There are three statuses:
		//b = bought
		//g = greyed-out
		//u = unseen
		//s = seen (exclusive to Ocean)
	}

	//This method checks if the tiles around this tile are "unseen", and if they can't
	//the method makes said tiles "greyed-out", unless they are ocean tiles, which will be "seen"
	public void visibilityCheck (Tile [][] gameBoard) {
		if (this.getStatus() == 'b'){
			if (this.location.getGameY() > 0){
				Tile tileAbove = gameBoard[this.location.getGameX()][this.location.getGameY() - 1];
				if (tileAbove != null) {
					if (tileAbove.getClass() != (new Ocean(0, 0, 'u')).getClass()) {
						if (tileAbove.getStatus() == 'u') {
							tileAbove.makeGrey();
						}

					} else {
						if (tileAbove.getStatus() == 'u') {
							tileAbove.makeVisible();
						}
					}
				}
			}

			if (this.location.getGameY() < 6){
				Tile tileBelow = gameBoard[this.location.getGameX()][this.location.getGameY() + 1];
				if (tileBelow != null) {
					if (tileBelow.getClass() != (new Ocean(0, 0, 'u')).getClass()) {
						if (tileBelow.getStatus() == 'u') {
							tileBelow.makeGrey();
						}

					} else {
						if (tileBelow.getStatus() == 'u') {
							tileBelow.makeVisible();
						}
					}
				}
			}

			if (this.location.getGameX() > 0){
				Tile tileLeft = gameBoard[this.location.getGameX() - 1][this.location.getGameY()];
				if (tileLeft != null) {
					if (tileLeft.getClass() != (new Ocean(0, 0, 'u')).getClass()) {
						if (tileLeft.getStatus() == 'u') {
							tileLeft.makeGrey();
						}

					} else {
						if (tileLeft.getStatus() == 'u') {
							tileLeft.makeVisible();
						}
					}
				}
			}


			if (this.location.getGameX() < 6){
				Tile tileRight = gameBoard[this.location.getGameX() + 1][this.location.getGameY()];
				if (tileRight != null) {
					if (tileRight.getClass() != (new Ocean(0, 0, 'u')).getClass()) {
						if (tileRight.getStatus() == 'u') {
							tileRight.makeGrey();
						}

					} else {
						if (tileRight.getStatus() == 'u') {
							tileRight.makeVisible();
						}
					}
				}
			}
		}


	}

	abstract public Coordinate getLocation ();

	abstract public void draw ();

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}

	public String toString (){
		return this.getClass().toString().charAt(10)+"";
	}

	//This gives the player the resources from the tile
	public void grantResources (ResourceManager resources){
		resources.setFood(resources.getFood() + foodGranted);
		resources.setBuildingMaterial(resources.getBuildingMaterial() +buildingMaterialGranted );
	}

	//This takes the maintenance away from the resources
	public void maintenance (ResourceManager resources){
		resources.setFood(resources.getFood() - foodMaintenance);
		resources.setBuildingMaterial(resources.getBuildingMaterial() - repairMaintenance);
	}

	//This method upgrades the tile by increasing the upgrade Level, the maintenance and resources granted
	public void upgrade (){
		upgradeLv++;

		if (this.foodGranted > 0 && this.buildingMaterialGranted > 0){
			int randomNumber = (int)(Math.random() + 1);
			switch (randomNumber){
			case 1:
				this.foodGranted += 1;
				this.repairMaintenance += 1;
				break;
			default:			
				this.foodMaintenance += 1;
				this.buildingMaterialGranted += 1;
				break;
			}

		}else if (this.foodGranted > 0){
			this.foodGranted += 2;
			this.foodMaintenance += 1;

		}else if(this.buildingMaterialGranted > 0){
			this.buildingMaterialGranted += 2;
			this.repairMaintenance += 1;
		}
	}

	public Image getImageFileName() {
		return imageFileName;
	}

	public int getUpgradeLevel (){
		return this.upgradeLv;
	}

	abstract public void makeVisible ();

	abstract public void makeGrey ();



	public int getFoodGranted() {
		return foodGranted;
	}



	public void setFoodGranted(int foodGranted) {
		this.foodGranted = foodGranted;
	}



	public int getBuildingMaterialGranted() {
		return buildingMaterialGranted;
	}



	public void setBuildingMaterialGranted(int buildingMaterialGranted) {
		this.buildingMaterialGranted = buildingMaterialGranted;
	}



	public int getFoodMaintenance() {
		return foodMaintenance;
	}



	public void setFoodMaintenance(int foodMaintenance) {
		this.foodMaintenance = foodMaintenance;
	}



	public int getRepairMaintenance() {
		return repairMaintenance;
	}



	public void setRepairMaintenance(int repairMaintenance) {
		this.repairMaintenance = repairMaintenance;
	}



}
