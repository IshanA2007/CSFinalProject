import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

public class ArenaBackground{
   public int stage;
   ArrayList<Enemy> enemies;
   ArenaScene scene;
   BufferedImage BackgroundImage;
   public int bw, bh;
   
   public ArenaBackground(int combStage, ArenaScene ascene){
      scene = ascene;
      stage = combStage;
      enemies = new ArrayList<Enemy>();
      enemies.add(new Archer(stage));
      makeSwordsmen();
      try{
         File bckImg = new File("arena.png");
         BackgroundImage = ImageIO.read(bckImg);
         bw = BackgroundImage.getWidth(null);
         bh = BackgroundImage.getHeight(null);
      }
      catch(IOException e){
         System.exit(1);
      }
      
   }
   
   public void makeSwordsmen(){
      for(int i = 0; i < stage; i++){
         enemies.add(new Swordsman(enemies.get(0).getX()-100, enemies.get(0).getY()-100, stage));
      }
   }
   
   public void draw(Graphics g){
      //bckrnd img goes here
      g.drawImage(BackgroundImage, 0, 0, 700, 700, 0, 0, bw, bh, null);
      for(int i = 0; i < enemies.size(); i++){
         enemies.get(i).draw(g);
         int enemyX = enemies.get(i).getX();
         int enemyY = enemies.get(i).getY();
         //drawing healthbar
         
         g.setColor(Color.RED);
         g.fillRect(enemyX - 10, enemyY - 12, enemies.get(i).getHealth()*2, 10);
      }
   
   }
   
   public void archerAttack(int playerX, int playerY, Graphics g){
      Enemy arch = enemies.get(0);
      arch.checkProjectiles();
      arch.attack(playerX, playerY);
      arch.drawProjectiles(g);
      arch.moveProjectiles(playerX, playerY);
   }
      
   public int archerAttackDamage(int playerX, int playerY){
      
         Enemy arch = enemies.get(0);
         int projX = arch.getProjX();
      
         int projY = arch.getProjY();
         if(Math.abs((projX+50) - (playerX + scene.player.w/2)) < 30 && Math.abs((projY-45) - playerY+scene.player.h/2) < 30){
            return arch.getDamage();
         }
         return 0;
   }
   
   public void getAttacked(int playerX, int playerY, boolean attack, int weaponDmg){
      for(int i = 0; i < enemies.size(); i++){  
         int enemyX = enemies.get(i).getX();
         int enemyY = enemies.get(i).getY();
         if(Math.abs((enemyX+40) - (playerX+scene.player.w/2)) < 40 && (Math.abs((enemyY+70) - (playerY+scene.player.h/2)) < 40)){
            enemies.get(i).subHealth(weaponDmg);
         }
      }
   }
   
   public int swordsmenAttack(int playerX, int playerY){
      int finalDmg = 0;
      if(enemies.size() == 1){
         return 0;
      }
      else{
         for(int i = 1; i < enemies.size(); i++){
            enemies.get(i).move(playerX, playerY);
            int enemyX = enemies.get(i).getX();
            int enemyY = enemies.get(i).getY();
            if((Math.abs((enemyX+40) - (playerX+scene.player.w/2)) < 20) && (Math.abs((enemyY+50) - (playerY+scene.player.h/2)) < 20)){
               finalDmg += enemies.get(i).getDamage();
            }
         }
         return finalDmg;
      }
   }
   public boolean levelCleared(){
      if(enemies.size() > 0){
         for(int i = 0; i < enemies.size(); i++){
            if(enemies.get(i).getHealth()<= 0){
               if(enemies.size() == 1){
                  return true;
               }
               enemies.remove(enemies.get(i));
               scene.stats.money += 25;
            }
         }
         return false;
      }
      else{
         return true;
      }
   }
   
   
   
   
   
}
   
   
      
      
      