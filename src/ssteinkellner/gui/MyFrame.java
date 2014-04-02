package ssteinkellner.gui;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * @author Steinkellner Sebastian
 * @version 2014.03.01
 */
public class MyFrame extends JFrame{
	
	private String n, credits = "by Sebastian Steinkellner";
	private Dimension d = new Dimension(500,300);
	
	private MyView v;
	
	/**
	 * erzeugt einen frame für das programm
	 * @param view - das JPanel das angezeigt werden soll
	 * @param name - name des Programmes (wird im Fenster-Rahmen angezeigt)
	 */
	public MyFrame(MyView view, String name){
		v = view;
		n = name;
		
		this.resetTitle();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(d);
		
		this.setLayout(new BorderLayout());
		
		this.add(v);
		
		this.setVisible(true);
	}
	
	/**
	 * setzt den titel auf: "Programmname | title | Credits"
	 * @param title - teil der in den titel eingesetzt werden soll
	 */
	public void newTitle(String title){
		this.setTitle(n + " | " + title + " | " + credits);
	}
	/**
	 * setzt den titel auf: "Programmname | Credits"
	 */
	public void resetTitle(){
		this.setTitle(n + " | " + credits);
	}
}
