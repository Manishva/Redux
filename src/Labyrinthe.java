import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Labyrinthe {

    private int hauteur, largeur;
    private Square[][] carte;

    public Labyrinthe(String file) {
        try {

            Scanner sc = new Scanner(new FileInputStream(file));
            this.hauteur = sc.nextInt();
            this.largeur = sc.nextInt();
            sc.nextLine();

            this.carte = new Square[hauteur][largeur];
            for (int l = 0; l < hauteur; l++) {
                String ligne = sc.nextLine();
                for (int c = 0; c < largeur; c++) {
                    Square cc;
                    Character ch = ligne.charAt(c);
                    switch(ch) {
                        // Murs et Vide
                        case '#': cc = new Mur(l, c); break;
                        case ' ': cc = new CaseOrdinaire(l, c); break;

                        default: cc = new CaseOrdinaire(l,c); break;
                    }
                    carte[l][c] = cc;
                }
            }
            sc.close();
        }
        catch (IOException e) {e.printStackTrace();}
    }

    public Square getCase(int l, int c) {
        return carte[l][c];
    }

    public int getHauteur() { return this.hauteur;}
    public int getLargeur() { return this.largeur;}

    public void print() {

        // Parcours de toutes les lignes
        for (int l = 0; l < hauteur; l++) {
            // Parcours de toutes les colonnes
            for (int c = 0; c < largeur; c++) {
                // On affiche le toString de chaque case sans retour à la ligne
                System.out.print(carte[l][c].toString());
            }
            // Retour à la ligne à la fin de chaque rangée
            System.out.println();
        }
    }

}
