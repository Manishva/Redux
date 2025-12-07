import javax.swing.*;
import java.awt.*;

public class FenetreJeu extends JPanel {
    private final Labyrinthe labyrinthe;
    private static Bille bille;
    private static final int tailleCase = 30;
    private final int hauteur, largeur;
    private JFrame frame;
    private Events events;
    public static boolean tempb;

    public FenetreJeu(Labyrinthe l, Bille bille) {

        this.labyrinthe = l;
        this.bille = bille;
        this.hauteur = l.getHauteur();
        this.largeur = l.getLargeur();

        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(largeur * tailleCase, hauteur * tailleCase));

        this.events = new Events(bille, tailleCase);

        JFrame frame = new JFrame("Redux");
        this.frame = frame;
        frame.addMouseMotionListener(events);
        frame.addMouseListener(events);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);



    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        // Couche 1 : le Terrain

        // On parcourt toute la square
        for (int l = 0; l < hauteur; l++) {
            for (int c = 0; c < largeur; c++) {
                // On récupère la case
                Square laCase = labyrinthe.getCase(l, c);

                // 1. Couleur de fond

                //Mur
                if (laCase instanceof Mur) {
                    g.setColor(Color.BLACK);
                }
                // Cases vides
                else {
                    g.setColor(Color.GRAY);
                }
                // 2. Dessin du fon(x = colonne * taille, y = ligne * taille)
                if (c==0 && l ==0){
                    g.fillRect(c * tailleCase, l * tailleCase, tailleCase, tailleCase);
                }else{
                    g.fillRect(c * tailleCase, l * tailleCase, tailleCase, tailleCase);
                }


            }
        }
        // Couche 2 : La bille
        g.setColor(Color.BLUE);

        // On récupère les infos de la bille
        double x = bille.getX();
        double y = bille.getY();
        double r = bille.getRayon();

        // Conversion des coordonnées en pixels
        // On recule de r pour que x,y soit bien au milieu

        int xPixel = (int) ((x ) * tailleCase);
        int yPixel = (int) ((y ) * tailleCase);

        // Calcul de la taille en pixels (diamètre)
        int diametrePixel = (int) (2 * r * tailleCase);

        // Dessin
        g.fillOval(xPixel, yPixel, diametrePixel, diametrePixel);

        // Faire bouger la bille quand la souris est en jeu (Pause)
        if (events.enjeu) {
            this.events.MouseNothing();
            this.bille.updateX(bille.getVx());
            this.bille.updateY(bille.getVy());
        }


        // Partie collision
        // parcourir tout les blocks pour savoir où la collision a eu lieu
        for (int l = 0; l < hauteur; l++) {
            for (int c = 0; c < largeur; c++) {

                Square s = this.labyrinthe.getCase(l , c);


                if (s instanceof Mur) {
                    Mur mur = (Mur) s;
//                    System.out.println("l"+l);        // Débogage
//                    System.out.println("c"+c);        // Débogage

                    if (mur.touch(bille) && !tempb) {

                        mur.switchV(bille, tailleCase);
                        tempb = true;


                    }

                }
            }

        }



    }

    public static int getTailleCase() {
        return tailleCase;
    }

    public static Bille getBille() {
        return bille;
    }
}