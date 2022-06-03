import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class StartingBackground{
    public int referenceX;
    private BufferedImage bckImg, SignImage;
    int w;
    int h;
    int w1, h1, sw, sh;
    
    
    public StartingBackground(int newRefX){
      
      try{
         File bckgrndImg = new File("pelasework.jpg");
         bckImg = ImageIO.read(bckgrndImg);
         w1 = bckImg.getWidth(null);
         h1 = bckImg.getHeight(null);
         File signImg = new File("sign.png");
         SignImage = ImageIO.read(signImg);
         sw = SignImage.getWidth(null);
         sh = SignImage.getHeight(null);         
      }
      catch (IOException e){
         System.exit(1);
      }
      referenceX = newRefX;
    }
   
   
      
    
   public void draw(Graphics g){
      //grass
      g.drawImage(bckImg, 0-referenceX, 0, 1218-referenceX, 752, 0, 0, w1, h1, null);
      //sign
      g.drawImage(SignImage, 128-referenceX, 65, 128-referenceX+sw*4, 65+sh*4, 0, 0, sw, sh, null);
      g.drawImage(SignImage, 781-referenceX, 65, 781-referenceX+sw*4, 65+sh*4, 0, 0, sw, sh, null);
      g.drawImage(SignImage, 1031-referenceX, 220, 1031-referenceX+sw*4, 220+sh*4, 0, 0, sw, sh, null);
      g.drawImage(SignImage, 575-referenceX, 75, 575-referenceX+(sw*4), 75+(sh*4), 0, 0, sw, sh, null);
      g.drawImage(SignImage, 575-referenceX, 360, 575-referenceX+(sw*4), 350+(sh*4), 0, 0, sw, sh, null);
      g.setColor(Color.BLACK);
      g.setFont(new Font("Purisa", Font.BOLD, 12));
      g.drawString("Tutorial", 178-referenceX, 115);
      g.drawString("Arena", 831-referenceX, 115);
      g.drawString("Farm", 645-referenceX, 125);
      g.drawString("Shop", 1101-referenceX, 265);
      g.drawString("Boss", 625-referenceX, 415); 
   

      
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
