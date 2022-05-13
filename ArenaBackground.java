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
   
   
   public ArenaBackground(int combStage){
      stage = combStage;
      enemies = new ArrayList<Enemy>();
      enemies.add(new Archer(stage));
      makeSwordsmen();
      
   }
   
   public void makeSwordsmen(){
      for(int i = 0; i < stage; i++){
         enemies.add(new Swordsman(enemies.get(i).getX(), enemies.get(i).getY(), stage));
      }
   
   }
   
   public void draw(Graphics g){
      //bckrnd img goes here
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, 700, 700);
      for(int i = 0; i < enemies.size(); i++){
         enemies.get(i).draw(g);
         int enemyX = enemies.get(i).getX();
         int enemyY = enemies.get(i).getY();
         //drawing healthbar
         g.fillRect(enemyX - 10, enemyY - 10, enemyX + enemies.get(i).getHealth(), enemyY - 2);
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
      if(Math.abs(projX - playerX) < 7 && Math.abs(projY - playerY) < 7){
         return arch.getDamage();
      }
      return 0;
   }
   
   public void getAttacked(int playerX, int playerY, boolean attack, int weaponDmg){
      for(int i = 0; i < enemies.size(); i++){  
         int enemyX = enemies.get(i).getX();
         int enemyY = enemies.get(i).getY();
         if(attack && (Math.abs(enemyX - playerX) < 20) && (Math.abs(enemyY - playerY) < 20)){
            enemies.get(i).health -= weaponDmg;
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
            int enemyX = enemies.get(i).getX();
            int enemyY = enemies.get(i).getY();
            if((Math.abs(enemyX - playerX) < 20) && (Math.abs(enemyY - playerY) < 20)){
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
               enemies.remove(enemies.get(i));
            }
         }
         return false;
      }
      else{
         return true;
      }
   }
   
   
   
   
   
}
   
   
      
      
      