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
   public int sww, swh, spw, sph, hw, hh, cw, ch, siw, sih, spiw, spih, hiw, hih;
   BufferedImage image;
   BufferedImage upImage;
   BufferedImage CoinImage;
   BufferedImage SwordItemImage, SpearItemImage, HammerItemImage;
   int w, h;
   String style;
   public boolean inBounds;
   public int maxCurWeapon = 0;
   BufferedImage SwordImage, SpearImage, HammerImage;
   
   public Player(){
      try{
         File swordItemImg = new File("sworditem.png");
         File spearItemImg = new File("spearitem.png");
         File hammerItemImg = new File("hammeritem.png");
         SwordItemImage = ImageIO.read(swordItemImg);
         SpearItemImage = ImageIO.read(spearItemImg);
         HammerItemImage = ImageIO.read(hammerItemImg);
         siw = SwordItemImage.getWidth(null);
         sih = SwordItemImage.getHeight(null);
         spiw = SpearItemImage.getWidth(null);
         spih = SpearItemImage.getHeight(null);
         hiw = HammerItemImage.getWidth(null);
         hih = HammerItemImage.getHeight(null);
         File stillImg = new File("face.png");
         image = ImageIO.read(stillImg);
         File upImg = new File("back.png");
         File coinImg = new File("coin.png");
         upImage = ImageIO.read(upImg);
         w = image.getWidth(null);
         h = image.getHeight(null);
         File swordImg = new File("sword.png");
         File spearImg = new File("spear.png");
         File hammerImg = new File("hammer.png");
         SwordImage = ImageIO.read(swordImg);
         SpearImage = ImageIO.read(spearImg);
         HammerImage = ImageIO.read(hammerImg);
         CoinImage = ImageIO.read(coinImg);
         sww = SwordImage.getWidth(null);
         swh = SwordImage.getHeight(null);
         spw = SpearImage.getWidth(null);
         sph = SpearImage.getHeight(null);
         hw = HammerImage.getWidth(null);
         hh = HammerImage.getHeight(null);
         cw = CoinImage.getWidth(null);
         ch = CoinImage.getHeight(null);
         
      }
      catch (IOException e){
         System.exit(1);
      }
      rectX = 50;
      rectY = 350;
   }

   
   public void draw(Graphics g, String style, int health, boolean drawHealth, String curWeapon, int money, int shield){
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
         g.drawImage(SwordItemImage, 300, 650, 245+siw, 620+sih, 0, 0, siw, sih, null);
      }
      else if(curWeapon.equals("Spear")){
         g.drawImage(SpearItemImage, 300, 650, 245+spiw, 620+spih, 0, 0, spiw, spih, null);
      }
      else if(curWeapon.equals("Hammer")){
         g.drawImage(HammerItemImage, 300, 650, 245+hiw, 620+hih, 0, 0, hiw, hih, null);
      }
      
      g.setFont(new Font("Purisa", Font.BOLD, 15));
      g.drawString("Current Weapon: " + curWeapon, 280, 668);
      g.drawString("Health: " + health + "/100", 300, 655);
      g.drawString("Damage Reduction: "  + shield + "%", 280, 642);
      g.drawString("Money: " + money, 25, 25);    
      g.drawImage(CoinImage, 95, 7, 120, 32, 0, 0, cw, ch, null);
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
      

