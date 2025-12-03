public class Mur extends Square {

    public Mur(int lig, int col) {
        super(lig, col);
    }

    @Override
    public boolean estLibre(Bille bille, int tailleCase) {
        if ((bille.getX()-2*bille.getRayon())*tailleCase-super.getLig() < 0  ){

            return true;
        } else if ((bille.getY()-1*bille.getRayon())*tailleCase-super.getCol() < 0  ) {

            return true;
        } else if (false) {
            FenetreJeu.tempb = false;
            return false;
        } else if (false) {
            FenetreJeu.tempb = false;
            return false;
        }else {
            FenetreJeu.tempb = false;

            return false;
        }
    }

    @Override
    public String toString() {
        return "###";
    }

    @Override
    public boolean Contact(Bille bille, int tailleCase) {
        
        if ((bille.getX()-2*bille.getRayon())*tailleCase-super.getLig() < 0  ){
            System.out.println(super.getLig()*tailleCase);
            System.out.println((bille.getX()-bille.getRayon())*tailleCase);

            System.out.println("0 : "+ ((bille.getX()-bille.getRayon())*tailleCase-super.getLig()*tailleCase));
            System.out.println("BIP1");
            bille.switchVX();
            return true;
        } else if ((bille.getY()-2*bille.getRayon())*tailleCase-super.getCol() < 0  ) {
            System.out.println("BIPPPPPPPPPPPPPPPP2");
            bille.switchVY();
            return true;


        } else if ((bille.getX()+bille.getRayon())*tailleCase+super.getLig() < 0) {
            System.out.println("BIXXXXXXXXXXXX3");
            bille.switchVX();
            return true;
        } else if (false) {
            return false;
        }else {
            return false;
        }



    }
}