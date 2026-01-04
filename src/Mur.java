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
        if (((gety() * tailleCase ) - (int) ((b.getY() + b.getRayon()) * tailleCase) <= 0)
                && ((gety() * tailleCase + tailleCase) - (int) ((b.getY() + b.getRayon() ) * tailleCase) >= 0)) {


            if (((super.getx() * tailleCase) - (int) ((b.getX() + 2 * b.getRayon()) * tailleCase) <= 0)
                    && ((super.getx() * tailleCase + tailleCase) - (int) ((b.getX() + 2 * b.getRayon()) * tailleCase) >= 0)
            ) {
                //  System.out.println("SWITCH");
                b.switchVX();



            } else if (((super.getx() * tailleCase) - (int) ((b.getX()) * tailleCase) <= 0)
                    && ((super.getx() * tailleCase + tailleCase) - (int) ((b.getX()) * tailleCase) >= 0)) {
                //System.out.println("SWITCH");
                b.switchVX();


            }
        }
        if (((getx() * tailleCase) - (int) ((b.getX() + b.getRayon()) * tailleCase) <= 0)
                &&((getx() * tailleCase + tailleCase) - (int) ((b.getX() + b.getRayon()) * tailleCase) >= 0)) {


            if (((gety() * tailleCase) - (int) ((b.getY() + 2 * b.getRayon()) * tailleCase) <= 0)
                    && ((gety() * tailleCase + tailleCase) - (int) ((b.getY() + 2 * b.getRayon()) * tailleCase) >= 0)) {
                System.out.println("SWITCH");
                if (b.getVy()>0){
                    System.out.println("SWITCH VY");
                    b.switchVY();
//                    if (b.getVy()<-0.1){
//                        b.setV(b.getVx(), 0);
//                    }else{
//                        b.switchVY();
//                    }

                }
            } else if (((gety() * tailleCase + tailleCase) - (int) (b.getY() * tailleCase) >= 0)
                    && ((gety() * tailleCase) - (int) (b.getY() * tailleCase) <= 0)) {
                System.out.println("SWITCH2");
                if (b.getVy()<0){
                    System.out.println("SWITCH VY2");
                    b.switchVY();
//                    if (b.getVy()<0.1){
//                        b.setV(b.getVx(), 0);
//                    }else{
//                        b.switchVY();
//                    }
                }

            }
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
