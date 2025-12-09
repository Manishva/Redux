public abstract class Square {

    private final int y, x;
    protected boolean switchDirection;

    public Square(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getx() {
        return x;
    }
    public int gety() {
        return y;
    }

    public abstract boolean isEmpty();
    public abstract void enter(Bille b);
    public abstract void leave(Bille b);


    //Savoir quand il y a contact avec la bille
    public boolean touch(Bille b) {

        /*
         Je t'explique les modifs :

         J'ai mis Fenetre.jeu.getTailleCase dans une variable tailleCase pour que ca soit plus lisible.

         Ensuite j'ai enlevé tous les FenêtreJeu.getBille() car si on fait ça on utilise pas le paramètre bille de cette méthode touch(Bille b),
         de plus j'ai vu dans la classe fenetre que t'a appelé cette fonction en prenant comme argument l'attribut bille de la Fenetre donc j'ai utilisé ce paramètre là.
         Donc maintenant tu peux accéder aux méthodes de la Bille b.



         */// TU PEUX EFFACER QUAND T'AS LU C'ETAIT JUSTE POUR TE PREVENIR

        int tailleCase = FenetreJeu.getTailleCase();

        //--------------------Débogage---------------------------------------------------------------------------------------------------------------------------------------------------------------------//
        //        int tauxcorrection = (tailleCase/100);

        // rayon en pixel : 5
        //taille case en pixel : 10
//        System.out.println(b.getRayon());
//        System.out.println("gety : " + (getx() * tailleCase + tailleCase));
//        System.out.println("YBALL : " + (b.getY()) * tailleCase);
//        System.out.println("dif 1 :" + ((getx() * tailleCase) - (int) ((b.getX() + 2 * b.getRayon()) * tailleCase)));
//        System.out.println("dif 2 :" + ((getx() * tailleCase + tailleCase) - (int) ((b.getX() + 2 * b.getRayon()) * tailleCase)));
//        System.out.println("dif 3 :" + ((gety() * tailleCase) - (int) ((b.getY() + b.getRayon()) * tailleCase)));
//        System.out.println("dif 4 :" + ((gety() * tailleCase + tailleCase) - (int) ((b.getY() + b.getRayon()) * tailleCase)));
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//


        //-----------------------------------------------------TENTATIVE 1 Colision gauche----------------------------------------------------------------//
//        if (((getx() - (b.getX() + b.getRayon())) * tailleCase <= 0)                        // Vérifie si la bille a franchi le coté gauche de la case
//            && (((getx() + 1) - ((int) (b.getX() + b.getRayon()))) * tailleCase >= 0)       // Vérifie si la bille a franchi le coté droit de la case                                   //
//            && ((gety() - (b.getY() - b.getRayon())) * tailleCase <= 0)                     // Si j'ai bien compris on vérifie que la bille ne franchit pas la ligne du haut            ()->//
//            && (((gety() + 1) - ((int) (b.getY() + b.getRayon()))) * tailleCase >= 0)) {    // Si j'ai bien compris on vérifie que la bille ne franchit pas la ligne du bas.            //
//            System.out.println("PASSSSSSSSSSSS");     // Débogage
//            return true;

        /* COMMENTAIRE :
         * Première tentative (en utilisant mes neurones) : ca marche pas starfallah*/

        //----------------------------------------------------TENTATIVE 2 Colision gauche-----------------------------------------------------------------//
//        if ((getx() - ((int)(b.getX() + 2 * b.getRayon())) * tailleCase <= 0)
//            && (((getx() + 1) - ((int) b.getX())) * tailleCase >= 0)                          // Ici je comprends pas pk on regarde le bas de la bille lorsqu'on regarde si la bille touche
//            && ((gety() - ((int)(b.getY() + b.getRayon()))) * tailleCase <= 0)                       // le haut de la case -> pk on met un "+" au lieu d'un "-" ici dans b.getY() + b.getRayon() ?????
//            && (((gety() + 1) - ((int) (b.getY() + b.getRayon()))) * tailleCase >= 0)) {
//
//            //System.out.println("PASSSSSSSSSSSS");
//            return true;

        /* COMMENTAIRE :
         * Deuxième tentative (encore avec mes neurones) : J'ai voulu factoriser la variable tailleCase comme tu le vois. J'ai réussi a faire les collisions sur les côtés mais
         * ça m'a créé un mur invisible juste en dessous du vrai mur, je te laisse executer si tu veux étudier tout ça pour optimiser.
         * Du coup je vais continuer sur l'algo de base que tu m'as donné avec les modifications que j'ai faite en terme de variable
         * */

        //--------------------------------------------------TENTATIVE 3 Colisions 4 cotés--------------------------------------------------------------------//
                 // Collision par la Gauche
        if (((getx() * tailleCase) - (int) ((b.getX() + 2 * b.getRayon()) * tailleCase)  <= 0)
                && ((getx() * tailleCase + tailleCase) - (int) (b.getX() * tailleCase)>= 0)                           // Donc pourquoi on fait b.getX() + 2 * b.getRayon() ??? En faisant ça on sort du cercle non ???
                && ((gety() * tailleCase ) - (int) ((b.getY() + b.getRayon()) * tailleCase) <= 0)
                && ((gety() * tailleCase + tailleCase) - (int) ((b.getY() + b.getRayon() ) * tailleCase) >= 0)) {
            //System.out.println("PASSSSSSSSSSSS");     // Débogage
            return true;

            // Collision par la Droite
        } else if (((getx() * tailleCase + tailleCase) - (int) (b.getX() * tailleCase) >= 0)
                && ((getx() * tailleCase ) - (int) (b.getX() * tailleCase)  <= 0)
                && ((gety() * tailleCase ) - (int) ((b.getY() + b.getRayon()) * tailleCase) <= 0)
                && ((gety() * tailleCase + tailleCase) - (int) ((b.getY() + b.getRayon() ) * tailleCase) >= 0)) {
            //System.out.println("PASSSSSSSSSSSS2");    // Débogage
            return true;

            //Collision par le haut
        }else if (((gety() * tailleCase) - (int) ((b.getY() + 2 * b.getRayon()) * tailleCase) <= 0)
                &&((gety() * tailleCase + tailleCase) - (int) ((b.getY() + 2 * b.getRayon()) * tailleCase) >= 0)
                &&((getx() * tailleCase) - (int) ((b.getX() + b.getRayon()) * tailleCase) <= 0)
                &&((getx() * tailleCase + tailleCase) - (int) ((b.getX() + b.getRayon()) * tailleCase) >= 0)){

            System.out.println("HAUTTTTTTTTTT");    // Débogage
            return true;

        }else if (((gety() * tailleCase + tailleCase) - (int) (b.getY() * tailleCase) >= 0)
                &&((gety() * tailleCase) - (int) (b.getY() * tailleCase) <= 0)
                &&((getx() * tailleCase) - (int) ((b.getX() + b.getRayon()) * tailleCase) <= 0)
                &&((getx() * tailleCase + tailleCase) - (int) ((b.getX() + b.getRayon()) * tailleCase) >= 0)){

            System.out.println("BASSSSSSSSSSSS");    // Débogage
            return true;

    }else {
            FenetreJeu.tempb=false;
            return false;
        }
    }

    public abstract String toString();
}
