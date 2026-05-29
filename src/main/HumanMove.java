package main;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.*;
import model.Human;

public class HumanMove extends JPanel implements KeyListener {
	
	Human human1 = new Human();
	
	public HumanMove() { //Konstruktor
	    setBackground(Color.WHITE);
	    setFocusable(true);

	    
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Ziel zeichnen (rot)
        g.setColor(Color.RED);
        g.fillRect(100, 100, 100, 100);

        // Spieler zeichnen (grün)
        human1.showChar(g);
        
        
    }

	@Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        
            case KeyEvent.VK_UP    -> {human1.moveUp(e);}
            
            case KeyEvent.VK_DOWN  -> {human1.moveDown(e);}
            
            case KeyEvent.VK_LEFT  -> {human1.moveLeft(e); }
            
            case KeyEvent.VK_RIGHT -> {human1.moveRight(e);}
        }
        

        repaint();
        
	}
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
        
	public static void main(String[] args) {
		
		JFrame fenster = new JFrame("LilGame");
        fenster.setSize(1920/2, 1080/2);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.add(new HumanMove());
        
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.LIGHT_GRAY);
//        fenster.setSize(200, 200);
//		
        JLabel label = new JLabel("Hallo Welt! Dies ist ein JLabel.");
        label.setSize(20, 20);
        fenster.add(label);
//        fenster.add(panel);
        

        fenster.setVisible(true);

	}



}
