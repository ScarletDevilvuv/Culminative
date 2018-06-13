package com;

public class ResourceManager {
	private int food;
	private int buildingMaterial;
	private int initialFood;
	private int initialBuildingMaterial;
	
	public ResourceManager (int food, int buildingMaterial){
		
		initialFood = food;
		initialBuildingMaterial = buildingMaterial;
		
		this.food = food;
		this.buildingMaterial = buildingMaterial;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getBuildingMaterial() {
		return buildingMaterial;
	}

	public void setBuildingMaterial(int buildingMaterial) {
		this.buildingMaterial = buildingMaterial;
	}
	
	

}
