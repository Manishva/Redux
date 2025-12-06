import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Events implements MouseMotionListener, MouseListener {
    public boolean enjeu;

    public Bille bille;
    protected  int sx, sy;
    private double tailleCase;
    private MouseEvent lastMouseEvent;

    // Créer les événements pour les lier au jeu
    public Events(Bille bille, double tailleCase) {
        this.enjeu = false;

        this.bille = bille;
        this.sy = 0;
        this.sx = 0;
        this.tailleCase = tailleCase;
    }
    // Quand la souris est statique, la bille se rapproche d'elle quand meme
    public void MouseNothing() {
        if (this.lastMouseEvent != null) {

            this.mouseMoved(this.lastMouseEvent);
            this.sx = lastMouseEvent.getX();
            this.sy = lastMouseEvent.getY();
//            System.out.println("BIP : "+this.sx + " " + this.sy);

            int xPixel = (int) (((bille.getX() - bille.getRayon()) * this.tailleCase) + 25);
            int yPixel = (int) (((bille.getY() - bille.getRayon()) * this.tailleCase) + 45);
//            System.out.println("xPixel : "+xPixel);
//            System.out.println("yPixel : "+yPixel);
            this.bille.calculateVx(sx - xPixel );
            this.bille.calculateVy(sy - yPixel );
//            System.out.println("dif 1 :" + (sx - xPixel));
//            System.out.println("dif 2 :" + (sy - yPixel));
//            System.out.println("bille : "+this.bille.getV());
            this.bille.frottement();
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
//  récupérer les données de la souris pour les utiliser dans la méthode MouseNothing()
    @Override
    public void mouseMoved(MouseEvent e) {

        if (enjeu) {
            // test pour centrer la bille dans la souris au repos
            if (e != lastMouseEvent){
                this.lastMouseEvent = e;
//            }else{
//
//              System.out.println( this.sx + " " + this.sy );
            }




        }
    }
//  pour detacher la souris du jeu
    @Override
    public void mouseClicked(MouseEvent e) {
        if (enjeu) {
            this.enjeu = false;
        }else{
            this.enjeu = true;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

