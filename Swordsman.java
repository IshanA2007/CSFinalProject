import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class Swordsman extends Enemy{
   public int swX, swY, dmg, health;
   public boolean isDefeated, shoot;
   public boolean attahck = false;
   public Swordsman(archX, archY){
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
   
   
   
         