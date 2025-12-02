public class CaseOrdinaire extends Square {

    public CaseOrdinaire(int lig, int col) {
        super(lig, col);
    }

    @Override
    public boolean estLibre() {
        return false;
    }

    @Override
    public String toString() {
        return "   ";
    }
}