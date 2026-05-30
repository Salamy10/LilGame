package model;

import java.awt.event.KeyEvent;

public interface Movable {
	
	void moveLeft(KeyEvent e);
	void moveRight(KeyEvent e);
	void moveUp(KeyEvent e);
	void moveDown(KeyEvent e);

}
