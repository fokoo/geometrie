public class Line {
    Point originPoint;
    Vector direction;
    //Point endPoint;

   /* public Line() {
        this.originPoint = new Point();
        this.endPoint = new Point(1, 1);
        this.direction = new Vector(this.originPoint, this.endPoint);
    }*/

    public Line(Point point, Vector direction) {
        this.originPoint = point;
        this.direction = direction;
        //this.endPoint = new Point(direction.getX()+point.getX(), direction.getY()+point.getY());
    }

    public Line(Point firstPoint, Point secondPoint) {
        this.originPoint = firstPoint;
        //this.endPoint = secondPoint;
        this.direction = new Vector(firstPoint, secondPoint);
    }

    @Override
    public String toString() {
        return "Line{" +
                "originPoint=" + originPoint +
                ", direction=" + direction +
                '}';
    }

    Point getOrigin(){
        return this.originPoint;
    }

    Vector getDirection(){
        return this.direction.normalized();
    }

    boolean isParallel(Line line){
        //System.out.println(line.direction.getY()*this.direction.getX()-line.direction.getX()*this.direction.getY());
        if(line.direction.getY()*this.direction.getX()-line.direction.getX()*this.direction.getY()==0){
                return !isSameLine(line);

        } else {
                return false;
        }
    }

    private boolean isSameLine(Line line) {
        // x = a_1t_1 + x_1 = a_2t_2 + x_2   ==> x_1-x_2 = a_2t_2 if same line
        // y = b_1t_1 + y_1 = b_2t_2 + y_2
        return (Math.abs((this.originPoint.getX()-line.originPoint.getX())*line.direction.getY() -
                (this.originPoint.getY()-line.originPoint.getY())*line.direction.getX() ) < 0.00001);
    }

    Point getIntersection(Line line){
        double dn, en, x, y, t1, t2, a1, a2, b1, b2;
       /* if(isParallel(line)){
            return null;
        }*/
        // matrix entries
        a1 = this.direction.getX();
        a2 = line.direction.getX();
        b1 = this.direction.getY();
        b2 = line.direction.getY();
        x = line.originPoint.getX()-this.originPoint.getX();
        y = line.originPoint.getY()-this.originPoint.getY();
        dn = b1*a2-a1*b2;
        if(dn==0){
            if(isSameLine(line)){
                if(this.equals(line)) {
                    System.out.println("Same line");
                    return null;
                }
                    /*  if(!isSameSegment(line)){
                    return null;
                }
                System.out.println("Beide Linien sind uebereinander");
                return this.originPoint;*/

                ///return sameSegmentPoint(line);
                System.out.println("Beide Linien sind auf selben Gerade, also der Schnitt ist ein Linie, " +
                        "zudem der " + interPointSameLine(this, line) + " gehört");
                return interPointSameLine(this, line);
            }
            return null;
        } else if(a1==0) {
            t2 = -x/a2;
            t1 = (y+line.direction.getY()*t2)/this.direction.getY();
            if(t1>1 || t1<0 || t2>1 || t2<0){
                return null;
            }
            System.out.println("a1= " + a1);
            return new Point(this.originPoint.getX(), b2*t2 + line.originPoint.getY());
        } else {
            en = -x*b1 + y*a1;
            t2 = en/dn;
            t1 = (x+line.direction.getX()*t2)/this.direction.getX();
            if(t1>1 || t1<0 || t2>1 || t2<0){
                return null;
            }
            return new Point(a1*t1 + this.originPoint.getX(), b1*t1 + this.originPoint.getY() );
        }
    }

/*    private boolean isSameSegment(Line segment) {
        double s1 = getEndPoint(this).getY()-this.originPoint.getY();
        double s2 = getEndPoint(segment).getY()-segment.originPoint.getY();
        double max1 = Math.max(getEndPoint(segment).getY(),segment.originPoint.getY());
        double min1 = Math.min(getEndPoint(this).getY(),this.originPoint.getY());
        double min2 = Math.min(getEndPoint(segment).getY(),segment.originPoint.getY());
        double max2 = Math.max(getEndPoint(this).getY(),this.originPoint.getY());
        double s = s1 + s2;
        if(max1>max2) {
            double m =max1-min1;
            System.out.println("s: "+ s + ", m: " + m);
            System.out.println(max1-min1<=s);
            return max1-min1<=s;//Math.abs(Math.max(s, max1 - min1)-s) < 0.00001;
        } else {
            double m =max2-min2;
            System.out.println("s: "+ s + ", m: " + m);
            return max2-min2<=s;//Math.abs(Math.max(s, max2 - min2)-s) < 0.00001;
        }
    }*/

   /* private Point sameSegmentPoint(Line segment) {
        double s1 = Math.abs(getEndPoint(this).getY()-this.originPoint.getY());
        double s2 = Math.abs(getEndPoint(segment).getY()-segment.originPoint.getY());
        double max1 = Math.max(getEndPoint(segment).getY(),segment.originPoint.getY());
        double min1 = Math.min(getEndPoint(this).getY(),this.originPoint.getY());
        double min2 = Math.min(getEndPoint(segment).getY(),segment.originPoint.getY());
        double max2 = Math.max(getEndPoint(this).getY(),this.originPoint.getY());
        double s = s1 + s2;
        if(max1>=max2) {
            double m =max1-min1;
            if(m<=s){
               *//* if(getEndPoint(segment).getY() <= segment.originPoint.getY()){
                    return getEndPoint(segment);
                }
                return segment.getOrigin();*//*
               return getSameLineInterPoint(this, segment);
            } else {
                return null;
            }
        } else {
            double m =max2-min2;
            if(m<=s){
                return getSameLineInterPoint(this, segment);
               *//* if(getEndPoint(this).getY() <= this.originPoint.getY()){
                    return getEndPoint(this);
                }
                return this.getOrigin();*//*
            } else {
                return null;
            }
        }
    }
*/
    // x = a_1t_1 + x_1 = a_2t_2 + x_2   ==> t_2(x_1) =(x_1-x_2)/a_2  if same line
    // y = b_1t_1 + y_1 = b_2t_2 + y_2
  /*  private Point getSameLineInterPoint(Line line1, Line line2) {
        double t1, t2, t1_, t2_;
        double a1 = line1.direction.getX();
        double a2 = line2.direction.getX();
        double b1 = line1.direction.getY();
        double b2 = line2.direction.getY();
        double x1 = line1.getOrigin().getX();
        double y1 = line1.getOrigin().getY();
        double x2 = line2.getOrigin().getX();
        double y2 = line2.getOrigin().getY();
        double x = x2-x1;
        double y = y2-y1;
        double x1_ = getEndPoint(line1).getX();
        double y1_ = getEndPoint(line1).getY();
        if(a2!=0 && a1==0){
           t2 = -x/a2;
           t2_ = (x1_-x2)/a2;
           if(Math.abs(t2)<=1) {
               return line1.getOrigin();
           } else if(Math.abs(t2_)<=1) {
               return getEndPoint(line1);
           }
        } else if(a1!=0 && a2==0){
            t1 = x/a1;
            t1_ = (x1_-x2)/a2;
            if(Math.abs(t1)<=1) {
                return line2.getOrigin();
            } else if(Math.abs(t1_)<=1) {
                return getEndPoint(line2);
            }
        }else if(a1==0 && a2==0){
            if(x1==0){
                if(Math.abs(x)<)
                return null;
            }else if(y1==0){
                return null;
            }
        }
        return null;
    }*/
    private Point interPointSameLine(Line line1, Line line2) {
        if(line1.computeT(line2.originPoint)<=1 && line1.computeT(line2.originPoint)>=0){
            return line2.originPoint;
        }
        if(line1.computeT(getEndPoint(line2))<=1 && line1.computeT(getEndPoint(line2))>=0){
            return getEndPoint(line2);
        }
        if(line2.computeT(line1.originPoint)<=1 && line2.computeT(line1.originPoint)>=0){
            return line1.originPoint;
        }
        if(line2.computeT(getEndPoint(line1))<=1 && line2.computeT(getEndPoint(line1))>=0){
            return getEndPoint(line1);
        }
        return null;
    }

      //x = a_1t_1 + x_1 = a_2t_2 + x_2   ==> t_2(x_1) =(x_1-x_2)/a_2  if same line
      // y = b_1t_1 + y_1 = b_2t_2 + y_2
    // x = at + x1  ==> t(x) =(x-x1)/a
    // y = bt + y1
    // dn = b1*a2-a1*b2;
    private double computeT(Point point){
        double t=-2;
        double a, b, x1, y1, x, y;
          a = this.direction.getX();
          b = this.direction.getY();
          x1 = this.getOrigin().getX();
          y1 = this.getOrigin().getY();
          x = point.getX();
          y = point.getY();
          if (a != 0) {
              //System.out.println("t: "+ (x-x1)/a );
              return (x-x1)/a;
          }
          if (b != 0) {
              //System.out.println("t: "+ (y-y1)/a );
              return (y-y1)/a;
          }
        //System.out.println("t: "+ t );
        return t;
    }

    private Point getEndPoint(Line line) {
        return new Point(direction.getX()+line.originPoint.getX(), direction.getY()+line.originPoint.getY());
    }
}
