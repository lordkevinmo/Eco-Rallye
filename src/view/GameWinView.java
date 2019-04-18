package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextComponent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

import controller.GameController;
import controller.RenderController;

public class GameWinView  extends JFrame {
	private JButton btn;
	private double bonus ;
	
	public GameWinView(double bonus,int terrain){
		this.bonus=bonus;
        this.setTitle("Eco Rallye - You win !");
        this.setSize(RenderController.width, RenderController.height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new FondPannel(new ImageIcon(getClass().getResource("/res/pisteWin"+terrain+".png")).getImage());
        panel.setLayout(null);
        
        btn = new JButton("Encore une piste ?");
        
        btn.setBounds(RenderController.width/2 - 150/2,RenderController.height/2 - 30/2,150, 30);
        panel.add(btn);
        //panel.add(btn);

        btn.addActionListener(event->{
            this.dispose();
            new RenderController().loadLevels();
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
        g.drawString("       Gagné !", RenderController.width/2 - 75, 230);
        g.drawString("Bonus "+new Double(bonus).floatValue(), RenderController.width/2 - 54, 200);
    }	
}
