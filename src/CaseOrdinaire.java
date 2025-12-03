public class CaseOrdinaire extends Square {

    public CaseOrdinaire(int lig, int col) {
        super(lig, col);
    }

    @Override
    public boolean estLibre(Bille bille,int tailleCase) {
        return false;
    }

    @Override
    public String toString() {
        return "   ";
    }

    @Override
    public boolean Contact(Bille bille,int taillegrille) {
        return false;
    }
}