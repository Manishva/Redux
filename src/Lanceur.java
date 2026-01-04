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
        playButton.setBounds(80,80, 100, 40);
        imagePanel.setBounds(0,0,582, 301);
        frame.setSize(582, 301);
        frame.setResizable(true);
        frame.add(imagePanel);
        frame.add(playButton);
        frame.setVisible(true);


    }
}