package view;

import javax.swing.*;

import controller.GameController;
import controller.RenderController;
import controller.ShopController;
import model.OPTION;
import model.User;
import model.UserSingeleton;

import java.awt.*;

public class ShopView extends JFrame {

	private JButton btnRX, btnTemps,btnHome;
	private JLabel score,text;
    private User user= UserSingeleton.getUser();
    private String msg="";
    
    public ShopView(ShopController shopController ){
        this.setTitle("Eco Rallye - Shop");
        this.setSize(RenderController.width, RenderController.height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        btnRX = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/res/battery.jpg")).getImage().getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH)));
        
        btnTemps = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/res/plustime.png")).getImage().getScaledInstance(150, 100,  java.awt.Image.SCALE_SMOOTH)));
        btnHome  = new JButton("Accueil");
        
        btnRX.setBounds(RenderController.width/2 - 350/2, RenderController.height/2 - 100, 150, 80);
        btnTemps.setBounds(RenderController.width/2 + 50, RenderController.height/2 - 100, 150, 80);
        btnHome.setBounds(RenderController.width/2 -60 , RenderController.height/2 + 100, 150, 30);
        
        JLabel textRx = new JLabel("Range extender ");
        textRx.setBounds(RenderController.width/2 - 350/2 +15, RenderController.height/2 - 30, 180, 60);
        textRx.setFont(new Font("Verdana",1,15));
        textRx.setForeground(Color.decode("#32C132"));
        
        //btnDesert.setBounds(RenderController.width/2 + 50, RenderController.height/2 - 100, 150, 100);
        JLabel textTemps = new JLabel("Temps 0 consommation");
        textTemps.setBounds(RenderController.width/2 + 50 , RenderController.height/2 - 30, 250, 60);
        textTemps.setFont(new Font("Verdana",1,15));
        textTemps.setForeground(Color.decode("#00B4BB"));
        panel.add(textRx);
        panel.add(textTemps);
        
        score = new JLabel("Score: "+Math.round(user.getScore()*10000)/10000d);
        score.setBounds(RenderController.width/2 + 380, 15, 170, 60);
        score.setFont(new Font("Verdana",1,15));
        score.setForeground(Color.BLACK);
        
        text = new JLabel("Choisir parmi les options");
        text.setBounds(RenderController.width/2 - 105, 18, 250, 60);
        text.setFont(new Font("Roboto", Font.BOLD, 20));
        text.setForeground(Color.BLACK);
        
        panel.add(text);
        panel.add(score);
        panel.add(btnRX);
        panel.add(btnTemps);
        panel.add(btnHome);
        

        btnRX.addActionListener(event->{
            //this.dispose();
            msg=shopController.buyItem(OPTION.RX);
            score.setText("Score: "+Math.round(user.getScore()*10000)/10000d);
            repaint();
            //Controller(RenderController.width, RenderController.height, 1, new ImageIcon(getClass().getResource(neige)).getImage());
        });
        btnTemps.addActionListener(event->{
            //this.dispose();
            msg=shopController.buyItem(OPTION.TIMER);
            score.setText("Score: "+Math.round(user.getScore()*10000)/10000d);
            repaint();
            //new GameController(RenderController.width, RenderController.height, 2, new ImageIcon(getClass().getResource(desert)).getImage());
        });
        btnHome.addActionListener(event -> {
        	this.dispose();
        	score.setText("Score: "+Math.round(user.getScore()*10000)/10000d);
        	MainMenu.main(null);
        });
        
        this.setContentPane(panel);
        this.setVisible(true);

        
        
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font font = new Font("Roboto", Font.BOLD, 20 );
        g.setFont(font);
        g.setColor(Color.BLACK);
      //  g.drawString("Choisir parmi les options", RenderController.width/2 - 105, 100);
        //RenderController.width/2 -100 , 30,400,100
        g.drawString(msg,RenderController.width/2 -70 , RenderController.height/2 + 100);
        //g.drawString(, RenderController.width/2 + 380, 55);
    }
}
