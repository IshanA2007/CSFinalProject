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
    int w;
    int h;
    
    
    public StartingBackground(int newRefX){
      try{
         File riverImg = new File("river-removebg-preview.png");
         image = ImageIO.read(riverImg);
         w = image.getWidth(null);
         h = image.getHeight(null);
      }
      catch (IOException e){
         System.exit(1);
      }
      referenceX = newRefX;
    }
    
   public void draw(Graphics g){
      //grass
      g.setColor(new Color(4, 120, 33));
      g.fillRect(0, 0, 700, 700);
      
      g.drawImage(image, 500-referenceX, 0, w+700-referenceX, 700, 0, 0, w, h, null);
      
   }
   
   public void moveBackground(int change){
      
      referenceX += change;
      
      
   }
   
   
      
}
