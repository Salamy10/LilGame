package model;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class Human implements Movable, KeyListener{
	
	 //Laufgeschwindigkeit
	int speed = 10;
	//Position
	int x = 200, y = 200;
	//Direction
	boolean up, down, left, right;
	
    int playerWidth = 400, playerHeight = 400;
	
    ImageIcon gifStance = new ImageIcon("Assets/PackageM/Idle_Front.gif");  // ← dein Dateiname
    Image charStance = gifStance.getImage();
    
    //LilGentleman Idle Animation
    ImageIcon gifIdleRight = new ImageIcon("Assets/PackageM/Idle_Right.gif");  // ← dein Dateiname
    Image charIdleRight = gifIdleRight.getImage();
    //LilGentleman Idle Animation
    ImageIcon gifIdleLeft = new ImageIcon("Assets/PackageM/Idle_Left.gif");  // ← dein Dateiname
    Image charIdleLeft = gifIdleLeft.getImage();
    //LilGentleman Idle Animation
    ImageIcon gifIdleDown = new ImageIcon("Assets/PackageM/Idle_Front.gif");  // ← dein Dateiname
    Image charIdleDown = gifIdleDown.getImage();
    //LilGentleman Idle Animation
    ImageIcon gifIdleUp = new ImageIcon("Assets/PackageM/Idle_Behind.gif");  // ← dein Dateiname
    Image charIdleUp = gifIdleUp.getImage();
    
    //LilGentleman Run Right Animation
    ImageIcon gifRunRight = new ImageIcon("Assets/PackageM/walk_Right.gif");  // ← dein Dateiname
    Image charRunRight = gifRunRight.getImage();
    //LilGentleman RunLeft Animation
    ImageIcon gifRunLeft = new ImageIcon("Assets/PackageM/walk_Left.gif");  // ← dein Dateiname
    Image charRunLeft = gifRunLeft.getImage();
    //LilGentleman Run Animation
    ImageIcon gifRunDown = new ImageIcon("Assets/PackageM/walk_Front.gif");  // ← dein Dateiname
    Image charRunDown = gifRunDown.getImage();
    //LilGentleman Run Animation
    ImageIcon gifRunUp = new ImageIcon("Assets/PackageM/walk_Behind.gif");  // ← dein Dateiname
    Image charRunUp = gifRunUp.getImage();
	
    public void showChar(Graphics g) {
//		// Spieler zeichnen (grün)
//        g.drawImage(charStance, x, y, playerWidth, playerHeight);
//        g.drawRect(x, y, playerWidth, playerHeight);
        g.drawImage(charIdleDown, x, y, playerWidth, playerHeight, null);
        
	}
	
	@Override
	public void moveRight(KeyEvent e) {
    	x += speed; charStance = charRunRight; 	//run
    	up = false; down = false; left = false; right = true;		
	}

	@Override
	public void moveUp(KeyEvent e) {	
		y -= speed; charStance = charRunUp; 	//run  	
    	up = true; down = false; left = false; right = false;	//direction   
	}
	
	@Override
	public void moveDown(KeyEvent e) {		
    	y += speed; charStance = charRunDown; 	//run 	
    	up = false; down = true; left = false; right = false;	//direction		
	}

	@Override
	public void moveLeft(KeyEvent e) {		
    	x -= speed; charStance = charRunLeft; 	//run
    	up = false; down = false; left = true; right = false;	//direction		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	
	
}
