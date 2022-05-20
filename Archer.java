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
   
   
   public Archer(int stage){
      curProj = new ArrayList<Projectile>();
      archStage = stage;
      health = 10 * archStage;
      Random rand = new Random();
      int upperbound = 200;
      archX = rand.nextInt(upperbound)+300;
      archY = rand.nextInt(upperbound+300)+100;
      dmg = 3 * (archStage);
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
      //System.out.println(archX);
      g.setColor(Color.BLUE);
      g.fillRect(archX, archY, 5, 10);
   }
}
     
      