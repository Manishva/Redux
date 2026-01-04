//---------------------FENETRE DU JEU--------------------------------//

import javax.swing.*;
import java.awt.*;

public class FenetreJeu extends JPanel {
    private final Labyrinthe labyrinthe;
    private static Bille bille;
    private static final int tailleCase = 30;
    private final int hauteur, largeur;
    protected JFrame frame;
    private Events events;
    private JLabel label;
    public static boolean tempb;
    public static long chrono;
    static int second;
    static int minute;
    protected static int lvlid = 2;


    public FenetreJeu(Labyrinthe l, Bille bille) {

        this.labyrinthe = l;
        this.bille = bille;
        this.hauteur = l.getHauteur();
        this.largeur = l.getLargeur();
        this.second = 0;
        this.minute = 0;

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
        this.label = new JLabel("Redux");
        frame.getContentPane().add(label, BorderLayout.SOUTH);
        label.setText(String.valueOf(chrono));
        label.setFont(new Font("Arial", Font.BOLD, 21));








    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        chrono = chrono + PlayButton.tempo;


        if (chrono >= 1000) {
            chrono = chrono - 1000;
            second++;
        }
        if (second >= 60) {
            second = 0;
            minute++;
        }




        label.setText(String.valueOf(minute +" :" + second+ "." + chrono));






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
                } else if (laCase instanceof End){
                    g.setColor(Color.GREEN);
                }else if(laCase instanceof FakeEnd){
                    g.setColor(Color.GREEN);
                }else if (laCase instanceof Freeze)
                    g.setColor(new Color(0,0,182,155));
                // Cases vides
                else {
                    g.setColor(Color.GRAY);
                }
                // 2. Dessin du fon(x = colonne * taille, y = ligne * taille)
                g.fillRect(c * tailleCase, l * tailleCase, tailleCase, tailleCase);


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
        // On parcourt tous les blocs pour savoir où une collision a lieu
        for (int l = 0; l < hauteur; l++) {
            for (int c = 0; c < largeur; c++) {

                Square s = this.labyrinthe.getCase(l , c);


                if (s instanceof Mur) {
                    Mur mur = (Mur) s;
//                    System.out.println("l"+l);        // Débogage
//                    System.out.println("c"+c);        // Débogage

                    if (mur.touch(bille) /*&& !tempb*/) {


                        System.out.println(tempb);

                        mur.switchV(bille, tailleCase);
                        //tempb = true;



                    }

                } else if(s instanceof End){
                    End end = (End) s;
                    if (end.touch(bille) && !tempb) {
                        end.enter(bille);
                    }

                }else if(s instanceof Freeze){
                    Freeze freeze = (Freeze) s;
                    if (freeze.touch(bille) && !tempb) {
                        freeze.enter(bille);
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