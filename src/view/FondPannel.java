package view;

import javax.swing.*;
import java.awt.*;

public class FondPannel extends JPanel {

    private Image image;

    public FondPannel(Image image){
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
      g.drawImage(image, 0, 0, null);
    }
}
