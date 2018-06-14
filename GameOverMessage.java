package com;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class GameOverMessage extends JPanel implements MouseListener{
	private final Image gameOverPicture = Toolkit.getDefaultToolkit().getImage("Losing.png");
	private final Font font1 = new Font ("Arial", Font.PLAIN, 25);
	private final Font font2 = new Font ("Arial", Font.BOLD, 30);
	
	public GameOverMessage() {
		this.setLayout(null);

		//have to use repaint
		this.addMouseListener(null);
		addMouseListener(this);
		setVisible (true);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(gameOverPicture, 0, 0, this);
		g.setColor(Color.white);
		g.setFont(font2);
		if (Logic.getTurnCounter() == 1) g.drawString("You have survived for " + Logic.getTurnCounter() + " day", 250, 390);
		else g.drawString("You have survived for " + Logic.getTurnCounter() + " days", 250, 390);
		g.setFont(font1);
		g.drawString("Click any where to restart", 300, 700);
	
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Frame.getCardLayout().show(Frame.getMainPanel(), "1");
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
}
