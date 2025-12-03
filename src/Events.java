import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Events implements MouseMotionListener, MouseListener {
    public boolean enjeu;

    public Bille bille;
    protected  int sx, sy;
    private double tailleCase;
    private MouseEvent mouseEvent;

    public Events(Bille bille, double tailleCase) {
        this.enjeu = false;

        this.bille = bille;
        this.sy = 0;
        this.sx = 0;
        this.tailleCase = tailleCase;
    }
    public void MouseNothing() {
        if (this.mouseEvent != null) {
            this.mouseMoved(this.mouseEvent);
            this.bille.frottement();
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if (enjeu) {
            this.sx = e.getX();
            this.sy = e.getY();

            int xPixel = (int) ((bille.getX() * this.tailleCase));
            int yPixel = (int) ((bille.getY() * this.tailleCase));
            this.bille.calculateVx(sx - xPixel);
            this.bille.calculateVy(sy - yPixel);
            this.mouseEvent = e;









        }
    }

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

