package sprites;

import java.util.ArrayList;

public class NPCEntity extends InformationEntity{
    public NPCEntity(double xPosition, double yPosition, double Proximity, int imageIndex, double imageXPosition, double imageYPosition, int imageWidth, int imageHeight, double collisionX, double collisionY, int collisionHeight, int collisionWidth, String text, ArrayList<String> Conveersation) {
        super(xPosition, yPosition, Proximity, imageIndex, imageXPosition, imageYPosition, imageWidth, imageHeight, collisionX, collisionY, collisionHeight, collisionWidth, text);
    }
}
