public class MyGeometry {
    public static void main(String[] args) {
        //test subtract in class Point
        Point point1 = new Point();
        Point point2 = new Point(-1, 0);
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point2.subtract(point1));
        System.out.println();
        //test class Vector
        Vector vector1 = new Vector(1, .1);
        Vector vector2 = new Vector(point1, point2);
        System.out.println(vector1.add(new Vector(0,0)));
        System.out.println(vector1.add(vector2));
        System.out.println(vector1.multiply(2));
        Vector vector3 = vector1.normalized();
        System.out.println(Math.sqrt(Math.pow(vector3.getX(),2)+Math.pow(vector3.getY(),2)));
        System.out.println();
        //test class line
        Line line1 = new Line(point1, vector1);
        Point point3 = new Point(0,1);
        Line line2 = new Line(point2, point3);
        System.out.println(line1.getDirection());
        System.out.println(line1.isParallel(line1));
        System.out.println(line2.isParallel(line2));
        System.out.println(line1.isParallel(line2));
        System.out.println(line2);
        System.out.println(new Line(new Point(), new Point(1,1)));
        System.out.println(line2.isParallel(new Line(new Point(), new Point(1,1))));
        System.out.println(line1.getIntersection(line1));
        System.out.println(line2.getIntersection(line2));
        System.out.println(line1.getIntersection(line2));
        Line line3 = new Line(new Point(-1,0), new Point(1,2));
        Line line4 = new Line(new Point(-1,2), new Point(1,0));
        System.out.println(line3.getIntersection(line4));
        Line line5 = new Line(new Point(-1,0), new Point(1,0));
        Line line6 = new Line(new Point(0,-1), new Point(0,1));
        System.out.println(line5.getIntersection(line6));
        Line line7 = new Line(new Point(0,0), new Point(10,10));
        Line line8 = new Line(new Point(2,2), new Point(16,4));
        System.out.println(line7.getIntersection(line8));
        Line line9 = new Line(new Point(0,0), new Point(-2,0));
        Line line10 = new Line(new Point(-2,-2), new Point(-2,2));
        System.out.println(line9.getIntersection(line10));
        Line line11 = new Line(new Point(0,4), new Point(4,4));
        Line line12 = new Line(new Point(4,0), new Point(4,8));
        System.out.println(line11.getIntersection(line12));
        Line line13 = new Line(new Point(0,0), new Point(16,16));
        Line line14 = new Line(new Point(4,4), new Point(8,8));
        System.out.println(line11.getIntersection(line12));
        Line line15 = new Line(new Point(4,4), new Point(12,12));
        Line line16 = new Line(new Point(6,8), new Point(8,10));
        System.out.println(line15.getIntersection(line16));
        Line line17 = new Line(new Point(0,0), new Point(-4,6));
        Line line18 = new Line(new Point(-4,2), new Point(-8,8));
        System.out.println(line17.getIntersection(line18));
        Line line19 = new Line(new Point(0,0), new Point(0,2));
        Line line20 = new Line(new Point(4,4), new Point(4,6));
        System.out.println(line19.getIntersection(line20));
        Line line21 = new Line(new Point(0,0), new Point(0,2));
        Line line22 = new Line(new Point(4,4), new Point(6,4));
        System.out.println(line21.getIntersection(line22));
        Line line23 = new Line(new Point(-2,-2), new Point(4.5,4.5));
        Line line24 = new Line(new Point(6,6), new Point(10,10));
        System.out.println(line23.getIntersection(line24));
        Line line25 = new Line(new Point(0,0), new Point(2,2));
        Line line26 = new Line(new Point(4,0), new Point(1,4));
        System.out.println(line21.getIntersection(line22));
        Line line27 = new Line(new Point(2,2), new Point(8,2));
        Line line28 = new Line(new Point(4,4), new Point(6,4));
        System.out.println(line27.getIntersection(line28));
        Line line29 = new Line(new Point(4,2), new Point(4,4));
        Line line30 = new Line(new Point(0,8), new Point(10,0));
        System.out.println(line29.getIntersection(line30));
        Line line31 = new Line(new Point(-2,-2), new Point(5,5));
        Line line32 = new Line(new Point(5,5), new Point(10,10));
        System.out.println(line31.getIntersection(line32));
        Line line33 = new Line(new Point(-2,-2), new Point(6,6));
        Line line34 = new Line(new Point(4,4), new Point(10,10));
        System.out.println(line33.getIntersection(line34));
        Line line35 = new Line(new Point(10,10), new Point(-2,-2));
        Line line36 = new Line(new Point(4,4), new Point(5,5));
        System.out.println(line35.getIntersection(line36));
        Line line37 = new Line(new Point(3,1), new Point(8,3));
        Line line38 = new Line(new Point(2,4), new Point(6,10));
        System.out.println(line37.getIntersection(line38));
    }
}