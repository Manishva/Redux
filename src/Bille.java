import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import static java.lang.Math.sqrt;

public class Bille {

    private double x, y;
    private double vx, vy, v;
    private double r = 0.3;
    private double f;


    public Bille(double x, double y, double f) {
        this.x = x;
        this.y = y;
        this.f = 0.00007;

    }

    public double getF() {
        return f;
    }
    public void setF(double f) {
        this.f = f;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getRayon() {
        return this.r;
    }
    public void switchVX() {
        this.vx = -1*this.vx;
        System.out.println("vx: " + this.vx);
    }
    public void switchVY() {

        this.vy = -1*this.vy;
        System.out.println("vy: " + this.vy);
    }

    public void frottement(){
        this.vx = this.vx * (1-(this.f/this.getV()));
        this.vy = this.vy * (1-(this.f/this.getV()));
    }
    public double getVx() {
        return this.vx;
    }
    public void updateX(double vx){
        this.x = this.x + vx;
    }
    public void updateY(double vy){
        this.y = this.y + vy;
    }

    public double getVy() {
        return this.vy;
    }

    public double getV() {
        setV(vx, vy);
        return this.v;
    }
    public double calculateVx(int sx) {
        this.vx = this.vx + sx*f;
        return this.vx;

    }
    public double calculateVy(int sy) {
        this.vy = this.vy + sy*f;
        return this.vy;
    }
    public void setV(double vx, double vy) {
        this.v = sqrt(vx * vx + vy * vy);
    }
}