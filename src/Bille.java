public class Bille {

    private double x, y;
    private double vx, vy;
    private double r = 0.3;

    public Bille(double x, double y) {
        this.x = x;
        this.y = y;
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
}