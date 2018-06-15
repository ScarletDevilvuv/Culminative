package com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.*;

public class Menu extends JPanel{

	Image menuBackground = Toolkit.getDefaultToolkit().getImage("Title.png");
	
	private JButton newGame = new JButton("New Game");
	private JButton loadGame = new JButton("Load Game");
	private JButton instruction = new JButton("Instructions");
	private JButton exitGame = new JButton("Exit Game");
	private Font menuFont = new Font ("Arial", Font.PLAIN, 40);
	private BufferedReader fileReader;
	private File fileReadFrom;

	public Menu () { 
		this.setLayout(null);

		//Setting the background color
		newGame.setBackground(Color.lightGray);
		loadGame.setBackground(Color.lightGray);
		exitGame.setBackground(Color.lightGray);
		instruction.setBackground(Color.lightGray);
		
		//Setting the fonts of the JButtons
		newGame.setFont(menuFont);
		loadGame.setFont(menuFont);
		exitGame.setFont(menuFont);
		instruction.setFont(menuFont);
		
		//Setting the locations of the JButtons and adding it to the "Menu"
		newGame.setBounds(320, 310, 250, 70);
		this.add(newGame);
		loadGame.setBounds(320, 410, 250, 70);
		this.add(loadGame);
		exitGame.setBounds(320, 510, 250, 70);
		this.add(exitGame);
//		instruction.setBounds(320, 510, 250, 70);
//		this.add(instruction);
		
		//Mouse listener for button hover effect
		newGame.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        newGame.setBackground(Color.BLACK);
		        newGame.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
				newGame.setBackground(Color.lightGray);
				newGame.setForeground(Color.BLACK);
		    }
		});
		
		loadGame.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	loadGame.setBackground(Color.BLACK);
		    	loadGame.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	loadGame.setBackground(Color.lightGray);
		    	loadGame.setForeground(Color.BLACK);
		    }
		});
		
		exitGame.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	exitGame.setBackground(Color.BLACK);
		    	exitGame.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	exitGame.setBackground(Color.lightGray);
		    	exitGame.setForeground(Color.BLACK);
		    }
		});
		
//		instruction.addMouseListener(new java.awt.event.MouseAdapter() {
//		    public void mouseEntered(java.awt.event.MouseEvent evt) {
//		    	instruction.setBackground(Color.BLACK);
//		    	instruction.setForeground(Color.WHITE);
//		    }
//
//		    public void mouseExited(java.awt.event.MouseEvent evt) {
//		    	instruction.setBackground(Color.lightGray);
//		    	instruction.setForeground(Color.BLACK);
//		    }
//		});
				
		//Action listeners for the buttons
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO code reset every single variable
				Frame.getCardLayout().show(Frame.getMainPanel(), "2");//remember to reset everything first
				
			}
		});
		
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO code to read the variables from the file from the unfinished game
				Tile [][] newGameBoard = new Tile[Logic.getBoardSize()][Logic.getBoardSize()];
				Tile tileBeingAdded = null;
				StringBuilder nameOfTileBeingAdded = null;

				fileReadFrom = GameScreen.getFile();
				StringBuilder loadedGame = null;
				try {
					fileReader = new BufferedReader(new FileReader(fileReadFrom));
					loadedGame = new StringBuilder(fileReader.readLine());
					fileReader.close();
				}catch (IOException e){
					System.out.println("There has been an error in the program.");
					System.out.println("The the file might have been badly formatted.");
					System.out.println(e);
				}


				StringTokenizer tileTokenList = new StringTokenizer(loadedGame.toString(), "-");

				int newTurnCounter = Integer.parseInt(tileTokenList.nextToken().toString());
				int newFood = Integer.parseInt(tileTokenList.nextToken().toString());
				int newBuildingMaterial = Integer.parseInt(tileTokenList.nextToken().toString());

				for (int i = 0; i < Logic.getBoardSize(); i++){
					for (int j = 0; j < Logic.getBoardSize(); j++){
						Coordinate positionToAssignToTheTile = Logic.change.toPosition(i, j);

						nameOfTileBeingAdded = new StringBuilder(tileTokenList.nextToken().toString());
						char statusOfTileBeingAdded = tileTokenList.nextToken().charAt(0);

						switch (nameOfTileBeingAdded.toString()){
							case "River":
								tileBeingAdded = new River(positionToAssignToTheTile, statusOfTileBeingAdded);
								break;
							case "Farm":
								tileBeingAdded = new Farm(positionToAssignToTheTile, statusOfTileBeingAdded);
								break;
							case "Forest":
								tileBeingAdded = new Forest(positionToAssignToTheTile, statusOfTileBeingAdded);
								break;
							case "Mine":
								tileBeingAdded = new Mine(positionToAssignToTheTile, statusOfTileBeingAdded);
								break;
							default:
								tileBeingAdded = new MainTile(positionToAssignToTheTile, statusOfTileBeingAdded);
						}


						tileBeingAdded.setUpgradeLv(Integer.parseInt(tileTokenList.nextToken().toString()));
						tileBeingAdded.setFoodGranted(Integer.parseInt(tileTokenList.nextToken().toString()));
						tileBeingAdded.setBuildingMaterialGranted(Integer.parseInt(tileTokenList.nextToken().toString()));
						tileBeingAdded.setFoodMaintenance(Integer.parseInt(tileTokenList.nextToken().toString()));
						tileBeingAdded.setRepairMaintenance(Integer.parseInt(tileTokenList.nextToken().toString()));

						newGameBoard [i][j] = tileBeingAdded;
						Logic.setGameBoard(newGameBoard);
						tileBeingAdded.visibilityCheck(Logic.getGameBoard());

						if (tileBeingAdded.getStatus() == 'g'){
							tileBeingAdded.makeGrey();
						}else if (tileBeingAdded.getStatus() == 'b'){
							tileBeingAdded.makeVisible();
						}

						Main.frame.gameScreen().repaint();

					}
				}

				Logic.setTurnCounter(newTurnCounter);
				Logic.getResources().setFood(newFood);
				Logic.getResources().setBuildingMaterial(newBuildingMaterial);
				Frame.getCardLayout().show(Frame.getMainPanel(), "2");//read from file first
				
			}
		});
		
//		instruction.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				Frame.getCardLayout().show(Frame.getMainPanel(), "3");
//
//			}
//		});
		
		exitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
	}
	
	//Paint Component
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	       g.drawImage(menuBackground, 0, 0, this);
	}
	
	
}

