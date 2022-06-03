import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
public class Fireball{
   public int fX, fY, damage;
   public int w = 7;
   public int h = 7;
   BufferedImage FireballImage;
   
   public Fireball(int nfX, int nfY){
      fX = nfX;
      fY = nfY;
      damage = 1;
      try{
         File fireballImg = new File("fireball.png");
         FireballImage = ImageIO.read(fireballImg);
      }
      catch(IOException e){
         System.exit(1);
      }
   }
   
   public void move(){
      fX -= 5;
   }
   
   public void draw(Graphics g){
      g.setColor(Color.YELLOW);
      g.drawImage(FireballImage, fX, fY, fX+30, fY+30, 0, 0, FireballImage.getWidth(null), FireballImage.getHeight(null), null);
   }
   public int getX(){
      return fX;
   }
   
   public int getY(){
      return fY;
   }
}
