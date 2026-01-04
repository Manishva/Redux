//---------------------ARRIERE PLAN DU LANCEUR--------------------------------//

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImagePanel extends JPanel {
    private final BufferedImage image;

    public ImagePanel() {
        try {
            this.image = ImageIO.read(new File("src/Launcher_bg.jpg"));


        } catch (IOException ex) {
            throw new IllegalArgumentException("String Format Error");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
