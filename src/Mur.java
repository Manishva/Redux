public class Mur extends Square {

    public Mur(int lig, int col) {
        super(lig, col);
    }

    @Override
    public boolean estLibre() {
        return false;
    }

    @Override
    public String toString() {
        return "###";
    }
}