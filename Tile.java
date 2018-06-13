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
	protected Image BlackTile;
	
	public Tile (int x, int y, char status) {
		location = new Coordinate (x, y);
		this.status = status;
		BlackTile = BLACKIMAGE;
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
	public void visibilityCheck (Tile [][] gameBoard){


		Tile tileAbove = gameBoard [this.location.getArrayX()][this.location.getArrayY()+1];
		if (tileAbove != null){
			if (tileAbove.getClass() != (new Ocean(0,0,'u')).getClass()){
				if (tileAbove.getStatus() == 'u'){
					tileAbove.makeGrey();
				}

			}else{				
				if (tileAbove.getStatus() == 'u'){
					tileAbove.makeVisible();
				}
			}
		}

		Tile tileBelow = gameBoard [this.location.getArrayX()][this.location.getArrayY()-1];
		if (tileBelow != null){
			if (tileBelow.getClass() != (new Ocean(0,0,'u')).getClass()){
				if (tileBelow.getStatus() == 'u'){
					tileBelow.makeGrey();
				}

			}else{				
				if (tileBelow.getStatus() == 'u'){
					tileBelow.makeVisible();
				}
			}
		}

		Tile tileLeft  = gameBoard [this.location.getArrayX()-1][this.location.getArrayY()];
		if (tileLeft != null){
			if (tileLeft.getClass() != (new Ocean(0,0,'u')).getClass()){
				if (tileLeft.getStatus() == 'u'){
					tileLeft.makeGrey();
				}

			}else{
				if (tileLeft.getStatus() == 'u'){
					tileLeft.makeVisible();
				}
			}
		}

		Tile tileRight = gameBoard [this.location.getArrayX()+1][this.location.getArrayY()];
		if (tileRight != null){
			if (tileRight.getClass() != (new Ocean(0,0,'u')).getClass()){
				if (tileRight.getStatus() == 'u'){
					tileRight.makeGrey();
				}

			}else{
				if (tileRight.getStatus() == 'u'){
					tileRight.makeVisible();
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
			
			if (this.foodGranted != 0 && this.buildingMaterialGranted != 0){
				this.foodGranted += 1;
				this.buildingMaterialGranted += 1;
				this.foodMaintenance += 1;
				this.repairMaintenance += 1;
				
			}else if (this.foodGranted != 0){
				this.foodGranted += 2;
				this.foodMaintenance += 1;
				
			}else if(this.buildingMaterialGranted != 0){
				this.buildingMaterialGranted += 2;
				this.repairMaintenance += 1;
			}
			
			
		}

	public Image getImageFileName() {
		return imageFileName;
	}

	
	abstract public void makeVisible ();
	
	abstract public void makeGrey ();


}
