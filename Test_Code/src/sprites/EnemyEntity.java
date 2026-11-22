package sprites;

import java.util.ArrayList;

public class EnemyEntity extends ResourceEntity{
    double damage, healRate, speed;
    ArrayList<double[]> path;
    EntityManager EM;
    public EnemyEntity(EntityManager EM,double xPosition, double yPosition, double Proximity, int imageIndex, double imageXPosition, double imageYPosition, int imageWidth, int imageHeight, double collisionX, double collisionY, int collisionHeight, int collisionWidth, double health, double damage, double healing, double speed, int healRate) {
        super(EM ,xPosition, yPosition, Proximity, imageIndex, imageXPosition, imageYPosition, imageWidth, imageHeight, collisionX, collisionY, collisionHeight, collisionWidth, health);
        this.damage = damage;
        this.speed = speed;
        this.healRate = healRate;
        this.EM = EM;
        EM.addTooEnemyEntities(this);
        ArrayList<double[]> path = new ArrayList<double[]>();
    }
    public void setPath(ArrayList<double[]> newPath){
        path = newPath;
    }
    public void Move(){
        
    }

}
