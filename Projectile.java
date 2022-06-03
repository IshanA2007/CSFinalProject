import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class Projectile{
   public int projX, projY;
   public int projDmg;
   public int fw, fh;
   BufferedImage FireballImage;
   public Projectile(int archX, int archY, int newDmg){
      projX = archX - 20;
      projY = archY - 5;
      projDmg = newDmg;
      try{
         File fireballImg = new File("fireball.png");
         FireballImage = ImageIO.read(fireballImg);
         fw = FireballImage.getWidth(null);
         fh = FireballImage.getHeight(null);
      }
      catch(IOException e){
         System.exit(1);
      }
   }
   
   public void draw(Graphics g){
      g.drawImage(FireballImage, projX, projY, projX + fw/4, projY + fh/4, 0, 0, fw, fh, null);
   }
   
   public void move(int playerX, int playerY){
      if(projY - playerY > 0){
         projY -= 5;
      }
      else if(projY - playerY < 0){
         projY += 5;
      }
      projX -= 5;
   }
   
   public int getX(){
      return projX;
   }
   
   public int getY(){
      return projY;
   }
      
   
}
      
      
      