package controller;

import javax.swing.*;

import view.FondPannel;
import view.GameOverView;
import view.LevelsView;
import view.PisteView;
import view.ShopView;

public class RenderController extends JFrame{
    public FondPannel panel;

    public static int width = 1023;
    public static int height = 511;
    private JButton btn,shop,fourchette;
    public void loadMenu() {

        String titre = "Eco Rallye - Menu Principal";

        this.Initialize();

    	this.setTitle(titre);
        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);

        this.setContentPane(panel);
        this.setVisible(true);
    }
    private void Initialize() {
        String path = "/res/car.png";
        panel = new FondPannel(new ImageIcon(getClass().getResource(path)).getImage());
        panel.setLayout(null);
//nouveau jeu
        btn = new JButton("Commencer le jeu");
        btn.setBounds(width/2 - 150/2,height/2 - 30/2,150, 30);
        
//shop 
        shop = new JButton("Shop");
        shop.setBounds(width/2 - 150/2,height/2 +30,150, 30);
//fourchette 
        fourchette = new JButton("Chronometre  : "+(PisteView.fourchette?"Oui":"Non"));
        fourchette.setBounds(width/2 - 150/2,height/2 +80,150, 30);
        
        panel.add(btn);
        panel.add(shop);
        panel.add(fourchette);
        
        btn.addActionListener(event -> loadLevels());
        shop.addActionListener(event -> {loadShop();});
        fourchette.addActionListener(event -> {
        	PisteView.fourchette=!PisteView.fourchette;
        	fourchette.setText("Chronometre  : "+(PisteView.fourchette?"Oui":"Non"));
        	});

    }
    public void loadLevels() {
        this.dispose();
        new LevelsView();
    }
    public void loadShop() {
    	this.dispose();
    	new ShopView(new ShopController())	;
    }
    public void loadGameOver() {
    	this.dispose();
    }   
    
}
