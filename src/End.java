//---------------------CASE DE SORTIE--------------------------------//

import javax.swing.*;

public class End extends Square{

    int lvlid = 1;

    // Constructeur de la case
    public End(int l,int c){
        super(l,c);
    }

    // Concrétisation des méthodes abstraites
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enter(Bille b) {
        System.out.println(FenetreJeu.minute +" :" + FenetreJeu.second+ "." + FenetreJeu.chrono);
        if (lvlid==1){

            PlayButton.jeu = new Jeu("lab2.txt");
            PlayButton.graphic.frame.setVisible(false);
            PlayButton.graphic = new FenetreJeu(PlayButton.jeu.labyrinthe, PlayButton.jeu.getBille());

            Timer timer = new Timer(PlayButton.tempo, ev -> {

                PlayButton.graphic.repaint();


            });
            timer.setInitialDelay(0);
            timer.start();
            lvlid++;
        } else if (lvlid==2) {

            Jeu jeu = new Jeu("lab3.txt");
            PlayButton.graphic.frame.setVisible(false);
            FenetreJeu graphic = new FenetreJeu(jeu.labyrinthe, jeu.getBille());

            Timer timer = new Timer(PlayButton.tempo, ev -> {

                graphic.repaint();


            });
            timer.setInitialDelay(0);
            timer.start();
            lvlid++;

        }

    }

    @Override
    public void leave(Bille b) {

    }

    @Override
    public String toString() {
        return "e";
    }
}
