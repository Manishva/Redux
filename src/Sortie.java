public class Sortie extends Square {

    public Sortie(int lig, int col) {
        super(lig, col);
    }

    public boolean Contact(Bille bille, int tailleCase) {
        return true;
    }

    public String toString() {
        return "( )";
    }

    @Override
    public boolean switchV(Bille bille, int tailleCase) {
        return false;
    }
}