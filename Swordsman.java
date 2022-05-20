import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class Swordsman extends Enemy{
   
   public int swX, swY, dmg, health, sw, sh;
   public boolean isDefeated, shoot;
   public boolean attahck = false;
   public int stage;
   BufferedImage SwordsmanImage;
   public Swordsman(int archX, int archY, int stage){
      try{
         File swordsmanImg = new File("swordsman.png");
         SwordsmanImage = ImageIO.read(swordsmanImg);
         sw = SwordsmanImage.getWidth(null);
         sh = SwordsmanImage.getHeight(null);
      }
      catch (IOException e){
         System.exit(1);
      }
      swX = 150;
      swY = 150;
      dmg = stage;
      health = 5*stage;
   }
   
   public void attack(int playerX, int playerY){
      if(shoot){  
         if(Math.abs(swX - playerX) < 50 && Math.abs(swY - playerY) < 50){
            attahck = true;
         }
         attahck = false;
      }
      attahck = false;
   }
   
   
   public void checkProjectiles(){
   }
   
   public void draw(Graphics g){
      
      g.drawImage(SwordsmanImage, swX, swY, swX+sw, swY+sh, 0, 0, sw, sh, null);
   }
   
   public int getX(){
      return swX;
   }
   
   public void subHealth(int dmg){
      health -= dmg;
   }
   
   public int getY(){
      return swY;
   }
   
   public int getHealth(){
      return health;
   }
   
   public void drawProjectiles(Graphics g){
   }
   
   public void moveProjectiles(int a, int b){
   }
   
   public int getProjX(){
      return 0;
   }
   
   public int getProjY(){
      return 0;
   }
   
   public int getDamage(){
      return dmg;
   }
}
   
   
   
   
   
         