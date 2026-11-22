package sprites;

import java.util.ArrayList;

public class NPCEntity extends InformationEntity{
    ArrayList<String> Conversation;
    EntityManager EM;
    public NPCEntity(EntityManager EM,double xPosition, double yPosition, double Proximity, int imageIndex, double imageXPosition, double imageYPosition, int imageWidth, int imageHeight, double collisionX, double collisionY, int collisionHeight, int collisionWidth, String text, ArrayList<String> Conversation) {
        super(EM ,xPosition, yPosition, Proximity, imageIndex, imageXPosition, imageYPosition, imageWidth, imageHeight, collisionX, collisionY, collisionHeight, collisionWidth, text);
        this.Conversation = Conversation;
        this.EM = EM;
        EM.addTooNPCEntities(this);
    }
}
