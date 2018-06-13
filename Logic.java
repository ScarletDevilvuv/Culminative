package com;

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
	private final static int BOARD_SIZE = 7; //change 101
	//add view portion
	private final static int CAMP_LOCATION = (BOARD_SIZE-1)/2;
	private static int turnCounter;

	public Logic (){
		gameBoard = new Tile [BOARD_SIZE][BOARD_SIZE];
		change = new ArrayLocation_To_Position_Translator ();
		camp = new MainTile (CAMP_LOCATION, CAMP_LOCATION, 'b');
		resources = new ResourceManager (BEGINNING_FOOD, BEGINNING_MATERIAL);
		gameBoard [CAMP_LOCATION][CAMP_LOCATION] = camp;
		turnCounter = 1;
		buyTile (camp);

		//This creates the board
		for (int i = 0; i < BOARD_SIZE; i++){
			for (int j = 0; j < BOARD_SIZE; j++){
				if (gameBoard [i][j] == null){
					Coordinate positionToAssignToTheTile = change.toPosition(i, j);

					if (i == 0 || i == BOARD_SIZE-1|| j == 0 || j == BOARD_SIZE-1){
						gameBoard [i][j] = new Ocean (positionToAssignToTheTile, 'u');
					}else{
						int randomNumber = (int)(Math.random() * (4) + 1);
						Tile currentTile = null;
						switch (randomNumber){
						case 1: currentTile = new Farm (positionToAssignToTheTile, 'u');
						break;
						case 2: currentTile = new Forest (positionToAssignToTheTile, 'u');
						break;
						case 3: currentTile = new Mine (positionToAssignToTheTile, 'u');
						break;
						case 4: currentTile = new River (positionToAssignToTheTile, 'u');
						break;
						}

						gameBoard [i][j] = currentTile;

					}//Inner if statement

				}//if (gameBoard [i][j] == null)
			}//Inner Loop
		}//Outer Loop

		//This line makes the main tile or camp visible, which starts the chain of what is visible and what isn't 
		camp.visibilityCheck(gameBoard);

		
		
		
		for (int i = 0; i < BOARD_SIZE; i++){
			for (int j = 0; j < BOARD_SIZE; j++){
				System.out.print(gameBoard [i][j] + " ");;
			}
			System.out.println();
		}

	}


	public void buyTile (Tile tile){
		Tile tileBought = gameBoard[tile.getLocation().getArrayX()][tile.getLocation().getArrayY()];
		tileBought.setStatus('b');
		tileBought.visibilityCheck(gameBoard);

	}

	public void loseTile (Tile tile){
		gameBoard[tile.getLocation().getArrayX()][tile.getLocation().getArrayY()].setStatus('g');
	}
	
	public void endTurn (){
		for (int i = 0; i < BOARD_SIZE; i++){
			for (int j = 0; j < BOARD_SIZE; j++){
				gameBoard [i][j].maintenance(resources);
				gameBoard [i][j].grantResources(resources);
			}
		}
		if (isGameOver()){
			
		}else{
			turnCounter++;
		}
	}


	public boolean isGameOver (){
		if (resources.getFood() <= 0){
			return true;
		}else if (resources.getBuildingMaterial() <= 0){
			return true;
		}else{
			return false;
		}
	}
	
	public static Tile[][] getGameBoard() {
		return gameBoard;
	}



	public static void setGameBoard(Tile[][] gameBoard) {
		Logic.gameBoard = gameBoard;
	}


	

}