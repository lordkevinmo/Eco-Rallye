package controller;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

import model.STATE;
import model.User;
import model.UserSingeleton;
import view.PisteView;
import view.GameOverView;
import view.GameWinView;
import view.Keyboard;
import view.Mouse;
import view.SlashTrail;

public class GameController extends JPanel implements KeyListener {
    private JFrame frame= new JFrame();
    private User user = UserSingeleton.getUser();
    private PisteView pisteView ;
    private final SlashTrail slashTrail = new SlashTrail(20);
    private Image image;
    
    private GameController(int terrain, Image img) {
    	pisteView = new PisteView();
        this.image = img;
    	switch (terrain) {
    		case 1 : {pisteView.load1();break;}
    		case 2 : {pisteView.load2();break;}
    	}
        //pisteView.load(terrain);

        Mouse mouse = new Mouse();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

        addKeyListener(new Keyboard());

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                update();
                repaint();
                
                if(pisteView.getState()==STATE.DEAD) {
                	
                	cancel();
                	for(boolean x: Keyboard.keyDown )
                		x=false;
                	
                	pisteView.destroy();
                	frame.dispose();
                	
                	/*
                	System.gc();
                	java.awt.Window win[] = java.awt.Window.getWindows(); 
                	for(int i=0;i<win.length;i++){ 
                	    win[i].dispose(); 
                	    win[i]=null;
                	} */
                	
                	new GameOverView();
                	/*RenderController rc = new RenderController();
                	rc.dispose();
                	panel = new FondPannel(new ImageIcon(getClass().getResource(path)).getImage());
                    panel.setLayout(null);*/
                }
                if(pisteView.getState()==STATE.WIN) {
                	cancel();
                	for(boolean x: Keyboard.keyDown )
                		x=false;
                	
                	pisteView.destroy();
                	frame.dispose();
                	user.addScore(pisteView.getCar().getEnergie());
                	System.out.println("energie left "+pisteView.getCar().getEnergie());
                	new GameWinView(pisteView.getCar().getEnergie(),terrain);
                }
            }
        }, 100, 1000 / 55);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        Graphics2D g2d = (Graphics2D) g;
        // g2d.scale(0.5, 0.5);
        draw(g2d);
    }

    public void update() {
        pisteView.update();
        
        //if (Mouse.pressed) {
        //    slashTrail.addTrail(Mouse.x, Mouse.y);
        //}
        //else {
        //    slashTrail.standBy();
        //}
    }

    private void draw(Graphics2D g) {
        pisteView.draw(g);
        pisteView.drawDebug(g);
        
        if (Mouse.pressed) {
            g.setColor(Color.ORANGE);
            g.fillOval(Mouse.x - 2, Mouse.y - 2, 4, 4);
        }
        
        slashTrail.drawDebug(g);

    }

    public GameController(int x, int y, int terrain, Image img) {
        //Runnable utilisé pour faire du lambda expression plus bas

        SwingUtilities.invokeLater(()-> {
            GameController gameController;
            gameController = new GameController(terrain, img);
            
            frame.setTitle("Eco Rallye");
            frame.getContentPane().add(gameController);
            frame.setSize(x, y);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);
            gameController.requestFocus();


        });
    }



    // KeyListener implementation 
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) { }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
