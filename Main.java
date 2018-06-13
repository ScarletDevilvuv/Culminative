package com;

import javax.swing.SwingUtilities;

public class Main {
	//Main method
	public static void main (String [] args){

		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Frame();
			}
		});

	}
}
