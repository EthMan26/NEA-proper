package sprites;

public class ImageEntity extends BaseEntity{
    double imageX, imageY;
    int imageWidth, imageHeight, imageIndex;
    EntityManager EM;
    public ImageEntity(EntityManager EM,double xPosition, double yPosition, double Proximity, int imageIndex, double imageXPosition , double imageYPosition, int imageWidth, int imageHeight){
        super(EM ,xPosition, yPosition, Proximity);
        imageX = imageXPosition;
        imageY = imageYPosition;
        this.imageIndex = imageIndex;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.EM = EM;
        EM.addTooImageEntities(this);
    }
    public double getImageX(){
        return imageX;
    }
    public double getImageY(){
        return imageY;
    }
    public int getImageWidth(){
        return imageWidth;
    }
    public int getImageHeight(){
        return imageHeight;
    }
    public int getImageIndex(){
        return imageIndex;
    }
    public void setImageX(double val){
        imageX = val;
    }
    public void setImageY(double val){
        imageY = val;
    }
    public void setImageWidth(double val){
        imageWidth += val;
    }
    public void setImageHeight(double val){
        imageHeight += val;
    }
    public void offsetImageX(double val){
        imageX += val;
    }
    public void offsetImageY(double val){
        imageY += val;
    }

    @Override
    public void offsetAllX(double val){
        x += val;
        imageX += val;
    }
    @Override
    public void offsetAllY(double val){
        y += val;
        imageY += val;
    }
}
