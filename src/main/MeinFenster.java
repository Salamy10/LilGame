package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MeinFenster extends JPanel implements KeyListener {

    int x = 200, y = 200;  // Startposition
    int speed = 10;         // Geschwindigkeit

    public MeinFenster() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
    }

    // Hier wird das Quadrat gezeichnet
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 40, 40);  // x, y, Breite, Höhe
    }

    // Taste gedrückt
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP    -> y -= speed;
            case KeyEvent.VK_DOWN  -> y += speed;
            case KeyEvent.VK_LEFT  -> x -= speed;
            case KeyEvent.VK_RIGHT -> x += speed;
        }
        repaint();  // Fenster neu zeichnen
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame fenster = new JFrame("LilGame");
        fenster.setSize(500, 500);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.add(new MeinFenster());
        fenster.setVisible(true);
    }
}