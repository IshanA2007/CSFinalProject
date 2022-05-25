import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;
import java.awt.event.*;
import java.io.IOException;

public class TutorialBackground{
   public int stage;
   public int speakStage;
   BufferedImage image;
   BufferedImage HeemImage;
   BufferedImage TutorialImage;
   BufferedImage HammerImage, SwordImage, SpearImage;
   BufferedImage ShieldImage;
   BufferedImage ChestplateImage;
   BufferedImage EckImage;
   int w, h, w1, h1, wt, ht, sw, sh, hw, hh, sww, swh, cpw, cph, shw, shh, ew, eh;
   int[] xPoints;
   int[] yPoints;
   
   
   public TutorialBackground(){
      stage = 0;
       try{
         File stillImg = new File("face.png");
         image = ImageIO.read(stillImg);
         File eckImg = new File("Eck.png");
         File tutorialImg = new File("tutorial.png");
         TutorialImage = ImageIO.read(tutorialImg);
         wt = TutorialImage.getWidth(null);
         ht = TutorialImage.getHeight(null);

         w = image.getWidth(null);
         h = image.getHeight(null);
         File heemImg = new File("DaHeem.png");
         EckImage = ImageIO.read(eckImg);
         ew = EckImage.getWidth(null);
         eh = EckImage.getWidth(null);
         HeemImage = ImageIO.read(heemImg);
         
         w1 = HeemImage.getWidth(null);
         h1 = HeemImage.getHeight(null);
         
         File swordImg = new File("sword.png");
         File spearImg = new File("spear.png");
         File hammerImg = new File("hammer.png");
         File shieldImg = new File("shield.png");
         File cpImg = new File("chestplate.png");
         
         ShieldImage = ImageIO.read(shieldImg);
         ChestplateImage = ImageIO.read(cpImg);         
         SwordImage = ImageIO.read(swordImg);
         SpearImage = ImageIO.read(spearImg);
         HammerImage = ImageIO.read(hammerImg);
         
         sw = SpearImage.getWidth(null);
         sh = SpearImage.getHeight(null);
         
         hw = HammerImage.getWidth(null);
         hh = HammerImage.getHeight(null);
         
         sww = SwordImage.getWidth(null);
         swh = SwordImage.getHeight(null);
         
         cpw = ChestplateImage.getWidth(null);
         cph = ChestplateImage.getHeight(null);
         
         shw = ShieldImage.getWidth(null);
         shh = ShieldImage.getHeight(null);
         
         

         
      }
      catch (IOException e){
         System.exit(1);
      }
      xPoints = new int[3];
      yPoints = new int[3];
      
      xPoints[0] = 490;
      xPoints[1] = 490;
      xPoints[2] = 630;
      yPoints[0] = 560;
      yPoints[1] = 580;
      yPoints[2] = 600;

   }
   
   public void drawMoves(Graphics g, boolean display, int playerX, int playerY){
      g.setColor(Color.WHITE);
      g.drawImage(TutorialImage, 0, 0, 700, 700, 0, 0, wt, ht, null);
      g.setFont(new Font("Purisa", Font.BOLD, 20));
      g.setColor(Color.BLACK);
      if(display){
         g.drawString("Take a look around, then press R to go to next scene", 100, 250);
      }
      
      
   }
   
