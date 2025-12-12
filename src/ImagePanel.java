import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel() {
        image = new ImageIcon("Oxyd.png").getImage();
    }
}
