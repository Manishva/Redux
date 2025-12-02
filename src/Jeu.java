public class Jeu {

    public Labyrinthe labyrinthe;
    public Bille bille;

    public Jeu(String f){
        this.labyrinthe = new Labyrinthe(f);
        this.bille = new Bille(2.0, 2.0);
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