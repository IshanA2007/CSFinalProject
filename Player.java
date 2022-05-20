import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class Player{
   public int headX;
   public int headY;
   public int rectX;
   public int rectY;
   public int sww, swh, spw, sph, hw, hh;
   BufferedImage image;
   BufferedImage upImage;
   int w, h;
   String style;
   public boolean inBounds;
   public int maxCurWeapon = 0;
   BufferedImage SwordImage, SpearImage, HammerImage;
   
   public Player(){
      try{
         File stillImg = new File("face.png");
         image = ImageIO.read(stillImg);
         File upImg = new File("back.png");
         upImage = ImageIO.read(upImg);
         w = image.getWidth(null);
         h = image.getHeight(null);
         File swordImg = new File("sword.png");
         File spearImg = new File("spear.png");
         File hammerImg = new File("hammer.png");
         SwordImage = ImageIO.read(swordImg);
         SpearImage = ImageIO.read(spearImg);
         HammerImage = ImageIO.read(hammerImg);
         sww = SwordImage.getWidth(null);
         swh = SwordImage.getHeight(null);
         spw = SpearImage.getWidth(null);
         sph = SpearImage.getHeight(null);
         hw = HammerImage.getWidth(null);
         hh = HammerImage.getHeight(null);
      }
      catch (IOException e){
         System.exit(1);
      }
      rectX = 50;
      rectY = 350;
   }

   
   public void draw(Graphics g, String style, int health, boolean drawHealth, String curWeapon){
      if(style.equals("still")||style.equals("down")){
         g.drawImage(image, rectX, rectY, w+rectX, h+rectY, 0, 0, w, h, null);
      }
      else if(style.equals("up")){
         g.drawImage(upImage, rectX, rectY, w+rectX, h+rectY, 0, 0, w, h, null);
      }
      else if(style.equals("right") || style.equals("left")){   
         g.drawImage(image, rectX, rectY, w+rectX, h+rectY, 0, 0, w, h, null);
      }
      if(drawHealth){
         
         g.setColor(Color.RED);
         g.fillRect(rectX, rectY, health, 10);
      }
      g.setColor(Color.BLACK);
      g.fillRect(300, 670, 100, 30);
      
      
      
      //put weapon images in hotbar here
      if(curWeapon.equals("Fist")){
         
      }
      else if(curWeapon.equals("Sword")){
         g.drawImage(SwordImage, 250, 630, 300+sww, 670+swh, 0, 0, sww, swh, null);
      }
      else if(curWeapon.equals("Spear")){
         g.drawImage(SpearImage, 250, 630, 300+spw, 670+sph, 0, 0, spw, sph, null);
      }
      else if(curWeapon.equals("Hammer")){
         g.drawImage(HammerImage, 250, 630, 300+hw, 670+hh, 0, 0, hw, hh, null);
      }
      
      g.setFont(new Font("Purisa", Font.BOLD, 15));
      g.drawString("Current Weapon: " + curWeapon, 300, 668);
      g.drawString("Health: " + health + "/100", 300, 655);
         
      
      
      
      
      
      
      
      
   }
   public boolean inBetween(int var, int bot, int top){
      if(var >= bot && var <= top){
         return true;
      }
      return false;
   }
   
   public void move(int changeX, int changeY){
      if(rectX > 600){
         rectX -= 5;
      }
      else if(rectX < 0){
         rectX += 5;
      }
      
            
      else{
         rectX += changeX;
         rectY += changeY;
      }      
 
   }
}
      

