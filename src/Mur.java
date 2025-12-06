public class Mur extends Square {

    public Mur(int lig, int col) {
        super(lig, col);
    }


    // Savoir quand il y a Contact avc la bille
    @Override
    public boolean Contact(Bille bille, int tailleCase) {
//        int tauxcorrection = (tailleCase/100);

        // rayon en pixel : 5
        //taille case en pixel : 10
//        System.out.println(bille.getRayon());
//        System.out.println("getLig : " + (super.getCol() * tailleCase + tailleCase));
//        System.out.println("YBALL : " + (bille.getY()) * tailleCase);
//        System.out.println("dif 1 :" + ((super.getCol() * tailleCase ) - (int) ((bille.getX() +2 * bille.getRayon()) * tailleCase )));
//        System.out.println("dif 2 :" + ((super.getCol() * tailleCase + tailleCase) - (int) ((bille.getX() + 2 * bille.getRayon()) * tailleCase )));
//        System.out.println("dif 3 :!" + ((super.getLig() * tailleCase ) - (int) ((bille.getY() + bille.getRayon() ) * tailleCase)));
//        System.out.println("dif 4 :!"+ ((super.getLig() * tailleCase + tailleCase) - (int) ((bille.getY()+ bille.getRayon() ) * tailleCase)));

      //  System.out.println(bille.getVx());
        if (((super.getCol() * tailleCase ) - (int) ((bille.getX() + 2 * bille.getRayon()) * tailleCase)  <= 0)
                && ((super.getCol() * tailleCase + tailleCase) - (int) ((bille.getX() + 2 * bille.getRayon()) * tailleCase)>= 0)
                && ((super.getLig() * tailleCase ) - (int) ((bille.getY() + bille.getRayon()) * tailleCase) <= 0)
                && ((super.getLig() * tailleCase + tailleCase) - (int) ((bille.getY() + bille.getRayon() ) * tailleCase) >= 0)) {
            //System.out.println("PASSSSSSSSSSSS");


            return true;
       } else if (((super.getCol() * tailleCase ) - (int) ((bille.getX() ) * tailleCase)  <= 0)
                && ((super.getCol() * tailleCase + tailleCase) - (int) ((bille.getX() ) * tailleCase)>= 0)
                && ((super.getLig() * tailleCase ) - (int) ((bille.getY() + bille.getRayon()) * tailleCase) <= 0)
                && ((super.getLig() * tailleCase + tailleCase) - (int) ((bille.getY() + bille.getRayon() ) * tailleCase) >= 0)) {
                System.out.println("PASSSSSSSSSSSS");
                return true;
        } else {
            FenetreJeu.tempb=false;

            return false;
        }
    }

    @Override
    public String toString() {
        return "###";
    }
    // switcher la vitesse quand il y a contact
    @Override
    public boolean switchV(Bille bille, int tailleCase) {
        if (((super.getCol() * tailleCase ) - (int) ((bille.getX() + 2 * bille.getRayon()) * tailleCase)  <= 0)
                && ((super.getCol() * tailleCase + tailleCase) - (int) ((bille.getX() + 2 * bille.getRayon()) * tailleCase)>= 0)
        ) {
          //  System.out.println("SWICTH");
            bille.switchVX();

            return true;


        } else if (((super.getCol() * tailleCase ) - (int) ((bille.getX() ) * tailleCase)  <= 0)
                && ((super.getCol() * tailleCase + tailleCase) - (int) ((bille.getX() ) * tailleCase)>= 0)) {
              System.out.println("SWICTH");
            bille.switchVX();
            return true;



//        } else if (((super.getCol() * tailleCase + tailleCase - (int) (bille.getY()+ bille.getRayon())*tailleCase) <= 0)
//                && ((super.getCol() * tailleCase ) - (int) (bille.getY()+ bille.getRayon()) * tailleCase >= 0)) {
//            bille.switchVY();
//            return true;


        }else {
            return false;
        }



    }

}