   public void drawWeapons(Graphics g, boolean display, int playerX, int playerY){
      g.setColor(Color.RED);
      g.drawImage(TutorialImage, 0, 0, 700, 700, 0, 0, wt, ht, null);
      g.setFont(new Font("Purisa", Font.BOLD, 20));
      g.setColor(Color.BLACK);
      if(display){
         g.drawString("Take a look around, then press R to go to next scene", 100, 250);
      }
      g.drawImage(SpearImage, 200, 300, 200 + sw, 300+sh, 0, 0, sw, sh, null);
      if(playerX > 150 && playerX < 250 && playerY > 250 && playerY<350){
         g.setColor(Color.BLACK);
         g.setFont(new Font("Purisa", Font.BOLD, 15));
         g.drawString("Spear", 220, 270);
      }
      
      g.drawImage(SwordImage, 350, 300, 350+sww, 300+swh, 0, 0, sww, swh, null);
      if(playerX > 300 && playerX < 400 && playerY > 250 && playerY<350){
         g.setColor(Color.BLACK);
         g.setFont(new Font("Purisa", Font.BOLD, 15));
         g.drawString("Sword", 370, 270);
      }
      g.drawImage(HammerImage, 500, 300, 500+hw, 300+hh, 0, 0, hw, hh, null);
      if(playerX > 450 && playerX < 550 && playerY > 250 && playerY < 350){
         g.setColor(Color.BLACK);
         g.setFont(new Font("Purisa", Font.BOLD, 15));
         g.drawString("Hammer of Doom", 490, 270);
      }
      g.drawImage(ShieldImage, 250, 450, 250+shw, 450+shh, 0, 0, shw, shh, null);
      if(playerX > 200 && playerX < 300 && playerY > 400 && playerY < 500){
         g.setColor(Color.BLACK);
         g.setFont(new Font("Purisa", Font.BOLD, 15));
         g.drawString("Shield", 220, 420);
      }
      g.drawImage(ChestplateImage, 450, 450, 450+cpw, 450+cph, 0, 0, cpw, cph, null);
      if(playerX > 400 && playerX < 500 && playerY > 400 && playerY < 500){
         g.setColor(Color.BLACK);
         g.setFont(new Font("Purisa", Font.BOLD, 15));
         g.drawString("Chestplate", 410, 420);
      }
   
      
   }
   
   public void drawObjective(Graphics g, boolean display, int playerX, int playerY){
      g.setColor(Color.BLACK);
      g.drawImage(TutorialImage, 0, 0, 700, 700, 0, 0, wt, ht, null);
      g.setFont(new Font("Purisa", Font.BOLD, 20));
      g.setColor(Color.BLACK);
      if(display){
         g.drawString("Take a look around, then press R to go to next scene", 100, 250);
      }
      g.drawImage(EckImage, 335, 100, 335+ew, 100+eh, 0, 0, ew, eh, null);
   }
   public void drawMoveSpeech(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(HeemImage, 520, 500, 700, 700,w1, 0, 0, h1, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("Press 'w' to move forward, 's' to move back", 60, 570);
      g.drawString("and 'a' and 'd' to move sideways!", 60, 590);
      g.drawString("Try moving around a bit till you're comfortable, then press E to close!", 60, 610);
   }
   
   public void drawWeaponSpeech(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(HeemImage, 520, 500, 700, 700,w1, 0, 0, h1, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("Press E to close", 60, 630);
      g.drawString("These items can be purchased at the shop house, check it out!", 60, 610);
      g.drawString("You can also get armor/shields to reduce damage you receive!", 60, 590);
      g.drawString("You can buy weapons to increase your damage against enemies!", 60, 570);
    
      
      
      
   }
   
   public void drawObjectiveSpeech(Graphics g){
      g.setColor(Color.WHITE);
      g.fillRect(50, 550, 500, 100);
      g.fillPolygon(xPoints, yPoints, 3);
      g.drawImage(HeemImage, 520, 500, 700, 700,w1, 0, 0, h1, null);
      g.setFont(new Font("Purisa", Font.BOLD, 13));
      g.setColor(Color.BLACK);
      g.drawString("Your goal in this game is to defeat the boss", 60, 570);
      g.drawString("The boss stole my math notes, but I have a test tmorrow!", 60, 590);
      g.drawString("...His name..is the Eck. Please get my notes back for me; Good luck!", 60, 610);
      g.drawString("Press E to close", 60, 630);
   }
   
   
}
   
   