package sprites;

public class EnemyEntity extends ResourceEntity{
    double damage, healRate, speed;
    public EnemyEntity(double xPosition, double yPosition, double Proximity, int imageIndex, double imageXPosition, double imageYPosition, int imageWidth, int imageHeight, double collisionX, double collisionY, int collisionHeight, int collisionWidth, double health, double damage, double healing, double speed, int healRate) {
        super(xPosition, yPosition, Proximity, imageIndex, imageXPosition, imageYPosition, imageWidth, imageHeight, collisionX, collisionY, collisionHeight, collisionWidth, health);
        this.damage = damage;
        this.speed = speed;
        this.healRate = healRate;
    }

}
