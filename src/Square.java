//---------------------CLASSE MODELISANT UNE CASE--------------------------------//

public abstract class Square {

    private final int y, x;
    public static boolean isInside; ;

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

        int tailleCase = FenetreJeu.getTailleCase();


        // Collision par la Gauche
        if (((getx() * tailleCase) - (int) ((b.getX() + 2 * b.getRayon()) * tailleCase)  <= 0)
                && ((getx() * tailleCase + tailleCase) - (int) (b.getX() * tailleCase)>= 0)
                && ((gety() * tailleCase ) - (int) ((b.getY() + b.getRayon()) * tailleCase) <= 0)
                && ((gety() * tailleCase + tailleCase) - (int) ((b.getY() + b.getRayon() ) * tailleCase) >= 0)) {

            //System.out.println("----------GAUCHE-----------");     // Débogage
            isInside = true;
            return true;

            // Collision par la Droite
        } else if (((getx() * tailleCase + tailleCase) - (int) (b.getX() * tailleCase) >= 0)
                && ((getx() * tailleCase ) - (int) (b.getX() * tailleCase)  <= 0)
                && ((gety() * tailleCase ) - (int) ((b.getY() + b.getRayon()) * tailleCase) <= 0)
                && ((gety() * tailleCase + tailleCase) - (int) ((b.getY() + b.getRayon() ) * tailleCase) >= 0)) {

            //System.out.println("----------DROITE-----------");    // Débogage
            isInside = true;
            return true;

            //Collision par le haut
        }else if (((gety() * tailleCase) - (int) ((b.getY() + 2 * b.getRayon()) * tailleCase) <= 0)
                &&((gety() * tailleCase + tailleCase) - (int) ((b.getY() + 2 * b.getRayon()) * tailleCase) >= 0)
                &&((getx() * tailleCase) - (int) ((b.getX() + b.getRayon()) * tailleCase) <= 0)
                &&((getx() * tailleCase + tailleCase) - (int) ((b.getX() + b.getRayon()) * tailleCase) >= 0)){

            //System.out.println("----------HAUT-----------");    // Débogage
            isInside = true;
            return true;

            //Collision par le haut
        }else if (((gety() * tailleCase + tailleCase) - (int) (b.getY() * tailleCase) >= 0)
                &&((gety() * tailleCase) - (int) (b.getY() * tailleCase) <= 0)
                &&((getx() * tailleCase) - (int) ((b.getX() + b.getRayon()) * tailleCase) <= 0)
                &&((getx() * tailleCase + tailleCase) - (int) ((b.getX() + b.getRayon()) * tailleCase) >= 0)){

            //System.out.println("----------BAS-----------");    // Débogage
            isInside = true;
            return true;

    }else {
            //FenetreJeu.tempb=false;
            isInside = false;
            return false;
        }
    }

    public abstract String toString();
}
