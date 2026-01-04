import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButton extends JPanel implements ActionListener {
    public static int tempo = 10;
    public JButton playButton;
    public static Jeu jeu;
    public static FenetreJeu graphic;

    public PlayButton() {
        playButton = new JButton("Play");
        JPanel panel = new JPanel();
        this.playButton.addActionListener(this);
        panel.add(playButton);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Lanceur.frame.setVisible(false);
        jeu = new Jeu("lab.txt");
        graphic = new FenetreJeu(jeu.labyrinthe, jeu.getBille());


        Timer timer = new Timer(tempo, ev -> {

            graphic.repaint();


        });
        timer.setInitialDelay(0);
        timer.start();
    }
}
