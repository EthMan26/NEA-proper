package sprites;

public class BaseEntity {
    double x,y,proximity;
    EntityManager EM;
    public BaseEntity(EntityManager EM,double xPosition, double yPosition, double Proximity) {
        x = xPosition;
        y = yPosition;
        this.EM = EM;
        this.proximity = Proximity;
        EM.addTooBaseEntities(this);
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getProximity(){
        return proximity;
    }
    public void offsetAllX(double val){
        x += val;
    }
    public void offsetAllY(double val){
        y += val;
    }
}
