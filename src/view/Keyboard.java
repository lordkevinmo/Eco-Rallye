package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * keyboard class
 */
public class Keyboard extends KeyAdapter {
    
    public static boolean[] keyDown = new boolean[256];

    @Override
    public void keyPressed(KeyEvent e) {
        keyDown[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	keyDown[e.getKeyCode()] = false;
    }
    public static boolean keyB() {
    	return keyDown[66];//key code : b    	
    }
    public static boolean keyT() {
    	return keyDown[84];//KEY CODE :t 
    }
    
    public static boolean allReleased() {
    	for(int i=0;i<256;i++)
    		if (keyDown[i]==true) return false;
    	return true;
    }
    
}