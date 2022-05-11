import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class Projectile{
   public int projX, projY;
   public int projDmg;
   public Projectile(int archX, int archY, int newDmg){
      projX = archX - 20;
      projY = archY - 5;
      projDmg = newDmg;
   }
   
   public void draw(Graphics g){
   }
   
}
      
      
      