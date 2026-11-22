package sprites;

public class CollisionEntity extends ImageEntity{
    double collisionX, collisionY;
    int collisionWidth, collisionHeight;
    EntityManager EM;
    public CollisionEntity(EntityManager EM,double xPosition, double yPosition, double Proximity, int imageIndex, double imageXPosition, double imageYPosition, int imageWidth, int imageHeight, double collisionX, double collisionY, int collisionHeight, int collisionWidth) {
        super(EM ,xPosition, yPosition, Proximity, imageIndex, imageXPosition, imageYPosition, imageWidth, imageHeight);
        this.collisionX = collisionX;
        this.collisionY = collisionY;
        this.collisionWidth = collisionWidth;
        this.collisionHeight = collisionHeight;
        this.EM = EM;
        EM.addTooCollisionEntities(this);
    }
    public double getCollisionX(){
        return collisionX;
    }
    public double getCollisionY(){
        return collisionY;
    }
    public int getCollisionWidth(){
        return collisionWidth;
    }
    public int getCollisionHeight(){
        return collisionHeight;
    }
    public void setCollisionX(double val){
        collisionX = val;
    }
    public void setCollisionY(double val){
        collisionY = val;
    }
    public void setCollisionWidth(double val){
        collisionWidth += val;
    }
    public void setCollisionHeight(double val){
        collisionHeight += val;
    }
    public void offsetCollisionX(double val){
        collisionX += val;
    }
    public void offsetCollisionY(double val){
        collisionY += val;
    }

    @Override
    public void offsetAllX(double val){
        x += val;
        imageX += val;
        collisionX += val;
    }
    @Override
    public void offsetAllY(double val){
        y += val;
        imageY += val;
        collisionY += val;
    }
}
