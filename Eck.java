import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class Eck{
   public int eckX, eckY, health, damage;
   public int ew, eh;
   BufferedImage EckImage;
   public Eck(){
      eckX = 450;
      eckY = 350;
      damage = 10;
      health = 1000;
      try{
         File eckImg = new File("Eck.png");
         EckImage = ImageIO.read(eckImg);
         ew = EckImage.getWidth(null);
         eh = EckImage.getHeight(null);
      }
      catch(IOException e){
         System.exit(1);
      }

   }
   
   public int getX(){
      return eckX;
   }
   
   public int getY(){
      return eckY;
   }
   
   public int getDmg(){
      return damage;
   }
   
   public int getHealth(){
      return health;
   }
   
   public void move(int moveX, int moveY){
      eckX += moveX;
      eckY += moveY;
   }
   
   public void draw(Graphics g){
   
      g.drawImage(EckImage, eckX, eckY, eckX+ew, eckY+eh, 0, 0, ew, eh, null);
      g.setColor(Color.BLUE);
      g.fillRect(eckX - 5, eckY - 5, health/10, 5);
   }
}
   
   
   