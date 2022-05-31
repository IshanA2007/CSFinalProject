import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class Minion{
   public int minX, minY, health, w, h;
   BufferedImage SwordsmanImage;
   public Minion(int nMinX, int nMinY){
      health = 50;
      minX = nMinX;
      minY = nMinY;
      try{
         File swordsmanImg = new File("swordsman.png");
         SwordsmanImage = ImageIO.read(swordsmanImg);
         w = SwordsmanImage.getWidth(null);
         h = SwordsmanImage.getHeight(null);
      }
      catch(IOException e){
         System.exit(1);
      }
   }
   
   public int getHealth(){
      return health;
   }
   
   public int getX(){
      return minX;
   }
   
   public int getY(){
      return minY;
   }
   
   
   public void draw(Graphics g){
      g.drawImage(SwordsmanImage, minX, minY, minX+w, minY+h, 0, 0, w, h, null);
      g.setColor(Color.BLACK);
      g.fillRect(minX - 5, minY - 5, health, 5);
   }
   
   public void move(int playerX, int playerY){
      if(minX - playerX >= 5){
         minX -= 2;
      }
      else if(minX - playerX <= -5){
         minX += 2;
      }
     
      if(minY - playerY >= 5){
         minY -= 2;
      }
      else if(minY - playerY <= -5){
         minY += 2;
      }
   }
}
         
      
      