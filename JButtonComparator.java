package com;
import java.util.Comparator;

import javax.swing.JButton;

public class JButtonComparator implements Comparator <JButton>{

	public int compare(JButton jButton1, JButton jButton2) {
		return jButton1.getText().compareTo(jButton2.getText());
	}
	
}
