package sprites;

public class BaseEntity {
    double x,y,proximity;
    public BaseEntity(double xPosition, double yPosition, double Proximity) {
        x = xPosition;
        y = yPosition;
        this.proximity = proximity;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getProximity(){
        return y;
    }
    public void offsetAllX(double val){
        x += val;
    }
    public void offsetAllY(double val){
        y += val;
    }
}
