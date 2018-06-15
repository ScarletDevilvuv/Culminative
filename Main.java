package com;

import javax.swing.SwingUtilities;

public class Main {

	public static Frame frame;

	//Main method
	public static void main (String [] args){

		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				frame = new Frame();
			}
		});

	}
}
