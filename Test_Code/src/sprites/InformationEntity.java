package sprites;

public class InformationEntity extends CollisionEntity{
    String text;
    EntityManager EM;
    //default value for looking at text will be used such as thier proximity
    public InformationEntity(EntityManager EM,double xPosition, double yPosition, double Proximity, int imageIndex, double imageXPosition, double imageYPosition, int imageWidth, int imageHeight, double collisionX, double collisionY, int collisionHeight, int collisionWidth, String text) {
        super(EM ,xPosition, yPosition, Proximity, imageIndex, imageXPosition, imageYPosition, imageWidth, imageHeight, collisionX, collisionY, collisionHeight, collisionWidth);
        this.text = text;
        this.EM = EM;
        EM.addTooInformationEntities(this);
    }
    public String getText(){
        return text;
    }
    public boolean inProximity(double playerX, double playerY){
        // for later
        return true;
    }
}
