import javax.swing.*;

public class Lanceur {

    public static void main(String[] args) {

        PlayButton playButton = new PlayButton();
        JFrame frame = new JFrame("Lanceur");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(playButton);
        frame.setSize(500, 500);



    }
}