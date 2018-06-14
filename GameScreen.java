package com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class GameScreen extends JPanel implements MouseListener{

	private final Image HUD = Toolkit.getDefaultToolkit().getImage("HUD.png");
	private final Image marker = Toolkit.getDefaultToolkit().getImage("marker.png");
	private int [] selectedTile = {325, 325};
	private final Font buttonFont = new Font ("Arial", Font.PLAIN, 20);
	private final Font buttonFont2 = new Font ("Arial", Font.PLAIN, 17);
	private JButton saveGameButton;
	private JButton upgradeButton;
	private JButton endTurnButton;
	private static Tile tileClickedOn;
	private final Font dayCounterFont = new Font ("Arial", Font.BOLD, 35);
	private final Font resourcesFont = new Font ("Arial", Font.PLAIN, 25);
	private final Font upgradeFont = new Font ("Arial", Font.PLAIN, 20);


	public GameScreen() {
		this.setLayout(null);

		//have to use repaint
		this.addMouseListener(null);
		addMouseListener(this);
		setVisible (true);
		saveGameButton = new JButton("Save Game");
		upgradeButton = new JButton("Buy or Upgrade");
		endTurnButton = new JButton("End Turn");

		saveGameButton.setBackground(Color.lightGray);
		upgradeButton.setBackground(Color.lightGray);
		endTurnButton.setBackground(Color.lightGray);

		saveGameButton.setFont(buttonFont);
		upgradeButton.setFont(buttonFont2);
		endTurnButton.setFont(buttonFont);

		saveGameButton.setBounds(735,500,150,50);
		this.add(saveGameButton);
		upgradeButton.setBounds(735,575,150,50);
		this.add(upgradeButton);
		endTurnButton.setBounds(735,650,150,50);
		this.add(endTurnButton);


		//Mouse listener for button hover effect
		saveGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				saveGameButton.setBackground(Color.BLACK);
				saveGameButton.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				saveGameButton.setBackground(Color.lightGray);
				saveGameButton.setForeground(Color.BLACK);
			}
		});

		upgradeButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				upgradeButton.setBackground(Color.BLACK);
				upgradeButton.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				upgradeButton.setBackground(Color.lightGray);
				upgradeButton.setForeground(Color.BLACK);
			}
		});

		endTurnButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				endTurnButton.setBackground(Color.BLACK);
				endTurnButton.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				endTurnButton.setBackground(Color.lightGray);
				endTurnButton.setForeground(Color.BLACK);
			}
		});


		//Action listeners for the buttons
		endTurnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logic.endTurn();
				repaint();
			}
		});

		upgradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tileClickedOn != null){
					if (tileClickedOn.getStatus() == 'g'){
						Logic.buyTile(tileClickedOn);
					}else if (tileClickedOn.getStatus() == 'b'){
						tileClickedOn.upgrade();
					}
				}
				repaint();
				System.out.println(Logic.getTurnCounter()); //TODO test case
			}
		});

	}


	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(HUD, 0, 0, this);
		for (int verticalCount = 0; verticalCount < 7; verticalCount ++) {
			for (int horizontalCount = 0; horizontalCount < 7; horizontalCount ++) {
				g.drawImage(Logic.getGameBoard()[verticalCount][horizontalCount].getImageFileName(), 26 + 100*verticalCount,25 + 100*horizontalCount, this);
			}
		}
		
		g.setColor(Color.white);
		
		g.setFont(resourcesFont);
		g.drawString(Integer.toString(Logic.getResources().getFood()), 750, 160);
		g.drawString(Integer.toString(Logic.getResources().getBuildingMaterial()), 750, 240);

		g.setFont(dayCounterFont);
		g.drawString(Integer.toString(Logic.getTurnCounter()), 830, 50);
		g.drawImage(marker, selectedTile[0], selectedTile[1], this);
		
		if (tileClickedOn != null){
			g.drawImage(tileClickedOn.getImageFileName(), 745, 294, this);
			g.setFont(upgradeFont);
			g.drawString("LV", 846, 315);
			g.drawString(Integer.toString(tileClickedOn.getUpgradeLevel()), 846, 390);
			g.drawString(Integer.toString(tileClickedOn.getFoodGranted()-tileClickedOn.getFoodMaintenance()), 795, 469);
			g.drawString(Integer.toString(tileClickedOn.getBuildingMaterialGranted()-tileClickedOn.getRepairMaintenance()), 795, 434);

		}
	}
	
	// Get the coordination of the tile clicked
	public void tileClicked (int mousePosX, int mousePosY) {
		int tempX = 0;
		int tempY = 0;
		int tempAlignedMousePosX = 0;
		int tempAlignedMousePosY = 0;
		// x coordinate
		if (mousePosX >= 25 && mousePosX <= 125) {
			tempAlignedMousePosX = 25;
			tempX = 0;
		}
		else if (mousePosX > 125 && mousePosX <= 225) {
			tempAlignedMousePosX = 125;
			tempX = 1;
		}
		else if (mousePosX > 225 && mousePosX <= 325) {
			tempAlignedMousePosX = 225;
			tempX = 2;
		}
		else if (mousePosX > 325 && mousePosX <= 425) {
			tempAlignedMousePosX = 325;
			tempX = 3;
		}
		else if (mousePosX > 425 && mousePosX <= 525) {
			tempAlignedMousePosX = 425;
			tempX = 4;
		}
		else if (mousePosX > 525 && mousePosX <= 625) {
			tempAlignedMousePosX = 525;
			tempX = 5;
		}
		else if (mousePosX > 625 && mousePosX <= 725) {
			tempAlignedMousePosX = 625;
			tempX = 6;
		}
		
		// y coordinate
		if (mousePosY >= 25 && mousePosY <= 125) {
			tempAlignedMousePosY = 25;
			tempY = 0;
		}
		else if (mousePosY > 125 && mousePosY <= 225) {
			tempAlignedMousePosY = 125;
			tempY = 1;
		}
		else if (mousePosY > 225 && mousePosY <= 325) {
			tempAlignedMousePosY = 225;
			tempY = 2;
		}
		else if (mousePosY > 325 && mousePosY <= 425) {
			tempAlignedMousePosY = 325;
			tempY = 3;
		}
		else if (mousePosY > 425 && mousePosY <= 525) {
			tempAlignedMousePosY = 425;
			tempY = 4;
		}
		else if (mousePosY > 525 && mousePosY <= 625) {
			tempAlignedMousePosY = 525;
			tempY = 5;
		}
		else if (mousePosY > 625 && mousePosY <= 725) {
			tempAlignedMousePosY = 625;
			tempY = 6;
		}
		
		selectedTile [0] = tempAlignedMousePosX;
		selectedTile [1] = tempAlignedMousePosY;
		
		repaint();
		
		tileClickedOn = Logic.getGameBoard() [tempX][tempY];
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int mousePosX = e.getX();
		int mousePosY = e.getY();
		if (mousePosX >= 25 && mousePosX <= 725 && mousePosY >= 25 && mousePosY <= 725)
			tileClicked (mousePosX, mousePosY);
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void endTurn (Tile [][] gameBoard, ResourceManager resources, int turnCounter){
		for (int i = 0; i < 7; i++){
			for (int j = 0; j < 7; j++){
				gameBoard [i][j].maintenance(resources);
				gameBoard [i][j].grantResources(resources);
			}
		}
		if (Logic.isGameOver()){

		}else{
			turnCounter++;
			repaint();
		}
	}

	public static Tile getTileClickedOn (){
		return tileClickedOn;
	}

}
