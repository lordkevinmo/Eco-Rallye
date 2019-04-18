package view;

import javax.swing.*;

import controller.GameController;
import controller.RenderController;
import model.User;
import model.UserSingeleton;

import java.awt.*;

public class LevelsView extends JFrame {

	private JButton btnNeige, btnDesert,btnHome;
    private User user= UserSingeleton.getUser();
    
    public LevelsView(){
        this.setTitle("Eco Rallye - Choisir une piste");
        this.setSize(RenderController.width, RenderController.height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
 //       this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        btnNeige = new JButton(new ImageIcon(getClass().getResource("/res/neige.png")));
        btnDesert = new JButton(new ImageIcon(getClass().getResource("/res/desert.png")));
        btnHome =  new JButton("Accueil");
        
        btnNeige.setBounds(RenderController.width/2 - 350/2, RenderController.height/2 - 100, 150, 100);
        JLabel course1 = new JLabel("Course 1 ");
        course1.setBounds(RenderController.width/2 - 350/2 +40, RenderController.height/2 - 30, 180, 100);
        course1.setFont(new Font("Verdana",1,15));
        course1.setForeground(Color.BLUE);
        btnDesert.setBounds(RenderController.width/2 + 50, RenderController.height/2 - 100, 150, 100);
        JLabel course2 = new JLabel("Course 2");
        course2.setBounds(RenderController.width/2 + 50 +40, RenderController.height/2 - 30, 150, 100);
        course2.setFont(new Font("Verdana",1,15));
        course2.setForeground(Color.decode("#ff7212"));
        
        btnHome.setBounds(RenderController.width/2 -60 , RenderController.height/2 + 100, 150, 30);
        JLabel text = new JLabel("Choisissez une piste ");
        text.setBounds(RenderController.width/2 -100 , 30,400,100);
        text.setFont(new Font("Verdana",1,20));
        text.setForeground(Color.RED);
        
        panel.add(text);
        panel.add(course2);
        //g.drawString("Choisir une piste", RenderController.width/2 - 75, 100);
        panel.add(course1);
        panel.add(btnNeige);
        panel.add(btnDesert);
        panel.add(btnHome);
        String neige = "/res/pisteenneigee.png";
        String desert = "/res/pistedeserte.png";

        btnNeige.addActionListener(event->{
            this.dispose();
            new GameController(RenderController.width, RenderController.height, 1, new ImageIcon(getClass().getResource(neige)).getImage());
        });
        btnDesert.addActionListener(event->{
            this.dispose();
            new GameController(RenderController.width, RenderController.height, 2, new ImageIcon(getClass().getResource(desert)).getImage());
        });
        btnHome.addActionListener(event -> {
        	this.dispose();
        	new RenderController().loadMenu();
        });

        this.setContentPane(panel);
        this.setVisible(true);
   
    }

}
