//---------------------CASE VIDE--------------------------------//

public class CaseOrdinaire extends Square {


    //Constructeur de la case
    public CaseOrdinaire(int lig, int col) {
        super(lig, col);
    }

    // Concrétisation des méthodes abstraites
    @Override
    public String toString() {
        return "   ";
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