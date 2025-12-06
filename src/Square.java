public abstract class Square {

    private final int lig, col;

    public Square(int lig, int col) {
        this.lig = lig;
        this.col = col;
    }

    public int getCol() {
        return col;
    }
    public int getLig() {
        return lig;
    }

    public abstract boolean isEmpty();
    public abstract void enter(Bille b);
    public abstract void leave(Bille b);


    //Savoir quand il y a contact avec la bille
    public boolean touch(Bille b) {
        //        int tauxcorrection = (FenetreJeu.getTailleCase()/100);

        // rayon en pixel : 5
        //taille case en pixel : 10
//        System.out.println(bille.getRayon());
//        System.out.println("getLig : " + (super.getCol() * FenetreJeu.getTailleCase() + FenetreJeu.getTailleCase()));
//        System.out.println("YBALL : " + (bille.getY()) * FenetreJeu.getTailleCase());
//        System.out.println("dif 1 :" + ((super.getCol() * FenetreJeu.getTailleCase() ) - (int) ((bille.getX() +2 * bille.getRayon()) * FenetreJeu.getTailleCase() )));
//        System.out.println("dif 2 :" + ((super.getCol() * FenetreJeu.getTailleCase() + FenetreJeu.getTailleCase()) - (int) ((bille.getX() + 2 * bille.getRayon()) * FenetreJeu.getTailleCase() )));
//        System.out.println("dif 3 :!" + ((super.getLig() * FenetreJeu.getTailleCase() ) - (int) ((bille.getY() + bille.getRayon() ) * FenetreJeu.getTailleCase())));
//        System.out.println("dif 4 :!"+ ((super.getLig() * FenetreJeu.getTailleCase() + FenetreJeu.getTailleCase()) - (int) ((bille.getY()+ bille.getRayon() ) * FenetreJeu.getTailleCase())));
//    / /   / /   o        /  /                     /  /       /
//                        / /                    ()        / /
        //                  _
        //                 o_
        //
        //  System.out.println(bille.getVx());

        // Collision par la Gauche
        if (((getCol() * FenetreJeu.getTailleCase()) - (int) ((FenetreJeu.getBille().getX() + 2 * FenetreJeu.getBille().getRayon()) * FenetreJeu.getTailleCase())  <= 0)
                && ((getCol() * FenetreJeu.getTailleCase() + FenetreJeu.getTailleCase()) - (int) (FenetreJeu.getBille().getX() * FenetreJeu.getTailleCase())>= 0)
                && ((getLig() * FenetreJeu.getTailleCase() ) - (int) ((FenetreJeu.getBille().getY() + FenetreJeu.getBille().getRayon()) * FenetreJeu.getTailleCase()) <= 0)
                && ((getLig() * FenetreJeu.getTailleCase() + FenetreJeu.getTailleCase()) - (int) ((FenetreJeu.getBille().getY() + FenetreJeu.getBille().getRayon() ) * FenetreJeu.getTailleCase()) >= 0)) {
            //System.out.println("PASSSSSSSSSSSS");
            return true;

            // Collision par la Droite
        } else if (((getCol() * FenetreJeu.getTailleCase() ) - (int) ((FenetreJeu.getBille().getX() ) * FenetreJeu.getTailleCase())  <= 0)
                && ((getCol() * FenetreJeu.getTailleCase() + FenetreJeu.getTailleCase()) - (int) ((FenetreJeu.getBille().getX() + 2 * FenetreJeu.getBille().getRayon()) * FenetreJeu.getTailleCase())>= 0)
                && ((getLig() * FenetreJeu.getTailleCase() ) - (int) ((FenetreJeu.getBille().getY() + FenetreJeu.getBille().getRayon()) * FenetreJeu.getTailleCase()) <= 0)
                && ((getLig() * FenetreJeu.getTailleCase() + FenetreJeu.getTailleCase()) - (int) ((FenetreJeu.getBille().getY() + FenetreJeu.getBille().getRayon() ) * FenetreJeu.getTailleCase()) >= 0)) {
            System.out.println("PASSSSSSSSSSSS2");
            return true;
        } else {
            FenetreJeu.tempb=false;

            return false;
        }
    }

    public abstract String toString();
}
