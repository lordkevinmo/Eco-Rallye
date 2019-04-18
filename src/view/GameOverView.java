package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.RenderController;

public class GameOverView  extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btn;
	private String path="/res/go.png";
	public GameOverView(){
        this.setTitle("Eco Rallye - Game Over");
        this.setSize(RenderController.width, RenderController.height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new FondPannel(new ImageIcon(getClass().getResource(path)).getImage());
        panel.setLayout(null);

        btn = new JButton("Nouvelle piste ?");
        
        
        btn.setBounds(RenderController.width/2 - 150/2,RenderController.height/2 - 30/2,150, 30);
        panel.add(btn);
        panel.add(btn);
        

        btn.addActionListener(event->{
            this.dispose();
            new RenderController().loadLevels();
        });

        this.setContentPane(panel);
        this.setVisible(true);

	}
	
}
