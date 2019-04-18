package view;

import controller.RenderController;

import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    public Fenetre(String path, String titre){
        super();
        this.setTitle(titre);
        this.setSize(new Dimension(RenderController.width, RenderController.height));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setContentPane(new FondPannel(new ImageIcon(getClass().getResource(path)).getImage()));
        this.setVisible(true);
    }
}
