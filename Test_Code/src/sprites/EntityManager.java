package sprites;

import Backrounds.backgroundManager;
import main.GamePanel;
import main.Keys;

import java.io.IOException;
import java.util.ArrayList;

public class EntityManager {

    GamePanel gp;
    public ArrayList<BaseEntity> allEntities = new ArrayList<BaseEntity>();
    public ArrayList<ImageEntity> allImageEntities  = new ArrayList<ImageEntity>();
    public ArrayList<CollisionEntity> allCollisionEntities = new ArrayList<CollisionEntity>();
    public ArrayList<ResourceEntity> allResourceEntities = new ArrayList<ResourceEntity>();
    public ArrayList<EnemyEntity> allEnemyEntities = new ArrayList<EnemyEntity>();
    public ArrayList<InformationEntity> allInformationEntities = new ArrayList<InformationEntity>();
    public ArrayList<NPCEntity> allNPCEntities = new ArrayList<NPCEntity>();

    public EntityManager(GamePanel gp){
        this.gp = gp;
    }
    public void initialEntitySetup(){
        //first set of created values are the base entities that will be in the entities array list and the base entity arraylist
        //then the image entities will have the same done to them, collision, resources enemies information's and NPC's
        ImageEntity centerImage = new ImageEntity(this,0,0,0,7,0,0,gp.screenWidth,gp.screenHeight);
        ImageEntity left = new ImageEntity(this,-167,0,0,0,-167,0,167,167);
        CollisionEntity right = new CollisionEntity(this,2000,0,0,1,1000,0,1000,1000,1000,0,1000,1000);
        ImageEntity dude = new ImageEntity(this,2000,0,0,2,0,700,1000,100);
        // add both of these to the Image entity creation from above
        //        holdingArr = BM.makePersonalisedBackground(4,screenWidthMid,screenHeightMid,2700*backgroundMult,2700*backgroundMult);
        //        BM.currentPointer = BM.setCurrentBackgrounds(true,holdingArr);
        //        holdingArr = BM.makePersonalisedBackground(2,0,0,screenWidth,300);
        //        BM.currentPointer = BM.setCurrentBackgrounds(true,holdingArr);
        //        holdingArr = BM.makePersonalisedBackground(2,-1000,-1000,screenWidth,screenHeight);
        //        BM.currentPointer = BM.setCurrentBackgrounds(true,holdingArr);
        //        holdingArr = BM.makePersonalisedBackground(0,-200,200,5,screenHeightMid - (holdingArr[1] /2));
        //        BM.currentPointer = BM.setCurrentBackgrounds(true,holdingArr);
        //        holdingArr = BM.makePersonalisedBackground(0,0,1000,100,100);
        //        BM.currentPointer = BM.setCurrentBackgrounds(true,holdingArr);
        //
    }

    //all these are noted from the constructor classes of the entities being created so that all created entities are added to the correct arraylist
    //and mainly so that they are added to all that are applicable

    public void addTooBaseEntities(BaseEntity B){
        allEntities.add(B);
    }
    public void addTooImageEntities(ImageEntity I){
        allImageEntities.add(I);
    }
    public void addTooCollisionEntities(CollisionEntity C){
        allCollisionEntities.add(C);
    }
    public void addTooResourceEntities(ResourceEntity R){
        allResourceEntities.add(R);
    }
    public void addTooEnemyEntities(EnemyEntity E){
        allEnemyEntities.add(E);
    }
    public void addTooInformationEntities(InformationEntity I){
        allInformationEntities.add(I);
    }
    public void addTooNPCEntities(NPCEntity N){
        allNPCEntities.add(N);
    }
}
