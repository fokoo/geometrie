public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Point firstPoint, Point secondPoint) {
        Point vector = secondPoint.subtract(firstPoint);
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    Vector add(Vector vector){
        double x = this.x+vector.x;
        double y = this.y+vector.y;
        return new Vector(x,y);
    }

    Vector multiply(double coef){
        double x = coef*this.x;
        double y = coef*this.y;
        return new Vector(x,y);
    }

    Vector normalized(){
        if(x==0 && y==0){
            return this;
        }
        double norm = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        return multiply(1/norm);
    }
}
