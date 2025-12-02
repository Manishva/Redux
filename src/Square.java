public abstract class Square {

    private final int lig, col;

    public Square(int lig, int col) {
        this.lig = lig;
        this.col = col;
    }

    public abstract boolean estLibre();
    public abstract String toString();
}
