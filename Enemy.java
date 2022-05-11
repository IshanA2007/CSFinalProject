import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;
abstract class Enemy{
   
   abstract void attack(int playerX, int playerY);
   
   abstract void checkProjectiles();
   
   abstract void draw(Graphics g);
   
   abstract int getX();
   
   abstract int getY();
   
   abstract int getHealth();
   
   abstract void drawProjectiles(Graphics g);
}
