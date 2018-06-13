package com;

public class ArrayLocation_To_Position_Translator {
	public ArrayLocation_To_Position_Translator () {	
	}
	
	public Coordinate toPosition (int arrayX, int arrayY){
		return new Coordinate (arrayX - 50, arrayY - 50);
	}
	
	public int [] toArrayLocation (Coordinate location){
		int [] returnedArray = {location.getArrayX(), location.getArrayY()};
		return returnedArray;
	}
	
}
