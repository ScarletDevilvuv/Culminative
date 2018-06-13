package com;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GameScreen extends JPanel{

	private final Image HUD = Toolkit.getDefaultToolkit().getImage("HUD.png");

	public GameScreen() {
		//have to use repaint
		setVisible (true);
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(HUD, 0, 0, this);

		for (int verticalCount = 0; verticalCount < 7; verticalCount ++) {
			for (int horizontalCount = 0; horizontalCount < 7; horizontalCount ++) {
				g.drawImage(Logic.getGameBoard()[verticalCount][horizontalCount].getImageFileName(), 26 + 100*verticalCount,25 + 100*horizontalCount, this);
			}
		}

	}

}
