public class Sortie extends Square {

    public Sortie(int lig, int col) {
        super(lig, col);
    }

    public boolean estLibre() {
        return true;
    }

    public String toString() {
        return "( )";
    }
}