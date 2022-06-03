import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class Archer extends Enemy{

   public int health;
   public int archX;
   public int archY;
   public int dmg;
   public ArrayList<Projectile> curProj;
   public boolean isDefeated = false;
   public boolean shoot = true;
   public int archStage;
   public int w, h, fw, fh;
   BufferedImage ArcherImage, FireballImage;
   
   public Archer(int stage){
      curProj = new ArrayList<Projectile>();
      archStage = stage;
      health = 10 * archStage;
      Random rand = new Random();
      int upperbound = 200;
      archX = 600;
      archY = 300;
      dmg = 3 * (archStage);
      try{
         File archImg = new File("mage.png");
         ArcherImage=ImageIO.read(archImg);
         w = ArcherImage.getWidth(null);
         h = ArcherImage.getHeight(null);
         File fireballImg = new File("fireball.png");
         FireballImage = ImageIO.read(fireballImg);
         fw = FireballImage.getWidth(null);
         fh = FireballImage.getHeight(null);
      }
      catch(IOException e){
         System.exit(1);
      }
   }
   public void move(int playerX, int playerY){
   }
   public void checkProjectiles(){
      for(int i = 0; i < curProj.size(); i++){
            if(curProj.get(i).getX() < 0){
            curProj.remove(i);
         }
      }
      if(curProj.size() == 0){
         shoot = true;
      }
      else{ 
         shoot = false;
      }
         
     
   }
   
   public int getProjX(){
      return curProj.get(0).projX;
   }
   
   public int getProjY(){
      return curProj.get(0).projY;
   }
   
   public void attack(int playerX, int playerY){
      if(shoot){
         curProj.add(new Projectile(archX, archY, dmg));
      }
   }
   
   public void subHealth(int dmg){
      health -= dmg;
   }
   
   public void moveProjectiles(int playerX, int playerY){
      curProj.get(0).move(playerX, playerY);

   }
   
   public void drawProjectiles(Graphics g){
      for(int i = 0; i < curProj.size(); i++){
         curProj.get(i).draw(g);
      }
   }
   
   
      
   public int getDamage(){
      return dmg;
   }
         
   
   public int getX(){
      return archX;
   }
   
   public int getY(){
      return archY;
   }
   
   public int getHealth(){
      return health;
   }
   
   public void draw(Graphics g){
      //archer img here
      g.drawImage(ArcherImage, archX, archY, archX + w, archY + h, 0, 0, w, h, null);
     
   }
}
     
      