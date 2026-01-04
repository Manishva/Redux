//---------------------CASE DE SORTIE--------------------------------//

import javax.swing.*;

public class End extends Square{

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
        if (FenetreJeu.lvlid==2){

            PlayButton.jeu = new Jeu("lab2.txt");
            PlayButton.graphic.frame.setVisible(false);
            PlayButton.graphic = new FenetreJeu(PlayButton.jeu.labyrinthe, PlayButton.jeu.getBille());

            Timer timer = new Timer(PlayButton.tempo, ev -> {

                PlayButton.graphic.repaint();


            });
            timer.setInitialDelay(0);
            timer.start();
            FenetreJeu.lvlid++;
        } else if (FenetreJeu.lvlid==3) {

            Jeu jeu = new Jeu("lab3.txt");
            PlayButton.graphic.frame.setVisible(false);
            FenetreJeu graphic = new FenetreJeu(jeu.labyrinthe, jeu.getBille());

            Timer timer = new Timer(PlayButton.tempo, ev -> {

                graphic.repaint();


            });
            timer.setInitialDelay(0);
            timer.start();
            FenetreJeu.lvlid++;

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
