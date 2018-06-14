package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{

	Image menuBackground = Toolkit.getDefaultToolkit().getImage("Title.png");
	
	private JButton newGame = new JButton("New Game");
	private JButton loadGame = new JButton("Load Game");
	private JButton instruction = new JButton("Instructions");
	private JButton exitGame = new JButton("Exit Game");
	private Font menuFont = new Font ("Arial", Font.PLAIN, 40);

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
		exitGame.setBounds(320, 610, 250, 70);
		this.add(exitGame);
		instruction.setBounds(320, 510, 250, 70);
		this.add(instruction);
		
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
		
		instruction.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	instruction.setBackground(Color.BLACK);
		    	instruction.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	instruction.setBackground(Color.lightGray);
		    	instruction.setForeground(Color.BLACK);
		    }
		});
				
		//Action listeners for the buttons
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO code reset every single variable
				
				Frame.getCardLayout().show(Frame.getMainPanel(), "2");//remember to reset everything first
				
			}
		});
		
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO code to read the variables from the file from the ubnfinished game
				
				Frame.getCardLayout().show(Frame.getMainPanel(), "2");//read from file first
				
			}
		});
		
		instruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frame.getCardLayout().show(Frame.getMainPanel(), "3");
				
			}
		});
		
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

