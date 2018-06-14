package com;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {

	private static JFrame frame;


	//MainMenu Buttons
	private final int buttonWidth = 900;
	private final int buttonHeight = 775;
	private static JPanel mainPanel = new JPanel();
	private static CardLayout cardLayout = new CardLayout();
	private Menu menu = new Menu();
	private GameScreen gameScreen = new GameScreen();
	private Instructions instructions = new Instructions();
	private GameOverMessage gameOverMessage = new GameOverMessage();
	private Logic logic;
	
	public Frame (){
		
		logic = new Logic();
		frame = new JFrame ();

		frame.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		frame.setMaximumSize(new Dimension(buttonWidth, buttonHeight));
		frame.setMinimumSize(new Dimension(buttonWidth, buttonHeight));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		mainPanel.setLayout(cardLayout);
		mainPanel.add(menu, "1");
		mainPanel.add(gameScreen, "2");
		mainPanel.add(instructions, "3");
		mainPanel.add(gameOverMessage, "4");
		
		cardLayout.show(mainPanel, "1");
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
	public static JPanel getMainPanel() {
		return mainPanel;
	}
	
	public static CardLayout getCardLayout() {
		return cardLayout;
	}
	
}