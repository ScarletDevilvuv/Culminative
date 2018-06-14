package com;

import java.awt.Image;
import java.awt.Toolkit;

//There are three statuses of tiles:
//b = bought
//g = greyed-out
//u = unseen
//s = seen (exclusive to Ocean)

public class Logic {

	private static ArrayLocation_To_Position_Translator change;
	private static Tile[][] gameBoard;
	private static MainTile camp;
	private static ResourceManager resources;
	private final static int BEGINNING_FOOD = 10;
	private final static int BEGINNING_MATERIAL = 10;
	private final static int BOARD_SIZE = 7;

	//add view portion
	private final static int CAMP_LOCATION = (BOARD_SIZE-1)/2;
	private static int turnCounter;

	public Logic (){
		gameBoard = new Tile [BOARD_SIZE][BOARD_SIZE];
		change = new ArrayLocation_To_Position_Translator ();
		camp = new MainTile (CAMP_LOCATION - 50, CAMP_LOCATION - 50, 'b');
		resources = new ResourceManager (BEGINNING_FOOD, BEGINNING_MATERIAL);
		gameBoard [CAMP_LOCATION][CAMP_LOCATION] = camp;
		turnCounter = 1;
		buyTile (camp);

		//This creates the board
		for (int i = 0; i < BOARD_SIZE; i++){
			for (int j = 0; j < BOARD_SIZE; j++){
				if (gameBoard [i][j] == null){
					Coordinate positionToAssignToTheTile = change.toPosition(i, j);

					//					if (i == 0 || i == BOARD_SIZE-1|| j == 0 || j == BOARD_SIZE-1){
					//						gameBoard [i][j] = new Ocean (positionToAssignToTheTile, 'u');
					//					}else{
					int randomNumber = (int)(Math.random() * (4) + 1);
					Tile currentTile = null;
					switch (randomNumber){
					case 1:
						currentTile = new Farm (positionToAssignToTheTile, 'u');
						break;
					case 2:
						currentTile = new Forest (positionToAssignToTheTile, 'u');
						break;
					case 3:
						currentTile = new Mine (positionToAssignToTheTile, 'u');
						break;
					default:
						currentTile = new River (positionToAssignToTheTile, 'u');
						break;
					}

					gameBoard [i][j] = currentTile;

					//}//Inner if statement

				}//if (gameBoard [i][j] == null)
			}//Inner Loop
		}//Outer Loop

		//This line makes the main tile or camp visible, which starts the chain of what is visible and what isn't 
		camp.visibilityCheck(gameBoard);




		for (int i = 0; i < BOARD_SIZE; i++){
			for (int j = 0; j < BOARD_SIZE; j++){
				System.out.print(gameBoard [i][j].location.getGameX() + "-" + gameBoard [i][j].location.getGameY() + " ");;
			}
			System.out.println();
		}

	}


	public static void buyTile (Tile tile){
		if (tile.getStatus() == 'g'){
			resources.setFood(resources.getFood()-3);
			resources.setBuildingMaterial(resources.getBuildingMaterial()-3);
			tile.makeVisible();
			tile.visibilityCheck(gameBoard);
		}
	}

	public static void loseTile (Tile tile){
		gameBoard[tile.getLocation().getArrayX()][tile.getLocation().getArrayY()].setStatus('g');
	}

	public static void endTurn (){
		for (int i = 0; i < BOARD_SIZE; i++){
			for (int j = 0; j < BOARD_SIZE; j++){
				if (gameBoard [i][j].getStatus() == 'b'){
					gameBoard [i][j].maintenance(resources);
					gameBoard [i][j].grantResources(resources);
					gameBoard [i][j].visibilityCheck(gameBoard);
				}

			}
		}
		if (isGameOver()){
			Frame.getCardLayout().show(Frame.getMainPanel(), "4");

		}else{
			camp.upgrade();
			turnCounter++;
		}
	}


	public static boolean isGameOver (){
		if (resources.getFood() < 0){
			return true;
		}
		if (resources.getBuildingMaterial() < 0){
			return true;
		}else {
			return false;
		}
	}

	public static Tile[][] getGameBoard() {
		return gameBoard;
	}

	//TODO Resets the game
	public static void reset() {

	}

	public static void setGameBoard(Tile[][] gameBoard) {
		Logic.gameBoard = gameBoard;
	}

	public static int getTurnCounter(){
		return turnCounter;
	}

	public static int getBoardSize (){
		return BOARD_SIZE;
	}


	public static ResourceManager getResources() {
		return resources;
	}


	public static void setResources(ResourceManager resources) {
		Logic.resources = resources;
	}





}
