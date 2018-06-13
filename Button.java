package com;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;

public class Button extends JLabel{
	
	private String writing;
	private JPanel panelToCallWhenClicked;
	private int order;
	private int width;
	private int height;
	private Dimension buttonSize;
	private Image image;
	private BufferStrategy bufferStrategy;
	
	public Button (String writing, final JPanel panelToCallWhenClicked, int order, int width, int height){
		
		this.writing = writing;
		this.order = order;
		this.width = width;
		this.height = height;
		this.buttonSize = new Dimension (width, height);
		image = Toolkit.getDefaultToolkit().getImage("Untitled.png");
		this.repaint ();
		
		this.addMouseListener(new MouseListener () {

			public void mouseClicked(MouseEvent arg0) {
				panelToCallWhenClicked.setVisible(true);
			}

			public void mouseEntered(MouseEvent arg0) {
				
			}

			public void mouseExited(MouseEvent arg0) {
				
			}

			public void mousePressed(MouseEvent arg0) {
				
			}

			public void mouseReleased(MouseEvent arg0) {
				
			}
			
		});
		
	}
	
	public void paint (Graphics g){
		g.drawString("hello", 0, 0);
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getOrder() {
		return order;
	}

	public String getWriting() {
		return writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}

	public JPanel getPanelToCallWhenClicked() {
		return panelToCallWhenClicked;
	}

	public void setPanelToCallWhenClicked(JPanel panelToCallWhenClicked) {
		this.panelToCallWhenClicked = panelToCallWhenClicked;
	}
}
