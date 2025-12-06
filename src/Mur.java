public class Mur extends Square {

    public Mur(int lig, int col) {
        super(lig, col);
    }




    @Override
    public String toString() {
        return "###";
    }

    // switcher la vitesse quand il y a contact
    public void switchV(Bille bille, int tailleCase) {
        if (((super.getCol() * tailleCase ) - (int) ((bille.getX() + 2 * bille.getRayon()) * tailleCase)  <= 0)
                && ((super.getCol() * tailleCase + tailleCase) - (int) ((bille.getX() + 2 * bille.getRayon()) * tailleCase)>= 0)
        ) {
          //  System.out.println("SWICTH");
            bille.switchVX();


        } else if (((super.getCol() * tailleCase ) - (int) ((bille.getX() ) * tailleCase)  <= 0)
                && ((super.getCol() * tailleCase + tailleCase) - (int) ((bille.getX() ) * tailleCase)>= 0)) {
              System.out.println("SWICTH");
            bille.switchVX();



//        } else if (((super.getCol() * tailleCase + tailleCase - (int) (bille.getY()+ bille.getRayon())*tailleCase) <= 0)
//                && ((super.getCol() * tailleCase ) - (int) (bille.getY()+ bille.getRayon()) * tailleCase >= 0)) {
//            bille.switchVY();
//            return true;


        }else {
            return;
        }



    }

    @Override
    public boolean isEmpty(){
        return false;
    }

    @Override
    public void enter(Bille b){

    }

    @Override
    public void leave(Bille b){

    }

}
