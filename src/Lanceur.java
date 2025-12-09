import javax.swing.Timer;

public class Lanceur {
    public static int tempo = 10;
    public static void main(String[] args) {

        Jeu jeu = new Jeu("lab.txt");
        FenetreJeu graphic = new FenetreJeu(jeu.labyrinthe, jeu.getBille());
        Timer timer = new Timer(tempo, e -> {

            graphic.repaint();


        });
        timer.setInitialDelay(0);
        timer.start();
    }
}