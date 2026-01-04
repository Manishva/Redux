public class End extends Square{
    public End(int l,int c){
        super(l,c);
    }
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enter(Bille b) {
        System.out.println(FenetreJeu.minute +" :" + FenetreJeu.second+ "." + FenetreJeu.chrono);
        System.exit(1);    }

    @Override
    public void leave(Bille b) {

    }

    @Override
    public String toString() {
        return "e";
    }
}
