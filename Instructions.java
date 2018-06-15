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

public class Instructions extends JPanel{

	private final Image instructionImage = Toolkit.getDefaultToolkit().getImage("instruction.png");
	private JButton back = new JButton("Back");
	private Font instructionFont = new Font ("Arial", Font.PLAIN, 40);

	public Instructions() {
		this.setLayout(null);
		back.setBackground(Color.lightGray);
		back.setFont(instructionFont);
		back.setBounds(720, 720, 250, 70);
		this.add(back);

		this.setVisible(true);
		
		back.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        back.setBackground(Color.BLACK);
		        back.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
				back.setBackground(Color.lightGray);
				back.setForeground(Color.BLACK);
		    }
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO code reset every single variable
				Frame.getCardLayout().show(Frame.getMainPanel(), "1");//remember to reset everything first
				
			}
		});

	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(instructionImage, 0, 0, this);
	}

	

}
