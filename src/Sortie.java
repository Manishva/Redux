public class Sortie extends Square {

    public Sortie(int lig, int col) {
        super(lig, col);
    }

    @Override
    public String toString() {
        return "( )";
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