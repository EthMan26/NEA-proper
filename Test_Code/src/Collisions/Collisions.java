package Collisions;

import main.GamePanel;
import sprites.CollisionEntity;
import sprites.EnemyEntity;
import sprites.player;

import java.util.ArrayList;
public class Collisions {
    player P;
    GamePanel gp;
    public Collisions(GamePanel gp){
        this.gp = gp;
    }
    public void playerCollisions (ArrayList<CollisionEntity> areas ,player P){
        //background collision detection
        //problems encountered were, detecting that the x was not in the right area leading to a line that you could not pass,
        // doing all the checks without finding the minimum so that the touching of the collision would lead to going to the bottom right
        //subtracting the X when it should be the Y
        //coordinate not lining up as they were not adjusted correctly
        this.P = P;
        for(CollisionEntity currentArea:areas){
            if(currentArea.getCollisionX()<(P.x+P.width) && (currentArea.getCollisionX() + currentArea.getCollisionWidth())>P.x && currentArea.getCollisionY()<(P.y+P.height) && (currentArea.getCollisionY() + currentArea.getCollisionHeight())>P.y){
                double distanceFromLeft = (P.x + P.width) - currentArea.getCollisionX();
                double distanceFromRight = (currentArea.getCollisionX() + currentArea.getCollisionWidth()) - P.x;
                double distanceFromTop = (P.y + P.height) - currentArea.getCollisionY();
                double distanceFromBottom = (currentArea.getCollisionY() + currentArea.getCollisionHeight()) - P.y;

                double minDistanceFrom = Math.min(Math.min(distanceFromLeft, distanceFromRight),Math.min(distanceFromTop, distanceFromBottom));


                if(minDistanceFrom == distanceFromLeft) {
                    P.x = currentArea.getCollisionX() - P.width;
                    gp.coordsX -= distanceFromLeft/2;
                } else if(minDistanceFrom == distanceFromRight) {
                    P.x = currentArea.getCollisionX() + currentArea.getCollisionWidth();
                    gp.coordsX += distanceFromRight/2;
                } else if(minDistanceFrom == distanceFromTop) {
                    P.y = currentArea.getCollisionY() - P.height;
                    gp.coordsY += distanceFromTop/2;
                } else {
                    P.y = currentArea.getCollisionY() + currentArea.getCollisionHeight();
                    gp.coordsY -= distanceFromBottom/2;
                }
            }
        }
    }
    public void CollisionCheckerNonPlayer (ArrayList<CollisionEntity> areas , EnemyEntity currentEnemy) {//prior to this the inputed arraylist will be sorted by y coordinate

        for(CollisionEntity currentArea:areas){
            if(currentArea.getY()>(currentEnemy.getY()+currentEnemy.getCollisionWidth())){
                break;// if you go below the lowest point of the entity what is the point of continuing
            }
            if(currentArea.getCollisionX()<(currentEnemy.getX()+currentEnemy.getCollisionWidth()) && (currentArea.getCollisionX() + currentArea.getCollisionWidth())>currentEnemy.getX() && currentArea.getCollisionY()<(currentEnemy.getY()+currentEnemy.getCollisionHeight()) && (currentArea.getCollisionY() + currentArea.getCollisionHeight())>currentEnemy.getY()){
                double distanceFromLeft = (currentEnemy.getX() + currentEnemy.getCollisionWidth()) - currentArea.getCollisionX();
                double distanceFromRight = (currentArea.getCollisionX() + currentArea.getCollisionWidth()) - currentEnemy.getX();
                double distanceFromTop = (currentEnemy.getY() + currentEnemy.getCollisionHeight()) - currentArea.getCollisionY();
                double distanceFromBottom = (currentArea.getCollisionY() + currentArea.getCollisionHeight()) - currentEnemy.getY();

                //want to move the player the smallest amount while also guaranteeing that the player entity gets out of the way for the
                double minDistanceFrom = Math.min(Math.min(distanceFromLeft, distanceFromRight),Math.min(distanceFromTop, distanceFromBottom));

                //based on prior logic of the game there is no need to concern that moving an enemy would put it into another area, (only further into one it was already encased within, which is checked later on via the for loop here).

                if(minDistanceFrom == distanceFromLeft) {
                    currentEnemy.offsetAllX( -distanceFromLeft );
                    //make a point of resetting the horizontal velocity, or vertical in this section
                } else if(minDistanceFrom == distanceFromRight) {
                    currentEnemy.offsetAllX( distanceFromRight );
                } else if(minDistanceFrom == distanceFromTop) {
                    currentEnemy.offsetAllY( -distanceFromTop );
                } else {
                    currentEnemy.offsetAllY( distanceFromBottom );
                }
            }
        }
    }

}
