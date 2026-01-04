//---------------------CASE DE SORTIE--------------------------------//

import javax.swing.*;

public class FakeEnd extends Square{

    // Constructeur de la case
    public FakeEnd(int l,int c){
        super(l,c);
    }

    // Concrétisation des méthodes abstraites
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enter(Bille b) {

    }

    @Override
    public void leave(Bille b) {

    }

    @Override
    public String toString() {
        return "w";
    }
}