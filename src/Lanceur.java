//---------------------LANCEUR DU JEU--------------------------------//

import javax.swing.*;


public class Lanceur {
    public static JFrame frame;
    public static void main(String[] args) {

        PlayButton playButton = new PlayButton();
        frame = new JFrame("Lanceur");
        JPanel imagePanel = new ImagePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.pack();
        frame.setLocationRelativeTo(null);
        playButton.setBounds(0,110, 582, 301);
        imagePanel.setBounds(0,0,582, 301);
        frame.setSize(582, 333);
        frame.setLocation(700,350);
        frame.setResizable(false);
        frame.add(imagePanel);
        frame.add(playButton);
        frame.setVisible(true);
    }
}