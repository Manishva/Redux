import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Jeu {

    public Labyrinthe labyrinthe;
    public Bille bille;
    public Events events;
    private double tailleCase;


    public Jeu(String f) {
        this.labyrinthe = new Labyrinthe(f);
        this.bille = new Bille(1.0 + 0.5 - Bille.r, 1.0 + 0.5 - Bille.r);
        this.events = new Events(bille, tailleCase);
    }

    public Bille getBille() {
        return this.bille;
    }

    public static void main(String[] args) {
        Jeu j = new Jeu("lab.txt");

        //while(true) {
        j.labyrinthe.print();
        //}
    }
}