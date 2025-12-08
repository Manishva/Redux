public class Mur extends Square {

    public Mur(int y, int x) {
        super(y, x);
    }




    @Override
    public String toString() {
        return "###";
    }

    // switcher la vitesse quand il y a contact
    public void switchV(Bille b, int tailleCase) {
        if (((super.getx() * tailleCase ) - (int) ((b.getX() + 2 * b.getRayon()) * tailleCase)  <= 0)
                && ((super.getx() * tailleCase + tailleCase) - (int) ((b.getX() + 2 * b.getRayon()) * tailleCase)>= 0)
        ) {
          //  System.out.println("SWITCH");
            b.switchVX();


        } else if (((super.getx() * tailleCase ) - (int) ((b.getX() ) * tailleCase)  <= 0)
                && ((super.getx() * tailleCase + tailleCase) - (int) ((b.getX() ) * tailleCase)>= 0)) {
            //System.out.println("SWITCH");
            b.switchVX();


        }if (((gety() * tailleCase) - (int) ((b.getY() + 2 * b.getRayon()) * tailleCase) <= 0)
                &&((gety() * tailleCase + tailleCase) - (int) ((b.getY() + 2 * b.getRayon()) * tailleCase) >= 0)) {
            System.out.println("SWITCH");
            b.switchVY();
        }
//        else if {
//        }



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
