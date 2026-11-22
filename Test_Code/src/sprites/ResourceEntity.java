package sprites;

public class ResourceEntity extends CollisionEntity{
    double health;
    EntityManager EM;
    public ResourceEntity(EntityManager EM,double xPosition, double yPosition, double Proximity, int imageIndex, double imageXPosition, double imageYPosition, int imageWidth, int imageHeight, double collisionX, double collisionY, int collisionHeight, int collisionWidth, double health) {
        super(EM ,xPosition, yPosition, Proximity, imageIndex, imageXPosition, imageYPosition, imageWidth, imageHeight, collisionX, collisionY, collisionHeight, collisionWidth);
        this.health = health;
        this.EM = EM;
        EM.addTooResourceEntities(this);
    }
    public double getHelth(){
        return health;
    }
    public void Hit(double val){
        health -= val;
        if (health <= 0){
            Die();
        }
    }
    public void Die(){
        Drop();
    }
    public void Drop(){
        //add drops, a random type and random number of
    }
}
