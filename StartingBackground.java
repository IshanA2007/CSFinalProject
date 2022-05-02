import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class StartingBackground{
    public int referenceX;
    private BufferedImage image;
    private BufferedImage bckImg;
    int w;
    int h;
    int w1, h1;
    Boundary[] boundaries;
    
    
    public StartingBackground(int newRefX){
      boundaries = new Boundary[5];
      boundaries[1] = new Boundary(0, 0 
      try{
         File riverImg = new File("river-removebg-preview.png");
         image = ImageIO.read(riverImg);
         w = image.getWidth(null);
         h = image.getHeight(null);
         File bckgrndImg = new File("pelasework.jpg");
         bckImg = ImageIO.read(bckgrndImg);
         w1 = bckImg.getWidth(null);
         h1 = bckImg.getHeight(null);
         
      }
      catch (IOException e){
         System.exit(1);
      }
      referenceX = newRefX;
    }
   
   public void makeBoundaries(){
      
    
   public void draw(Graphics g){
      //grass
      g.drawImage(bckImg, 0-referenceX, 0, 1218-referenceX, 752, 0, 0, w1, h1, null);
      

      
   }
   
   public void moveBackground(int change){
      if(referenceX <= 0){
            referenceX += 50;
         }
      else if(referenceX <= 518){
         referenceX += change;
      }
      else if(referenceX > 518){
         referenceX -= 50;
      }
      
      
      
      
   }
   
   
      
}
