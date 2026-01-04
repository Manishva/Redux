//---------------------CASE RALENTISSANT--------------------------------//


import javax.swing.*;

public class Freeze extends Square {

    // Constructeur de la case
    public Freeze(int l,int c){
        super(l,c);
    }

    // Concrétisation des méthodes abstraites
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enter(Bille b) {
        Bille.f = 0.005;
        b.frottement();
    }

    @Override
    public void leave(Bille b) {
        Bille.f = 0.0005;
    }

    @Override
    public String toString() {
        return "f";
    }
}
