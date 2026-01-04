import static java.lang.Math.sqrt;

public class Bille {

    private double x, y;
    private double vx, vy, v;
    protected static final double r = 0.3;
    protected static double f = 0.0005;
    private double a = 0.00005;
    private double maxSpeed = 0.25;


    // Constructeur de la Bille
    public Bille(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getRayon() {
        return this.r;
    }

    public double getVx() {
        return this.vx;
    }

    public double getVy() {
        return this.vy;
    }

    public double getV() {
        return sqrt(this.vx * this.vx + this.vy * this.vy);
    }

    public void switchVX() {
        this.vx = -1*this.vx;
        //    System.out.println("vx: " + this.vx);
    }
    public void switchVY() {

        this.vy = -1*this.vy;
        System.out.println("vy: " + this.vy);
    }

    // Calcul de la vitesse en fonction des frottements
    public void frottement(){
        this.vx = this.vx * (1-(this.f/this.getV()));
        this.vy = this.vy * (1-(this.f/this.getV()));
    }


    // calcul la norme de la vitesse pour l'utiliser dans des calcul
    public void setV(double vx, double vy) {
        this.v = sqrt(this.vx * this.vx + this.vy * this.vy);
    }
    // Déplacement de la Bille
    public void updateX(double vx) {
        this.x = this.x + vx;
    }

    public void updateY(double vy){
        this.y = this.y + vy ;
    }


    // Prends les écarts (sx, sy) entre la souris et la bille en paramètre et les ajoute à la vitesse après pondération des frottements
    public void updateVx(int sx) {

        if (getV() < maxSpeed){
            this.vx = this.vx + sx*a;
        }



    }

    public void updateVy(int sy) {

        if (getV() < maxSpeed){
            this.vy = this.vy + sy*a;
        }



    }
/*
    public void updateVy(int sy) {
        if (Square.isInside && ((getVy() > -0.01 ) && ( getVy() < 0.01))){
            this.vy = 0;
            System.out.println("WWW");
        }else {
            if (getV() < maxSpeed) {
                System.out.println("???" + Square.isInside);
                this.vy = this.vy + sy * a;
            }
        }
    }
*/
}