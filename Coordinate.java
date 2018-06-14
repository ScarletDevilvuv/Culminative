package com;

public class Coordinate {
	private int arrayX;
	private int arrayY;
	
	public Coordinate (int x, int y) {
		this.arrayX = x;
		this.arrayY = y;
	}
	
	public Coordinate (Coordinate c) {
		this.arrayX = c.getGameX();
		this.arrayY = c.getGameY();
	}

	public int getArrayX () {
		return arrayX;
	}
	
	public int getArrayY () {
		return arrayY;
	}
	
	public int getGameX () {
		return this.arrayX + 50;
	}
	
	public int getGameY () {
		return arrayY + 50;
	}
	
	
	public void setX (int x) {
		this.arrayX = x;
	}
	
	public void setY (int y) {
		this.arrayY = y;
	}
	
	public static Coordinate above (Coordinate center) {
		return new Coordinate (center.getArrayX(), center.getArrayY()+1);
	}
	
	public static Coordinate below (Coordinate center) {
		return new Coordinate (center.getArrayX(), center.getArrayY()-1);
	}
	
	public static Coordinate left (Coordinate center) {
		return new Coordinate (center.getArrayX()-1, center.getArrayY());
	}
	
	public static Coordinate right (Coordinate center) {
		return new Coordinate (center.getArrayX()+1, center.getArrayY());
	}
}
