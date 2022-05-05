import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class StartingBackground{
    public int referenceX;
    private BufferedImage bckImg;
    int w;
    int h;
    int w1, h1;
    
    
    public StartingBackground(int newRefX){
      
      try{
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
   
   
      
    
   public void draw(Graphics g){
      //grass
      g.drawImage(bckImg, 0-referenceX, 0, 1218-referenceX, 752, 0, 0, w1, h1, null);
      

      
   }
   
   public void moveBackground(int change){
      if(referenceX <= 0){
            referenceX += 5;
         }
      else if(referenceX <= 518){
         referenceX += change;
      }
      else if(referenceX > 518){
         referenceX -= 5;
      }
      
      
      
      
   }
   
   
      
}
