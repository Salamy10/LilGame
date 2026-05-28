package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MeinFenster extends JPanel implements KeyListener {

    private static final long serialVersionUID = 1L;

    // Spieler
    int x = 200, y = 200, a = 200, b = 155;
    int speed = 20;

    // Ziel-Objekt
    int zielX = 100, zielY = 100;
    int zielGroesse = 20;
    
    
    //World Border
    int borderLeft = 20, borderRight = 1920-20, borderUp = 20, borderDown = 1080-20;
    
    /*Player Direction*/
    boolean up, down, left, right;
    //LilGentleman Stance
    ImageIcon gifStance = new ImageIcon("Assets/Monster_Pack_Free_Character_2/Idle_Front.gif");  // ← dein Dateiname
    Image charStance = gifStance.getImage();
    
    //LilGentleman Idle Animation
    ImageIcon gifIdleRight = new ImageIcon("Assets/Monster_Pack_Free_Character_2/Idle_Right.gif");  // ← dein Dateiname
    Image charIdleRight = gifIdleRight.getImage();
    //LilGentleman Idle Animation
    ImageIcon gifIdleLeft = new ImageIcon("Assets/Monster_Pack_Free_Character_2/Idle_Left.gif");  // ← dein Dateiname
    Image charIdleLeft = gifIdleLeft.getImage();
    //LilGentleman Idle Animation
    ImageIcon gifIdleDown = new ImageIcon("Assets/Monster_Pack_Free_Character_2/Idle_Front.gif");  // ← dein Dateiname
    Image charIdleDown = gifIdleDown.getImage();
    //LilGentleman Idle Animation
    ImageIcon gifIdleUp = new ImageIcon("Assets/Monster_Pack_Free_Character_2/Idle_Behind.gif");  // ← dein Dateiname
    Image charIdleUp = gifIdleUp.getImage();
    
    //LilGentleman Run Right Animation
    ImageIcon gifRunRight = new ImageIcon("Assets/Monster_Pack_Free_Character_2/Walk_Right.gif");  // ← dein Dateiname
    Image charRunRight = gifRunRight.getImage();
    //LilGentleman RunLeft Animation
    ImageIcon gifRunLeft = new ImageIcon("Assets/Monster_Pack_Free_Character_2/Walk_Left.gif");  // ← dein Dateiname
    Image charRunLeft = gifRunLeft.getImage();
    //LilGentleman Run Animation
    ImageIcon gifRunDown = new ImageIcon("Assets/Monster_Pack_Free_Character_2/Walk_Front.gif");  // ← dein Dateiname
    Image charRunDown = gifRunDown.getImage();
    //LilGentleman Run Animation
    ImageIcon gifRunUp = new ImageIcon("Assets/Monster_Pack_Free_Character_2/Walk_Behind.gif");  // ← dein Dateiname
    Image charRunUp = gifRunUp.getImage();
    
    int playerWidth = 400, playerHeight = 400;

    int punkte = 0;
    Random random = new Random();

    public MeinFenster() { //Konstruktor
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        
        //Stance
        gifStance.setImageObserver(this); 
        //Idle
        gifIdleRight.setImageObserver(this);
        gifIdleLeft.setImageObserver(this);
        gifIdleDown.setImageObserver(this);
        gifIdleUp.setImageObserver(this);
        //walk
        gifRunRight.setImageObserver(this);
        gifRunLeft.setImageObserver(this);
        gifRunDown.setImageObserver(this);
        gifRunUp.setImageObserver(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Ziel zeichnen (rot)
        g.setColor(Color.RED);
        g.fillRect(zielX, zielY, zielGroesse, zielGroesse);

        // Spieler zeichnen (grün)
        g.drawImage(charStance, x, y, playerWidth, playerHeight, this);

        // Punkte anzeigen
        g.setColor(Color.WHITE);
        g.drawString("Punkte: " + punkte, 10, 20);
        
        
        // Punkte anzeigen
        g.setColor(Color.PINK);
        g.fillRect(borderLeft, 0, 5, 200);
        
        
    }

    // Prüft ob Spieler das Ziel berührt
    void kollisionPruefen() {
        Rectangle spieler = new Rectangle(x, y, playerWidth, playerHeight);
        Rectangle ziel = new Rectangle(zielX, zielY, zielGroesse, zielGroesse);

        if (spieler.intersects(ziel)) {
            punkte++;
            // Ziel an zufälliger neuer Position
            zielX = random.nextInt(borderLeft, borderRight);
            zielY = random.nextInt(borderUp, borderDown);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        
            case KeyEvent.VK_UP    -> {            	
            	if(y > borderUp) {
            		y -= speed; b -= speed; charStance = charRunUp; 	//run
            	}
            	up = true; down = false; left = false; right = false;	//direction
            }
            
            case KeyEvent.VK_DOWN  -> {
            	if(y < borderDown) {
            		y += speed; b += speed; charStance = charRunDown; 	//run
            	}
            	up = false; down = true; left = false; right = false;	//direction
            }
            
            case KeyEvent.VK_LEFT  -> {
            	if(x > borderLeft) {
            		x -= speed; a -= speed; charStance = charRunLeft; 	//run
            	}
            	up = false; down = false; left = true; right = false;	//direction
            }
            
            case KeyEvent.VK_RIGHT -> {
            	if(x < borderRight) {
            		x += speed; a += speed; charStance = charRunRight; 	//run
            	}
            	up = false; down = false; left = false; right = true;	//direction
            }
        }
        
        kollisionPruefen();
        repaint();
    }

    @Override public void keyReleased(KeyEvent e) {
    	if(up) {
    	charStance = charIdleUp;
    	}
    	if(down) {
    	charStance = charIdleDown;
    	}
    	if(left) {
    	charStance = charIdleLeft;
    	}
    	if(right) {
    	charStance = charIdleRight;
    	}
    	
    }
    
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame fenster = new JFrame("LilGame");
        fenster.setSize(1920, 1080);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.add(new MeinFenster());
        fenster.setVisible(true);
    }
}