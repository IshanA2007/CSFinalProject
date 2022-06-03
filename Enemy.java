import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;
abstract class Enemy{
   int health;
   
   abstract void subHealth(int dmg);
   
   abstract void attack(int playerX, int playerY);
   
   abstract void checkProjectiles();
   
   abstract void draw(Graphics g);
   
   abstract int getX();
   
   abstract void move(int playerX, int playerY);
   abstract int getY();
   
   abstract int getHealth();
   
   abstract void drawProjectiles(Graphics g);
   
   abstract void moveProjectiles(int playerX, int playerY);
   
   abstract int getProjX();
   
   abstract int getProjY();
   
   abstract int getDamage();
   
   
}
