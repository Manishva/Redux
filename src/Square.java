public abstract class Square {

    private final int lig, col;

    public Square(int lig, int col) {
        this.lig = lig;
        this.col = col;
    }

    public int getCol() {
        return col;
    }
    public int getLig() {
        return lig;
    }
    public abstract boolean estLibre(Bille bille, int tailleCase);
    public abstract String toString();
    public abstract boolean Contact( Bille bille, int tailleCase);
}
