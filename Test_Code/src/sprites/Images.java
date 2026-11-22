package sprites;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Images {
    public ArrayList<BufferedImage> masterImageHolder = new ArrayList<BufferedImage>();
    public Images(){
        try {
            imageSetUp();
        }catch(IOException _){

        }
    }
    public void imageSetUp() throws IOException {
        //here  every possible background image will be stored in an array list so it can be used for any sprite
        masterImageHolder.add(ImageIO.read(Images.class.getResourceAsStream("/backgrounds/water.png")));//water index:0
        masterImageHolder.add(ImageIO.read(Images.class.getResourceAsStream("/backgrounds/path.png")));//path index:1
        masterImageHolder.add(ImageIO.read(Images.class.getResourceAsStream("/backgrounds/bon.png")));//ben index:2
        masterImageHolder.add(ImageIO.read(Images.class.getResourceAsStream("/backgrounds/bottomLeftOverworld.png")));//bottomLeft index:3
        masterImageHolder.add(ImageIO.read(Images.class.getResourceAsStream("/backgrounds/bottomRightOverworld.png")));//bottomRight index:4
        masterImageHolder.add(ImageIO.read(Images.class.getResourceAsStream("/backgrounds/topRightOverworld.png")));//top right index:5
        masterImageHolder.add(ImageIO.read(Images.class.getResourceAsStream("/backgrounds/white.png")));//white index:6
        masterImageHolder.add(ImageIO.read(Images.class.getResourceAsStream("/backgrounds/dorbito.png")));//white index:7
        masterImageHolder.add(ImageIO.read(Images.class.getResourceAsStream("/backgrounds/DD.png")));//DD index:8


        //masterImageHolder.add();// index:
    }
    public BufferedImage getImageByIndex(int index){
        return masterImageHolder.get(index);
    }

}
